package app;

import utiles.Constantes;

public class Arquero extends Jugador {
 
	private int cantPenalesAtajados; 
	private int cantGolesRecibidos;
	
	public Arquero(String nombre, boolean isSuplente, String club){
		super(nombre,Jugador.ARQUERO,isSuplente,club);
	}
	 
	public void setCantidadPenalesAtajados(int cantidad) {
		this.cantPenalesAtajados = cantidad;
	}
	 
	public int getCantidadPenalesAtajados() {
		return this.cantPenalesAtajados;
	}
	 
	public void setCantidadGolesRecibidos(int cantidad) {
		this.cantGolesRecibidos = cantidad;
	}
	 
	protected int getCantidadGolesRecibidos() {
		return this.cantGolesRecibidos;
	}
	
	protected int getPuntaje(EstadisticasJugadorFecha estadisticasArquero){
		int puntos = 0;
		
		puntos = (puntos+Constantes.PUNTOS_GOL_ARQUERO)*goles;
		
		if(ganoEquipo()) {
			puntos += Constantes.PUNTOS_CLUB_GANA_PARTIDO;
		} else {
			puntos += Constantes.PUNTOS_CLUB_PIERDE_PARTIDO;
		}
		
		if (rojas > 0) {
			if (estadisticasArquero.getTiempoRoja()==1) {
				puntos += Constantes.PUNTOS_EXPULSADO_PRIMERTIEMPO;
			} else {
				puntos += Constantes.PUNTOS_EXPULSADO_SEGUNDOTIEMPO;
			}
		}
		
		//falta validar dos cosas la primera es que si es arquero y recibe un gol se le reste un punto.
		//la segunda es qeu sea suplente o no juege esa fecha.
		if (estadisticasArquero.getPenalesAtajados()>0) puntos += Constantes.PUNTOS_PENAL_ATAJADO;
		
		if (estadisticasArquero.getPenalesErrados() > 0 ) puntos += Constantes.PUNTOS_PENAL_ERRADO;
		
		if(!estadisticasArquero.getCompletoPartido()) puntos += Constantes.PUNTOS_NO_JUEGA_DOSTIEMPOS;
		
		if(!estadisticasArquero.isJuega()) puntos += Constantes.PUNTOS_NO_JUEGA_PARTIDO;
		

		return puntos;
	}

	
	protected void actualizarDatos(EstadisticasJugadorFecha estadisticas) {
		goles=estadisticas.getGoles();
		equipoGana=estadisticas.isGanoFecha();
		amarillas=estadisticas.getAmarillas();
		cantPenalesAtajados=estadisticas.getPenalesAtajados();
		rojas=estadisticas.getRojas();
		isEstrella=estadisticas.getEsEstrella();
		jugoPartidoEntero=estadisticas.getCompletoPartido();
		cantPenalesErrados=estadisticas.getPenalesErrados();
		completoPartido= estadisticas.getCompletoPartido();
		puntaje = getPuntaje(estadisticas);
		precio += 100 * puntaje;
	}

	 
}
 
