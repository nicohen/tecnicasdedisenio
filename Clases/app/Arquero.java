package app;

public class Arquero extends Jugador {
 
	private int cantPenalesAtajados; 
	private int cantGolesRecibidos;	 
	 
	public void setAtajaPenal(int cantidad) {
            this.cantPenalesAtajados= cantidad;
	}
	 
	public int getAtajaPenal() {
		return cantPenalesAtajados;
	}
	 
	public void setCantGolesRecibidos(int cantidad) {
		cantGolesRecibidos=cantidad;
	}
	 
	public int getCantGolesRecibidos() {
		return cantGolesRecibidos;
	}
	 
}
 
