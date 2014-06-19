package ar.com.grupo1.tecnicas.Target;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class FileTargetTest {

	@Test
	public void testGetDestination() {
		String destination = "my destination";
		FileTarget fileTarget = new FileTarget(destination);
		assertEquals( destination, fileTarget.getTargetDestination() );
	}

	@Test
	public void testLog() throws IOException{
		String destination = "my destination";
		String message = "prueba";
		FileTarget fileTarget = new FileTarget(destination);
		fileTarget.log(message);
		
		assertEquals(readFileLog(destination) , message );
	}

	private String readFileLog(String destination) throws IOException{
		File archivo = new File (destination);
		FileReader fr = new FileReader (archivo);
		BufferedReader br = new BufferedReader(fr);		
		String line = br.readLine();
		br.close();
		return line;
	}
	
	
}
