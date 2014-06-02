package ar.com.grupo1.tecnicas.Logging;


public class App 
{
	
	
    public static void nombreDelMetodo(){
    	Logging log = new Logging("./prueba.properties2", "Name");
    	//Logging log = new Logging("./prueba.xml");
    	//Logging log = new Logging("./prueba.properties2");

    	Target consoleTarget = new ConsoleTarget();
    	log.addTarget(consoleTarget);
    	Target fileTarget = new FileTarget("myTarget.log");
    	log.addTarget(fileTarget);
    	log.setFormat("%p %t %% %n %F %M %d{ss:mm:HH} %L %m");
    	log.log("Hola", "WARN");
    	
    	
    	
    }
	public static void main( String[] args )
    {
    	nombreDelMetodo();  	
    }
}
