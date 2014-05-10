package ar.com.grupo1.tecnicas.Logging;

public class ConsoleTarget extends Target {

	@Override
	void log(String message) {
		System.out.println("logueando consola");
	}

}
