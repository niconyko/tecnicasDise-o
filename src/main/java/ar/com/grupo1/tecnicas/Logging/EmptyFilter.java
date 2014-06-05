package ar.com.grupo1.tecnicas.Logging;

public class EmptyFilter implements filterCustom {
	public EmptyFilter(){
		System.out.println("runtime loaded method");
	}

	@Override
	public boolean filter(String message, Context context) {
		return true;
	}
}
