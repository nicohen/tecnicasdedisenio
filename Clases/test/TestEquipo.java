package test;

import java.util.ArrayList;
import java.util.List;
import exceptions.JugadorInexistenteException;
import exceptions.SaldoInsuficienteException;
import exceptions.ValidationException;

import junit.framework.TestCase;
import app.Controlador;
import app.Equipo;
import app.EstadisticasJugadorFecha;
import app.Jugador;
import app.Participante;
import java.io.IOException;

public class TestEquipo extends TestCase {
	/*
	public void equipoTest() throws IOException, ValidationException, SaldoInsuficienteException {
		Controlador controlador = new Controlador();
		Participante tecnico = null;//new Participante("Nicolas", "Cohen", "123456", 31252197, null);
                Participante tecnico1 = null;
		List<Jugador> jugadores = new ArrayList<Jugador>();
		Equipo equipo = null;
                Equipo equipo1 = null;
                int result;
		//ingreso los datos del usuario.
		tecnico.setDni(30598832);
		tecnico.setApellido("Lambda");
		tecnico.setNombre("Lalo");	
		tecnico.setPassword("123456");
		tecnico.setEquipo(equipo);

                tecnico1.setDni(30598832);
		tecnico1.setApellido("Lambda");
		tecnico1.setNombre("Lalo");	
		tecnico1.setPassword("123456");
		tecnico1.setEquipo(equipo);
                
		//inicio la sesion del usuario
		result= tecnico.iniciarSesion("nombre","apellido","123456");
		tecnico.armarEquipo("Pirulo");
                
                result= tecnico1.iniciarSesion("nombre1","apellido1","123456");
		tecnico1.armarEquipo("Pirulo1");
		creacion de algunos jugadores de prueba
		Jugador jugador1 = new Jugador("ariel ortega",3,false,"River Plate");
		Jugador jugador2 = new Jugador("Rolfi Montenegro",4,false,"Independiente");
		Jugador jugador3 = new Jugador("dario Tula",2,false,"San Lorenzo");
		Jugador jugador4 = new Jugador("jose Sand",4,false,"Lanus");
		Jugador jugador5 = new Jugador("daniel Islas",1,false,"Tigre");
		Jugador jugador6 = new Jugador("ogro Fabiani",4,false,"River Plate");
		Jugador jugador7 = new Jugador("jose Marzola",2,false,"Boca Juniors");
		Jugador jugador8 = new Jugador("Loperfido juan",2,false,"Huracan");
		Jugador jugador9 = new Jugador("javier leguizamon",3,false,"River Plate");
		Jugador jugador10 = new Jugador("Adrian Assman",1,false,"Independiente");
		Jugador jugador11 = new Jugador("Toto Lorenzo",2,false,"Boca Juniors");
		Jugador jugador12 = new Jugador("Licho Figueroa",1,false,"San Martin de Tucuman");
		Jugador jugador13 = new Jugador("Javier Mercado",1,false,"Racing Club");
		Jugador jugador14 = new Jugador("Juan Veron",1,false,"Estudiantes de la Plata");
		Jugador jugador15 = new Jugador("Lolo Lopez",1,false,"San Martin de Tucuman");
		Jugador jugador16 = new Jugador("FAbian Vargas",3,false,"Boca Juniors");
		Jugador jugador17 = new Jugador("Piojo Lopez",3,false,"Racing Club");
		Jugador jugador18 = new Jugador("Lucas Castroan",3,false,"Racing Club");
		Jugador jugador19 = new Jugador("Leopoldo lugone",3,false,"Racing Club");
		Jugador jugador20 = new Jugador("Lucas Jiemenz",4,false,"Estudiantes de la Plata");
		Jugador jugador21 = new Jugador("MArtin Palermo",4,false,"Boca Juniors");
		Jugador jugador22 = new Jugador("Roman Riquelme",4,false,"San Martin de Tucuman");
		Jugador jugador23 = new Jugador("Licas Gioda",4,false,"San Lorenzo");
		Jugador jugador24 = new Jugador("Sebastian Bataglia",4,false,"San Martin de Tucuman");
		Jugador jugador25 = new Jugador("Sebastian Forlin",4,false,"San Martin de Tucuman");
		Jugador jugador26 = new Jugador("Julio Caceres",4,false,"Racing Club");
		Jugador jugador27 = new Jugador("Carlos Ahumada",2,false,"Estudiantes de la Plata");
		Jugador jugador28 = new Jugador("Jose Bergesio",2,false,"San Martin de Tucuman");
		Jugador jugador29 = new Jugador("Luli Rios",2,false,"San Lorenzo");
		Jugador jugador30 = new Jugador("Lionel Messi",2,false,"Estudiantes de la Plata");
                jugador1.setRojas(1);
                jugador1.setGoles(4);
                jugador1.setJuega(true);
                
                jugador2.setEstrella(true);
                jugador2.setGoles(4);
                jugador2.setJuega(true);
                
		jugadores.add(jugador1);
		jugadores.add(jugador2);
		jugadores.add(jugador3);
		jugadores.add(jugador4);
		jugadores.add(jugador5);
		jugadores.add(jugador6);
		jugadores.add(jugador7);
		jugadores.add(jugador8);
		jugadores.add(jugador9);
		jugadores.add(jugador10);
		jugadores.add(jugador11);
		jugadores.add(jugador12);
		jugadores.add(jugador13);
		jugadores.add(jugador14);
		jugadores.add(jugador15);
		jugadores.add(jugador16);
		jugadores.add(jugador17);
		jugadores.add(jugador18);
		jugadores.add(jugador19);
		jugadores.add(jugador20);
		jugadores.add(jugador21);
		jugadores.add(jugador22);
		jugadores.add(jugador23);
		jugadores.add(jugador24);
		jugadores.add(jugador25);
		jugadores.add(jugador26);
		jugadores.add(jugador27);
		jugadores.add(jugador28);
		jugadores.add(jugador29);
		jugadores.add(jugador30);
		
		equipo = new Equipo("Pirulo", jugadores);
		
		compro jugadores
		tecnico.comprarJugador(jugador1);
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
		
                tecnico1.comprarJugador(jugador2);
		tecnico1.comprarJugador(jugador13);
		tecnico1.comprarJugador(jugador3);
		tecnico1.comprarJugador(jugador7);
		tecnico1.comprarJugador(jugador29);
		tecnico1.comprarJugador(jugador30);
		tecnico1.comprarJugador(jugador1);
		tecnico1.comprarJugador(jugador16);
		tecnico1.comprarJugador(jugador17);
		tecnico1.comprarJugador(jugador19);
		tecnico1.comprarJugador(jugador18);
		tecnico1.comprarJugador(jugador24);
		tecnico1.comprarJugador(jugador25);
		tecnico1.comprarJugador(jugador26);
		tecnico1.comprarJugador(jugador9);
		
		cargo estadisticas de fecha
		
		EstadisticasJugadorFecha estadisticaJugador1 = new EstadisticasJugadorFecha(jugador1,0,true,0,0,0,0,0,true,false,0);
		EstadisticasJugadorFecha estadisticaJugador2 = new EstadisticasJugadorFecha(jugador13,1,false,0,0,0,0,0,true,false,0);
		EstadisticasJugadorFecha estadisticaJugador3 = new EstadisticasJugadorFecha(jugador3,0,true,0,0,0,0,0,true,false,0);
		EstadisticasJugadorFecha estadisticaJugador4 = new EstadisticasJugadorFecha(jugador7,0,true,0,0,0,0,0,true,false,0);
		EstadisticasJugadorFecha estadisticaJugador5 = new EstadisticasJugadorFecha(jugador29,1,false,1,0,0,0,0,true,false,0);
		EstadisticasJugadorFecha estadisticaJugador6 = new EstadisticasJugadorFecha(jugador30,1,true,1,0,0,0,0,true,false,0);
		EstadisticasJugadorFecha estadisticaJugador7 = new EstadisticasJugadorFecha(jugador1,1,true,1,0,0,0,0,true,false,1);
		EstadisticasJugadorFecha estadisticaJugador8 = new EstadisticasJugadorFecha(jugador16,2,true,0,0,0,0,0,false,false,1);
		EstadisticasJugadorFecha estadisticaJugador9 = new EstadisticasJugadorFecha(jugador17,2,false,0,0,0,0,0,true,false,1);
		EstadisticasJugadorFecha estadisticaJugador10 = new EstadisticasJugadorFecha(jugador19,1,true,0,0,0,0,0,true,false,1);
		EstadisticasJugadorFecha estadisticaJugador11 = new EstadisticasJugadorFecha(jugador18,0,true,0,0,0,0,0,true,false,1);
		EstadisticasJugadorFecha estadisticaJugador12 = new EstadisticasJugadorFecha(jugador24,0,false,0,0,0,0,0,true,false,1);
		EstadisticasJugadorFecha estadisticaJugador13 = new EstadisticasJugadorFecha(jugador25,2,true,0,0,0,0,0,true,false,1);
		EstadisticasJugadorFecha estadisticaJugador14 = new EstadisticasJugadorFecha(jugador26,1,false,0,0,0,0,0,true,false,1);
		EstadisticasJugadorFecha estadisticaJugador15 = new EstadisticasJugadorFecha(jugador9,0,true,0,0,0,0,0,true,false,1);
		EstadisticasJugadorFecha estadisticaJugador16 = new EstadisticasJugadorFecha(jugador2,2,true,0,0,0,0,0,true,false,0);
//		EstadisticasJugadorFecha estadisticaJugador17 = new EstadisticasJugadorFecha("Lucas Castroan",2,true,0,0,0,0,0,true,false,0);
//		EstadisticasJugadorFecha estadisticaJugador18 = new EstadisticasJugadorFecha("Leopoldo lugone",0,true,0,0,0,0,0,true,false,0);
//		EstadisticasJugadorFecha estadisticaJugador19 = new EstadisticasJugadorFecha("Lucas Jiemenz",2,false,0,0,0,0,0,true,false,0);
//		EstadisticasJugadorFecha estadisticaJugador20 = new EstadisticasJugadorFecha("MArtin Palermo",0,true,0,0,0,0,0,true,false,0);
//		EstadisticasJugadorFecha estadisticaJugador21 = new EstadisticasJugadorFecha("Roman Riquelme",2,true,0,0,0,0,0,true,false,0);
//		EstadisticasJugadorFecha estadisticaJugador22 = new EstadisticasJugadorFecha("Licas Gioda",0,true,0,2,1,1,1,true,false,0);
//		EstadisticasJugadorFecha estadisticaJugador23 = new EstadisticasJugadorFecha("Sebastian Bataglia",0,true,0,0,0,0,0,true,false,1);
//		EstadisticasJugadorFecha estadisticaJugador24 = new EstadisticasJugadorFecha("Sebastian Bataglia",0,true,0,0,0,0,0,true,false,0);
//		EstadisticasJugadorFecha estadisticaJugador25 = new EstadisticasJugadorFecha("Sebastian Forlin",2,true,0,0,0,0,0,true,false,0);
//		EstadisticasJugadorFecha estadisticaJugador26 = new EstadisticasJugadorFecha("Julio Caceres",0,false,0,0,1,2,1,true,false,0);
//		EstadisticasJugadorFecha estadisticaJugador27 = new EstadisticasJugadorFecha("Carlos Ahumada",2,true,0,2,1,1,1,true,false,0);
//		EstadisticasJugadorFecha estadisticaJugador28 = new EstadisticasJugadorFecha("Jose Bergesio",0,true,0,1,0,2,0,true,false,0);
//		EstadisticasJugadorFecha estadisticaJugador29 = new EstadisticasJugadorFecha("Luli Rios",2,true,0,1,0,1,0,true,true,0);
//		EstadisticasJugadorFecha estadisticaJugador30 = new EstadisticasJugadorFecha("Lionel Messi",0,true,0,1,0,2,0,true,false,0);
		
		
		Actualizo los puntajes para cada jugador
		
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
		jugador12.actualizarDatos(estadisticaJugador12);
		jugador13.actualizarDatos(estadisticaJugador13);
		jugador14.actualizarDatos(estadisticaJugador14);
		jugador15.actualizarDatos(estadisticaJugador15);
		jugador16.actualizarDatos(estadisticaJugador16);
//		jugador17.actualizarDatos(estadisticaJugador17);
//		jugador18.actualizarDatos(estadisticaJugador18);
//		jugador19.actualizarDatos(estadisticaJugador19);
//		jugador20.actualizarDatos(estadisticaJugador20);
//		jugador21.actualizarDatos(estadisticaJugador21);
//		jugador22.actualizarDatos(estadisticaJugador22);
//		jugador23.actualizarDatos(estadisticaJugador23);
//		jugador24.actualizarDatos(estadisticaJugador24);
//		jugador25.actualizarDatos(estadisticaJugador25);
//		jugador26.actualizarDatos(estadisticaJugador26);
//		jugador27.actualizarDatos(estadisticaJugador27);
//		jugador28.actualizarDatos(estadisticaJugador28);
//		jugador29.actualizarDatos(estadisticaJugador29);
//		jugador30.actualizarDatos(estadisticaJugador30);
		
		pido los puntajes de las fechas
//		expectedResult= "El equipo no cuenta con la cantiad  minima de jugadores";
		
                System.out.println("El tecnico 2 debe tener mas puntaje por tener un jugador estrella y con mas goles");
                
                    System.out.println("el tecnico 1 tiene : ");
                    System.out.println(tecnico.getPuntosAcumulados() );
                    System.out.println("el tecnico 2 tiene : " );
                    System.out.println(tecnico1.getPuntosAcumulados() );
	}*/
}

		

