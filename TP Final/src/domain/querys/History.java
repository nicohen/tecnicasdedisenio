package domain.querys;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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
	
	public boolean haveDonation (User user, Group group, Date date){
		Donation[] allAvailableDonations = (Donation[]) this.donations.toArray();
		Arrays.sort(allAvailableDonations);
		
		int bottom = 0;
		int top = this.donations.size();
		int pos= this.donations.size()/2;
		while (top>bottom){
			int cmpGroup = allAvailableDonations[pos].getBenefeciary().compareTo(group);
			int cmpUser = allAvailableDonations[pos].getDonor().compareTo(user);
			int cmpDate = allAvailableDonations[pos].getDate().compareTo(date);
			if(cmpGroup<0 || (cmpGroup==0 && cmpUser<0) || (cmpGroup==0 && cmpUser==0 && cmpDate<0)){
				bottom = pos+1;
				pos = (bottom+top)/2;
			} else if(cmpGroup>0 || (cmpGroup==0 && cmpUser>0) || (cmpGroup==0 && cmpUser==0 && cmpDate>0)){
				top = pos;
				pos = (bottom+top)/2;
			} else {
				top = bottom = pos;
			}
		}
		int cmpGroup = allAvailableDonations[pos].getBenefeciary().compareTo(group);
		int cmpUser = allAvailableDonations[pos].getDonor().compareTo(user);
		int cmpDate = allAvailableDonations[pos].getDate().compareTo(date);
		return (cmpGroup==0 && cmpUser==0 && cmpDate==0);
	}
	
	public boolean haveBid (Date date, User user){
		Bid[] allAvailableBids = (Bid[]) this.bids.toArray();
		Arrays.sort(allAvailableBids);
		
		int bottom = 0;
		int top = this.donations.size();
		int pos= this.donations.size()/2;
		while (top>bottom){
			int cmpUser = allAvailableBids[pos].getOwner().compareTo(user);
			int cmpDate = allAvailableBids[pos].getDate().compareTo(date);
			if(cmpDate<0 || (cmpDate==0 && cmpUser<0)){
				bottom = pos+1;
				pos = (bottom+top)/2;
			} else if(cmpDate>0 || (cmpDate==0 && cmpUser>0)){
				top = pos;
				pos = (bottom+top)/2;
			} else {
				top = bottom = pos;
			}
		}
		int cmpUser = allAvailableBids[pos].getOwner().compareTo(user);
		int cmpDate = allAvailableBids[pos].getDate().compareTo(date);
		return (cmpDate==0 && cmpUser==0);
	}
	
	public boolean haveKeyExchange(String code) {
		KeyExchange[] allAvailableBids = (KeyExchange[]) this.bids.toArray();
		Arrays.sort(allAvailableBids);
		
		int bottom = 0;
		int top = this.donations.size();
		int pos= this.donations.size()/2;
		while (top>bottom){
			int cmpCode = allAvailableBids[pos].getKey().getCode().compareTo(code);
			if(cmpCode<0){
				bottom = pos+1;
				pos = (bottom+top)/2;
			} else if(cmpCode>0){
				top = pos;
				pos = (bottom+top)/2;
			} else {
				top = bottom = pos;
			}
		}
		return (allAvailableBids[pos].getKey().getCode().compareTo(code)==0);
	}
	
	public boolean haveQuery(User user, Date date) {
		Query[] allAvailableBids = (Query[]) this.bids.toArray();
		Arrays.sort(allAvailableBids);
		
		int bottom = 0;
		int top = this.donations.size();
		int pos= this.donations.size()/2;
		while (top>bottom){
			int cmpUser = allAvailableBids[pos].getUser().compareTo(user);
			int cmpDate = allAvailableBids[pos].getDate().compareTo(date);
			if(cmpUser<0 || (cmpUser==0 && cmpDate<0)){
				bottom = pos+1;
				pos = (bottom+top)/2;
			} else if(cmpUser>0 || (cmpUser==0 && cmpDate>0)){
				top = pos;
				pos = (bottom+top)/2;
			} else {
				top = bottom = pos;
			}
		}
		int cmpUser = allAvailableBids[pos].getUser().compareTo(user);
		int cmpDate = allAvailableBids[pos].getDate().compareTo(date);
		return (cmpDate==0 && cmpUser==0);
	}
}
