package ar.com.grupo1.tecnicas.Logging;

import org.slf4j.Logger;


public class App 
{
	
    public static void methodName(){
    	MultiTargetLogger log = new MultiTargetLogger("Name");
    	Target consoleTarget = new ConsoleTarget();
    	log.addTarget(consoleTarget);
    	Target fileTarget = new FileTarget("myTarget.log");
    	log.addTarget(fileTarget);
    	//log.setFormat("%p %t %% %n %F %M %d{ss:mm:HH} %L %m");
    	log.log("Hola", "WARN");
    	
    	LoggerFactoryAdapter logFactory = new LoggerFactoryAdapter();
		Logger slf4jLog = logFactory.getLogger("Juan");
		slf4jLog.trace("msg trace");
		slf4jLog.debug("msg debug");
		slf4jLog.info("msg info");
		slf4jLog.warn("msg warm");
		slf4jLog.error("msg error");
		Exception e = new Exception("EXCEPTION");
		slf4jLog.trace("msg trace",e);
		slf4jLog.debug("msg debug",e);
		slf4jLog.info("msg info",e);
		slf4jLog.warn("msg warm",e);
		slf4jLog.error("msg error",e);
    }
    
	public static void main( String[] args )
    {
    	methodName();  	
    }
}
