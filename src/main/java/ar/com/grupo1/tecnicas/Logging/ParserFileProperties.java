package ar.com.grupo1.tecnicas.Logging;

import java.util.ArrayList;

public class ParserFileProperties {

	private String file;
	private ArrayList<String> a;
	
	public ParserFileProperties(String fileProperties){
		file = fileProperties;
		a = new ArrayList<String>();
	}
	
	public ArrayList<String> parser(){
		a.add("d");
		a.add("HH:mm:ss");
		a.add("p");
		a.add("t");
		a.add("m");
		a.add("%");
		a.add("n");
		a.add("d");
		a.add("l");
		a.add("f");
		a.add("M");
		
		return a;
	}
	
}
