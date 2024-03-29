package test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;
import app.Arquero;
import app.CampeonatoSingleton;
import app.Controlador;
import app.Equipo;
import app.EstadisticasJugadorFecha;
import app.Jugador;
import app.Participante;

public class TestCalculoCosto extends TestCase {
			
		private void _test_Calculo_Costo(){
			
			Controlador controlador=new Controlador();
			
			//Instancio un participante de prueba
			Participante participante = controlador.crearNuevoParticipante(
		    		   "Roberto","Herman","123456",31252197,"Equipo de Nico");

		    //Instancio jugadores para el equipo del participante   
			Jugador jugador1 = new Arquero("ariel ortega",false,"River Plate");
			Jugador jugador2 = new Arquero("Rolfi Montenegro",false,"Independiente");
			Jugador jugador3 = new Arquero("dario Tula",false,"San Lorenzo");
			
				//creo equipo
			Equipo equipo=new Equipo("Equipo Prueba");
			equipo.getJugadores().add(jugador1);
			equipo.getJugadores().add(jugador2);
			equipo.getJugadores().add(jugador3);
			
			participante.setEquipo(equipo);
			
			CampeonatoSingleton.getInstancia().agregarParticipante(participante);
			//Instancio estadisticas de prueba
			EstadisticasJugadorFecha estadisticaJugador1 = new EstadisticasJugadorFecha(jugador1,1,false,0,0,0,0,0,true,true,0,true);
			EstadisticasJugadorFecha estadisticaJugador2 = new EstadisticasJugadorFecha(jugador2,4,true,0,0,0,0,0,true,false,0,true);
			EstadisticasJugadorFecha estadisticaJugador3 = new EstadisticasJugadorFecha(jugador3,0,true,0,0,0,0,0,true,false,0,true);
			
			List<EstadisticasJugadorFecha> estadisticasList = new ArrayList<EstadisticasJugadorFecha>();
			//agrego estadisticas a lista de estadisticas
			estadisticasList.add(estadisticaJugador1);
			estadisticasList.add(estadisticaJugador2);
			estadisticasList.add(estadisticaJugador3);
			
			//proceso las estadisticas asignando puntajes
			CampeonatoSingleton.getInstancia().procesarFecha(estadisticasList);
			
			Jugador jugador;
			jugador=participante.getEquipo().getJugadores().get(0);
			Assert.assertEquals(jugador.getPrecio(),5200);
			jugador=participante.getEquipo().getJugadores().get(1);
			Assert.assertEquals(jugador.getPrecio(),8200);
			jugador=participante.getEquipo().getJugadores().get(2);
			Assert.assertEquals(jugador.getPrecio(),5000);
						
			}
		public void test(){
			_test_Calculo_Costo();
			
		}

}

