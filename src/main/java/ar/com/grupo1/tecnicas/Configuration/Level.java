package ar.com.grupo1.tecnicas.Configuration;


public class Level {

	public enum enumLevel {TRACE, DEBUG, INFO, WARN, ERROR, FATAL, OFF};
	private enumLevel level;
	
	public Level(enumLevel filterLevel) {
		level = filterLevel;
	} 
	
	public void setLevel(enumLevel levelSet){
		level = levelSet;
	}
	
	public boolean isValid(enumLevel otherlevel ){
		
		return ( level.compareTo(otherlevel) <= 0);
	}
		
}
