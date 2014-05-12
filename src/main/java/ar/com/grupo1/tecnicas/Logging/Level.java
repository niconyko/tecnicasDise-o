package ar.com.grupo1.tecnicas.Logging;

import java.util.ArrayList;


public class Level {

	private ArrayList<String> listLevel;
	private int levelLog;
	
	public Level(String filterLevel) {
		listLevel = new ArrayList<String>();
		listLevel.add("DEBUG");
		listLevel.add("INFO");
		listLevel.add("WARN");
		listLevel.add("ERROR");
		listLevel.add("FATAL");
		listLevel.add("OFF");
		
		setLevel(filterLevel);
	} 
	
	public void setLevel(String level){
		if(listLevel.contains(level))
			levelLog = listLevel.indexOf(level);
	}
	
	public boolean isValid( String level ){
		if( levelLog <= listLevel.indexOf(level))
			return true;
		return false;
	}
		
}
