package app;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import utiles.Constantes;
import exceptions.*;

public class Equipo {
 
	private int idEquipo;
	private String nombre;
	private double precio;
	List<Jugador> jugadores;
	
	public Equipo(String nombre,List<Jugador> jugadores){
		this.nombre=nombre;
		this.precio=0;
		this.jugadores=jugadores;
		this.idEquipo=CampeonatoSingleton.getCampeonatoSingleton().getIdEquipoNuevo();
	}
	public void cambiarJugador(Jugador jugadorActual, Jugador nuevoJugador) throws JugadorInexistenteException {
		Iterator<Jugador> it=jugadores.iterator();
		int i=0;
		
		while(it.hasNext()){
			Jugador jugador=it.next();
			if (jugador.getIdJugador()==jugadorActual.getIdJugador()){
				jugadores.set(i, nuevoJugador);
				return;
			}
			i++;		
		}
		throw new JugadorInexistenteException("No se encontró el jugador a cambiar");
	}
	 
	public void eliminarJugador(Jugador jugador) throws JugadorInexistenteException {
		if (jugadores.contains(jugador))
			jugadores.remove(jugador);
		else
			throw new JugadorInexistenteException("No se encontró el jugador a borrar");
	}
	 
	public boolean haySaldoDisponible(double costoJugador) {
		
		double saldo=Constantes.LIMITE_COSTO_EQUIPO-precio;		
		if (saldo<costoJugador)
			return false;
		else
			return true;		
	}
	 
	public void validarCostoDelEquipo() throws ValidationException {
        if (getPrecio()>Constantes.LIMITE_COSTO_EQUIPO)
            throw new ValidationException("Se alcanzó el límite de costo del equipo");
	}
	
	//Ver si es usado en algun lugar.
	/* 
	public void validarJugadores() {
	 
	}*/
	 
	public void validarCantidadJugadoresTotal() throws ValidationException {
        if (jugadores.size()>Constantes.MAXIMA_CANTIDAD_JUGADORES)               
        	throw new ValidationException("Se superó la cantidad máxima de jugadores");
	}
	 
	public boolean validarCambiosPermitidos() {
		//Al menos en esta entrega no es necesario queda para futuros extansiones del tp.
		return false;
	}
	 
	public void validarCantidadDeJugadoresPorPosicion() throws ValidationException {
        int cantDefensores=0;
        int cantMediocampistas=0;
        int cantDelanteros=0;
        int cantArqueros=0;
        int minimo=Constantes.MIN_JUGADORES_POSICION;
        
        for (Jugador jugador : jugadores) {
            switch (jugador.getPosicion()){        
            case Jugador.ARQUERO: cantArqueros++;
           	  break;
            case Jugador.DELANTERO: cantDelanteros++;
			  break;
            case Jugador.DEFENSOR: cantDefensores++;
			  break;
            case Jugador.MEDIOCAMPISTA: cantMediocampistas++;
			  break;
			 
            }
        }
        if(cantArqueros<minimo || cantDelanteros<minimo || cantDefensores<minimo || cantMediocampistas<minimo){
        	throw new ValidationException("No se alcanzó el mínimo de jugadores por posición");
        }
	}

	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}

	public int getIdEquipo() {
		return idEquipo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getPrecio() {
		return precio;
	}

	public void addJugador(Jugador jugador) {
		this.jugadores.add(jugador);
	}
	
	public List<Jugador> getJugadores() {
		return jugadores;
	}

}
 
