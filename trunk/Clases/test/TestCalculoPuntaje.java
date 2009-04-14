package test;

import java.util.ArrayList;
import java.util.List;

import exceptions.ValidationException;

import app.Arquero;
import app.CampeonatoSingleton;
import app.Controlador;
import app.EstadisticasJugadorFecha;
import app.Jugador;
import app.JugadorDeCampo;
import app.Participante;
import junit.framework.Assert;
import junit.framework.TestCase;

public class TestCalculoPuntaje extends TestCase {
	
	private void _test_Calculo_Puntaje(){
		
		Controlador controlador = new Controlador();

	    Participante participante = controlador.crearNuevoParticipante(
	    		   "Roberto","Herman","123456",31252197,"Equipo de Nico");
	       List<Jugador> jugadores = new ArrayList<Jugador>();

		Jugador jugador1 = new Arquero("ariel ortega",false,"River Plate");
		Jugador jugador2 = new Arquero("Rolfi Montenegro",false,"Independiente");
		Jugador jugador3 = new Arquero("dario Tula",false,"San Lorenzo");
		Jugador jugador4 = new Arquero("Alejandro Romagnoli",false,"San Lorenzo");
		Jugador jugador5 = new JugadorDeCampo("daniel Islas",Jugador.DEFENSOR,false,"Tigre");
		Jugador jugador6 = new JugadorDeCampo("ogro Fabiani",Jugador.DEFENSOR,false,"River Plate");
		Jugador jugador7 = new JugadorDeCampo("jose Marzola",Jugador.DEFENSOR,false,"Boca Juniors");
		Jugador jugador8 = new JugadorDeCampo("Loperfido juan",Jugador.DEFENSOR,false,"Huracan");
		Jugador jugador9 = new JugadorDeCampo("javier leguizamon",Jugador.MEDIOCAMPISTA,false,"River Plate");
		Jugador jugador10 = new JugadorDeCampo("Adrian Assman",Jugador.MEDIOCAMPISTA,false,"Independiente");
		Jugador jugador11 = new JugadorDeCampo("Toto Lorenzo",Jugador.MEDIOCAMPISTA,false,"Boca Juniors");
		Jugador jugador12 = new JugadorDeCampo("Juan Veron",Jugador.MEDIOCAMPISTA,false,"Estudiantes de la Plata");
		Jugador jugador13 = new JugadorDeCampo("Lolo Lopez",Jugador.DELANTERO,false,"San Martin de Tucuman");
		Jugador jugador14 = new JugadorDeCampo("FAbian Vargas",Jugador.DELANTERO,false,"Boca Juniors");
		Jugador jugador15 = new JugadorDeCampo("Piojo Lopez",Jugador.DELANTERO,false,"Racing Club");
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
		
		try {
			
			participante.crearEquipo(jugadores);
		CampeonatoSingleton.getInstancia().agregarParticipante(participante);
		EstadisticasJugadorFecha estadisticaJugador1 = new EstadisticasJugadorFecha(jugador1,1,false,0,0,0,0,0,true,true,0,true);
		EstadisticasJugadorFecha estadisticaJugador2 = new EstadisticasJugadorFecha(jugador2,4,true,0,0,0,0,0,true,false,0,true);
		EstadisticasJugadorFecha estadisticaJugador3 = new EstadisticasJugadorFecha(jugador3,0,true,0,0,0,0,0,true,false,0,true);
		EstadisticasJugadorFecha estadisticaJugador4 = new EstadisticasJugadorFecha(jugador5,1,false,1,0,0,0,0,true,false,0,true);
		EstadisticasJugadorFecha estadisticaJugador5 = new EstadisticasJugadorFecha(jugador6,1,true,1,0,0,0,0,true,false,0,true);
		EstadisticasJugadorFecha estadisticaJugador6 = new EstadisticasJugadorFecha(jugador7,1,true,1,0,0,0,0,true,false,0,true);
		EstadisticasJugadorFecha estadisticaJugador7 = new EstadisticasJugadorFecha(jugador8,2,true,0,0,0,0,0,false,false,0,true);
		EstadisticasJugadorFecha estadisticaJugador8 = new EstadisticasJugadorFecha(jugador9,2,false,0,0,0,0,0,true,false,0,true);
		EstadisticasJugadorFecha estadisticaJugador9 = new EstadisticasJugadorFecha(jugador10,1,true,0,0,0,0,0,true,false,1,true);
		EstadisticasJugadorFecha estadisticaJugador10 = new EstadisticasJugadorFecha(jugador11,0,true,0,0,0,0,0,true,false,0,true);
		EstadisticasJugadorFecha estadisticaJugador11 = new EstadisticasJugadorFecha(jugador12,0,false,0,0,0,0,0,true,false,0,true);
		EstadisticasJugadorFecha estadisticaJugador12 = new EstadisticasJugadorFecha(jugador13,2,true,0,0,0,0,0,true,false,0,true);
		EstadisticasJugadorFecha estadisticaJugador13 = new EstadisticasJugadorFecha(jugador14,1,false,0,0,0,0,0,true,false,0,true);
		EstadisticasJugadorFecha estadisticaJugador14 = new EstadisticasJugadorFecha(jugador15,0,true,0,0,0,0,0,true,false,0,true);
		EstadisticasJugadorFecha estadisticaJugador15 = new EstadisticasJugadorFecha(jugador4,2,true,0,0,0,0,0,true,false,0,true);
		
		List<EstadisticasJugadorFecha> estadisticasList = new ArrayList<EstadisticasJugadorFecha>();
		
		estadisticasList.add(estadisticaJugador1);
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
		estadisticasList.add(estadisticaJugador12);
		estadisticasList.add(estadisticaJugador13);
		estadisticasList.add(estadisticaJugador14);
		estadisticasList.add(estadisticaJugador15);
		
		
		CampeonatoSingleton.getInstancia().procesarFecha(estadisticasList);
		
		Assert.assertEquals(participante.getPuntosAcumulados(), 64);
		} catch (ValidationException e) {
			
		}
	}
	public void test(){
		_test_Calculo_Puntaje();
		
	}

}
