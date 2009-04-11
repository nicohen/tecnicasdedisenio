import java.util.ArrayList;

public class Equipo {
 
	private String nombre;
	 
	private double precio;
	 
	private ArrayList jugadores;
	 
	private int idEquipo;
	 
	private Participante[] participante;
	 
	private Jugador jugador;
	 
	private Fecha fecha;
	 
	private Controlador controlador;
	 
	public double getPrecio() {
		return 0;
	}
	 
	public void setPrecio(double precio) {
	 
	}
	 
	public string getNombre() {
		return null;
	}
	 
	public ArrayList getJugadores() {
		return null;
	}
	 
	public void agregarJugador() {
	 
	}
	 
	public void cambiarJugador() {
	 
	}
	 
	public void eliminarJugador() {
	 
	}
	 
	public void almacenarEquipo(jugadores lista jugadores) {
	 
	}
	 
	public boolean validarSaldoDisponible() {
		return false;
	}
	 
	public void validarCostoEquipo(Equipo equipo) {
            if (equipo.getPrecio()>100000)
                return false;
            else
                return true;
	}
	 
	public void validarJugadores(Equipo equipo) {
	 
	}
	 
	public boolean validarCantJugadoresxEquip() {
            if (equipo.getJugadores().size()!=15)               
                   return false;
                else 
                    return true;
	}
	 
	public boolean validarCambiosPermitidos() {
		return false;
	}
	 
	public setIdEquipo() {
	 
	}
	 
	public getIdEquipo() {
	 
	}
	 
	public validarCantDeJugadoresXPosicion(Equipo equipo) {
             List list = new ArrayList();
            int cantDef=0;
            int cantMed=0;
            int cantDel=0;
            int cantArq=0;
            int cantDefSup=0;
            int cantMedSup=0;
            int cantDelSup=0;
            int cantArqSup=0;
            list=equipo.getJugadores();
            Iterator iter=list.iterator();
            while (iter.hasNext())
                {
                    AbstractJugador jug=(AbstractJugador) iter.next();
                    switch (jug.getPosicion()){
                        case 0: 
                            if (jug.getIsSuplente())
                            cantArqSup=cantArqSup+1;
                            else
                            cantArq=cantArq+1;  
                            break;
                        case 1: 
                            if (jug.getIsSuplente())
                            cantDefSup=cantDefSup+1;
                            else
                            cantDef=cantDef+1;   
                            break;
                         case 2: 
                            if (jug.getIsSuplente())
                            cantMedSup=cantMedSup+1;
                            else
                            cantMed=cantMed+1;   
                            break;
                         default: 
                            if (jug.getIsSuplente())
                            cantDelSup=cantDelSup+1;
                            else
                            cantDel=cantDel+1;     
                    }
                }
            if (cantDel<2||cantArq<1||cantMed<2||cantDef<2||cantDel<2||cantDelSup<1||cantArqSup<1||cantMedSup<1||cantDefSup<2 )
                return false;
            else
                return true;
	
	 
	}
	 
}
 
