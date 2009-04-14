package app;

import java.util.ArrayList;
import java.util.List;

import utiles.Constantes;
import exceptions.JugadorInexistenteException;
import exceptions.ValidationException;

public class Equipo {
 
	private int idEquipo;
	private String nombre;
	private double precio;
	private List<Jugador> jugadores;
	
	public Equipo(String nombreEquipo) {
		this.nombre = nombreEquipo;
		this.precio = 0;
		this.jugadores = new ArrayList<Jugador>();
		this.idEquipo = CampeonatoSingleton.getInstancia().getIdEquipoNuevo();
	}
	
	public boolean haySaldoDisponible(double costoJugador) {
		double saldo = Constantes.LIMITE_COSTO_EQUIPO - precio;		
		if (saldo <= costoJugador) {
			return false;
		} else {
			return true;
		}
	}
	 
	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}
	
	public int getIdEquipo() {
		return idEquipo;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void agregarJugador(Jugador jugador) throws ValidationException {
		Controlador.validarNuevoJugador(this,jugador);
		this.jugadores.add(jugador);
	}
	
	public void cambiarJugador(Jugador jugadorActual, Jugador nuevoJugador) throws JugadorInexistenteException {
		int i=0;
		
		for(Jugador jugador : jugadores) {
			if (jugador.getIdJugador() == jugadorActual.getIdJugador()){
				jugadores.set(i++, nuevoJugador);
				return;
			}
		}
		throw new JugadorInexistenteException("El jugador para cambiar "+jugadorActual.getNombre()+" no se encontro en el equipo.");
	}
	 
	public void eliminarJugador(Jugador jugador) throws JugadorInexistenteException {
		if (jugadores.contains(jugador)) {
			jugadores.remove(jugador);
		} else {
			throw new JugadorInexistenteException("El jugador para eliminar "+jugador.getNombre()+" no se encontro en el equipo.");
		}
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void armarEquipo(List<Jugador> jugadores) throws ValidationException {
		if(this.jugadores.size()==0) {
			this.jugadores = jugadores;
		} else {
			throw new ValidationException("El equipo ya fue armado anteriormente");
		}
	}

	public void actualizarEstadisticasJugador(int j, Jugador jugador) {
		jugadores.set(j, jugador);
	}

}
 
