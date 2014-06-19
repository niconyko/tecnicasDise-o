package ar.com.grupo1.tecnicas.Parser;

import java.util.ArrayList;
import java.util.Arrays;

import ar.com.grupo1.tecnicas.Configuration.Level.enumLevel;

public abstract class ParserFile {
	
	protected String filename;
	protected String sourceName = null;
	protected ArrayList<String> listConf;
	protected String datePattern = null;
	protected String delimeter = "-";
	protected enumLevel level = enumLevel.TRACE;
	public abstract ArrayList<String> parser();
	
	protected void processDatePattern() {
		int i = 0;
		for (String field : listConf) {
			char caracter = field.charAt(1);
    		if( caracter == 'd' ){
    			String shortField = field.substring(0,2);
    			datePattern = field.substring(3, (field.length() - 1) );
            	listConf.set(i, shortField);
            	break;
    		}
    		i++;
		}
	}
	
	protected ArrayList<String> getformatFields(String format){
		return new ArrayList<String>(Arrays.asList(format.split(" ")));
	}
	
	protected void TranslateFormatIntoPattern(String format){
		listConf = getformatFields(format);
		processDatePattern();
	}
	
	protected void processFormat(String format) {		
		if(format!= null && format.equalsIgnoreCase("json") ){
			listConf = new ArrayList<String>();
			listConf.add("json");			
		}
		
		else TranslateFormatIntoPattern(format);
	}
	
	protected void processDelimeter(String readDelimeter) {
		if (readDelimeter == null) return;
		this.delimeter = readDelimeter;
	}

	protected void processLevel(String readLevel) {
		if (readLevel == null) return;
		this.level = enumLevel.valueOf(readLevel);
	}
	
	public ArrayList<String> setFormat(String format){
		TranslateFormatIntoPattern(format);
		return listConf;
	}
	
	public String getDatePattern(){
		return this.datePattern;
	}

	public String getDelimeter() {
		return this.delimeter;
	}
	
	public enumLevel getFilterLevel() {
		return this.level;
	}
	
	public void setDelimeter(String delimeter) {
		this.delimeter = delimeter;
	}
	
	public void setFilterLevel(String level) {
		this.level = enumLevel.valueOf(level);
	}

}
