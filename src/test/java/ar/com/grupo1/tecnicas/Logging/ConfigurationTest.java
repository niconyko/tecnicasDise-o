package ar.com.grupo1.tecnicas.Logging;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ConfigurationTest {
	String fileName = "prueba.properties2";

	@Test
	public void SetDelimiter() {
		String delimeter = ";";
		Configuration conf = new Configuration(fileName);
		conf.setDelimeter(delimeter);
		assertEquals(conf.getDelimeter(),delimeter);
	}

	@Test
	public void SetFilterLevel() {
		String level = "2";
		Configuration conf = new Configuration(fileName);
		conf.setFilterLevel(level);
		assertEquals(conf.getFilterLevel(),level);
	}
}
