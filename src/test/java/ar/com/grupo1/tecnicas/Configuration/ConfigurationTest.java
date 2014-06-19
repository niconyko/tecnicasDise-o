package ar.com.grupo1.tecnicas.Configuration;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.com.grupo1.tecnicas.Configuration.Configuration;
import ar.com.grupo1.tecnicas.Configuration.Level.enumLevel;

public class ConfigurationTest {

	@Test
	public void SetDelimiter() {
		String delimeter = ";";
		String logName = "Juan";
		Configuration conf = new Configuration(logName);
		conf.setDelimeter(delimeter);
		assertEquals(conf.getDelimeter(),delimeter);
	}

	@Test
	public void SetFilterLevel() {
		String logName = "Juan";
		String level = "TRACE";
		Configuration conf = new Configuration(logName);
		conf.setFilterLevel(level);
		assertEquals(conf.getFilterLevel(),enumLevel.TRACE);
	}
}
