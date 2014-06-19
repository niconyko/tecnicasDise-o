package ar.com.grupo1.tecnicas.Logging;

import java.util.ArrayList;
import java.util.Arrays;

abstract class ParserFile {
	
	protected String filename;
	protected String sourceName = null;
	protected ArrayList<String> listConf;
	protected String datePattern = null;
	protected String delimeter = "-";
	protected String level = "TRACE";
	abstract ArrayList<String> parser();
	
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
	
	/*
	protected void processDelimeter(String readDelimiter) {
		if (readDelimiter == null){	return;	}
		this.delimeter = readDelimiter;
	}
	
	protected void processLevel(String readLevel) {
		if (readLevel == null){	return;}
		this.level = readLevel;
	}
	
	*/
	
	protected String process(String value){
		if(value == null){ return null;}
		return value;
		
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
	
	public String getFilterLevel() {
		return this.level;
	}
	
	public void setDelimeter(String delimeter) {
		this.delimeter = delimeter;
	}
	
	public void setFilterLevel(String level) {
		this.level = level;
	}

}
