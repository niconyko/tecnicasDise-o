package ar.com.grupo1.tecnicas.Logging;

public class ConsoleTarget extends Target {

	@Override
	void log(Context context, Configuration configuration) {
		String finalString = this.generateMessage(context, configuration);
		System.out.println(finalString);
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
