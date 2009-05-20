package domain.querys;

import java.util.ArrayList;
import java.util.List;

import domain.auctions.Bid;
import domain.customers.Donation;
import domain.customers.KeyExchange;

/**
 * Clase singleton que representa al Historial del sistema, el cual registra
 * donaciones, canjeo de puntos por claves, ofertas y consultas
 * 
 * @see KeyExchange
 * @see Donation
 * @see Bid
 * @see Query
 * 
 */
public class History {
	private List<KeyExchange> keyExchanges;
	private List<Donation> donations;
	private List<Bid> bids;
	private List<Query> querys;
	// singleton
	static private History history = new History();

	/**
	 * Inicializa las estructuras necesarias para la implementación del
	 * Historial, clase de instancia única utilizando el patrón Singleton.
	 */
	private History() {
		this.keyExchanges = new ArrayList<KeyExchange>();
		this.donations = new ArrayList<Donation>();
		this.bids = new ArrayList<Bid>();
		this.querys = new ArrayList<Query>();
	}

	public static History getInstance() {
		return history;
	}

	public List<KeyExchange> getKeyExchanges() {
		return keyExchanges;
	}

	public List<Donation> getDonations() {
		return donations;
	}

	public List<Bid> getBids() {
		return bids;
	}

	public List<Query> getQuerys() {
		return querys;
	}

	public void addKeyExchange(KeyExchange keyExchange) {
		this.keyExchanges.add(keyExchange);
	}

	public void addDonation(Donation donation) {
		this.donations.add(donation);
	}

	public void addBid(Bid bid) {
		this.bids.add(bid);
	}

	public void addQuery(Query query) {
		this.querys.add(query);
	}
}
