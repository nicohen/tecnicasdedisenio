package test;

import java.util.ArrayList;
import java.util.List;

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
	
	public void calculoPuntajeTest(){
		
		Controlador controlador = new Controlador();

	    Participante participante = controlador.crearNuevoParticipante(
	    		   "Nicolas","Cohen","123456",31252197,"Equipo de Nico");
	       List<Jugador> jugadores = new ArrayList<Jugador>();

		Jugador jugador1 = new Arquero("ariel ortega",false,"River Plate");
		Jugador jugador2 = new Arquero("Rolfi Montenegro",false,"Independiente");
		Jugador jugador3 = new Arquero("dario Tula",false,"San Lorenzo");
		
		jugadores.add(jugador1);
		jugadores.add(jugador2);
		jugadores.add(jugador3);
		
		EstadisticasJugadorFecha estadisticaJugador2 = new EstadisticasJugadorFecha(jugador1,1,false,0,0,0,0,0,true,false,0,true);
		EstadisticasJugadorFecha estadisticaJugador3 = new EstadisticasJugadorFecha(jugador2,0,true,0,0,0,0,0,true,false,0,true);
		EstadisticasJugadorFecha estadisticaJugador4 = new EstadisticasJugadorFecha(jugador3,0,true,0,0,0,0,0,true,false,0,true);
		
		List<EstadisticasJugadorFecha> estadisticasList = new ArrayList<EstadisticasJugadorFecha>();
		
		CampeonatoSingleton.getInstancia().procesarFecha(estadisticasList);
		
		Assert.assertEquals(participante.getPuntosAcumulados(), 15);
	}

}
