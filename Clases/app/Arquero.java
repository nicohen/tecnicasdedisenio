package app;

public class Arquero extends Jugador {
 
	private int cantPenalesAtajados; 
	private int cantGolesRecibidos;	 
	
	public Arquero(String nombre,int posicion,boolean isSuplente,String club){
		
		super(nombre,posicion,isSuplente,club);
		
	}
	 
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
 
