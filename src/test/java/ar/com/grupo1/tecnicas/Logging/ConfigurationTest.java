package ar.com.grupo1.tecnicas.Logging;

import static org.junit.Assert.*;

import org.junit.Test;

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
		String level = "2";
		String logName = "Juan";
		Configuration conf = new Configuration(logName);
		conf.setFilterLevel(level);
		assertEquals(conf.getFilterLevel(),level);
	}
}
