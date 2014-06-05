package ar.com.grupo1.tecnicas.Logging;

public class CustomTarget extends Target {

	@Override
	void log(Context context, Configuration configuration) {
		System.out.println("Logging a custom target");
	}

}
