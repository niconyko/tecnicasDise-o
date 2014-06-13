package ar.com.grupo1.tecnicas.Logging;

import java.io.File;
import java.util.ArrayList;

public class Configuration {
	
	private ParserFile parser;
	private final String fileProperties = "./logger-config.properties";
	private final String fileXML = "./logger-config.xml";
	private ArrayList<String> listConfiguration;
	
	public Configuration(String sourceName){
		parser = loadConfiguration(sourceName);
		listConfiguration = parser.parser();
	}
	
	private ParserFile loadConfiguration(String sourceName) {
		File f = new File(fileProperties);
		if(f.isFile()) {
			return new ParserFileProperties(fileProperties, sourceName);
		}
		f = new File(fileXML);
		if(f.isFile()){
			return new ParserFileXml(fileXML, sourceName);
		}
		return new ParserDefault();
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
