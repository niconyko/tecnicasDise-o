package ar.com.grupo1.tecnicas.Logging;

import static org.junit.Assert.*;

import org.junit.Test;


public class LevelTest{

	
	@Test
	public void testIfLevelIsValid() {
		Level level = new Level("DEBUG");
		String particularLevel = "DEBUG";
		assert( level.isValid(particularLevel) );
	}
	
	@Test
	public void testSetLevelAndTheLevelIsValid() {
		Level level = new Level("WARN");
		String particularLevel = "ERROR";
			
		assert( level.isValid(particularLevel) );
	}
	
	@Test
	public void testSetLevelAndTheLevelIsInvalid() {
		Level level = new Level("OFF");	
		String particularLevel = "ERROR";
		assert( ! level.isValid(particularLevel) );
	}
	
	@Test
	public void testSetLevelAndTheLevelIsValidWithEqualLevel() {
		Level level = new Level("DEBUG");
		String particularLevel = "WARN";
		level.setLevel("WARN");		
		assert(  level.isValid(particularLevel) );
	}
	
}