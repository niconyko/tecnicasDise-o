package ar.com.grupo1.tecnicas.Logging;



public class Logging implements ILogging{
	String level;
	private String format;
	public void log(String message, Level level, Context context) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}
	public void removeTarget(Target target) {
		// TODO Auto-generated method stub
		
	}
	


}
