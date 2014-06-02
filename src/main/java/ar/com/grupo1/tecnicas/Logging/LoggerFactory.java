package ar.com.grupo1.tecnicas.Logging;

import java.util.ArrayList;
import java.util.Iterator;

public  class LoggerFactory {
	private static int ERROR = -1;
	private static ArrayList<Logging> manager = new ArrayList<>();
	//BORRAR CUANDO SE HAGA FUNCIONALIDAD DE LEVANTAR CONFIGURACION
	private static String filename = "./prueba.properties2";
	//HASTA ACA

	public static void reset(){
		manager.clear();
	}
	public static int getLoggingCount(){
		return manager.size();
	}
	
	public static boolean addLog(String nameLog){
		if (containsLog(nameLog)) return false;
		manager.add(new Logging(filename, nameLog));
		return true;
	}
	
	private static int getLoggingIndex(String name){
		Iterator<Logging> iter = manager.iterator();
		int index = 0;
		while(iter.hasNext()){
			Logging logging = iter.next();
			if (logging.getName().equals(name))	return index;
			index++;
		}
		return ERROR;
	}
	
	public static Logging getLogger(String name){
		Iterator<Logging> iter = manager.iterator();
		while(iter.hasNext()){
			Logging logging = iter.next();
			if (logging.getName().equals(name))	return logging;
		}
		return null;
	}
	
	private static boolean containsLog(String name){
		Iterator<Logging> iter = manager.iterator();
		while(iter.hasNext()){
			Logging logging = iter.next();
			if (logging.getName().equals(name))	return true;
		}
		return false;
	}
		
	public static boolean removeLog(String nameLog){
		if(!containsLog(nameLog)) return false;
		int index = getLoggingIndex(nameLog);
		manager.remove(index);
		return true;
	}
	
		
	
}
