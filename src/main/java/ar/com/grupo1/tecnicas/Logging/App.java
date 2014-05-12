package ar.com.grupo1.tecnicas.Logging;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void nombreDelMetodo(){
    	Logging log = new Logging("./prueba.properties2");
    	Target consoleTarget = new ConsoleTarget();
    	log.addTarget(consoleTarget);
    	Target fileTarget = new FileTarget("myTarget.log");
    	log.addTarget(fileTarget);
    	log.log("Hola", "WARN");
    	
    }
	public static void main( String[] args )
    {
    	nombreDelMetodo();  	
    }
}
