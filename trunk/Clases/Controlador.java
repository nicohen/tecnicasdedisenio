
public class Controlador {
 
	private Participante participante;
	private Equipo equipo;
	
	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public boolean validarPassword() {
		return false;
	}
	 
	public void crearNuevoUsuario(String nombre) {
		
	}
	 
	public boolean validarExistenciaDeJugador() {
		return false;
	}
	 
	public void crearEquipo() {
		Equipo equipo = new Equipo();
		this.equipo = equipo;
	}
	 
}
 
