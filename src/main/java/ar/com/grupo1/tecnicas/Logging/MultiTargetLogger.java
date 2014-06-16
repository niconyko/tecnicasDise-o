package ar.com.grupo1.tecnicas.Logging;

import java.util.ArrayList;
import java.util.regex.Pattern;

import ar.com.grupo1.tecnicas.Logging.Level.enumLevel;


public class MultiTargetLogger implements Logger{
	private String name = "";
	private String level = "";
	private String format = "";
	private String regexFilter = ".*";
	private String customClassFilterName = "";
	private ArrayList<Target> targets;
	private Level levelLog;
	private Context context;
	private Configuration config;
	
	
	public MultiTargetLogger (String name) {
		targets = new ArrayList<Target>();
		config = new Configuration(name);
		levelLog = new Level(config.getFilterLevel() );
		this.name = name;
	}
	
	public boolean regexFilterAccepted(String message){
	    Pattern pattern = Pattern.compile(regexFilter);
	    java.util.regex.Matcher matcher = pattern.matcher(message);
		return matcher.find();
	}
	
	private boolean customFilterLoggingMessage(String message){
		if (customClassFilterName.equals("")){
			return true;
		}
	
		try {
			Class<?> filterClass = Class.forName(customClassFilterName);
			FilterCustom filter = (FilterCustom) filterClass.newInstance();
			return filter.filter(message);
		} catch (Exception e) {
			return false;
		}
	}
	public boolean log(String userMessage, String level) {
		context = new Context(name, level, userMessage, config.getDatePattern(), config.getDelimeter());
		
		String messageOut = context.generateMessage(config);		
		if(levelLog.isValid(enumLevel.valueOf(level)) && this.regexFilterAccepted(messageOut) && this.customFilterLoggingMessage(messageOut)){
			for (Target target : targets) {
				target.log(messageOut);
			}
			return true;
		 }
		return false;
	}
	
	public boolean log(String message, Throwable e, String level) {
		message += e.getMessage(); 
		return log(message, level);
	}
	
	public void setRegexFilter(String regexFilter){
		this.regexFilter = regexFilter;
	}
	
	public void setCustomFilterClass(String className){
		this.customClassFilterName = className;
	}
	
	public void setLevel(String level) {
		this.level = level;
		levelLog.setLevel(level);
	}
	
	public String getLevel() {
		return level;
	}

	public String getDelimeter() {
		return config.getDelimeter();
	}

	public String getName(){
		return this.name;
	}
	
	public void setDelimeter(String delimeter) {
		config.setDelimeter(delimeter);
	}

	public void setFormat(String format) {
		this.format = format;
		config.setOutputFormat(format);
	}
	
	public String getFormat() {
		return format;
	}
	
	public void addTarget(Target target) {
		if (targets.contains(target)){
			return;
		}
		targets.add(target);
	}
	
	public void removeTarget(Target target) {
		targets.remove(target);
	}
	
	public int TargetsCount() {
		return targets.size();
	}
	
	public void addTarget(String Name){
		try {
			Class<?> targetClass = Class.forName(Name);
			Target target = (Target) targetClass.newInstance();
			targets.add(target);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	@Override
	public boolean equals(Object object){
		if(!(object instanceof MultiTargetLogger)){
			return false;
		}
		MultiTargetLogger otherLoggin = (MultiTargetLogger) object;
		if(this.name.equals(otherLoggin.getName())){
			return true;
		}
		return this == object;	
	}
	 
	@Override
	public int hashCode() {
		return this.TargetsCount() % 7;
	}
	 
	
}
