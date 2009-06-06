package domain.querys;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import domain.auctions.Bid;
import domain.customers.Donation;
import domain.customers.Group;
import domain.customers.KeyExchange;
import domain.customers.User;

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
	private ArrayList<KeyExchange> keyExchanges;
	private ArrayList<Donation> donations;
	private ArrayList<Bid> bids;
	private ArrayList<Query> querys;
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

	public final List<KeyExchange> getKeyExchanges() {
		return keyExchanges;
	}

	public final List<Donation> getDonations() {
		return donations;
	}

	public final List<Bid> getBids() {
		return bids;
	}

	public final List<Query> getQuerys() {
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

	public boolean haveDonation(User user, Group group, Date date) {
		Object[] array = this.donations.toArray();
		Donation[] allAvailableDonations = new Donation[this.donations.size()];
		for (int i = 0; i < this.donations.size(); i++) {
			allAvailableDonations[i] = (Donation) array[i];
		}
		Arrays.sort(allAvailableDonations);

		int bottom = 0;
		int top = this.donations.size() - 1;
		int pos = this.donations.size() / 2;
		while (top > bottom) {
			int cmpGroup = allAvailableDonations[pos].getBenefeciary()
					.compareTo(group);
			int cmpUser = allAvailableDonations[pos].getDonor().compareTo(user);
			int cmpDate = allAvailableDonations[pos].getDate().compareTo(date);
			if (cmpGroup < 0 || (cmpGroup == 0 && cmpUser < 0)
					|| (cmpGroup == 0 && cmpUser == 0 && cmpDate < 0)) {
				bottom = pos + 1;
				pos = (bottom + top) / 2;
			} else if (cmpGroup > 0 || (cmpGroup == 0 && cmpUser > 0)
					|| (cmpGroup == 0 && cmpUser == 0 && cmpDate > 0)) {
				top = pos;
				pos = (bottom + top) / 2;
			} else {
				top = bottom = pos;
			}
		}
		int cmpGroup = allAvailableDonations[pos].getBenefeciary().compareTo(
				group);
		int cmpUser = allAvailableDonations[pos].getDonor().compareTo(user);
		int cmpDate = allAvailableDonations[pos].getDate().compareTo(date);
		return (cmpGroup == 0 && cmpUser == 0 && cmpDate == 0);
	}

	public boolean haveBid(Date date, User user) {
		Object[] array = this.bids.toArray();
		Bid[] allAvailableBids = new Bid[this.bids.size()];
		for (int i = 0; i < this.bids.size(); i++) {
			allAvailableBids[i] = (Bid) array[i];
		}
		Arrays.sort(allAvailableBids);

		int bottom = 0;
		int top = this.bids.size() - 1;
		int pos = this.bids.size() / 2;
		while (top > bottom) {
			int cmpUser = allAvailableBids[pos].getOwner().compareTo(user);
			int cmpDate = allAvailableBids[pos].getDate().compareTo(date);
			if (cmpDate < 0 || (cmpDate == 0 && cmpUser < 0)) {
				bottom = pos + 1;
				pos = (bottom + top) / 2;
			} else if (cmpDate > 0 || (cmpDate == 0 && cmpUser > 0)) {
				top = pos;
				pos = (bottom + top) / 2;
			} else {
				top = bottom = pos;
			}
		}
		int cmpUser = allAvailableBids[pos].getOwner().compareTo(user);
		int cmpDate = allAvailableBids[pos].getDate().compareTo(date);
		return (cmpDate == 0 && cmpUser == 0);
	}

	public boolean haveKeyExchange(String code) {
		Object[] array = this.keyExchanges.toArray();
		KeyExchange[] allAvailableKeyExchanges = new KeyExchange[this.keyExchanges
				.size()];
		for (int i = 0; i < this.keyExchanges.size(); i++) {
			allAvailableKeyExchanges[i] = (KeyExchange) array[i];
		}
		Arrays.sort(allAvailableKeyExchanges);

		int bottom = 0;
		int top = this.keyExchanges.size() - 1;
		int pos = this.keyExchanges.size() / 2;
		while (top > bottom) {
			int cmpCode = allAvailableKeyExchanges[pos].getKey().getCode()
					.compareTo(code);
			if (cmpCode < 0) {
				bottom = pos + 1;
				pos = (bottom + top) / 2;
			} else if (cmpCode > 0) {
				top = pos;
				pos = (bottom + top) / 2;
			} else {
				top = bottom = pos;
			}
		}
		return (allAvailableKeyExchanges[pos].getKey().getCode()
				.compareTo(code) == 0);
	}

	public boolean haveQuery(User user, Date date) {
		Object[] array = this.querys.toArray();
		Query[] allAvailableQueries = new Query[this.querys.size()];
		for (int i = 0; i < this.querys.size(); i++) {
			allAvailableQueries[i] = (Query) array[i];
		}
		Arrays.sort(allAvailableQueries);

		int bottom = 0;
		int top = this.querys.size() - 1;
		int pos = this.querys.size() / 2;
		while (top > bottom) {
			int cmpUser = allAvailableQueries[pos].getUser().compareTo(user);
			int cmpDate = allAvailableQueries[pos].getDate().compareTo(date);
			if (cmpUser < 0 || (cmpUser == 0 && cmpDate < 0)) {
				bottom = pos + 1;
				pos = (bottom + top) / 2;
			} else if (cmpUser > 0 || (cmpUser == 0 && cmpDate > 0)) {
				top = pos;
				pos = (bottom + top) / 2;
			} else {
				top = bottom = pos;
			}
		}
		int cmpUser = allAvailableQueries[pos].getUser().compareTo(user);
		int cmpDate = allAvailableQueries[pos].getDate().compareTo(date);
		return (cmpDate == 0 && cmpUser == 0);
	}
}
