package test;

import junit.framework.Assert;
import junit.framework.TestCase;
import app.Arquero;
import app.Equipo;
import app.Jugador;
import app.JugadorDeCampo;
import exceptions.JugadorInexistenteException;
import exceptions.SaldoInsuficienteException;

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
		//Si se produce excepcion de jugador inexistente el test es correcto
		try {
			try {
				equipo.cambiarJugador(jugador4, jugador5);
			} catch (SaldoInsuficienteException e) {
				
			}
		} catch (JugadorInexistenteException e) {
			return;
		}
		
		Assert.fail();
		
	}
	public void test(){
		_test_Cambio_Jugador();
		
	}

}
