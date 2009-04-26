package utiles;

public class Constantes {

	/**
	 * Limite de Precios y cantidad de jugadores
	 * */
	
	//Limite de precios
	public static final int COSTO_INICIAL_JUGADOR = 5000;
	public static final int LIMITE_COSTO_EQUIPO = 100000;

	//Limite de cantidad de jugadores
	public static final int MAXIMA_CANTIDAD_JUGADORES_EQUIPO = 15;
	public static final int MAXIMA_CANTIDAD_JUGADORES_CLUB = 4;
	public static final int MINIMA_CANTIDAD_JUGADORES_POSICION = 2;

	
	/**
	 * Puntajes
	 * */
	
	//Puntos por penales
	public static final int PUNTOS_PENAL_ATAJADO = 5;
	public static final int PUNTOS_PENAL_ERRADO = -4;

	//Puntos por no jugar
	public static final int PUNTOS_NO_JUEGA_PARTIDO = -2;
	public static final int PUNTOS_NO_JUEGA_DOSTIEMPOS = -1;

	//Puntos por expulsion
	public static final int PUNTOS_EXPULSADO_SEGUNDOTIEMPO = -2;
	public static final int PUNTOS_EXPULSADO_PRIMERTIEMPO = -4;
	
	//Puntos por gol
	public static final int PUNTOS_GOL_DELANTERO = 1;
	public static final int PUNTOS_GOL_MEDIOCAMPISTA = 2;
	public static final int PUNTOS_GOL_DEFENSOR = 3;
	public static final int PUNTOS_GOL_ARQUERO = 4;

	//Puntos en base al resultado del club
	public static final int PUNTOS_CLUB_GANA_PARTIDO = 2;
	public static final int PUNTOS_CLUB_PIERDE_PARTIDO = -1;
	
}
