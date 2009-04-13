package app;
/*
 * Main.java
 *
 * Created on 8 de abril de 2009, 08:16
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import exceptions.ValidationException;


public class Main {
    
   public static void main(String[] args) throws IOException {
       Controlador controlador = new Controlador();

       Participante participante = controlador.crearNuevoParticipante(
    		   "Nicolas","Cohen","123456",31252197,"Equipo de Nico");
       List<Jugador> jugadores = new ArrayList<Jugador>();

		Jugador jugador1 = new Jugador("ariel ortega",Jugador.ARQUERO,false,"River Plate");
		Jugador jugador2 = new Jugador("Rolfi Montenegro",Jugador.ARQUERO,false,"Independiente");
		Jugador jugador3 = new Jugador("dario Tula",Jugador.ARQUERO,false,"San Lorenzo");
		Jugador jugador4 = new Jugador("jose Sand",Jugador.DEFENSOR,false,"Lanus");
		Jugador jugador5 = new Jugador("daniel Islas",Jugador.DEFENSOR,false,"Tigre");
		Jugador jugador6 = new Jugador("ogro Fabiani",Jugador.DEFENSOR,false,"River Plate");
		Jugador jugador7 = new Jugador("jose Marzola",Jugador.DEFENSOR,false,"Boca Juniors");
		Jugador jugador8 = new Jugador("Loperfido juan",Jugador.DEFENSOR,false,"Huracan");
		Jugador jugador9 = new Jugador("javier leguizamon",Jugador.MEDIOCAMPISTA,false,"River Plate");
		Jugador jugador10 = new Jugador("Adrian Assman",Jugador.MEDIOCAMPISTA,false,"Independiente");
		Jugador jugador11 = new Jugador("Toto Lorenzo",Jugador.MEDIOCAMPISTA,false,"Boca Juniors");
//		Jugador jugador12 = new Jugador("Licho Figueroa",Jugador.MEDIOCAMPISTA,false,"San Martin de Tucuman");
//		Jugador jugador13 = new Jugador("Javier Mercado",Jugador.MEDIOCAMPISTA,false,"Racing Club");
//		Jugador jugador14 = new Jugador("Juan Veron",Jugador.MEDIOCAMPISTA,false,"Estudiantes de la Plata");
		Jugador jugador15 = new Jugador("Lolo Lopez",Jugador.DELANTERO,false,"San Martin de Tucuman");
		Jugador jugador16 = new Jugador("FAbian Vargas",Jugador.DELANTERO,false,"Boca Juniors");
		Jugador jugador17 = new Jugador("Piojo Lopez",Jugador.DELANTERO,false,"Racing Club");
		Jugador jugador18 = new Jugador("Lucas Castroan",Jugador.DELANTERO,false,"Racing Club");
		Jugador jugador19 = new Jugador("Leopoldo lugone",3,false,"Racing Club");
		Jugador jugador20 = new Jugador("Lucas Jiemenz",3,false,"Estudiantes de la Plata");
		Jugador jugador21 = new Jugador("MArtin Palermo",3,false,"Boca Juniors");
		Jugador jugador22 = new Jugador("Roman Riquelme",3,false,"San Martin de Tucuman");
		Jugador jugador23 = new Jugador("Licas Gioda",3,false,"San Lorenzo");
		Jugador jugador24 = new Jugador("Sebastian Bataglia",4,false,"San Martin de Tucuman");
		Jugador jugador25 = new Jugador("Sebastian Forlin",4,false,"San Martin de Tucuman");
		Jugador jugador26 = new Jugador("Julio Caceres",4,false,"Racing Club");
		Jugador jugador27 = new Jugador("Carlos Ahumada",4,false,"Estudiantes de la Plata");
		Jugador jugador28 = new Jugador("Jose Bergesio",4,false,"San Martin de Tucuman");
		Jugador jugador29 = new Jugador("Luli Rios",4,false,"San Lorenzo");
		Jugador jugador30 = new Jugador("Lionel Messi",4,false,"Estudiantes de la Plata");

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
//		jugadores.add(jugador12);
//		jugadores.add(jugador13);
//		jugadores.add(jugador14);
		jugadores.add(jugador15);
		jugadores.add(jugador16);
		jugadores.add(jugador17);
		jugadores.add(jugador18);
//		jugadores.add(jugador19);
//		jugadores.add(jugador20);
//		jugadores.add(jugador21);
//		jugadores.add(jugador22);
//		jugadores.add(jugador23);
//		jugadores.add(jugador24);
//		jugadores.add(jugador25);
//		jugadores.add(jugador26);
//		jugadores.add(jugador27);
//		jugadores.add(jugador28);
//		jugadores.add(jugador29);
//		jugadores.add(jugador30);

       try {
    	   participante.crearEquipo(jugadores);

    	   
			EstadisticasJugadorFecha estadisticaJugador2 = new EstadisticasJugadorFecha(jugador2,1,false,0,0,0,0,0,true,false,0);
			EstadisticasJugadorFecha estadisticaJugador3 = new EstadisticasJugadorFecha(jugador3,0,true,0,0,0,0,0,true,false,0);
			EstadisticasJugadorFecha estadisticaJugador4 = new EstadisticasJugadorFecha(jugador4,0,true,0,0,0,0,0,true,false,0);
			EstadisticasJugadorFecha estadisticaJugador5 = new EstadisticasJugadorFecha(jugador5,1,false,1,0,0,0,0,true,false,0);
			EstadisticasJugadorFecha estadisticaJugador6 = new EstadisticasJugadorFecha(jugador6,1,true,1,0,0,0,0,true,false,0);
			EstadisticasJugadorFecha estadisticaJugador7 = new EstadisticasJugadorFecha(jugador7,1,true,1,0,0,0,0,true,false,1);
			EstadisticasJugadorFecha estadisticaJugador8 = new EstadisticasJugadorFecha(jugador8,2,true,0,0,0,0,0,false,false,1);
			EstadisticasJugadorFecha estadisticaJugador9 = new EstadisticasJugadorFecha(jugador9,2,false,0,0,0,0,0,true,false,1);
			EstadisticasJugadorFecha estadisticaJugador10 = new EstadisticasJugadorFecha(jugador10,1,true,0,0,0,0,0,true,false,1);
			EstadisticasJugadorFecha estadisticaJugador11 = new EstadisticasJugadorFecha(jugador11,0,true,0,0,0,0,0,true,false,1);
			EstadisticasJugadorFecha estadisticaJugador15 = new EstadisticasJugadorFecha(jugador15,0,false,0,0,0,0,0,true,false,1);
			EstadisticasJugadorFecha estadisticaJugador16 = new EstadisticasJugadorFecha(jugador16,2,true,0,0,0,0,0,true,false,1);
			EstadisticasJugadorFecha estadisticaJugador17 = new EstadisticasJugadorFecha(jugador17,1,false,0,0,0,0,0,true,false,1);
			EstadisticasJugadorFecha estadisticaJugador18 = new EstadisticasJugadorFecha(jugador18,0,true,0,0,0,0,0,true,false,1);
			EstadisticasJugadorFecha estadisticaJugador19 = new EstadisticasJugadorFecha(jugador19,2,true,0,0,0,0,0,true,false,0);
 
			List<EstadisticasJugadorFecha> estadisticasList = new ArrayList<EstadisticasJugadorFecha>();
			
			//estadisticasList.add(estadisticaJugador1);
			estadisticasList.add(estadisticaJugador2);
			estadisticasList.add(estadisticaJugador3);
			estadisticasList.add(estadisticaJugador4);
			estadisticasList.add(estadisticaJugador5);
			estadisticasList.add(estadisticaJugador6);
			estadisticasList.add(estadisticaJugador7);
			estadisticasList.add(estadisticaJugador8);
			estadisticasList.add(estadisticaJugador9);
			estadisticasList.add(estadisticaJugador10);
			estadisticasList.add(estadisticaJugador11);
			estadisticasList.add(estadisticaJugador15);
			estadisticasList.add(estadisticaJugador16);
			estadisticasList.add(estadisticaJugador17);
			estadisticasList.add(estadisticaJugador18);
			estadisticasList.add(estadisticaJugador19);
			
    	   CampeonatoSingleton.getInstancia().procesarFecha(estadisticasList);
       } catch (ValidationException e) {
    	   e.printStackTrace();
       }
       
    }
    
}
