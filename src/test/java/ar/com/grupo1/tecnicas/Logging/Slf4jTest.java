package ar.com.grupo1.tecnicas.Logging;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;

public class Slf4jTest {
	@Test
	public void FactoryInitializationTest() {
		LoggerFactoryAdapter logFactory = new LoggerFactoryAdapter();
		Logger log = logFactory.getLogger("Juan");
		assertTrue(log.getName().equals("Juan"));
	}
}
