package ar.com.grupo1.tecnicas.Logging;


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
		
		if( level.compareTo(otherlevel) <= 0){
			return true;			
		}
		return false;
	}
		
}
