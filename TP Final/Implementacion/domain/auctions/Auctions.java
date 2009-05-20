package domain.auctions;

import java.util.ArrayList;

/**
 * Colecci�n de remates. Singleton accesible desde cualquier punto para obtener
 * una instancia de remate existente.
 */
public class Auctions {

	private static Auctions instance = null;

	private ArrayList<Auction> allAuctions;

	/**
	 * Constructor privado por la implementaci�n del patr�n Singleton. No ecibe
	 * par�metros e inicializa la colecci�n vac�a.
	 */
	private Auctions() {
		this.allAuctions = new ArrayList<Auction>();
	}

	/**
	 * Devuelve la �nica instancia viva de la clase Auctions. De no existir, la
	 * crea y la devuelve creada.
	 * 
	 * @return �nica instancia de la clase colecci�n.
	 */
	public static Auctions getAuctions() {
		if (Auctions.instance == null)
			Auctions.instance = new Auctions();
		return Auctions.instance;
	}

	/**
	 * Registra un nuevo remate en la colecci�n para que quede accesible desde
	 * donde se necesite. La excepci�n est� para proteger la colecci�n de
	 * entradas nulas.
	 * 
	 * @param auction
	 *            el remate a registrar
	 * @throws NullPointerException
	 *             Chequea que no se le pase un nulo para que no se agregue,
	 *             corrompiendo la colecci�n
	 */
	public void addAuction(Auction auction) throws NullPointerException {
		if (auction != null) {
			this.allAuctions.add(auction);
		} else {
			throw new NullPointerException();
		}
	}

	/**
	 * Devuelve la instancia solicitada de remate.
	 * 
	 * @return el remate solicitado
	 */
	public Auction getAnAuction() {
		return this.allAuctions.get(0); // FIXME
	}

}
