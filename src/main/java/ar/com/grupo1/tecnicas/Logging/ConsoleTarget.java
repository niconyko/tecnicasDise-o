package ar.com.grupo1.tecnicas.Logging;

public class ConsoleTarget extends Target {

	@Override
	void log(String message) {
		System.out.println(message);
	}

	@Override
	public boolean equals(Object object){
		return object instanceof ConsoleTarget;
	}
	
	@Override
	public int hashCode() {
		return 1;
	}
	 
}
