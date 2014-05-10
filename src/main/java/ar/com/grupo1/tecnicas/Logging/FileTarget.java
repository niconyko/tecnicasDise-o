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
	
	@Override
	public boolean equals(Object object){
		if(!(object instanceof FileTarget)) return false;
		FileTarget fileTarget = (FileTarget) object;
		return (this.destination.equals(fileTarget.getTargetDestination()));	
	}
	
	@Override
	public int hashCode() {
		return	destination.length() % 7;
	}

}
