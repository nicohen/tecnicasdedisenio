package app;
import utiles.Constantes;

public class Jugador {
 
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
	public static final int ARQUERO = 1;
	public static final int DEFENSOR = 2;
	public static final int MEDIOCAMPISTA = 3;
	public static final int DELANTERO = 4;
	
	public Jugador(String nombre, int posicion, boolean isSuplente, String club) {
		precio = Constantes.COSTO_INICIAL_JUGADOR;
		this.nombre=nombre;
		this.posicion=posicion;
		this.isSuplente=isSuplente;
		this.idJugador=CampeonatoSingleton.getInstancia().getIdJugadorNuevo();
	}
	public boolean getGana(){
		return equipoGana;
	}
	private int getPuntaje(int goles,boolean equipoGana,int rojas,int tiempoRoja, int atajaPenal,int erraPenal,boolean jugoEntero){
	int puntos=0;
	int pos=getPosicion();
	if(goles != 0){
		switch (pos){        
	    case ARQUERO: puntos=(puntos+4)*goles;
	 	  break;
	    case DELANTERO: puntos=(puntos+1)*goles;
		  break;
	    case DEFENSOR: puntos=(puntos+3)*goles;
		  break;
	    case MEDIOCAMPISTA: puntos=(puntos+2)*goles;
	    	break;
		}
	}
	if(getGana())
		puntos= puntos+2;
	else
		puntos=puntos-1;
	
	if (rojas != 0){
		if (tiempoRoja==1)
			puntos=puntos-4;
		else
			puntos=puntos-2;	
	}
	//falta validar dos cosas la primera es que si es arquero y recibe un gol se le reste un punto.
	//la segunda es qeu sea suplente o no juege esa fecha.
	if (atajaPenal != 0) puntos=puntos+5;
	if (erraPenal != 0 ) puntos=puntos-4;
	if(!jugoEntero) puntos=puntos-1;
	return puntos;
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
		precio=(Constantes.COSTO_INICIAL_JUGADOR + 100 * getPuntaje(goles,equipoGana,rojas, estadisticas.getTiempoRoja(),penalesAtajados,cantPenalesErrados,jugoPartidoEntero));
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

	
	 
}
 
