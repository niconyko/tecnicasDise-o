package ar.com.grupo1.tecnicas.Configuration;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.com.grupo1.tecnicas.Configuration.Level;
import ar.com.grupo1.tecnicas.Configuration.Level.enumLevel;


public class LevelTest{

	
	@Test
	public void testIfLevelIsValid() {
		Level level = new Level(enumLevel.DEBUG);
		assert( level.isValid(enumLevel.DEBUG) );
	}
	
	@Test
	public void testSetLevelAndTheLevelIsValid() {
		Level level = new Level(enumLevel.WARN);
			
		assert( level.isValid(enumLevel.ERROR) );
	}
	
	@Test
	public void testSetLevelAndTheLevelIsInvalid() {
		Level level = new Level(enumLevel.OFF);	
		assert( ! level.isValid(enumLevel.ERROR) );
	}
	
	@Test
	public void testSetLevelAndTheLevelIsValidWithEqualLevel() {
		Level level = new Level(enumLevel.DEBUG);
		level.setLevel(enumLevel.WARN);		
		assert(  level.isValid(enumLevel.WARN) );
	}
	
	@Test
	public void everyLevelIsValidForTraceLevel() {

		Level level = new Level(enumLevel.TRACE);

		assertTrue( level.isValid(enumLevel.TRACE) );
		assertTrue( level.isValid(enumLevel.DEBUG) );
		assertTrue( level.isValid(enumLevel.INFO) );
		assertTrue( level.isValid(enumLevel.WARN) );
		assertTrue( level.isValid(enumLevel.ERROR) );
		assertTrue( level.isValid(enumLevel.FATAL) );
		assertTrue( level.isValid(enumLevel.OFF) );
		
	}

	@Test
	public void traceLevelIsNotValidForDebugLevel() {

		Level level = new Level(enumLevel.DEBUG);

		assertFalse( level.isValid(enumLevel.TRACE) );
		
	}
}