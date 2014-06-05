package ar.com.grupo1.tecnicas.Logging;

import org.slf4j.Logger;


public class App 
{
	
    public static void nombreDelMetodo(){
    	Logging log = new Logging("Name");
    	Target consoleTarget = new ConsoleTarget();
    	log.addTarget(consoleTarget);
    	Target fileTarget = new FileTarget("myTarget.log");
    	log.addTarget(fileTarget);
    	//log.setFormat("%p %t %% %n %F %M %d{ss:mm:HH} %L %m");
    	log.log("Hola", "WARN");
    	
    	LoggerFactoryAdapter logFactory = new LoggerFactoryAdapter();
		Logger slf4jLog = logFactory.getLogger("Juan");
		slf4jLog.trace("S Info");
		slf4jLog.debug("S Info");
		slf4jLog.info("S Info");
		slf4jLog.warn("S Info");
		slf4jLog.error("S Info");
    }
    
	public static void main( String[] args )
    {
    	nombreDelMetodo();  	
    }
}
