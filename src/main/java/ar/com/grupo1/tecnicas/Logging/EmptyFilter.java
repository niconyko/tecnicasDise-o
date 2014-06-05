package ar.com.grupo1.tecnicas.Logging;

public class EmptyFilter implements FilterCustom {
	public EmptyFilter(){
		System.out.println("runtime loaded method");
	}

	@Override
	public boolean filter(String message) {
		return true;
	}
}
