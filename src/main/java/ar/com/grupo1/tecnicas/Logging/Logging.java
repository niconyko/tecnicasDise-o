package ar.com.grupo1.tecnicas.Logging;

import java.util.ArrayList;
import java.util.regex.Pattern;


public class Logging implements ILogging{
	private String name = "";
	private String level = "";
	private String format = "";
	private String regexFilter = ".*";
	private ArrayList<Target> targets;
	private Level levelLog;
	private Context context;
	private Configuration config;
	
	public Logging (String name) {
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
	public void log(String message, String level) {
		context = new Context(name, level, message, config.getDatePattern(), config.getDelimeter());
	
		if(levelLog.isValid(level) && this.regexFilterAccepted(message)){
			for (Target target : targets) {
				target.log(context, config);
			}
		}
	}
	
	public void setRegexFilter(String regexFilter){
		this.regexFilter = regexFilter;
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
		if (targets.contains(target)) return;
		targets.add(target);
	}
	
	public void removeTarget(Target target) {
		targets.remove(target);
	}
	
	public int TargetsCount() {
		return targets.size();
	}
	
	@Override
	public boolean equals(Object object){
		if(!(object instanceof Logging)) return false;
		Logging otherLoggin = (Logging) object;
		if(this.name.equals(otherLoggin.getName())) return true;
		return this == object;	
	}
	 
	@Override
	public int hashCode() {
		return this.TargetsCount() % 7;
	}
	 
	
}
