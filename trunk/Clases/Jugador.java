public class Jugador {
 
	private int id;
	 
	private String nombre;
	 
	private String posicion;
	 
	private int goles;
	 
	private int amarillas;
	 
	private int rojas;
	 
	private int precioJugador;
	 
	private boolean juega;
	 
	private boolean isSuplente;
	 
	private int CantErraPenal;
	 
	private String club;
	 
	private int TiemposJugados;
	 
	private boolean isEstrella;
	 
	private int tiempoReemplazado;
	 
	private Equipo[] equipo;
	 
	public int getId() {
		return id;
	}
	 
	public string getNombre() {
		return nombre;
	}
	 
	public int getPosicion() {
		return posicion;
	}
	 
	public int getGoles() {
		return goles;
	}
	 
	public int getAmarillas() {
		return amarillas;
	}
	 
	public int getRojas() {
		return rojas;
	}
	 
	public double getPrecio() {
		return precioJugador;
	}
        
	 
	public String getClub() {
		return club;
	}
	 
	public boolean getJuega() {
		return juega;
	}
	 
	public int getErraPenal() {
		return CantErraPenal;
	}
        
        public void setErraPenal(int Cantidad) {
            CantErraPenal= Cantidad;
	}
	 
	public void setId() {
	 
	}
	 
	public void setNombre(String nom) {
            nombre=nom;
	}
	 
	public void setPosicion(String pos) {
                this.posicion =pos;
	}
	public void setIsSuplente(boolean isSup) {
                isSuplente=isSup;
	}
	  
	public boolean getIsSuplente() {
		return isSuplente;
	}
	 
	public void actualizarDatos(EstadisticasJugadorFecha estadisticas) {
	 
	}
 
	public int getTiempoJugado() {
		return 0;
	}
	 
	public int calculaPuntosJugador() {
		return 0;
	}
	 
}
 
