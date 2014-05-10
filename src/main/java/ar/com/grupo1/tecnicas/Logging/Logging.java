package ar.com.grupo1.tecnicas.Logging;

import java.util.ArrayList;



public class Logging implements ILogging{
	private String level = "";
	private String format = "";
	private ArrayList<Target> targets;
	
	public Logging(){
		targets = new ArrayList<Target>();
	}
	
	public void log(String message, String level, Context context) {
		for (Target target : targets) {
			target.log(message);
		}
	}
	
	public void setLevel(String level) {
		this.level = level;
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
	
}
