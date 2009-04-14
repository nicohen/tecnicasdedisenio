package app;
import java.util.List;

import exceptions.SaldoInsuficienteException;
import exceptions.ValidationException;

public class Participante {
 
	private int idParticipante;
	private String password;
	private int dni;	 
	private String nombre; 
	private String apellido;	 
	private Equipo equipo;	 
	private int puntosAcumulados;	 
	private int puntosFechaActual;	 

	public Participante(String nombre, String apellido, String password, int dni, String nombreEquipo) {
		this.password = password;
		this.dni = dni;	 
		this.nombre = nombre; 
		this.apellido = apellido;
		this.equipo = new Equipo(nombreEquipo);
		this.idParticipante = CampeonatoSingleton.getInstancia().getIdParticipanteNuevo();
		this.puntosAcumulados = 0;	 
		this.puntosFechaActual = 0;	
	}

	public int getIdParticipante() {
		return idParticipante;
	}

	public String getPassword() {
		return password;
	}

	public int getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public Equipo getEquipo() {
		return equipo;
	}
	
	public void setEquipo(Equipo equipo) {
		this.equipo=equipo;
	}
	public int getPuntosAcumulados() {
		return puntosAcumulados;
	}

	public void acumularPuntos(int puntos) {
		this.puntosAcumulados+=puntos;
	}

	public int getPuntosFechaActual() {
		return puntosFechaActual;
	}

	public void setPuntosFechaActual(int puntosFechaActual) {
		this.puntosFechaActual = puntosFechaActual;
	}
	
	//faltantes de implementacion.
//	public int iniciarSesion(String nombre, String apellido, String password) {
//		return 0; 
//	}
	 
//	public void cerrarSesion() {
//		return;
//	}
	
	/* crea la instancia de un nuevo equipo a crear por el usuario deberia devolver un equipo dicho armar equipo un equipo vacio y recibe elnombre del equipo*/ 
	public void crearEquipo(List<Jugador> jugadores) throws ValidationException {
		Controlador.validarEquipo(jugadores);
		this.equipo.armarEquipo(jugadores);

	}
	
	public void comprarJugador(Jugador jugador) throws SaldoInsuficienteException, ValidationException {	
		if (this.equipo.haySaldoDisponible(jugador.getPrecio())) {
			this.equipo.agregarJugador(jugador);
		} else {
			throw new SaldoInsuficienteException("Saldo insuficiente para comprar jugador");
		}
	}
}
 
