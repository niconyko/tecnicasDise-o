package ar.com.grupo1.tecnicas.Logging;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import ar.com.grupo1.tecnicas.Target.ConsoleTarget;
import ar.com.grupo1.tecnicas.Target.MultiTargetLogger;
import ar.com.grupo1.tecnicas.Target.Target;

public class LoggerFactoryAdapter implements org.slf4j.ILoggerFactory {

	ConcurrentMap<String, org.slf4j.Logger> loggerMap;
	public LoggerFactoryAdapter() {
		loggerMap = new ConcurrentHashMap<String, org.slf4j.Logger>();
	}
	
	@Override
	public org.slf4j.Logger getLogger(String logName) {
		org.slf4j.Logger slf4jLogger = loggerMap.get(logName);
	    if (slf4jLogger == null) {
	    	MultiTargetLogger log = LoggerFactory.getLogger(logName);
	    	Target consoleTarget = new ConsoleTarget();
	    	log.addTarget(consoleTarget);
	    	slf4jLogger = new LoggerAdapter(log);
	    	loggerMap.put(logName, slf4jLogger);
	    }
	    return slf4jLogger;
	}
}
