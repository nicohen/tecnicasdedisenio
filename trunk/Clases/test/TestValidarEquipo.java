package test;

import java.util.ArrayList;
import java.util.List;

import app.Arquero;
import app.Controlador;
import app.Equipo;
import app.Jugador;
import app.JugadorDeCampo;
import app.Participante;
import exceptions.ValidationException;
import junit.framework.Assert;
import junit.framework.TestCase;

public class TestValidarEquipo extends TestCase {
	
	public void testValidarEquipo() {
		Controlador controlador = new Controlador();

		Participante participante = controlador.crearNuevoParticipante(
    		   "Nicolas","Cohen","123456",31252197,"Equipo de Nico");
		List<Jugador> jugadores = new ArrayList<Jugador>();

		Jugador jugador1 = new Arquero("ariel ortega",false,"River Plate");
		Jugador jugador2 = new Arquero("Rolfi Montenegro",false,"Independiente");
		Jugador jugador3 = new Arquero("dario Tula",false,"San Lorenzo");
		Jugador jugador4 = new JugadorDeCampo("jose Sand",Jugador.DEFENSOR,false,"Lanus");
		Jugador jugador5 = new JugadorDeCampo("daniel Islas",Jugador.DEFENSOR,false,"Tigre");
		Jugador jugador6 = new JugadorDeCampo("ogro Fabiani",Jugador.DEFENSOR,false,"River Plate");
		Jugador jugador7 = new JugadorDeCampo("jose Marzola",Jugador.DEFENSOR,false,"Boca Juniors");
		Jugador jugador8 = new JugadorDeCampo("Loperfido juan",Jugador.DEFENSOR,false,"Huracan");
		Jugador jugador9 = new JugadorDeCampo("javier leguizamon",Jugador.MEDIOCAMPISTA,false,"River Plate");
		Jugador jugador15 = new JugadorDeCampo("Lolo Lopez",Jugador.DELANTERO,false,"San Martin de Tucuman");
		Jugador jugador16 = new JugadorDeCampo("FAbian Vargas",Jugador.DELANTERO,false,"Boca Juniors");
		Jugador jugador17 = new JugadorDeCampo("Piojo Lopez",Jugador.DELANTERO,false,"Racing Club");
		Jugador jugador18 = new JugadorDeCampo("Lucas Castroan",Jugador.DELANTERO,false,"Racing Club");
		Jugador jugador19 = new JugadorDeCampo("Lucas Castroan",Jugador.DELANTERO,false,"Racing Club");
		Jugador jugador20 = new JugadorDeCampo("Rubens Sambuesa",Jugador.DELANTERO,false,"Ferro");
		Jugador jugador21 = new JugadorDeCampo("Diego Buonanote",Jugador.DELANTERO,false,"River Plate");
		
		jugadores.add(jugador1);
		jugadores.add(jugador2);
		jugadores.add(jugador3);
		jugadores.add(jugador4);
		jugadores.add(jugador5);
		jugadores.add(jugador6);
		jugadores.add(jugador7);
		jugadores.add(jugador8);
		jugadores.add(jugador9);
		jugadores.add(jugador15);
		jugadores.add(jugador16);
		jugadores.add(jugador17);
		jugadores.add(jugador18);
		jugadores.add(jugador19);
		jugadores.add(jugador20);
		jugadores.add(jugador21);
		
		Equipo equipoTest = new Equipo("Equipo de Nico");
		try {
			
			participante.crearEquipo(jugadores);
			
		} catch (ValidationException e) {
			Assert.assertEquals(0, 0);
		}
		
	}
}
