package ar.com.grupo1.tecnicas.Logging;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;


public class Context {

	private String nameMethod, fileName, threadName, level, message, datePattern, separator, lineNumber;
	private Hashtable data;
	
	
	public Context(String level, String message, String datePattern) {
		this.nameMethod = Thread.currentThread().getStackTrace()[3].getMethodName();
		this.lineNumber = String.valueOf(Thread.currentThread().getStackTrace()[3].getLineNumber());
		this.fileName = Thread.currentThread().getStackTrace()[3].getFileName();
		this.threadName = Thread.currentThread().getName();
		this.level = level;
		this.message = message;
		this.datePattern = processDate(datePattern);
		this.separator = "-";
		
		data = new Hashtable();
		loadConfigHash();
	}

	private String processDate(String datePattern) {
		if(datePattern == null) return null;
		SimpleDateFormat date = new SimpleDateFormat(datePattern);
		return date.format(new Date());
	}
	
	private void loadConfigHash() {
		data.put("%d", this.datePattern);
		data.put("%p", this.level);
		data.put("%t", this.threadName);
		data.put("%m", this.message);
		data.put("%%", "%");
		data.put("%n", this.separator);
		data.put("%L", this.lineNumber);
		data.put("%F", this.fileName);
		data.put("%M", this.nameMethod);
	}
	
	public String getData(String key) {
		return (String) data.get(key);
	}
	
	public String getSeparator() {
		return this.separator;
	}

	@Override
	public boolean equals(Object object){
		if(!(object instanceof Context)) return false;
		Context context = (Context) object;
		return (this.nameMethod == context.getData("%F") && this.lineNumber == getData("%L")
				&& this.threadName == context.getData("%t") && this.level == context.getData("%p") );	
	}
	
	@Override
	public int hashCode() {
		return Integer.valueOf(this.getData("%L")) % 7;
	}
	 
}
