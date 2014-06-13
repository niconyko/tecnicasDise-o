package ar.com.grupo1.tecnicas.Logging;

import static org.junit.Assert.*;

import java.util.logging.Level;

import org.junit.Test;

public class LoggingTest {

	String format = "this is my output format";
	String logName = "Name";
	
	@Test
	public void testGetLevel() {
		MultiTargetLogger logging = new MultiTargetLogger(logName);
		logging.setLevel(Level.INFO.toString());
		assertEquals( Level.INFO.toString(), logging.getLevel());
	}
	
	@Test
	public void testGetFormat() {
		MultiTargetLogger logging = new MultiTargetLogger(logName);
		logging.setFormat(format);
		assertEquals( format, logging.getFormat());
	}
	
	@Test
	public void testCreateEmpty() {
		String emptyValue = "";
		MultiTargetLogger logging = new MultiTargetLogger(logName);
		assertEquals( emptyValue , logging.getFormat() );
		assertEquals( emptyValue, logging.getLevel());
		assertEquals( 0, logging.TargetsCount() );
	}

	@Test
	public void testAddConsoleTarget() {
		MultiTargetLogger logging = new MultiTargetLogger(logName);
		ConsoleTarget consoleTarget = new ConsoleTarget();
		logging.addTarget(consoleTarget);
		assertEquals(1, logging.TargetsCount());
		
	}

	@Test
	public void testAddFileTarget() {
		String target = "target";
		String anotherTarget = "target2";
		MultiTargetLogger logging = new MultiTargetLogger(logName);

		FileTarget fileTarget = new FileTarget(target);
		logging.addTarget(fileTarget);
		assertEquals(logging.TargetsCount(), 1);

		FileTarget otherFileTarget = new FileTarget(anotherTarget);
		logging.addTarget(otherFileTarget);
		assertEquals(2, logging.TargetsCount());
	}
	
	@Test
	public void testAddDifferentTargets() {
		String target = "target";
		
		MultiTargetLogger logging = new MultiTargetLogger(logName);

		FileTarget fileTarget = new FileTarget(target);
		logging.addTarget(fileTarget);
		
		ConsoleTarget consoleTarget = new ConsoleTarget();
		logging.addTarget(consoleTarget);
		
		assertEquals(2, logging.TargetsCount());
	}
	
	@Test
	public void testAddTwiceTheSameTarget() {
		String target = "target";
		
		MultiTargetLogger logging = new MultiTargetLogger(logName);
		FileTarget fileTarget = new FileTarget(target);
		
		logging.addTarget(fileTarget);
		logging.addTarget(fileTarget);
		
		assertEquals(1, logging.TargetsCount());
	}

	@Test
	public void testCantAddTwoConsoleTargets() {
	
		MultiTargetLogger logging = new MultiTargetLogger(logName);
		ConsoleTarget consoleTarget = new ConsoleTarget();
		
		logging.addTarget(consoleTarget);
		logging.addTarget(consoleTarget);
		
		assertEquals( 1, logging.TargetsCount());
	}

	@Test
	public void testDeleteFileTarget() {
		String target = "target";
		
		MultiTargetLogger logging = new MultiTargetLogger(logName);
		
		FileTarget fileTarget = new FileTarget(target);		
		logging.addTarget(fileTarget);
		logging.removeTarget(fileTarget);
		
		assertEquals(0, logging.TargetsCount());
	}

	@Test
	public void testDeleteConsoleTarget() {
		
		MultiTargetLogger logging = new MultiTargetLogger(logName);
		ConsoleTarget consoleTarget = new ConsoleTarget();		
		logging.addTarget(consoleTarget);
		logging.removeTarget(consoleTarget);
		
		assertEquals(0, logging.TargetsCount());
	}

	@Test
	public void testDeleteUnexistingTarget() {
		String target = "target";
		
		MultiTargetLogger logging = new MultiTargetLogger(logName);
		FileTarget fileTarget = new FileTarget(target);
		
		logging.addTarget(fileTarget);
		logging.removeTarget(new ConsoleTarget());
		
		assertEquals(1, logging.TargetsCount());
	}
	
	@Test
	public void SetDelimiter() {
		String delimeter = ";";
		MultiTargetLogger logging = new MultiTargetLogger(logName);
		logging.setDelimeter(delimeter);
		assertEquals(logging.getDelimeter(),delimeter);
	}

	@Test
	public void regexMatchWithRegexFilterNotInitialized() {
		MultiTargetLogger logging = new MultiTargetLogger(logName);
		assertTrue(logging.regexFilterAccepted("aasdfasdfasdfafda"));
		assertTrue(logging.regexFilterAccepted(""));
		assertTrue(logging.regexFilterAccepted("12341243"));
		assertTrue(logging.regexFilterAccepted("  "));
	}
	
	@Test
	public void regexStringWithABegginingFilter() {
		MultiTargetLogger logging = new MultiTargetLogger(logName);
		logging.setRegexFilter("^a");
		assertTrue(logging.regexFilterAccepted("aasdfasdfasdfafda"));
		assertFalse(logging.regexFilterAccepted(""));
		assertFalse(logging.regexFilterAccepted("12341243"));
		assertFalse(logging.regexFilterAccepted("  "));
	}
	
	@Test
	public void regexStringWithOneCharacterFilter() {
		MultiTargetLogger logging = new MultiTargetLogger(logName);
		logging.setRegexFilter("^.$");
		assertFalse(logging.regexFilterAccepted("aasdfasdfasdfafda"));
		assertFalse(logging.regexFilterAccepted(""));
		assertFalse(logging.regexFilterAccepted("12341243"));
		assertFalse(logging.regexFilterAccepted("  "));
		assertTrue(logging.regexFilterAccepted("k"));
	}
	
	@Test
	public void regexStringWithNumbersFilter() {
		MultiTargetLogger logging = new MultiTargetLogger(logName);
		logging.setRegexFilter("^[0-9]*$");
		assertFalse(logging.regexFilterAccepted("aasdfasdfasdfafda"));
		assertTrue(logging.regexFilterAccepted(""));
		assertTrue(logging.regexFilterAccepted("12341243"));
		assertFalse(logging.regexFilterAccepted("  "));
		assertFalse(logging.regexFilterAccepted("k"));
	}
	
	@Test
	public void customFilter() {
		MultiTargetLogger logging = new MultiTargetLogger(logName);
		logging.setCustomFilterClass("ar.com.grupo1.tecnicas.Logging.EmptyFilter");
		assertTrue(logging.log("message", "DEBUG"));
	}
	
	@Test
	public void customTarget() {
		MultiTargetLogger logging = new MultiTargetLogger(logName);
		logging.addTarget("ar.com.grupo1.tecnicas.Logging.CustomTarget");
		assertTrue(logging.log("message", "DEBUG"));
	}
	
	@Test
	public void printThrowable() {
		MultiTargetLogger logging = new MultiTargetLogger(logName);
		Exception e = new Exception("Hay throwable");
		assertTrue(logging.log("message", e,  "DEBUG"));
	}
}
