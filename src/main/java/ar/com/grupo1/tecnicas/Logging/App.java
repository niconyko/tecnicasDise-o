package ar.com.grupo1.tecnicas.Logging;


import java.util.ArrayList;
import java.util.ListIterator;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void nombreDelMetodo(){
    	Logging log = new Logging("./prueba.properties");
    	Target consoleTarget = new ConsoleTarget();
    	log.addTarget(consoleTarget);
    	log.log("Hola", "WARN");
    	
    }
	public static void main( String[] args )
    {
    	nombreDelMetodo();  	
    }
}
