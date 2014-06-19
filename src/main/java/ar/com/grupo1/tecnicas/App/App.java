package ar.com.grupo1.tecnicas.App;

import ar.com.grupo1.tecnicas.Target.ConsoleTarget;
import ar.com.grupo1.tecnicas.Target.FileTarget;
import ar.com.grupo1.tecnicas.Target.MultiTargetLogger;
import ar.com.grupo1.tecnicas.Target.Target;


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
    }
    
	public static void main( String[] args )
    {
    	methodName();  	
    }
}
