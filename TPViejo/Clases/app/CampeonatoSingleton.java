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
		int i=0,j=0,k=0;
		
		for(Participante participante: listaParticipantes){
			for(Jugador jugador:participante.getEquipo().getJugadores()){
				for(EstadisticasJugadorFecha estadisticasJugador:estadisticasJugadores){
					if (estadisticasJugador.getJugador().getIdJugador()==jugador.getIdJugador()){
						jugador.actualizarDatos(estadisticasJugador);
						participante.getEquipo().actualizarEstadisticasJugador(j,jugador);
						participante.acumularPuntos(jugador.getPuntaje(estadisticasJugador));
						break;
					}
					k++;//k para estadisticas	
				}
				j++;//j para jugadores de equipo
				k=0;
			}
			//actualiza puntos del participante usando puntosFechaActual, y puntosAcumulados
			listaParticipantes.set(i, participante);
			i++;//i para participantes
			j=0;
		}
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

	public void agregarParticipante(Participante participante) {
		listaParticipantes.add(participante);		
	}

}
