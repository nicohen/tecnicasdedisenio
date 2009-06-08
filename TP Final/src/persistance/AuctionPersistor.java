/**
 * 
 */
package persistance;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import domain.auctions.AuctionStatus;
import domain.auctions.IncrementalAuction;
import domain.auctions.Product;
import domain.auctions.ReverseAuction;
import domain.customers.Bidder;
import domain.persistanceInterface.IncrementalAuctionPersistor;
import domain.persistanceInterface.ReverseAuctionPersistor;

public class AuctionPersistor implements IncrementalAuctionPersistor,
		ReverseAuctionPersistor {

	private static AuctionPersistor instance = null;

	private Map<Long, IncrementalAuction> incrementals;
	private Map<Long, ReverseAuction> reverse;
	private Set<Long> ids;

	private AuctionPersistor() {
		this.incrementals = new HashMap<Long, IncrementalAuction>();
		this.reverse = new HashMap<Long, ReverseAuction>();
		this.ids = new HashSet<Long>();
	}

	/*
	 * (non-Javadoc) // TODO: debe haber un método que devuelva un remate o el
	 * otro indistinctamente
	 */
	@Override
	public IncrementalAuction getIncrementalAuctionById(long auctionId) {
		if (!this.ids.contains(auctionId)) {
			return null;
		}
		if (this.incrementals.containsKey(auctionId)) {
			return this.incrementals.get(auctionId);
		} else {
			return null; // this.reverse.get(auctionId);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.persistanceInterface.IncrementalAuctionPersistor#getIncrementalAuctionForPrize(domain.auctions.Product)
	 */
	@Override
	public IncrementalAuction getIncrementalAuctionForPrize(Product prize) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.persistanceInterface.IncrementalAuctionPersistor#getIncrementalAuctionForPrize(java.lang.String)
	 */
	@Override
	public IncrementalAuction getIncrementalAuctionForPrize(
			String prizeDescription) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.persistanceInterface.IncrementalAuctionPersistor#getIncrementalAuctionForWinner(domain.customers.Bidder)
	 */
	@Override
	public IncrementalAuction getIncrementalAuctionForWinner(Bidder bidder) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.persistanceInterface.IncrementalAuctionPersistor#getIncrementalAuctions()
	 */
	@Override
	public IncrementalAuction[] getIncrementalAuctions() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.persistanceInterface.IncrementalAuctionPersistor#getIncrementalAuctionsForHighestBidder(domain.customers.Bidder)
	 */
	@Override
	public IncrementalAuction[] getIncrementalAuctionsForHighestBidder(
			Bidder bidder) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.persistanceInterface.IncrementalAuctionPersistor#getIncrementalAuctionsForStatus(domain.auctions.AuctionStatus)
	 */
	@Override
	public IncrementalAuction[] getIncrementalAuctionsForStatus(
			AuctionStatus status) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.persistanceInterface.IncrementalAuctionPersistor#saveIncrementalAuction(domain.auctions.IncrementalAuction)
	 */
	@Override
	public void saveIncrementalAuction(IncrementalAuction auction) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.persistanceInterface.ReverseAuctionPersistor#getReverseAuctionById(long)
	 */
	@Override
	public ReverseAuction getReverseAuctionById(long auctionId) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.persistanceInterface.ReverseAuctionPersistor#getReverseAuctionForPrize(domain.auctions.Product)
	 */
	@Override
	public ReverseAuction getReverseAuctionForPrize(Product prize) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.persistanceInterface.ReverseAuctionPersistor#getReverseAuctionForPrize(java.lang.String)
	 */
	@Override
	public ReverseAuction getReverseAuctionForPrize(String prizeDescription) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.persistanceInterface.ReverseAuctionPersistor#getReverseAuctionForWinner(domain.customers.Bidder)
	 */
	@Override
	public ReverseAuction getReverseAuctionForWinner(Bidder bidder) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.persistanceInterface.ReverseAuctionPersistor#getReverseAuctions()
	 */
	@Override
	public ReverseAuction[] getReverseAuctions() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.persistanceInterface.ReverseAuctionPersistor#getReverseAuctionsForStatus(domain.auctions.AuctionStatus)
	 */
	@Override
	public ReverseAuction[] getReverseAuctionsForStatus(AuctionStatus status) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.persistanceInterface.ReverseAuctionPersistor#saveReverseAuction(domain.auctions.ReverseAuction)
	 */
	@Override
	public void saveReverseAuction(ReverseAuction auction) {
		// TODO Auto-generated method stub

	}

}
