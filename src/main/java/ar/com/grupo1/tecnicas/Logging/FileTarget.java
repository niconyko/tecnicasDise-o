package ar.com.grupo1.tecnicas.Logging;

public class FileTarget extends Target{

	String destination;
	
	public FileTarget(String destination) {
		this.destination = destination;
	}
	
	@Override
	void log(String message) {
		System.out.println("Logueando file");
	}
	
	public String getTargetDestination(){
		return destination;
	}
	

}
