package ar.com.grupo1.tecnicas.Logging;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class ContextTest {
	
	String level = "WARN", message="message", datePattern ="HH:mm:ss", delimeter="-";
	
	
	@Test
	public void testGetDelimiter() {
		 
		Context context = new Context(level,message,datePattern,delimeter);
		String delimeterData = context.getData("%n");                  
		assertEquals(delimeter, delimeterData);
	}

	@Test
	public void testGetLevel() {
		 
		Context context = new Context(level,message,datePattern,delimeter);
		String levelData = context.getData("%p");                  
		assertEquals(level, levelData);
	}
	
	@Test
	public void testGetMessage() {
		 
		Context context = new Context(level,message,datePattern,delimeter);
		String msgData = context.getData("%m");                  
		assertEquals(message, msgData);
	}
	
	@Test
	public void testGetDate() {
		 
		Context context = new Context(level,message,datePattern,delimeter);
		String dateData = context.getData("%d");                  
		SimpleDateFormat date = new SimpleDateFormat(datePattern);
		
		assertEquals( (String)date.format(new Date()), dateData);
	}
	
	@Test
	public void testGetNameThread() {
		 
		Context context = new Context(level,message,datePattern,delimeter);
		String threadData = context.getData("%t");                  
				
		assertEquals("main" , threadData);
	}

	

}
