package app;
public class EstadisticasJugadorFecha {
 
	private Jugador jugador; 
	private int goles;	
	private int penalesAtajados;
	private boolean ganoFecha;	 
	private int penalesConvertidos;	 
	private int amarillas;	 
	private int rojas;	 
	private int tiempoRoja;	 
	private int tiempoAmarilla;	  
	private boolean esEstrella;
	private boolean completoPartido;
	private int penalesErrados;
	public EstadisticasJugadorFecha(
			Jugador jugador,
			int goles,
			boolean ganoFecha,
			int penalesConvertidos,
			int amarillas,
			int rojas,
			int tiempoRoja,
			int tiempoAmarilla,
			boolean completoPartido,
			boolean esEstrella,
			int penalesErrados
			){
	
		this.jugador=jugador;
		this.goles=goles;
		this.ganoFecha=ganoFecha;
		this.penalesConvertidos=penalesConvertidos;
		this.amarillas=amarillas;
		this.rojas=rojas;
		this.tiempoRoja=tiempoRoja;
		this.tiempoAmarilla=tiempoAmarilla;
		this.esEstrella=esEstrella;
		this.completoPartido=completoPartido;
		this.penalesErrados=penalesErrados;
	}
	
	public Jugador getJugador() {
		return jugador;
	}
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	public int getGoles() {
		return goles;
	}
	public void setGoles(int goles) {
		this.goles = goles;
	}
	public boolean isGanoFecha() {
		return ganoFecha;
	}
	public void setGanoFecha(boolean ganoFecha) {
		this.ganoFecha = ganoFecha;
	}
	public int getPenalesConvertidos() {
		return penalesConvertidos;
	}
	public int getPenalesErrados(){
		return penalesErrados;
	}
	public int getPenalesAtajados(){
		return penalesAtajados;
	}
	public void setPenalesConvertidos(int penalesConvertidos) {
		this.penalesConvertidos = penalesConvertidos;
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
	public int getTiempoRoja() {
		return tiempoRoja;
	}
	public void setTiempoRoja(int tiempoRoja) {
		this.tiempoRoja = tiempoRoja;
	}
	public int getTiempoAmarilla() {
		return tiempoAmarilla;
	}
	public void setTiempoAmarilla(int tiempoAmarilla) {
		this.tiempoAmarilla = tiempoAmarilla;
	}

	public boolean getEsEstrella() {
		return esEstrella;
	}
	public void setEsEstrella(boolean value) {
		esEstrella=value;
	}
	public boolean getCompletoPartido(){
		return completoPartido;
	}
	 
}
 
