/**
 * 
 */
package persistence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import domain.auctions.AuctionStatus;
import domain.auctions.IncrementalAuction;
import domain.auctions.Product;
import domain.auctions.ReverseAuction;
import domain.customers.Bidder;
import domain.exceptions.NoBiddersException;
import domain.persistenceInterface.IncrementalAuctionPersistor;
import domain.persistenceInterface.ReverseAuctionPersistor;

public class AuctionPersistor implements IncrementalAuctionPersistor,
		ReverseAuctionPersistor {

	private static AuctionPersistor instance = null;

	private AuctionPersistorTemplate<IncrementalAuction> incrementals;
	private AuctionPersistorTemplate<ReverseAuction> reverse;

	private AuctionPersistor() {
		this.incrementals = new AuctionPersistorTemplate<IncrementalAuction>();
		this.reverse = new AuctionPersistorTemplate<ReverseAuction>();
	}

	public static AuctionPersistor getInstance() {
		if (AuctionPersistor.instance == null) {
			AuctionPersistor.instance = new AuctionPersistor();
		}
		return AuctionPersistor.instance;

	}

	/*
	 * (non-Javadoc) // TODO: debe haber un m�todo que devuelva un remate o el
	 * otro indistintamente
	 */
	@Override
	public IncrementalAuction getIncrementalAuctionById(long auctionId) {
		return this.incrementals.getAuctionById(auctionId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.persistanceInterface.IncrementalAuctionPersistor#getIncrementalAuctionForPrize(domain.auctions.Product)
	 */
	@Override
	public IncrementalAuction getIncrementalAuctionForPrize(Product prize) {
		return this.incrementals.getAuctionForPrize(prize);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.persistanceInterface.IncrementalAuctionPersistor#getIncrementalAuctionForPrize(java.lang.String)
	 */
	@Override
	public IncrementalAuction getIncrementalAuctionForPrize(
			String prizeDescription) {
		return this.getIncrementalAuctionForPrize(prizeDescription);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.persistanceInterface.IncrementalAuctionPersistor#getIncrementalAuctionForWinner(domain.customers.Bidder)
	 */
	@Override
	public IncrementalAuction getIncrementalAuctionForWinner(Bidder bidder) {
		return this.incrementals.getAuctionForWinner(bidder);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.persistanceInterface.IncrementalAuctionPersistor#getIncrementalAuctions()
	 */
	@Override
	public ArrayList<IncrementalAuction> getIncrementalAuctions() {
		return this.incrementals.getAuctions();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.persistanceInterface.IncrementalAuctionPersistor#getIncrementalAuctionsForHighestBidder(domain.customers.Bidder)
	 */
	@Override
	public ArrayList<IncrementalAuction> getIncrementalAuctionsForHighestBidder(
			Bidder bidder) {
		Map<Long, IncrementalAuction> incrementalAuctions = this.incrementals
				.getPersitenceMap();
		if (incrementalAuctions.size() == 0)
			return null;
		Iterator<Long> it = incrementalAuctions.keySet().iterator();
		ArrayList<IncrementalAuction> res = new ArrayList<IncrementalAuction>();
		while (it.hasNext()) {
			IncrementalAuction ia = incrementalAuctions.get(it.next());
			try {
				if (ia.getHighestBidder().equals(bidder)) {
					res.add(ia);
				}
			} catch (NoBiddersException e) {}
		}
		return res;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.persistanceInterface.IncrementalAuctionPersistor#getIncrementalAuctionsForStatus(domain.auctions.AuctionStatus)
	 */
	@Override
	public ArrayList<IncrementalAuction> getIncrementalAuctionsForStatus(
			AuctionStatus status) {
		return this.incrementals.getAuctionsForStatus(status);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.persistanceInterface.IncrementalAuctionPersistor#saveIncrementalAuction(domain.auctions.IncrementalAuction)
	 */
	@Override
	public void saveIncrementalAuction(IncrementalAuction auction) {
		this.incrementals.saveAuction(auction);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.persistanceInterface.ReverseAuctionPersistor#getReverseAuctionById(long)
	 */
	@Override
	public ReverseAuction getReverseAuctionById(long auctionId) {
		return this.reverse.getAuctionById(auctionId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.persistanceInterface.ReverseAuctionPersistor#getReverseAuctionForPrize(domain.auctions.Product)
	 */
	@Override
	public ReverseAuction getReverseAuctionForPrize(Product prize) {
		return this.reverse.getAuctionForPrize(prize);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.persistanceInterface.ReverseAuctionPersistor#getReverseAuctionForPrize(java.lang.String)
	 */
	@Override
	public ReverseAuction getReverseAuctionForPrize(String prizeDescription) {
		return this.reverse.getAuctionForPrize(prizeDescription);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.persistanceInterface.ReverseAuctionPersistor#getReverseAuctionForWinner(domain.customers.Bidder)
	 */
	@Override
	public ReverseAuction getReverseAuctionForWinner(Bidder bidder) {
		return this.reverse.getAuctionForWinner(bidder);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.persistanceInterface.ReverseAuctionPersistor#getReverseAuctions()
	 */
	@Override
	public ArrayList<ReverseAuction> getReverseAuctions() {
		return this.reverse.getAuctions();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.persistanceInterface.ReverseAuctionPersistor#getReverseAuctionsForStatus(domain.auctions.AuctionStatus)
	 */
	@Override
	public ArrayList<ReverseAuction> getReverseAuctionsForStatus(
			AuctionStatus status) {
		return this.reverse.getAuctionsForStatus(status);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.persistanceInterface.ReverseAuctionPersistor#saveReverseAuction(domain.auctions.ReverseAuction)
	 */
	@Override
	public void saveReverseAuction(ReverseAuction auction) {
		this.reverse.saveAuction(auction);
	}

}