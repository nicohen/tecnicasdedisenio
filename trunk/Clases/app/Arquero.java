package app;

public class Arquero extends Jugador {
 
	private int cantPenalesAtajados; 
	private int cantGolesRecibidos;	 
	
	public Arquero(String nombre, boolean isSuplente, String club){
		super(nombre,Jugador.ARQUERO,isSuplente,club);
	}
	 
	public void setCantidadPenalesAtajados(int cantidad) {
		this.cantPenalesAtajados = cantidad;
	}
	 
	public int getCantidadPenalesAtajados() {
		return this.cantPenalesAtajados;
	}
	 
	public void setCantidadGolesRecibidos(int cantidad) {
		this.cantGolesRecibidos = cantidad;
	}
	 
	protected int getCantidadGolesRecibidos() {
		return this.cantGolesRecibidos;
	}
	
	
	 
}
 
