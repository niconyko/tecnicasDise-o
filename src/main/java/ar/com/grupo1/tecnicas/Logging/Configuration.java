package ar.com.grupo1.tecnicas.Logging;

import java.util.ArrayList;

public class Configuration {
	
	private ParserFileProperties parser;
	private ArrayList<String> listConfiguration;
	
	public Configuration(String fileProperties){
		parser = new ParserFileProperties( fileProperties );
		listConfiguration = parser.parser();
	}
	
	public ArrayList<String> getConfiguration(){		
		return listConfiguration;
	}
	
	public String getDatePattern(){
		return parser.getDatePattern();
	}
}
