package ar.com.grupo1.tecnicas.Logging;



public interface ILogging {
	//public enum Level {DEBUG, INFO, WARN, ERROR, FATAL, OFF}
	void log (String message, String level, Context context);
	void setLevel(String level);
	String getLevel();
	void setFormat(String format);
	String getFormat();
	void addTarget(Target target);
	void removeTarget(Target target);
}
