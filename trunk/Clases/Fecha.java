import java.util.ArrayList;

public class Fecha {
 
	private int fecha;
	 
	private ArrayList<EstadisticasJugadorFecha> estadisticasJugadores;
	 
	public void setFecha(int fecha) {
		this.fecha = fecha;
	}
	
	public int getFecha() {
		return fecha;
	}
	 
	public void addEstadisticaJugadores(EstadisticasJugadorFecha estadisticasJugador) {
		this.estadisticasJugadores.add(estadisticasJugador);
	}
	
	public ArrayList<EstadisticasJugadorFecha> getEstadisticasJugadores() {
		return estadisticasJugadores;
	}
	 
}
 
