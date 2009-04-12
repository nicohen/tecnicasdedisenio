package app;

import java.util.List;

public class CampeonatoSingleton {
	
	static private CampeonatoSingleton singleton=null;
	
	private CampeonatoSingleton(){}
	
	static public CampeonatoSingleton getCampeonatoSingleton() {
		if(singleton==null){
			singleton=new CampeonatoSingleton();
			
		}
		return singleton;
	}

	public void procesarFecha(List<EstadisticasJugadorFecha> estadisticasJugadores){
		
	}
}
