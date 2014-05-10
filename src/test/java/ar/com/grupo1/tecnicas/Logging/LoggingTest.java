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
	

}
