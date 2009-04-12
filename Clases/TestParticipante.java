package test;

import junit.framework.TestCase;
import junit.framework.Assert;


public class TestParticipante extends TestCase {
	private Participante tecnico;
	Controlador controler;
	Equipo equipo;
	public void testArmado(){
	String nombretecnico, apellidotecnico,password,expectedResult;
	int idtecnico,result=0,dni;
	
	dni=tecnico.getDni();
	equipo=tecnico.getEquipo(nombretecnico);
	nombretecnico=tecnico.getNombre();
	idtecnico=tecnico.getIdParticipante();
	apellidotecnico=tecnico.getApellido();
	password=tecnico.getPassword();
	
	result= tecnico.iniciarSesion(nombretecnico, apellidotecnico, password,dni,equipo);
	
	controler.crearNuevoUsuario(nombre);
	expectedResult= "El equipo no cuenta con la cantiad  minima de jugadores";
	tecnico.armarEquipo(tecnico.getEquipo());
	
	if (expectedResult==0){
		Assert.assertEquals(expectedResult, result);	
	}
	else 
		
	}

}