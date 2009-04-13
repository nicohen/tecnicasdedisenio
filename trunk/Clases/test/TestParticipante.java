package app;

import junit.framework.TestCase;
import junit.framework.Assert;


public class TestParticipante extends TestCase {
	Controlador controler;
	private Participante tecnico;
	Equipo equipo;
	String nombretecnico, apellidotecnico,password,expectedResult,nombreEquipo,dnitecnico;
	int idtecnico,result=0;
	dnitecnico="30598832";
	nombretecnico="Lalo";
	apellidotecnico="Lambda";
	password="123456";
	nombreEquipo="fugitivos";
	//ingreso los datos del usuario.
	setDni(dnitecnico);
	setApellido(apellidotecnico);
	setNombre(nombretecnico);	
	setPassword(password);
	setEquipo(nombreEquipo);
	
	//creo un nuevo usuario.
	idtecnico=controler.crearNuevoUsuario();
	//ingreso su id.
	setIdParticipante(idtecnico);
	//me creo un nuevo equipo
	equipo=tecnico.getEquipo(nombreEquipo);
	//inicio la sesion del usuario
	result= tecnico.iniciarSesion(nombretecnico, apellidotecnico, password,dni,equipo);
	tecnico.armarEquipo(nombreEquipo);
	/*creacion de algunos jugadores de prueba*/
	Jugador jugador1 = new Jugador("ariel ortega",3,false,river);
	Jugador jugador2 = new Jugador("Rolfi Montenegro",4,false,independiente);
	Jugador jugador3 = new Jugador("dario Tula",2,false,SanLorenzo);
	Jugador jugador4 = new Jugador("jose Sand",4,false,lanus);
	Jugador jugador5 = new Jugador("daniel Islas",1,false,tigre);
	Jugador jugador6 = new Jugador("ogro Fabiani",4,false,river);
	Jugador jugador7 = new Jugador("jose Marzola",2,false,Boca);
	Jugador jugador8 = new Jugador("Loperfido juan",2,false,huracan);
	Jugador jugador9 = new Jugador("javier leguizamon",3,false,river);
	Jugador jugador10 = new Jugador("Adrian Assman",1,false,independiente);
	Jugador jugador11 = new Jugador("Toto Lorenzo",2,false,Boca);
	Jugador jugador12= new Juggador("Licho Figueroa",1,false,SanMartindeTucuman);
	Jugador jugador13= new Jugador("Javier Mercado",1,false,Racing);
	Jugador jugador14= new Jugador("Juan Veron",1,false,EstudiantesdelaPlata);
	Jugador jugador15= new Jugador("Lolo Lopez",1,false,SanMartindeTucuman);
	Jugador jugador16= new Jugador("FAbian Vargas",3,false,Boca);
	Jugador jugador17= new Jugador("Piojo Lopez",3,false,Racing);
	Jugador jugador18= new Jugador("Lucas Castroan",3,false,Racing);
	Jugador jugador19= new Jugador("Leopoldo lugone",3,false,Racing);
	Jugador jugador20= new Jugador("Lucas Jiemenz",4,false,EstudiantesdelaPlata);
	Jugador jugador21= new Jugador("MArtin Palermo",4,false,Boca);
	Jugador jugador22= new Jugador("Roman Riquelme",4,false,SanMartindeTucuman);
	Jugador jugador23= new Jugador("Licas Gioda",4,false,SanLorenzo);
	Jugador jugador24= new Jugador("Sebastian Bataglia",4,false,SanMartindeTucuman);
	Jugador jugador25= new Jugador("Sebastian Forlin",4,false,SanMartindeTucuman);
	Jugador jugador26= new Jugador("Julio Caceres",4,false,Racing);
	Jugador jugador27= new Jugador("Carlos Ahumada",2,false,EstudiantesdelaPlata);
	Jugador jugador28= new Jugador("Jose Bergesio",2,false,SanMartindeTucuman);
	Jugador jugador29= new Jugador("Luli Rios",2,false,SanLorenzo);
	Jugador jugador30= new Jugador("Lionel Messi",2,false,EstudiantesdelaPlata);

	/*compro jugadores*/
	tecnico.comprarJugador(jugador12);
	tecnico.comprarJugador(jugador13);
	tecnico.comprarJugador(jugador3);
	tecnico.comprarJugador(jugador7);
	tecnico.comprarJugador(jugador29);
	tecnico.comprarJugador(jugador30);
	tecnico.comprarJugador(jugador1);
	tecnico.comprarJugador(jugador16);
	tecnico.comprarJugador(jugador17);
	tecnico.comprarJugador(jugador19);
	tecnico.comprarJugador(jugador18);
	tecnico.comprarJugador(jugador24);
	tecnico.comprarJugador(jugador25);
	tecnico.comprarJugador(jugador26);
	tecnico.comprarJugador(jugador9);
	
	/*cargo estadisticas de fecha*/
	
	EstadisticasJugadorFecha estadisticaJugador1= new EstadisticasJugadorFecha("ariel ortega",0,true,0,0,0,0,0,true,false,0);
	stadisticasJugadorFecha estadisticaJugador2= new EstadisticasJugadorFecha("Rolfi Montenegro",1,false,0,0,0,0,0,true,false,0);
	stadisticasJugadorFecha estadisticaJugador3= new EstadisticasJugadorFecha("jose Sand",0,true,0,0,0,0,0,true,false,0);
	stadisticasJugadorFecha estadisticaJugador4= new EstadisticasJugadorFecha("daniel Islas",0,true,0,0,0,0,0,true,false,0);
	stadisticasJugadorFecha estadisticaJugador5= new EstadisticasJugadorFecha("ogro Fabiani",1,false,1,0,0,0,0,true,false,0);
	stadisticasJugadorFecha estadisticaJugador6= new EstadisticasJugadorFecha("jose Marzola",1,true,1,0,0,0,0,true,false,0);
	stadisticasJugadorFecha estadisticaJugador7= new EstadisticasJugadorFecha("Loperfido juan",1,true,1,0,0,0,0,true,false,1);
	stadisticasJugadorFecha estadisticaJugador8= new EstadisticasJugadorFecha("javier leguizamon",2,true,0,0,0,0,0,false,false,1);
	stadisticasJugadorFecha estadisticaJugador9= new EstadisticasJugadorFecha("Adrian Assman",2,false,0,0,0,0,0,true,false,1);
	stadisticasJugadorFecha estadisticaJugador10= new EstadisticasJugadorFecha("Toto Lorenzo",1,true,0,0,0,0,0,true,false,1);
	stadisticasJugadorFecha estadisticaJugador11= new EstadisticasJugadorFecha("Licho Figueroa",0,true,0,0,0,0,0,true,false,1);
	stadisticasJugadorFecha estadisticaJugador12= new EstadisticasJugadorFecha("Javier Mercado",0,false,0,0,0,0,0,true,false,1);
	stadisticasJugadorFecha estadisticaJugador13= new EstadisticasJugadorFecha("Juan Veron",2,true,0,0,0,0,0,true,false,1);
	stadisticasJugadorFecha estadisticaJugador14= new EstadisticasJugadorFecha("Lolo Lopez",1,false,0,0,0,0,0,true,false,1);
	stadisticasJugadorFecha estadisticaJugador15= new EstadisticasJugadorFecha("FAbian Vargas",0,true,0,0,0,0,0,true,false,1);
	stadisticasJugadorFecha estadisticaJugador16= new EstadisticasJugadorFecha("Piojo Lopez",2,true,0,0,0,0,0,true,false,0);
	stadisticasJugadorFecha estadisticaJugador17= new EstadisticasJugadorFecha("Lucas Castroan",2,true,0,0,0,0,0,true,false,0);
	stadisticasJugadorFecha estadisticaJugador18= new EstadisticasJugadorFecha("Leopoldo lugone",0,true,0,0,0,0,0,true,false,0);
	stadisticasJugadorFecha estadisticaJugador19= new EstadisticasJugadorFecha("Lucas Jiemenz",2,false,0,0,0,0,0,true,false,0);
	stadisticasJugadorFecha estadisticaJugador20= new EstadisticasJugadorFecha("MArtin Palermo",0,true,0,0,0,0,0,true,false,0);
	stadisticasJugadorFecha estadisticaJugador21= new EstadisticasJugadorFecha("Roman Riquelme",2,true,0,0,0,0,0,true,false,0);
	stadisticasJugadorFecha estadisticaJugador22= new EstadisticasJugadorFecha("Licas Gioda",0,true,0,2,1,1,1,true,false,0);
	stadisticasJugadorFecha estadisticaJugador23= new EstadisticasJugadorFecha("Sebastian Bataglia",0,true,0,0,0,0,0,true,false,1);
	stadisticasJugadorFecha estadisticaJugador24= new EstadisticasJugadorFecha("Sebastian Bataglia",0,true,0,0,0,0,0,true,false,0);
	stadisticasJugadorFecha estadisticaJugador25= new EstadisticasJugadorFecha("Sebastian Forlin",2,true,0,0,0,0,0,true,false,0);
	stadisticasJugadorFecha estadisticaJugador26= new EstadisticasJugadorFecha("Julio Caceres",0,false,0,0,1,2,1,true,false,0);
	stadisticasJugadorFecha estadisticaJugador27= new EstadisticasJugadorFecha("Carlos Ahumada",2,true,0,2,1,1,1,true,false,0);
	stadisticasJugadorFecha estadisticaJugador28= new EstadisticasJugadorFecha("Jose Bergesio",0,true,0,1,0,2,0,true,false,0);
	stadisticasJugadorFecha estadisticaJugador29= new EstadisticasJugadorFecha("Luli Rios",2,true,0,1,0,1,0,true,true,0);
	stadisticasJugadorFecha estadisticaJugador30= new EstadisticasJugadorFecha("Lionel Messi",0,true,0,1,0,2,0,true,false,0);
	
	
	/*Actualizo los puntajes para cada jugador*/
	
	jugador1.actualizarDatos(estadisticaJugador1);
	jugador2.actualizarDatos(estadisticaJugador2);
	jugador3.actualizarDatos(estadisticaJugador3);
	jugador4.actualizarDatos(estadisticaJugador4);
	jugador5.actualizarDatos(estadisticaJugador5);
	jugador6.actualizarDatos(estadisticaJugador6);
	jugador7.actualizarDatos(estadisticaJugador7);
	jugador8.actualizarDatos(estadisticaJugador8);
	jugador9.actualizarDatos(estadisticaJugador9);
	jugador10.actualizarDatos(estadisticaJugador10);
	jugador11.actualizarDatos(estadisticaJugador11);
	jugador12actualizarDatos(estadisticaJugador12);
	jugador13.actualizarDatos(estadisticaJugador13);
	jugador14.actualizarDatos(estadisticaJugador14);
	jugador15.actualizarDatos(estadisticaJugador15);
	jugador16.actualizarDatos(estadisticaJugador16);
	jugador17.actualizarDatos(estadisticaJugador17);
	jugador18.actualizarDatos(estadisticaJugador18);
	jugador19.actualizarDatos(estadisticaJugador19);
	jugador20.actualizarDatos(estadisticaJugador20);
	jugador21.actualizarDatos(estadisticaJugador21);
	jugador22.actualizarDatos(estadisticaJugador22);
	jugador23.actualizarDatos(estadisticaJugador23);
	jugador24.actualizarDatos(estadisticaJugador24);
	jugador25.actualizarDatos(estadisticaJugador25);
	jugador26.actualizarDatos(estadisticaJugador26);
	jugador27.actualizarDatos(estadisticaJugador27);
	jugador28.actualizarDatos(estadisticaJugador28);
	jugador29.actualizarDatos(estadisticaJugador29);
	jugador30.actualizarDatos(estadisticaJugador30);
	
	/*pido los puntajes de las fechas*/
	expectedResult= "El equipo no cuenta con la cantiad  minima de jugadores";
	/*
	if (expectedResult==0){
		Assert.assertEquals(expectedResult, result);	
	}
	else 
		

	}*/
}