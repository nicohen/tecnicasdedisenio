package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import utiles.Constantes;
import exceptions.ValidationException;

public class Controlador {
 
	private Participante participante;
	
	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

	public boolean validarPassword(String password) {
		if(participante.getPassword().equals(password)) {
			return true;
		} else {
			return false;
		}
	}

	public Participante crearNuevoParticipante(String nombre, String apellido, String password, int dni, String nombreEquipo) {
		Participante participante = new Participante(nombre,apellido,password,dni,nombreEquipo);
		CampeonatoSingleton.getInstancia().agregarParticipante(participante);
		return participante;	
	}

	public static void validarEquipo(List<Jugador> jugadores) throws ValidationException {
		if (jugadores.size()>Constantes.MAXIMA_CANTIDAD_JUGADORES_EQUIPO) {
			throw new ValidationException("Esta intentando cargar "+jugadores.size()+" jugadores, la cantidad minima de jugadores debe ser "+Constantes.MAXIMA_CANTIDAD_JUGADORES_EQUIPO);
		}
		
		int precioTotal=0;
		int arqueros=0;
		int defensores=0;
		int mediocampistas=0;
		int delanteros=0;
		Map<String,Integer> jugadoresPorClub = new TreeMap<String,Integer>(); 
		for(Jugador jugador : jugadores) {
			precioTotal+=jugador.getPrecio();
			switch(jugador.getPosicion()) {
				case Jugador.ARQUERO: arqueros++; break;
				case Jugador.DEFENSOR: defensores++; break;
				case Jugador.MEDIOCAMPISTA: mediocampistas++; break;
				case Jugador.DELANTERO: delanteros++; break;
				default:break;
			}
			if(jugadoresPorClub.containsKey(jugador.getClub())) {
				jugadoresPorClub.put(jugador.getClub(),1+jugadoresPorClub.get(jugador.getClub()));
			} else {
				jugadoresPorClub.put(jugador.getClub(),1);
			}
			
		}
		
		if(precioTotal>Constantes.LIMITE_COSTO_EQUIPO) {
			throw new ValidationException("El costo total del equipo es de "+precioTotal+" y fue excedido, el mismo no debe superar los "+Constantes.LIMITE_COSTO_EQUIPO);
		}
		
		if (arqueros<Constantes.MINIMA_CANTIDAD_JUGADORES_POSICION || 
			defensores<Constantes.MINIMA_CANTIDAD_JUGADORES_POSICION || 
			mediocampistas<Constantes.MINIMA_CANTIDAD_JUGADORES_POSICION || 
			delanteros<Constantes.MINIMA_CANTIDAD_JUGADORES_POSICION) {
			throw new ValidationException("La minima cantidad de jugadores por posicion debe ser "+Constantes.MINIMA_CANTIDAD_JUGADORES_POSICION);			
		}

		Set<String> clubes = jugadoresPorClub.keySet();
		for(String club : clubes) {
			if(jugadoresPorClub.get(club)>Constantes.MAXIMA_CANTIDAD_JUGADORES_CLUB) {
				throw new ValidationException("La maxima cantidad de jugadores por club debe ser "+Constantes.MAXIMA_CANTIDAD_JUGADORES_CLUB);
			}
		}
		
	}

	public static void validarNuevoJugador(Equipo equipo, Jugador jugador) throws ValidationException {
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores = equipo.getJugadores();
		jugadores.add(jugador);
		validarEquipo(jugadores);
	}
	 
}
 
