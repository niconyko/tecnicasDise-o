package ar.com.grupo1.tecnicas.Logging;

import static org.junit.Assert.*;

import org.junit.Test;

public class ContextTest {
	
	String nameMethod = "name method", fileName = "class.java", threadName = "thread id";
	int lineNumber = 12;
	
	@Test
	public void GetNameMethod() {
		Context context = new Context(nameMethod,lineNumber,fileName,threadName);
		assertEquals(context.GetNameMethod(), nameMethod);
	}
	
	@Test
	public void GetLineNumber() {
		Context context = new Context(nameMethod,lineNumber,fileName,threadName);
		assertEquals(context.GetLineNumber(), lineNumber);
	}
	
	@Test
	public void GetFileName() {
		Context context = new Context(nameMethod,lineNumber,fileName,threadName);
		assertEquals(context.GetFileName(), fileName);
	}
	
	@Test
	public void GetThreadName() {
		Context context = new Context(nameMethod,lineNumber,fileName,threadName);
		assertEquals(context.GetThreadName(), threadName);	
	}
}
