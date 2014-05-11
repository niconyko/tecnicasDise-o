package ar.com.grupo1.tecnicas.Logging;


public class Context {

	private String nameMethod, fileName, threadName, level;
	private int lineNumber;

	
	public Context(String nameMethod, int lineNumber, String fileName, String threadName , String level) {
		this.nameMethod = nameMethod;
		this.lineNumber = lineNumber;
		this.fileName = fileName;
		this.threadName = threadName;
		this.level = level;
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
