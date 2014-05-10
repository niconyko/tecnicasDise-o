package ar.com.grupo1.tecnicas.Logging;

import static org.junit.Assert.*;

import java.util.logging.Level;

import org.junit.Test;

public class LoggingTest {

	String format = "this is my output format";
	
	@Test
	public void getLevel() {
		Logging logging = new Logging();
		logging.setLevel(Level.INFO.toString());
		assertEquals(logging.getLevel(), Level.INFO.toString());
	}
	
	@Test
	public void getFormat() {
		Logging logging = new Logging();
		logging.setFormat(format);
		assertEquals(logging.getFormat(), format);
	}
	
	@Test
	public void CreateEmpty() {
		String emptyValue = "";
		Logging logging = new Logging();
		assertEquals(logging.getFormat(), emptyValue);
		assertEquals(logging.getLevel(), emptyValue);
		assertEquals(logging.TargetsCount(), 0);
	}

	@Test
	public void AddConsoleTarget() {
		Logging logging = new Logging();
		ConsoleTarget consoleTarget = new ConsoleTarget();
		logging.addTarget(consoleTarget);
		assertEquals(logging.TargetsCount(), 1);
		
		ConsoleTarget otherconsoleTarget = new ConsoleTarget();
		logging.addTarget(otherconsoleTarget);
		assertEquals(logging.TargetsCount(), 2);
	}

	@Test
	public void AddFileTarget() {
		String target = "target";
		
		Logging logging = new Logging();
		FileTarget fileTarget = new FileTarget(target);
		logging.addTarget(fileTarget);
		assertEquals(logging.TargetsCount(), 1);
	}
	
	@Test
	public void AddDifferentTargets() {
		String target = "target";
		
		Logging logging = new Logging();

		FileTarget fileTarget = new FileTarget(target);
		logging.addTarget(fileTarget);
		
		ConsoleTarget consoleTarget = new ConsoleTarget();
		logging.addTarget(consoleTarget);
		
		assertEquals(logging.TargetsCount(), 2);
	}
	
	@Test
	public void AddTwiceTheSameTarget() {
		String target = "target";
		
		Logging logging = new Logging();
		FileTarget fileTarget = new FileTarget(target);
		
		logging.addTarget(fileTarget);
		logging.addTarget(fileTarget);
		
		assertEquals(logging.TargetsCount(), 1);
	}

}
