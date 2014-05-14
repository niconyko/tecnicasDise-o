package ar.com.grupo1.tecnicas.Logging;

import java.util.ArrayList;


public class Logging implements ILogging{
	private String level = "";
	private String format = "";
	private ArrayList<Target> targets;
	private Level levelLog;
	private Context context;
	private Configuration config;
	
	public Logging (String fileProperties) {
		targets = new ArrayList<Target>();
		config = new Configuration(fileProperties);
		levelLog = new Level(config.getFilterLevel() );
	}
	
	public void log(String message, String level) {
		context = new Context(level, message, config.getDatePattern(), config.getDelimeter());
	
		if(levelLog.isValid(level) ){
			for (Target target : targets) {
				target.log(context, config);
			}
		}
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
		return this == object;	
	}
	 
	@Override
	public int hashCode() {
		return this.TargetsCount() % 7;
	}
	 
	
}
