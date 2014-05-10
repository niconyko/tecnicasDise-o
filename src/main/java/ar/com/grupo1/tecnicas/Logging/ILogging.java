package ar.com.grupo1.tecnicas.Logging;

public interface ILogging {
	public enum level {DEBUG, INFO, WARN, ERROR, FATAL, OFF}
	void log (String message, level level, Context context);
	void setLevel(level level);
	void getLevel();
	void setFormat(String format);
	void getFormat();
	void addTarget(Target target);
	void removeTarget(Target target);
}
