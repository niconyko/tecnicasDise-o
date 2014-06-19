package ar.com.grupo1.tecnicas.Parser;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import ar.com.grupo1.tecnicas.Configuration.Level.enumLevel;
import ar.com.grupo1.tecnicas.Parser.ParserFileProperties;

public class ParserFilePropertiesTest {
		String fileName = "";
		String logName = "name";
		@Test
		public void SetFormat() {
			ParserFileProperties parser = new ParserFileProperties(fileName, logName);
			ArrayList<String> conf = parser.setFormat("%p %t %% %n %F %M %d{ss:mm:HH} %L %m");
			assertEquals(conf.size(), 9);
			assertEquals(conf.get(0), "%p");
			assertEquals(conf.get(1), "%t");
			assertEquals(conf.get(8), "%m");
		}
		
		@Test
		public void SetDelimiter() {
			String delimeter = ";";
			ParserFileProperties parser = new ParserFileProperties(fileName, logName);
			parser.setDelimeter(delimeter);
			assertEquals(parser.getDelimeter(),delimeter);
		}

		@Test
		public void SetFilterLevel() {
			String level = "DEBUG";
			ParserFileProperties parser = new ParserFileProperties(fileName, logName);
			parser.setFilterLevel(level);
			assertEquals(parser.getFilterLevel(),enumLevel.DEBUG);
		}
		
		@Test
		public void ParserPropertiesTest() {
			ParserFileProperties parser = new ParserFileProperties("logger-config.properties", "Juan");
			parser.parser();
			assertEquals(parser.getFilterLevel(),enumLevel.TRACE);
			assertEquals(parser.getDelimeter(),"/");
		}
		
}
