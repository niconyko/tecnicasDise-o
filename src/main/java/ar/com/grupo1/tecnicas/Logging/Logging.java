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
		levelLog = new Level();
		config = new Configuration(fileProperties);
	}
	
	public void log(String message, String level) {
		
		String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
		String fileName = Thread.currentThread().getStackTrace()[2].getFileName();
		String getName = Thread.currentThread().getName();
	
		context = new Context(methodName, lineNumber, fileName, getName, level );
	
		if( levelLog.isValid(level) ){
			for (Target target : targets) {
				target.log(message, context, config);
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
	
	public void setFormat(String format) {
		this.format = format;
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
