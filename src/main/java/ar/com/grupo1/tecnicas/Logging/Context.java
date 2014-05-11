package ar.com.grupo1.tecnicas.Logging;


public class Context {

	private String nameMethod, fileName, threadName;
	private int lineNumber;

	
	public Context(String nameMethod, int lineNumber, String fileName, String threadName) {
		this.nameMethod = nameMethod;
		this.lineNumber = lineNumber;
		this.fileName = fileName;
		this.threadName = threadName;
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

	@Override
	public boolean equals(Object object){
		if(!(object instanceof Context)) return false;
		Context context = (Context) object;
		return (this.nameMethod == context.getFileName() && this.lineNumber == context.getLineNumber()
				&& this.threadName == context.getThreadName());	
	}
	
	@Override
	public int hashCode() {
		return this.getLineNumber() % 7;
	}
	 
}
