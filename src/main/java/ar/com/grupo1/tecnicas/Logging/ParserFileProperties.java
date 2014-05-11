package ar.com.grupo1.tecnicas.Logging;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class ParserFileProperties {



	private String filename;
	private ArrayList<String> listConf;
	
	
	public ParserFileProperties(String fileProperties){
		filename = fileProperties;
		listConf = new ArrayList<String>();
	}
	
	
	public ArrayList<String> parser(){
		File archivo = new File( filename );
		FileReader fr = null;
		try {
			fr = new FileReader (archivo);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    BufferedReader br = new BufferedReader(fr); 
	 
	    String linea = null;
		try {
			linea = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    while( linea != null){
	    	if(linea.length() > 1){
	    		char caracter = linea.charAt(1);
	    		if( caracter == 'd' ){
	    			String subString = linea.substring(0,2);
	            	String subString1 = linea.substring(3, (linea.length()- 1) );
	            	listConf.add(subString);
	            	listConf.add(subString1);
	            }
	            else{
	            	listConf.add(linea);	            		
	            		
	            }
	       }
	       try {
				linea = br.readLine();
				
	        } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	        }
	    }
	    try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    return listConf;
	}

}
