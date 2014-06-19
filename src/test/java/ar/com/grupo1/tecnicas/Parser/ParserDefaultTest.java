package ar.com.grupo1.tecnicas.Parser;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import ar.com.grupo1.tecnicas.Configuration.Level.enumLevel;
import ar.com.grupo1.tecnicas.Parser.ParserDefault;

public class ParserDefaultTest {
	
		@Test
		public void SetFormat() {
			ParserDefault parser = new ParserDefault();
			ArrayList<String> conf = parser.setFormat("%p %t %% %n %F %M %d{ss:mm:HH} %L %m");
			assertEquals(conf.size(), 9);
			assertEquals(conf.get(0), "%p");
			assertEquals(conf.get(1), "%t");
			assertEquals(conf.get(4), "%F");
			assertEquals(conf.get(8), "%m");
		}
		
		@Test
		public void SetDelimiter() {
			String delimeter = "-";
			ParserDefault parser = new ParserDefault();
			parser.setDelimeter(delimeter);
			assertEquals(parser.getDelimeter(),delimeter);
		}

		@Test
		public void SetFilterLevel() {
			
			ParserDefault parser = new ParserDefault();
			parser.setFilterLevel("ERROR");
			assertEquals(parser.getFilterLevel(),enumLevel.ERROR);
		}
		
		@Test
		public void ParserTest() {
			ParserDefault parser = new ParserDefault();
			parser.parser();
			assertEquals(parser.getFilterLevel(),enumLevel.TRACE);
			assertEquals(parser.getDelimeter(),"-");
		}
		
}