package ar.com.grupo1.tecnicas.Logging;

import static org.junit.Assert.*;

import java.util.logging.Level;

import org.junit.Test;

public class LoggingTest {

	String format = "this is my output format";
	String logName = "name";
	private String filename = "./prueba.properties2";
	@Test
	public void testGetLevel() {
		Logging logging = new Logging(filename, logName);
		logging.setLevel(Level.INFO.toString());
		assertEquals( Level.INFO.toString(), logging.getLevel());
	}
	
	@Test
	public void testGetFormat() {
		Logging logging = new Logging(filename, logName);
		logging.setFormat(format);
		assertEquals( format, logging.getFormat());
	}
	
	@Test
	public void testCreateEmpty() {
		String emptyValue = "";
		Logging logging = new Logging(filename, logName);
		assertEquals( emptyValue , logging.getFormat() );
		assertEquals( emptyValue, logging.getLevel());
		assertEquals( 0, logging.TargetsCount() );
	}

	@Test
	public void testAddConsoleTarget() {
		Logging logging = new Logging(filename, logName);
		ConsoleTarget consoleTarget = new ConsoleTarget();
		logging.addTarget(consoleTarget);
		assertEquals(1, logging.TargetsCount());
		
	}

	@Test
	public void testAddFileTarget() {
		String target = "target";
		String anotherTarget = "target2";
		Logging logging = new Logging(filename, logName);

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
		
		Logging logging = new Logging(filename, logName);

		FileTarget fileTarget = new FileTarget(target);
		logging.addTarget(fileTarget);
		
		ConsoleTarget consoleTarget = new ConsoleTarget();
		logging.addTarget(consoleTarget);
		
		assertEquals(2, logging.TargetsCount());
	}
	
	@Test
	public void testAddTwiceTheSameTarget() {
		String target = "target";
		
		Logging logging = new Logging(filename, logName);
		FileTarget fileTarget = new FileTarget(target);
		
		logging.addTarget(fileTarget);
		logging.addTarget(fileTarget);
		
		assertEquals(1, logging.TargetsCount());
	}

	@Test
	public void testCantAddTwoConsoleTargets() {
	
		Logging logging = new Logging(filename, logName);
		ConsoleTarget consoleTarget = new ConsoleTarget();
		
		logging.addTarget(consoleTarget);
		logging.addTarget(consoleTarget);
		
		assertEquals( 1, logging.TargetsCount());
	}

	@Test
	public void testDeleteFileTarget() {
		String target = "target";
		
		Logging logging = new Logging(filename, logName);
		
		FileTarget fileTarget = new FileTarget(target);		
		logging.addTarget(fileTarget);
		logging.removeTarget(fileTarget);
		
		assertEquals(0, logging.TargetsCount());
	}

	@Test
	public void testDeleteConsoleTarget() {
		
		Logging logging = new Logging(filename, logName);
		ConsoleTarget consoleTarget = new ConsoleTarget();		
		logging.addTarget(consoleTarget);
		logging.removeTarget(consoleTarget);
		
		assertEquals(0, logging.TargetsCount());
	}

	@Test
	public void testDeleteUnexistingTarget() {
		String target = "target";
		
		Logging logging = new Logging(filename, logName);
		FileTarget fileTarget = new FileTarget(target);
		
		logging.addTarget(fileTarget);
		logging.removeTarget(new ConsoleTarget());
		
		assertEquals(1, logging.TargetsCount());
	}
	
	@Test
	public void SetDelimiter() {
		String delimeter = ";";
		Logging logging = new Logging(filename, logName);
		logging.setDelimeter(delimeter);
		assertEquals(logging.getDelimeter(),delimeter);
	}

	@Test
	public void regexMatchWithRegexFilterNotInitialized() {
		Logging logging = new Logging(filename, logName);
		assertTrue(logging.regexFilterAccepted("aasdfasdfasdfafda"));
		assertTrue(logging.regexFilterAccepted(""));
		assertTrue(logging.regexFilterAccepted("12341243"));
		assertTrue(logging.regexFilterAccepted("  "));
	}
	
	@Test
	public void regexStringWithABegginingFilter() {
		Logging logging = new Logging(filename, logName);
		logging.setRegexFilter("^a");
		assertTrue(logging.regexFilterAccepted("aasdfasdfasdfafda"));
		assertFalse(logging.regexFilterAccepted(""));
		assertFalse(logging.regexFilterAccepted("12341243"));
		assertFalse(logging.regexFilterAccepted("  "));
	}
	
	@Test
	public void regexStringWithOneCharacterFilter() {
		Logging logging = new Logging(filename, logName);
		logging.setRegexFilter("^.$");
		assertFalse(logging.regexFilterAccepted("aasdfasdfasdfafda"));
		assertFalse(logging.regexFilterAccepted(""));
		assertFalse(logging.regexFilterAccepted("12341243"));
		assertFalse(logging.regexFilterAccepted("  "));
		assertTrue(logging.regexFilterAccepted("k"));
	}
	
	@Test
	public void regexStringWithNumbersFilter() {
		Logging logging = new Logging(filename, logName);
		logging.setRegexFilter("^[0-9]*$");
		assertFalse(logging.regexFilterAccepted("aasdfasdfasdfafda"));
		assertTrue(logging.regexFilterAccepted(""));
		assertTrue(logging.regexFilterAccepted("12341243"));
		assertFalse(logging.regexFilterAccepted("  "));
		assertFalse(logging.regexFilterAccepted("k"));
	}
}
