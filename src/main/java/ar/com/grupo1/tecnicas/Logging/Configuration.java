package ar.com.grupo1.tecnicas.Logging;

import java.util.ArrayList;

public class Configuration {
	
	private ParserFile parser;
	private String fileProperties = "./logger-config.properties";
	private ArrayList<String> listConfiguration;
	
	public Configuration(){
		parser = new ParserFileProperties(fileProperties);
		//parser = new ParserFileXml(fileProperties);
		listConfiguration = parser.parser();
	}
	
	public ArrayList<String> getConfiguration(){		
		return listConfiguration;
	}
	
	public void setOutputFormat(String format){		
		listConfiguration = parser.setFormat(format);
	}
	
	public String getDatePattern(){
		return parser.getDatePattern();
	}
	
	public String getDelimeter() {
		return parser.getDelimeter();
	}
	
	public String getFilterLevel() {
		return parser.getFilterLevel();
	}
	
	public void setDelimeter(String delimeter) {
		parser.setDelimeter(delimeter);
	}
	
	public void setFilterLevel(String level) {
		parser.setFilterLevel(level);
	}
}
