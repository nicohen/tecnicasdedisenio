package app;
import utiles.Constantes;

public abstract class Jugador implements Comparable<String> {
	protected int idJugador;
	protected String nombre;
	protected int posicion;
	protected int goles;
	protected int amarillas;
	protected int rojas;
	protected int precio;
	protected boolean juega;
	protected boolean esSuplente;
	protected int cantPenalesErrados;
	protected boolean completoPartido;
	protected boolean isEstrella;
	protected String club;
	protected boolean equipoGana;
	protected boolean jugoPartidoEntero;
	protected int puntaje;
	
	public static final int ARQUERO = 1;
	public static final int DEFENSOR = 2;
	public static final int MEDIOCAMPISTA = 3;
	public static final int DELANTERO = 4;
	
	public Jugador(String nombre, int posicion, boolean isSuplente, String club) {
		this.idJugador = CampeonatoSingleton.getInstancia().getIdJugadorNuevo();
		this.precio = Constantes.COSTO_INICIAL_JUGADOR;
		this.nombre = nombre;
		this.posicion = posicion;
		this.esSuplente = isSuplente;
		this.club = club;
	}
	public boolean ganoEquipo(){
		return equipoGana;
	}
	
	protected abstract int getPuntaje(EstadisticasJugadorFecha estadisticasJugador);
	protected abstract void actualizarDatos(EstadisticasJugadorFecha estadisticas);

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
		return esSuplente;
	}

	public void setSuplente(boolean isSuplente) {
		this.esSuplente = isSuplente;
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
	
	public int compareTo(String o) {
		return club.compareTo(o);
	}
	 
}
 
