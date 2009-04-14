package test;

import java.util.ArrayList;
import java.util.List;

import exceptions.JugadorInexistenteException;

import app.Arquero;
import app.CampeonatoSingleton;
import app.Controlador;
import app.Equipo;
import app.EstadisticasJugadorFecha;
import app.Jugador;
import app.JugadorDeCampo;
import app.Participante;
import junit.framework.Assert;
import junit.framework.TestCase;

public class TestCambioJugador extends TestCase {
	
	private void _test_Cambio_Jugador(){
		
	    //Instancio jugadores para el equipo del participante   
		Jugador jugador1 = new Arquero("ariel ortega",false,"River Plate");
		Jugador jugador2 = new Arquero("Rolfi Montenegro",false,"Independiente");
		Jugador jugador3 = new Arquero("dario Tula",false,"San Lorenzo");
		Jugador jugador4 = new Arquero("Edgardo Ramirez",false,"San Lorenzo");
		Jugador jugador5 = new JugadorDeCampo("Estanislao Rodriguez",Jugador.DELANTERO,false,"San Lorenzo");
			//creo equipo
		Equipo equipo=new Equipo("Equipo Prueba");
		equipo.getJugadores().add(jugador1);
		equipo.getJugadores().add(jugador2);
		equipo.getJugadores().add(jugador3);
		//Si se produce excepcion el test es correcto
		try {
			equipo.cambiarJugador(jugador4, jugador5);
		} catch (JugadorInexistenteException e) {
			return;
		}
		Assert.fail();
		
	}
	public void test(){
		_test_Cambio_Jugador();
		
	}

}
