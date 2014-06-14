package ar.com.grupo1.tecnicas.Logging;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ParserFileXmlTest {
		String fileName = "";
		String logName = "name";
		
		@Test
		public void SetFormat() {
			ParserFileXml parser = new ParserFileXml(fileName, logName);
			ArrayList<String> conf = parser.setFormat("%p %t %% %n %F %M %d{ss:mm:HH} %L %m");
			assertEquals(conf.size(), 9);
			assertEquals(conf.get(0), "%p");
			assertEquals(conf.get(1), "%t");
			assertEquals(conf.get(8), "%m");
		}
		
		@Test
		public void SetDelimiter() {
			String delimeter = ";";
			ParserFileXml parser = new ParserFileXml(fileName, logName);
			parser.setDelimeter(delimeter);
			assertEquals(parser.getDelimeter(),delimeter);
		}

		@Test
		public void SetFilterLevel() {
			String level = "Debug";
			ParserFileXml parser = new ParserFileXml(fileName, logName);
			parser.setFilterLevel(level);
			assertEquals(parser.getFilterLevel(),level);
		}
		
		@Test
		public void ParserXmlNotExistLogName() {
			ParserFileXml parser = new ParserFileXml("logger-config.xml", logName);			
			parser.parser();
			assertEquals(parser.getFilterLevel(),"TRACE");
			assertEquals(parser.getDelimeter(),"-");
			assertEquals(parser.getDatePattern(),null);			
			
		}
		

		@Test
		public void ParserXmlExistLogName() {
			ParserFileXml parser = new ParserFileXml("logger-config.xml", "Name");			
			parser.parser();
			assertEquals(parser.getFilterLevel(),"WARN");
			assertEquals(parser.getDelimeter(),"**");
			assertEquals(parser.getDatePattern(),"HH:mm:ss");		
			
		}
		
		
		
		
}