package app;

import utiles.Constantes;

public class JugadorDeCampo extends Jugador {
 
	public JugadorDeCampo(String nombre,int posicion,boolean isSuplente,String club){
		super(nombre,posicion,isSuplente,club);
	}
	 
	protected int getPuntaje(EstadisticasJugadorFecha estadisticasJugadorDeCampo){
		int puntos = 0;
		
		int golesRealizados = estadisticasJugadorDeCampo.getGoles();
		if(estadisticasJugadorDeCampo.getGoles() > 0){
			switch (getPosicion()){        
			    case DEFENSOR: puntos=(puntos+Constantes.PUNTOS_GOL_DEFENSOR)*golesRealizados; break;
			    case MEDIOCAMPISTA: puntos=(puntos+Constantes.PUNTOS_GOL_MEDIOCAMPISTA)*golesRealizados; break;
			    case DELANTERO: puntos=(puntos+Constantes.PUNTOS_GOL_DELANTERO)*golesRealizados; break;
				default: break;
			}
		}
		
		if(ganoEquipo()) {
			puntos += Constantes.PUNTOS_CLUB_GANA_PARTIDO;
		} else {
			puntos += Constantes.PUNTOS_CLUB_PIERDE_PARTIDO;
		}
		
		if (rojas > 0) {
			if (estadisticasJugadorDeCampo.getTiempoRoja()==1) {
				puntos += Constantes.PUNTOS_EXPULSADO_PRIMERTIEMPO;
			} else {
				puntos += Constantes.PUNTOS_EXPULSADO_SEGUNDOTIEMPO;
			}
		}
		
		if (estadisticasJugadorDeCampo.getPenalesErrados() > 0 ) puntos += Constantes.PUNTOS_PENAL_ERRADO;
		
		if(!estadisticasJugadorDeCampo.getCompletoPartido()) puntos += Constantes.PUNTOS_NO_JUEGA_DOSTIEMPOS;
		
		if(!estadisticasJugadorDeCampo.isJuega()) puntos += Constantes.PUNTOS_NO_JUEGA_PARTIDO;
		
		return puntos;
	}
	
	protected void actualizarDatos(EstadisticasJugadorFecha estadisticas) {
		goles=estadisticas.getGoles();
		equipoGana=estadisticas.isGanoFecha();
		amarillas=estadisticas.getAmarillas();
		rojas=estadisticas.getRojas();
		isEstrella=estadisticas.getEsEstrella();
		jugoPartidoEntero=estadisticas.getCompletoPartido();
		cantPenalesErrados=estadisticas.getPenalesErrados();
		completoPartido= estadisticas.getCompletoPartido();
		puntaje = getPuntaje(estadisticas);
		precio += 100 * puntaje;
	}


}
 
