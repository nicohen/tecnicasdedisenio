public class Participante {
 
	private int idParticipante;
	private String password;
	private int dni;	 
	private String nombre; 
	private String apellido;	 
	private Equipo equipo;	 
	private int puntosAcumulados;	 
	private int puntosFechaActual;	 

	public Participante(String nombre, String apellido, String password, int dni,Equipo equipo ) {
		this.password= password;
		this.dni=dni;	 
		this.nombre=nombre; 
		this.apellido=apellido;	 
		this.equipo=equipo;	 
		puntosAcumulados=0;	 
		puntosFechaActual=0;	
	}
	
	public int iniciarSesion(String nombre, String apellido, String password) {
		 
	}
	 
	public void cerrarSesion() {
	 
	}
	 
	public void armarEquipo() {
	 
	}
	 
	public void comprarJugador(Jugador jugador) {
	 
	}
	 
	public int getIdParticipante() {
		return idParticipante;
	}

	public void setIdParticipante(int idParticipante) {
		this.idParticipante = idParticipante;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public int getPuntosAcumulados() {
		return puntosAcumulados;
	}

	public void setPuntosAcumulados(int puntosAcumulados) {
		this.puntosAcumulados = puntosAcumulados;
	}

	public int getPuntosFechaActual() {
		return puntosFechaActual;
	}

	public void setPuntosFechaActual(int puntosFechaActual) {
		this.puntosFechaActual = puntosFechaActual;
	}
 
}
 
