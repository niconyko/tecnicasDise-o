package ar.com.grupo1.tecnicas.Logging;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.com.grupo1.tecnicas.Target.MultiTargetLogger;

public class LoggerFactoryTest {
	String name = "Name";
	String name2 = "Juan";

	@Test
	public void emptyWhenStart(){
		LoggerFactory.reset();
		assertEquals(LoggerFactory.getLoggingCount(), 0);
	}
	
	@Test
	public void addLogger(){
		LoggerFactory.reset();
		assertNotEquals(LoggerFactory.getLogger(name), null);
		assertEquals(LoggerFactory.getLoggingCount(), 1);
	}

	@Test
	public void addTheSameLoggerTwice(){
		LoggerFactory.reset();
		assertNotEquals(LoggerFactory.getLogger(name), null);
		assertEquals(LoggerFactory.getLoggingCount(), 1);
		assertNotEquals(LoggerFactory.getLogger(name), null);
		assertEquals(LoggerFactory.getLoggingCount(), 1);
	}

	@Test
	public void addMoreThanOneLog(){
		LoggerFactory.reset();
		assertNotEquals(LoggerFactory.getLogger(name), null);
		assertEquals(LoggerFactory.getLoggingCount(), 1);
		assertNotEquals(LoggerFactory.getLogger(name2), null);
		assertEquals(LoggerFactory.getLoggingCount(), 2);
	}

	@Test
	public void removeLog(){
		LoggerFactory.reset();
		assertNotEquals(LoggerFactory.getLogger(name), null);
		assertEquals(LoggerFactory.getLoggingCount(), 1);
		assertTrue(LoggerFactory.removeLog(name));
		assertEquals(LoggerFactory.getLoggingCount(), 0);
	}

	@Test
	public void removeLogThatNotExist(){
		LoggerFactory.reset();
		assertFalse(LoggerFactory.removeLog(name));
	}
	
	@Test
	public void getLoggerWhenNotExistAndCreateANewOne(){
		LoggerFactory.reset();
		assertEquals(LoggerFactory.getLoggingCount(), 0);
		assertNotEquals(LoggerFactory.getLogger(name),null);
	}
	
	@Test
	public void getLogger(){
		LoggerFactory.reset();
		assertNotEquals(LoggerFactory.getLogger(name), null);
		MultiTargetLogger logger = LoggerFactory.getLogger(name);
		assertNotEquals(logger,null);
		assertEquals(logger.getName(), name);
	}
	

	@Test
	public void removeLogWhenThereAreMoreThanOneLog(){
		LoggerFactory.reset();
		MultiTargetLogger logging1 = LoggerFactory.getLogger(name);
		MultiTargetLogger logging2 = LoggerFactory.getLogger(name2);
		assertTrue(LoggerFactory.removeLog(name));
	
		assertFalse(LoggerFactory.getLogger(name) == logging1);
		assertTrue(LoggerFactory.getLogger(name2) == logging2);
	}	
}
