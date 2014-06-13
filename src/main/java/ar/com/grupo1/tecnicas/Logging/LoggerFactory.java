package ar.com.grupo1.tecnicas.Logging;

import java.util.ArrayList;
import java.util.Iterator;

public  class LoggerFactory {
	private static int ERROR = -1;
	private static ArrayList<MultiTargetLogger> manager = new ArrayList<>();

	public static void reset(){
		manager.clear();
	}
	public static int getLoggingCount(){
		return manager.size();
	}
	
	private static MultiTargetLogger addLog(String nameLog){
		MultiTargetLogger logging = new MultiTargetLogger(nameLog); 
		manager.add(logging);
		return logging;
	}
	
	private static int getLoggingIndex(String name){
		Iterator<MultiTargetLogger> iter = manager.iterator();
		int index = 0;
		while(iter.hasNext()){
			MultiTargetLogger logging = iter.next();
			if (logging.getName().equals(name)) {
				return index;
			}
			index++;
		}
		return ERROR;
	}
	
	private static MultiTargetLogger getOneLogger(String name){
		Iterator<MultiTargetLogger> iter = manager.iterator();
		while(iter.hasNext()){
			MultiTargetLogger logging = iter.next();
			if (logging.getName().equals(name)){
				return logging;
			}
		}
		return null;
	}
	
	public static MultiTargetLogger getLogger(String Name){
		if (containsLog(Name)){
			return getOneLogger(Name);
		}
		return addLog(Name);
	}
	
	private static boolean containsLog(String name){
		Iterator<MultiTargetLogger> iter = manager.iterator();
		while(iter.hasNext()){
			MultiTargetLogger logging = iter.next();
			if (logging.getName().equals(name)){
				return true;
			}
		}
		return false;
	}
		
	public static boolean removeLog(String nameLog){
		if(!containsLog(nameLog)){
			return false;
		}
		int index = getLoggingIndex(nameLog);
		manager.remove(index);
		return true;
	}
}
