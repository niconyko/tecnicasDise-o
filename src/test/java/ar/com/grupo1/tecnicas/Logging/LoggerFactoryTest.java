package ar.com.grupo1.tecnicas.Logging;

import static org.junit.Assert.*;
import org.junit.Test;

public class LoggerFactoryTest {
	String name = "name";
	String name2 = "name2";

	@Test
	public void emptyWhenStart(){
		LoggerFactory.reset();
		assertEquals(LoggerFactory.getLoggingCount(), 0);
	}
	
	@Test
	public void addLogger(){
		LoggerFactory.reset();
		assertTrue(LoggerFactory.addLog(name));
		assertEquals(LoggerFactory.getLoggingCount(), 1);
	}

	@Test
	public void addTheSameLoggerTwice(){
		LoggerFactory.reset();
		assertTrue(LoggerFactory.addLog(name));
		assertEquals(LoggerFactory.getLoggingCount(), 1);
		assertFalse(LoggerFactory.addLog(name));
		assertEquals(LoggerFactory.getLoggingCount(), 1);
	}

	@Test
	public void addMoreThanOneLog(){
		LoggerFactory.reset();
		assertTrue(LoggerFactory.addLog(name));
		assertEquals(LoggerFactory.getLoggingCount(), 1);
		assertTrue(LoggerFactory.addLog(name2));
		assertEquals(LoggerFactory.getLoggingCount(), 2);
	}

	@Test
	public void removeLog(){
		LoggerFactory.reset();
		assertTrue(LoggerFactory.addLog(name));
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
	public void getLoggerWhenNotExist(){
		LoggerFactory.reset();
		assertEquals(LoggerFactory.getLogger(name),null);
	}
	
	@Test
	public void getLogger(){
		LoggerFactory.reset();
		assertTrue(LoggerFactory.addLog(name));
		Logging logger = LoggerFactory.getLogger(name);
		assertNotEquals(logger,null);
		assertEquals(logger.getName(), name);
	}
	

	@Test
	public void removeLogWhenThereAreMoreThanOneLog(){
		LoggerFactory.reset();
		assertTrue(LoggerFactory.addLog(name));
		assertTrue(LoggerFactory.addLog(name2));
		assertTrue(LoggerFactory.removeLog(name));
		assertEquals(LoggerFactory.getLogger(name), null);
		assertNotEquals(LoggerFactory.getLogger(name2),null);
	}
	
	
}
