public class Controlador {
 
	private Participante participante;
	
	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

	public boolean validarPassword(String pass) {
		if(participante.getPassword()== pass)
			return true;
		else
			return false;
	}
	 
	public boolean validarExistenciaDeJugador(Participante participante) {
		//TODO: ver este metodo... para mi no sirve de nada
		
		/*int result;
		
		if (result= participante.getIdParticipante(participante)== 0){
			return false;
		}
		else 
			return true;*/
		return true;
	}
	//falta implementar.
	public void crearNuevoUsuario(String nombre) {
		
	}
	 
}
 
