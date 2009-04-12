public class EstadisticasJugadorFecha {
 
	private Jugador jugador; 
	private int goles;	 
	private boolean ganoFecha;	 
	private int penalesConvertidos;	 
	private int amarillas;	 
	private int rojas;	 
	private int tiempoRoja;	 
	private int tiempoAmarilla;	 
	private int tiempoReemplazado;	 
	private boolean esEstrella;
	
	public EstadisticasJugadorFecha() {
	
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
	public int getTiempoReemplazado() {
		return tiempoReemplazado;
	}
	public void setTiempoReemplazado(int tiempoReemplazado) {
		this.tiempoReemplazado = tiempoReemplazado;
	}
	public boolean getEsEstrella() {
		return esEstrella;
	}
	public void setEsEstrella(boolean value) {
		esEstrella=value;
	}
	 
}
 
