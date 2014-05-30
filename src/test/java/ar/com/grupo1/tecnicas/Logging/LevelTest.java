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
	
	@Test
	public void everyLevelIsValidForTraceLevel() {

 		String traceLevel = "TRACE";
 		String debugLevel = "DEBUG";
		String infoLevel = "INFO";
		String warnLevel = "WARN";
		String errorLevel = "ERROR";
		String fatalLevel = "FATAL";
		String offLevel = "OFF";

		Level level = new Level(traceLevel);

		assertTrue( level.isValid(traceLevel) );
		assertTrue( level.isValid(debugLevel) );
		assertTrue( level.isValid(infoLevel) );
		assertTrue( level.isValid(warnLevel) );
		assertTrue( level.isValid(errorLevel) );
		assertTrue( level.isValid(fatalLevel) );
		assertTrue( level.isValid(offLevel) );
		
	}

	@Test
	public void traceLevelIsNotValidForDebugLevel() {

 		String traceLevel = "TRACE";
 		String debugLevel = "DEBUG";
		Level level = new Level(debugLevel);

		assertFalse( level.isValid(traceLevel) );
		
	}
}