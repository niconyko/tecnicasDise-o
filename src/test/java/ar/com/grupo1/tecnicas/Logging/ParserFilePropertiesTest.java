package ar.com.grupo1.tecnicas.Logging;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ParserFilePropertiesTest {
		String fileName = "";
	
		@Test
		public void SetFormat() {
			ParserFileProperties parser = new ParserFileProperties(fileName);
			ArrayList<String> conf = parser.setFormat("%p %t %% %n %F %M %d{ss:mm:HH} %L %m");
			assertEquals(conf.size(), 9);
			assertEquals(conf.get(0), "%p");
			assertEquals(conf.get(1), "%t");
			assertEquals(conf.get(8), "%m");
		}
		
		@Test
		public void SetDelimiter() {
			String delimeter = ";";
			ParserFileProperties parser = new ParserFileProperties(fileName);
			parser.setDelimeter(delimeter);
			assertEquals(parser.getDelimeter(),delimeter);
		}

		@Test
		public void SetFilterLevel() {
			String level = "2";
			ParserFileProperties parser = new ParserFileProperties(fileName);
			parser.setFilterLevel(level);
			assertEquals(parser.getFilterLevel(),level);
		}
		
}
