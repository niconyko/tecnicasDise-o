package ar.com.grupo1.tecnicas.Logging;

import static org.junit.Assert.*;

import org.junit.Test;

public class FileTargetTest {

	@Test
	public void testGetDestination() {
		String destination = "my destination";
		FileTarget fileTarget = new FileTarget(destination);
		assertEquals( destination, fileTarget.getTargetDestination() );
	}

}
