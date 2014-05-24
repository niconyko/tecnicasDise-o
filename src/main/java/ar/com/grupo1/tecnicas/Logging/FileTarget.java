package ar.com.grupo1.tecnicas.Logging;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class FileTarget extends Target{

	String destination;
	
	public FileTarget(String destination) {
		this.destination = destination;
	}
	
	@Override
	void log(Context context, Configuration configuration) {
		String message = context.generateMessage(configuration);
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(destination, true)))) {
		    out.println(message);
		    out.close();
		}catch (Exception e) {
			//handel exception
		};
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
