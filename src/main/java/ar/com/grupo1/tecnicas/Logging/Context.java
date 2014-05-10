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

	public String GetNameMethod() {
		return nameMethod;
	}

	public int GetLineNumber() {
		return lineNumber;
	}

	public String GetFileName() {
		return fileName;
	}

	public String GetThreadName() {
		return threadName;
	}

	@Override
	public boolean equals(Object object){
		if(!(object instanceof Context)) return false;
		Context context = (Context) object;
		return (this.nameMethod == context.GetFileName() && this.lineNumber == context.GetLineNumber()
				&& this.threadName == context.GetThreadName());	
	}
	
	@Override
	public int hashCode() {
		return this.GetLineNumber() % 7;
	}
	 
}
