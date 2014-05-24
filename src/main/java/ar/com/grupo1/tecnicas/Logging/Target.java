package ar.com.grupo1.tecnicas.Logging;

import java.util.ArrayList;

public abstract class Target {
	protected ArrayList<String> listConfiguration;
	abstract void log(Context context, Configuration configuration);
}
