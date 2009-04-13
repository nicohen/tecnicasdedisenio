package app;
import utiles.Constantes;

public class Jugador implements Comparable<String> {
 
	private int idJugador;
	private String nombre;
	private int posicion;
	private int goles;
	private int amarillas;
	private int rojas;
	private int precio;
	private boolean juega;
	private boolean isSuplente;
	private int penalesAtajados;
	private int cantPenalesErrados;
	private boolean completoPartido;
	private boolean isEstrella;
	private String club;
	private boolean equipoGana;
	private boolean jugoPartidoEntero;
	private int puntaje;
	
	public static final int ARQUERO = 1;
	public static final int DEFENSOR = 2;
	public static final int MEDIOCAMPISTA = 3;
	public static final int DELANTERO = 4;
	
	public Jugador(String nombre, int posicion, boolean isSuplente, String club) {
		this.idJugador = CampeonatoSingleton.getInstancia().getIdJugadorNuevo();
		this.precio = Constantes.COSTO_INICIAL_JUGADOR;
		this.nombre = nombre;
		this.posicion = posicion;
		this.isSuplente = isSuplente;
		this.club = club;
	}
	public boolean ganoEquipo(){
		return equipoGana;
	}
	private int getPuntaje(int golesRealizados, boolean ganoEquipo,int rojas, int tiempoRoja, int penalesAtajados, int penalesErrados, boolean juegaDosTiempos, boolean juega){
		int puntos = 0;
		
		if(golesRealizados > 0){
			switch (getPosicion()){        
			    case ARQUERO: puntos=(puntos+Constantes.PUNTOS_GOL_ARQUERO)*golesRealizados; break;
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
			if (tiempoRoja==1) {
				puntos += Constantes.PUNTOS_EXPULSADO_PRIMERTIEMPO;
			} else {
				puntos += Constantes.PUNTOS_EXPULSADO_SEGUNDOTIEMPO;
			}
		}
		
		//falta validar dos cosas la primera es que si es arquero y recibe un gol se le reste un punto.
		//la segunda es qeu sea suplente o no juege esa fecha.
		if (posicion==ARQUERO && penalesAtajados>0) puntos += Constantes.PUNTOS_PENAL_ATAJADO;
		
		if (penalesErrados > 0 ) puntos += Constantes.PUNTOS_PENAL_ERRADO;
		
		if(!juegaDosTiempos) puntos += Constantes.PUNTOS_NO_JUEGA_DOSTIEMPOS;
		
		if(!juega) puntos += Constantes.PUNTOS_NO_JUEGA_PARTIDO;
		
		if(posicion==ARQUERO) {
			getCantidadGolesRecibidos();
		}

		return puntos;
	}
	
	protected int getCantidadGolesRecibidos() {
		return 0;
	}
	
	public void actualizarDatos(EstadisticasJugadorFecha estadisticas) {
		goles=estadisticas.getGoles();
		equipoGana=estadisticas.isGanoFecha();
		amarillas=estadisticas.getAmarillas();
		penalesAtajados=estadisticas.getPenalesAtajados();
		rojas=estadisticas.getRojas();
		isEstrella=estadisticas.getEsEstrella();
		jugoPartidoEntero=estadisticas.getCompletoPartido();
		cantPenalesErrados=estadisticas.getPenalesErrados();
		completoPartido= estadisticas.getCompletoPartido();
		puntaje = getPuntaje(goles,equipoGana,rojas, estadisticas.getTiempoRoja(),penalesAtajados,cantPenalesErrados,jugoPartidoEntero,juega);
		precio += 100 * puntaje;
	}

	public int getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public int getGoles() {
		return goles;
	}

	public void setGoles(int goles) {
		this.goles = goles;
	}

	public int getAmarillas() {
		return amarillas;
	}

	public void setAmarillas(int amarillas) {
		this.amarillas = amarillas;
	}

	public int getRojas() {
		return rojas;
	}

	public void setRojas(int rojas) {
		this.rojas = rojas;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public boolean isJuega() {
		return juega;
	}

	public void setJuega(boolean juega) {
		this.juega = juega;
	}

	public boolean isSuplente() {
		return isSuplente;
	}

	public void setSuplente(boolean isSuplente) {
		this.isSuplente = isSuplente;
	}

	public int getCantPenalesErrados() {
		return cantPenalesErrados;
	}

	public void setCantPenalesErrados(int cantPenalesErrados) {
		this.cantPenalesErrados = cantPenalesErrados;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	public boolean getCompletoPartido() {
		return completoPartido;
	}

	public void setCompletoPartido(boolean completoPartido) {
		this.completoPartido = completoPartido;
	}

	public boolean isEstrella() {
		return isEstrella;
	}

	public void setEstrella(boolean isEstrella) {
		this.isEstrella = isEstrella;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	public int getPuntaje() {
		return puntaje;
	}

	public int compareTo(String o) {
		return club.compareTo(o);
	}
	 
}
 
