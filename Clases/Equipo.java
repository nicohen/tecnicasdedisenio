import java.util.List;
import utiles.Constantes;

public class Equipo {
 
	private int idEquipo;
	private String nombre;
	private double precio;
	List<Jugador> jugadores;
	
	public void cambiarJugador(Jugador jugadorActual, Jugador nuevoJugador) {
		
	}
	 
	public void eliminarJugador(Jugador jugador) {
		jugadores.remove(jugador);
	}
	 
	public boolean haySaldoDisponible() {
		if (precio > 0){
			return true;
		}
		else
			return false;
	}
	 
	public boolean validarCostoDelEquipo() {
        if (getPrecio()>Constantes.LIMITE_COSTO_EQUIPO)
            return false;
        else
            return true;
	}
	 
	public void validarJugadores() {
	 
	}
	 
	public boolean validarCantidadJugadoresTotal() {
        if (jugadores.size()<Constantes.MAXIMA_CANTIDAD_JUGADORES) {               
        	return false;
        } else { 
        	return true;
        }
	}
	 
	public boolean validarCambiosPermitidos() {
		return false;
	}
	 
	public void validarCantidadDeJugadoresPorPosicion() {
        int cantDef=0;
        int cantMed=0;
        int cantDel=0;
        int cantArq=0;
        int cantDefSup=0;
        int cantMedSup=0;
        int cantDelSup=0;
        int cantArqSup=0;
            
        for (Jugador jugador : jugadores) {
            if(jugador.getPosicion()==Jugador.ARQUERO) {
                if (jugador.isSuplente()) {
                	cantArqSup=cantArqSup+1;
                } else {
                	cantArq=cantArq+1;
                }
            } else if (jugador.getPosicion()==Jugador.DEFENSOR) {
            	if (jugador.isSuplente()) {
                    cantDefSup=cantDefSup+1;
            	} else {
                    cantDef=cantDef+1;
            	}
            } else if (jugador.getPosicion()==Jugador.MEDIOCAMPISTA) {
            	if (jugador.isSuplente()) {
            		cantMedSup=cantMedSup+1;
            	} else {
            		cantMed=cantMed+1;
            	}
            } else {
                if (jugador.isSuplente()) {
                	cantDelSup=cantDelSup+1;
                } else {
                	cantDel=cantDel+1;
                }
            }
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
 
