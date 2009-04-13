package app;

import java.util.ArrayList;
import java.util.List;

public class CampeonatoSingleton {
	
	static private CampeonatoSingleton singleton=null;
	private static int ultimoIdParticipante=0;
	private static int ultimoIdEquipo=0;
	private static int ultimoIdJugador=0;
	private static List<Participante> listaParticipantes;
	private CampeonatoSingleton(){}
	
	static public CampeonatoSingleton getInstancia() {
		if(singleton==null){
			listaParticipantes = new ArrayList<Participante>();
			singleton=new CampeonatoSingleton();
		}
		return singleton;
	}

	public void procesarFecha(List<EstadisticasJugadorFecha> estadisticasJugadores){
		
	}
	public int getIdJugadorNuevo(){
		return ultimoIdJugador++;
	}
	public int getIdEquipoNuevo(){
		return ultimoIdEquipo++;
	}
	public int getIdParticipanteNuevo(){
		return ultimoIdParticipante++;
	}
	public List<Participante> getListaParticipantes(){
		return this.listaParticipantes;
	}
}
