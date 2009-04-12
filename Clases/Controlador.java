public class Controlador {
 
	private Participante participante;
	
	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

	public boolean validarPassword(String pass) {
		if(participante.getPassword()== pass){
			return true;
		}
		else
			return false;
	}
	 
	public boolean validarExistenciaDeJugador(Participante participante) {
		int result;
		if (result= participante.getIdParticipante(participante)== 0){
			return false;
		}
		else 
			return true;
	}
	//falta implementar.
	public void crearNuevoUsuario(String nombre) {
		
	}
	 
}
 
