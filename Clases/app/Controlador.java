package app;

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
	//TODO: ver este metodo... para mi no sirve de nada, creemos que ahora no sirve mas
	/*public boolean validarExistenciaDeJugador() {
		
		int result;
		if (result= participante.getIdParticipante(nombre)== 0){
			return false;
		}
		else 
			return true;
		return true;
	}*/
	//falta implementar.
	public int crearNuevoUsuario() {
		return participante.getIdParticipante();	
	}
	 
}
 
