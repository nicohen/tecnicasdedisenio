public class Participante {
 
	private int dni;	 
	private String nombre; 
        private String password;
	private String apellido;	 
	private Equipo equipo;	 
	private int puntosAcumulados;	 
	private int PuntosFechaActual;	 
	private int idParticipante;	 
	private Equipo equipo;	 
	private Controlador controlador;
      /*faltaria un metodo que cargue los puntos de las fechas */  
        
	public void setDni(int dni) {
            this.dni= dni;
	}
	 
	public int getDni() {
		return dni;
	}
	 
	public void setNombre(String nombre) {
            this.nombre= nombre; 
	}
	 
	public String getNombre() {
		return null;
	}
	 
	public void setApellido(String apellido) {
	 
	}
	 
	public String getApellido() {
		return apellido;
	}
	 
	public void setEquipo(Equipo equipo) {
	 
	}
	 
	public Equipo getEquipo() {
		return equipo;
	}
	 
	public int getPuntosFecha() {
		return PuntosFechaActual;
	}
	 
	public int getPuntosAcumulado() {
		return puntosAcumulados;
	}
	 
	public void IngresarSesion() {
	 
	}
	 
	public void cerrarSesion() {
	 
	}
	 
	public void armarEquipo() {
	 
	}
	 
	public void comprarJugador(Jugador jugador) {
	 
	}
	 
}
 
