package ar.com.grupo1.tecnicas.Logging;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import java.util.Properties;


public class ParserFileProperties extends ParserFile {

	public ParserFileProperties(String fileProperties){
		filename = fileProperties;
	}
	
	public ArrayList<String> parser() {
	
		Properties prop = new Properties();
		InputStream input = null;
	 
		try {
			input = new FileInputStream(filename);
			prop.load(input);
			processFormat(prop.getProperty("format"));
			processDelimeter( prop.getProperty("delimeter"));
			processLevel(prop.getProperty("level"));
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
