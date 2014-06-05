package ar.com.grupo1.tecnicas.Logging;

public class ConsoleTarget extends Target {

	@Override
	void log(String message) {
		System.out.println(message);
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
