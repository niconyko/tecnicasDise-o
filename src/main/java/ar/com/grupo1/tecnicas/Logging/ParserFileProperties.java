package ar.com.grupo1.tecnicas.Logging;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import java.util.Properties;


public class ParserFileProperties extends ParserFile {

	public ParserFileProperties(String fileProperties, String logName){
		filename = fileProperties;
		sourceName = logName;
	}
	
	public ArrayList<String> parser() {
	
		Properties prop = new Properties();
		InputStream input = null;
	 
		try {
			input = new FileInputStream(filename);
			prop.load(input);
			processFormat(prop.getProperty(sourceName + ".format"));
			this.delimeter = process( prop.getProperty(sourceName + ".delimeter"));
			this.level = process(prop.getProperty(sourceName + ".level"));
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return listConf;
	}	
}
