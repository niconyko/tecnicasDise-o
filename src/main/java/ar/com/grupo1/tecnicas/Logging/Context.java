package ar.com.grupo1.tecnicas.Logging;


public class Context {

	private String nameMethod, fileName, threadName, level, message;
	private int lineNumber;
	
	
	public Context(String level, String message) {
		this.nameMethod = Thread.currentThread().getStackTrace()[3].getMethodName();;
		this.lineNumber = Thread.currentThread().getStackTrace()[3].getLineNumber();
		this.fileName = Thread.currentThread().getStackTrace()[3].getFileName();
		this.threadName = Thread.currentThread().getName();
		this.level = level;
		this.message = message;
	}

	public String getNameMethod() {
		return nameMethod;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public String getFileName() {
		return fileName;
	}

	public String getThreadName() {
		return threadName;
	}
	
	public String getLevel() {
		return level;
	}

	@Override
	public boolean equals(Object object){
		if(!(object instanceof Context)) return false;
		Context context = (Context) object;
		return (this.nameMethod == context.getFileName() && this.lineNumber == context.getLineNumber()
				&& this.threadName == context.getThreadName() && this.level == context.getLevel() );	
	}
	
	@Override
	public int hashCode() {
		return this.getLineNumber() % 7;
	}
	 
}
