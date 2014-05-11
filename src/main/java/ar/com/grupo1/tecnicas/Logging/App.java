package ar.com.grupo1.tecnicas.Logging;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Logging log = new Logging();
    	log.log("Hola", "WARN", new Context("A",1, "A" , "A"));
    	
    }
}
