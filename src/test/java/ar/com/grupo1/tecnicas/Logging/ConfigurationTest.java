package ar.com.grupo1.tecnicas.Logging;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConfigurationTest {

	@Test
	public void SetDelimiter() {
		String delimeter = ";";
		Configuration conf = new Configuration();
		conf.setDelimeter(delimeter);
		assertEquals(conf.getDelimeter(),delimeter);
	}

	@Test
	public void SetFilterLevel() {
		String level = "2";
		Configuration conf = new Configuration();
		conf.setFilterLevel(level);
		assertEquals(conf.getFilterLevel(),level);
	}
}
