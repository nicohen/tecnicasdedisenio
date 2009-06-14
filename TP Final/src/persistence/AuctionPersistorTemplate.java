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

	Map<Long, T> getPersitenceMap() {
		return this.auctions;
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
	 * @seedomain.persistanceInterface.IncrementalAuctionPersistor#
	 * getIncrementalAuctionForPrize(domain.auctions.Product)
	 */
	public T getAuctionForPrize(final Product prize) {
		SearchSolver<T> solver = new SearchSolver<T>() {
			@Override
			public boolean getCondition(T t) {
				return t.getPrize().equals(prize);
			}
		};
		return solver.solveUnique(auctions);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seedomain.persistanceInterface.IncrementalAuctionPersistor#
	 * getIncrementalAuctionForPrize(java.lang.String)
	 */
	public T getAuctionForPrize(final String prizeDescription) {
		SearchSolver<T> solver = new SearchSolver<T>() {
			@Override
			public boolean getCondition(T t) {
				return t.getPrize().getDescription().equals(prizeDescription);
			}
		};
		return solver.solveUnique(auctions);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seedomain.persistanceInterface.IncrementalAuctionPersistor#
	 * getIncrementalAuctionForWinner(domain.customers.Bidder)
	 */
	public T getAuctionForWinner(final Bidder bidder) {
		SearchSolver<T> solver = new SearchSolver<T>() {
			@Override
			public boolean getCondition(T t) {
				return (t.getStatus() == AuctionStatus.CLOSED)
						&& (t.getWinner() != null)
						&& (bidder.equals(t.getWinner()));
			}
		};
		return solver.solveUnique(auctions);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seedomain.persistanceInterface.IncrementalAuctionPersistor#
	 * getIncrementalAuctions()
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
	 * @seedomain.persistanceInterface.IncrementalAuctionPersistor#
	 * getIncrementalAuctionsForStatus(domain.auctions.AuctionStatus)
	 */
	public ArrayList<T> getAuctionsForStatus(final AuctionStatus status) {
		SearchSolver<T> solver = new SearchSolver<T>() {
			@Override
			public boolean getCondition(T t) {
				return t.getStatus().equals(status);
			}
		};
		return solver.solveCollection(auctions);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seedomain.persistanceInterface.IncrementalAuctionPersistor#
	 * saveIncrementalAuction(domain.auctions.IncrementalAuction)
	 */
	public void saveAuction(T auction) {
		this.auctions.put(auction.getAuctionId(), auction);
	}

}
