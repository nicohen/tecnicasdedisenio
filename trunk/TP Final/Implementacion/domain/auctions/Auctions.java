package domain.auctions;

import java.util.ArrayList;

/**
 * Colección de remates. Singleton accesible desde cualquier punto para obtener
 * una instancia de remate existente.
 */
public class Auctions {

	private static Auctions instance = null;

	private ArrayList<Auction> allAuctions;

	/**
	 * Constructor privado por la implementación del patrón Singleton. No ecibe
	 * parámetros e inicializa la colección vacía.
	 */
	private Auctions() {
		this.allAuctions = new ArrayList<Auction>();
	}

	/**
	 * Devuelve la única instancia viva de la clase Auctions. De no existir, la
	 * crea y la devuelve creada.
	 * 
	 * @return única instancia de la clase colección.
	 */
	public static Auctions getAuctions() {
		if (Auctions.instance == null)
			Auctions.instance = new Auctions();
		return Auctions.instance;
	}

	/**
	 * Registra un nuevo remate en la colección para que quede accesible desde
	 * donde se necesite. La excepción está para proteger la colección de
	 * entradas nulas.
	 * 
	 * @param auction
	 *            el remate a registrar
	 * @throws NullPointerException
	 *             Chequea que no se le pase un nulo para que no se agregue,
	 *             corrompiendo la colección
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
