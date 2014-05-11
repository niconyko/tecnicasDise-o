package ar.com.grupo1.tecnicas.Logging;

public class ConsoleTarget extends Target {

	@Override
	void log(String message, Context context) {
		System.out.println( context.getNameMethod() );
		System.out.println( context.getLineNumber() );
		System.out.println( context.getFileName() );
		System.out.println( context.getThreadName() );
	}

	@Override
	public boolean equals(Object object){
		if(!(object instanceof ConsoleTarget)) return false;
		return true;	
	}
	
	@Override
	public int hashCode() {
		return 1;
	}
	 
}
