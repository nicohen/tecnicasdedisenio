package persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import domain.auctions.Auction;
import domain.auctions.AuctionStatus;
import domain.auctions.Product;
import domain.customers.Bidder;

public class AuctionPersistorTemplate<T extends Auction> {

	private Map<Long, T> auctions;

	public AuctionPersistorTemplate() {
		this.auctions = new HashMap<Long, T>();
	}

	/*
	 * (non-Javadoc) // TODO: debe haber un método que devuelva un remate o el
	 * otro indistintamente
	 */
	public T getAuctionById(long auctionId) {
		if (this.auctions.containsKey(auctionId)) {
			return this.auctions.get(auctionId);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.persistanceInterface.IncrementalAuctionPersistor#getIncrementalAuctionForPrize(domain.auctions.Product)
	 */
	public T getAuctionForPrize(Product prize) {
		Iterator<Long> it = this.auctions.keySet().iterator();
		while (it.hasNext()) {
			T a = this.auctions.get(it.next());
			if (prize.equals(a.getPrize())) {
				return a;
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.persistanceInterface.IncrementalAuctionPersistor#getIncrementalAuctionForPrize(java.lang.String)
	 */
	public T getAuctionForPrize(String prizeDescription) {
		Iterator<Long> it = this.auctions.keySet().iterator();
		while (it.hasNext()) {
			T a = this.auctions.get(it.next());
			if (prizeDescription.equals(a.getPrize().getDescription())) {
				return a;
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.persistanceInterface.IncrementalAuctionPersistor#getIncrementalAuctionForWinner(domain.customers.Bidder)
	 */
	public T getAuctionForWinner(Bidder bidder) {
		Iterator<Long> it = this.auctions.keySet().iterator();
		while (it.hasNext()) {
			T a = this.auctions.get(it.next());
			if ((a.getStatus() == AuctionStatus.CLOSED)
					&& (a.getWinner() != null)
					&& (bidder.equals(a.getWinner()))) {
				return a;
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.persistanceInterface.IncrementalAuctionPersistor#getIncrementalAuctions()
	 */
	public ArrayList<T> getAuctions() {
		if (this.auctions.size() == 0)
			return null;
		Iterator<Long> it = this.auctions.keySet().iterator();
		ArrayList<T> res = new ArrayList<T>();
		while (it.hasNext()) {
			res.add(this.auctions.get(it.next()));
		}
		return res;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.persistanceInterface.IncrementalAuctionPersistor#getIncrementalAuctionsForStatus(domain.auctions.AuctionStatus)
	 */
	public ArrayList<T> getAuctionsForStatus(AuctionStatus status) {
		if (this.auctions.size() == 0)
			return null;
		Iterator<Long> it = this.auctions.keySet().iterator();
		ArrayList<T> res = new ArrayList<T>();
		while (it.hasNext()) {
			T ia = this.auctions.get(it.next());
			if (ia.getStatus().equals(status)) {
				res.add(ia);
			}
		}
		return res;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.persistanceInterface.IncrementalAuctionPersistor#saveIncrementalAuction(domain.auctions.IncrementalAuction)
	 */
	public void saveAuction(T auction) {
		this.auctions.put(auction.getAuctionId(), auction);
	}

}
