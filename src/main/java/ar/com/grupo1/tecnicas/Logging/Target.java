package ar.com.grupo1.tecnicas.Logging;

import java.util.ArrayList;

public abstract class Target {
	protected ArrayList<String> listConfiguration;
	abstract void log(Context context, Configuration configuration);
	protected String generateMessage(Context context, Configuration configuration) {
		ArrayList<String> dataList = configuration.getConfiguration();
		String finalString = "";
		
		for (String key : dataList) {
			finalString += context.getData(key);
			finalString += context.getSeparator();
		}
		
		return finalString;
	}
}
