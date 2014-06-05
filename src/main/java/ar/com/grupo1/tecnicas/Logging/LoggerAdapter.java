package ar.com.grupo1.tecnicas.Logging;

import org.slf4j.Marker;

public class LoggerAdapter implements org.slf4j.Logger{
	
	Logging log;
	String name;
	
	LoggerAdapter(Logging originalLog) {
		log = originalLog;
		name = originalLog.getName();
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public void trace(String message) {
		log.log(message, "TRACE");
	}
	
	@Override
	public void debug(String message) {
		log.log(message, "DEBUG");
	}
	
	@Override
	public void info(String message) {
		log.log(message, "INFO");
	}
	
	@Override
	public void warn(String message) {
		log.log(message, "WARN");
	}
	
	@Override
	public void error(String message) {
		log.log(message, "ERROR");
	}
	
	@Override
	public void trace(String message, Throwable e) {
		log.log(message, e, "ERROR");
	}

	@Override
	public void debug(String message, Throwable e) {
		log.log(message, e, "DEBUG");
	}
	
	@Override
	public void info(String message, Throwable e) {
		log.log(message, e, "INFO");
	}
	
	@Override
	public void warn(String message, Throwable e) {
		log.log(message, e, "WARN");
	}
	
	@Override
	public void error(String message, Throwable e) {
		log.log(message, e, "ERROR");
	}
	
	@Override
	public void debug(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void debug(String arg0, Object... arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void debug(Marker arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void debug(String arg0, Object arg1, Object arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void debug(Marker arg0, String arg1, Object arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void debug(Marker arg0, String arg1, Object... arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void debug(Marker arg0, String arg1, Throwable arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void debug(Marker arg0, String arg1, Object arg2, Object arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void error(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void error(String arg0, Object... arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void error(Marker arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void error(String arg0, Object arg1, Object arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void error(Marker arg0, String arg1, Object arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void error(Marker arg0, String arg1, Object... arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void error(Marker arg0, String arg1, Throwable arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void error(Marker arg0, String arg1, Object arg2, Object arg3) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void info(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void info(String arg0, Object... arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void info(Marker arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void info(String arg0, Object arg1, Object arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void info(Marker arg0, String arg1, Object arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void info(Marker arg0, String arg1, Object... arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void info(Marker arg0, String arg1, Throwable arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void info(Marker arg0, String arg1, Object arg2, Object arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isDebugEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDebugEnabled(Marker arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isErrorEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isErrorEnabled(Marker arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInfoEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInfoEnabled(Marker arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTraceEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTraceEnabled(Marker arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isWarnEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isWarnEnabled(Marker arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void trace(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void trace(String arg0, Object... arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void trace(Marker arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void trace(String arg0, Object arg1, Object arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void trace(Marker arg0, String arg1, Object arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void trace(Marker arg0, String arg1, Object... arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void trace(Marker arg0, String arg1, Throwable arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void trace(Marker arg0, String arg1, Object arg2, Object arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void warn(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void warn(String arg0, Object... arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void warn(Marker arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void warn(String arg0, Object arg1, Object arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void warn(Marker arg0, String arg1, Object arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void warn(Marker arg0, String arg1, Object... arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void warn(Marker arg0, String arg1, Throwable arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void warn(Marker arg0, String arg1, Object arg2, Object arg3) {
		// TODO Auto-generated method stub
		
	}

}
