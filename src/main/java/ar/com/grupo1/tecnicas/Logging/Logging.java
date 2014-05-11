package ar.com.grupo1.tecnicas.Logging;

import java.util.ArrayList;



public class Logging implements ILogging{
	private String level = "";
	private String format = "";
	private ArrayList<Target> targets;
	private Level levelLog;
	
	public Logging(){
		targets = new ArrayList<Target>();
		levelLog = new Level();
	}
	
	public void log(String message, String level, Context context) {
		System.out.println ("The line number is " + Thread.currentThread().getStackTrace()[2].getLineNumber());
		System.out.println("The Method name " + Thread.currentThread().getStackTrace()[2].getMethodName());
		System.out.println("The File name " + Thread.currentThread().getStackTrace()[2].getFileName());
		System.out.println("The thread name " + Thread.currentThread().getName());
		if( levelLog.isValid(level) ){
			for (Target target : targets) {
				target.log(message);
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
