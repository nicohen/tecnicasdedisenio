public class Arquero extends Jugador {
 
	private int CantAtajaPenal; 
	private int CantGolesRecibidos;	 
	private int CantGolesMetidos;
	 
	public void setAtajaPenal(int Cantidad) {
            this.CantAtajaPenal= Cantidad;
	}
	 
	public int getAtajaPenal() {
		return CantAtajaPenal;
	}
	 
	public void setCantGolesRecibidos(int Cantidad) {
                CantGolesRecibidos=Cantidad;
	}
	 
	public int getCantGolesRecibidos() {
		return CantGolesRecibidos;
	}
	 
}
 
