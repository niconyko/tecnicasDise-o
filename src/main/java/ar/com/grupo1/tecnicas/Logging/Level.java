package ar.com.grupo1.tecnicas.Logging;



public class Level {

	private enum enumLevel {TRACE, DEBUG, INFO, WARN, ERROR, FATAL, OFF};
	private enumLevel level;
	
	public Level(String filterLevel) {
		
		level = enumLevel.valueOf(filterLevel);
		
	} 
	
	public void setLevel(String levelSet){
		level = enumLevel.valueOf(levelSet);
		
	}
	
	public boolean isValid( String otherlevel ){
		enumLevel aux = enumLevel.valueOf(otherlevel);
		
		if( level.compareTo(aux) <= 0){
			return true;			
		}
		return false;
	}
		
}
