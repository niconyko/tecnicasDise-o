package ar.com.grupo1.tecnicas.Logging;

import static org.junit.Assert.*;

import java.util.logging.Level;

import org.junit.Test;

public class LoggingTest {

	String format = "this is my output format";
	private String filename = "./prueba.properties2";
	@Test
	public void testGetLevel() {
		Logging logging = new Logging(filename);
		logging.setLevel(Level.INFO.toString());
		assertEquals( Level.INFO.toString(), logging.getLevel());
	}
	
	@Test
	public void testGetFormat() {
		Logging logging = new Logging(filename);
		logging.setFormat(format);
		assertEquals( format, logging.getFormat());
	}
	
	@Test
	public void testCreateEmpty() {
		String emptyValue = "";
		Logging logging = new Logging(filename);
		assertEquals( emptyValue , logging.getFormat() );
		assertEquals( emptyValue, logging.getLevel());
		assertEquals( 0, logging.TargetsCount() );
	}

	@Test
	public void testAddConsoleTarget() {
		Logging logging = new Logging(filename);
		ConsoleTarget consoleTarget = new ConsoleTarget();
		logging.addTarget(consoleTarget);
		assertEquals(1, logging.TargetsCount());
		
	}

	@Test
	public void testAddFileTarget() {
		String target = "target";
		String anotherTarget = "target2";
		Logging logging = new Logging(filename);

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
		
		Logging logging = new Logging(filename);

		FileTarget fileTarget = new FileTarget(target);
		logging.addTarget(fileTarget);
		
		ConsoleTarget consoleTarget = new ConsoleTarget();
		logging.addTarget(consoleTarget);
		
		assertEquals(2, logging.TargetsCount());
	}
	
	@Test
	public void testAddTwiceTheSameTarget() {
		String target = "target";
		
		Logging logging = new Logging(filename);
		FileTarget fileTarget = new FileTarget(target);
		
		logging.addTarget(fileTarget);
		logging.addTarget(fileTarget);
		
		assertEquals(1, logging.TargetsCount());
	}

	@Test
	public void testCantAddTwoConsoleTargets() {
	
		Logging logging = new Logging(filename);
		ConsoleTarget consoleTarget = new ConsoleTarget();
		
		logging.addTarget(consoleTarget);
		logging.addTarget(consoleTarget);
		
		assertEquals( 1, logging.TargetsCount());
	}

	@Test
	public void testDeleteFileTarget() {
		String target = "target";
		
		Logging logging = new Logging(filename);
		
		FileTarget fileTarget = new FileTarget(target);		
		logging.addTarget(fileTarget);
		logging.removeTarget(fileTarget);
		
		assertEquals(0, logging.TargetsCount());
	}

	@Test
	public void testDeleteConsoleTarget() {
		
		Logging logging = new Logging(filename);
		ConsoleTarget consoleTarget = new ConsoleTarget();		
		logging.addTarget(consoleTarget);
		logging.removeTarget(consoleTarget);
		
		assertEquals(0, logging.TargetsCount());
	}

	@Test
	public void testDeleteUnexistingTarget() {
		String target = "target";
		
		Logging logging = new Logging(filename);
		FileTarget fileTarget = new FileTarget(target);
		
		logging.addTarget(fileTarget);
		logging.removeTarget(new ConsoleTarget());
		
		assertEquals(1, logging.TargetsCount());
	}

}
