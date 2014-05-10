package ar.com.grupo1.tecnicas.Logging;

import static org.junit.Assert.*;

import org.junit.Test;

public class FileTargetTest {

	@Test
	public void getDestination() {
		String destination = "my destination";
		FileTarget fileTarget = new FileTarget(destination);
		assertEquals(fileTarget.getTargetDestination(), destination);
	}

}
