package ar.com.grupo1.tecnicas.Logging;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ConfigurationTest {
	String fileName = "";
	
	@Test
	public void SetFormat() {
		Configuration conf = new Configuration(fileName);
		conf.setOutputFormat("%p %t %% %n %F %M %d{ss:mm:HH} %L %m");
		ArrayList<String> confItems = conf.getConfiguration();
		assertEquals(confItems.size(), 9);
		assertEquals(confItems.get(0), "%p");
		assertEquals(confItems.get(1), "%t");
		assertEquals(confItems.get(8), "%m");
	}
	
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
