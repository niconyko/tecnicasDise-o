package ar.com.grupo1.tecnicas.Parser;

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
			processDelimeter( prop.getProperty(sourceName + ".delimeter"));
			processLevel(prop.getProperty(sourceName + ".level"));
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					System.err.println("Input-Output Error");
					e.printStackTrace();
				}
			}
		}
		return listConf;
	}	
}
