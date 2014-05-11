package ar.com.grupo1.tecnicas.Logging;

import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void nombreDelMetodo(){
    	Logging log = new Logging("properties");
    	Target consoleTarget = new ConsoleTarget();
    	log.addTarget(consoleTarget);
    	log.log("Hola", "WARN");
    	
    }
	public static void main( String[] args )
    {
    	//nombreDelMetodo();
		ParserFileProperties parser = new ParserFileProperties("./prueba.properties");
		ArrayList<String> a= parser.parser();
		
		ListIterator<String> li = a.listIterator();
		
		while(li.hasNext()){
			String elemento = li.next();
			System.out.print(elemento+"\n");
		}    	
    }
}
