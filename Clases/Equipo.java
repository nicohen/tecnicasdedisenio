import java.util.ArrayList;
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
		
	}
	public void cambiarJugador(Jugador jugadorActual, Jugador nuevoJugador) {
		
	}
	 
	public void eliminarJugador(Jugador jugador) {
		jugadores.remove(jugador);
	}
	 
	public void haySaldoDisponible() throws SaldoInsuficienteException {
		//se toma como que hay saldo disponible el monto del precio del jugador mas barato
		double saldo=Constantes.LIMITE_COSTO_EQUIPO-precio;
		
		if (saldo<Constantes.COSTO_INICIAL_JUGADOR)
			throw new SaldoInsuficienteException();
		
	}
	 
	public void validarCostoDelEquipo() throws LimiteCostoException {
        if (getPrecio()>Constantes.LIMITE_COSTO_EQUIPO)
            throw new LimiteCostoException();
	}
	 
	public void validarJugadores() {
	 
	}
	 
	public void validarCantidadJugadoresTotal() throws CantidadMaximaJugadoresException {
        if (jugadores.size()>Constantes.MAXIMA_CANTIDAD_JUGADORES)               
        	throw new CantidadMaximaJugadoresException();
	}
	 
	public boolean validarCambiosPermitidos() {
		return false;
	}
	 
	public void validarCantidadDeJugadoresPorPosicion() throws JugadoresPorPosicionException {
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
        	throw new JugadoresPorPosicionException();
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
 
