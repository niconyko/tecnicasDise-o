package ar.com.grupo1.tecnicas.Logging;

import static org.junit.Assert.*;

import org.junit.Test;

public class ContextTest {
	
	String nameMethod = "name method", fileName = "class.java", threadName = "thread id";
	int lineNumber = 12;
	
	@Test
	public void testGetNameMethod() {
		Context context = new Context(nameMethod,lineNumber,fileName,threadName);
		assertEquals(nameMethod, context.getNameMethod());
	}
	
	@Test
	public void testGetLineNumber() {
		Context context = new Context(nameMethod,lineNumber,fileName,threadName);
		assertEquals( lineNumber, context.getLineNumber());
	}
	
	@Test
	public void testGetFileName() {
		Context context = new Context(nameMethod,lineNumber,fileName,threadName);
		assertEquals( fileName, context.getFileName());
	}
	
	@Test
	public void testGetThreadName() {
		Context context = new Context(nameMethod,lineNumber,fileName,threadName);
		assertEquals(threadName, context.getThreadName() );	
	}
}
