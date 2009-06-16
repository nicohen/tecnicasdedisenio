/**
 * 
 */
package persistence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import domain.auctions.Auction;
import domain.auctions.AuctionStatus;
import domain.auctions.AuctionType;
import domain.auctions.Bid;
import domain.auctions.IncrementalAuction;
import domain.auctions.Product;
import domain.auctions.ReverseAuction;
import domain.customers.Bidder;
import domain.exceptions.NoBiddersException;
import domain.persistenceInterface.AuctionPersistor;

public class AuctionPersistorImplementation implements AuctionPersistor {

	private static AuctionPersistorImplementation instance = null;

	private AuctionPersistorTemplate<IncrementalAuction> incrementals;
	private AuctionPersistorTemplate<ReverseAuction> reverse;

	private AuctionPersistorImplementation() {
		this.incrementals = new AuctionPersistorTemplate<IncrementalAuction>();
		this.reverse = new AuctionPersistorTemplate<ReverseAuction>();
	}

	public static AuctionPersistorImplementation getInstance() {
		if (AuctionPersistorImplementation.instance == null) {
			AuctionPersistorImplementation.instance = new AuctionPersistorImplementation();
		}
		return AuctionPersistorImplementation.instance;

	}

	/*
	 * (non-Javadoc) // TODO: debe haber un método que devuelva un remate o el
	 * otro indistintamente
	 */
	@Override
	public IncrementalAuction getIncrementalAuctionById(long auctionId) {
		return this.incrementals.getAuctionById(auctionId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seedomain.persistanceInterface.IncrementalAuctionPersistor#
	 * getIncrementalAuctionForPrize(domain.auctions.Product)
	 */
	@Override
	public IncrementalAuction getIncrementalAuctionForPrize(Product prize) {
		return this.incrementals.getAuctionForPrize(prize);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seedomain.persistanceInterface.IncrementalAuctionPersistor#
	 * getIncrementalAuctionForPrize(java.lang.String)
	 */
	@Override
	public IncrementalAuction getIncrementalAuctionForPrize(
			String prizeDescription) {
		return this.getIncrementalAuctionForPrize(prizeDescription);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seedomain.persistanceInterface.IncrementalAuctionPersistor#
	 * getIncrementalAuctionForWinner(domain.customers.Bidder)
	 */
	@Override
	public IncrementalAuction getIncrementalAuctionForWinner(Bidder bidder) {
		return this.incrementals.getAuctionForWinner(bidder);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seedomain.persistanceInterface.IncrementalAuctionPersistor#
	 * getIncrementalAuctions()
	 */
	@Override
	public ArrayList<IncrementalAuction> getIncrementalAuctions() {
		return this.incrementals.getAuctions();
	}

	@Override
	public ArrayList<IncrementalAuction> getIncrementalActiveAuctions() {
		return this.incrementals.getAuctionsForStatus(AuctionStatus.ACTIVE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seedomain.persistanceInterface.IncrementalAuctionPersistor#
	 * getIncrementalAuctionsForHighestBidder(domain.customers.Bidder)
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
			} catch (NoBiddersException e) {
			}
		}
		return res;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seedomain.persistanceInterface.IncrementalAuctionPersistor#
	 * getIncrementalAuctionsForStatus(domain.auctions.AuctionStatus)
	 */
	@Override
	public ArrayList<IncrementalAuction> getIncrementalAuctionsForStatus(
			AuctionStatus status) {
		return this.incrementals.getAuctionsForStatus(status);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seedomain.persistanceInterface.IncrementalAuctionPersistor#
	 * saveIncrementalAuction(domain.auctions.IncrementalAuction)
	 */
	@Override
	public void saveIncrementalAuction(IncrementalAuction auction) {
		this.incrementals.saveAuction(auction);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * domain.persistanceInterface.ReverseAuctionPersistor#getReverseAuctionById
	 * (long)
	 */
	@Override
	public ReverseAuction getReverseAuctionById(long auctionId) {
		return this.reverse.getAuctionById(auctionId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * domain.persistanceInterface.ReverseAuctionPersistor#getReverseAuctionForPrize
	 * (domain.auctions.Product)
	 */
	@Override
	public ReverseAuction getReverseAuctionForPrize(Product prize) {
		return this.reverse.getAuctionForPrize(prize);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * domain.persistanceInterface.ReverseAuctionPersistor#getReverseAuctionForPrize
	 * (java.lang.String)
	 */
	@Override
	public ReverseAuction getReverseAuctionForPrize(String prizeDescription) {
		return this.reverse.getAuctionForPrize(prizeDescription);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seedomain.persistanceInterface.ReverseAuctionPersistor#
	 * getReverseAuctionForWinner(domain.customers.Bidder)
	 */
	@Override
	public ReverseAuction getReverseAuctionForWinner(Bidder bidder) {
		return this.reverse.getAuctionForWinner(bidder);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * domain.persistanceInterface.ReverseAuctionPersistor#getReverseAuctions()
	 */
	@Override
	public ArrayList<ReverseAuction> getReverseAuctions() {
		return this.reverse.getAuctions();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seedomain.persistanceInterface.ReverseAuctionPersistor#
	 * getReverseAuctionsForStatus(domain.auctions.AuctionStatus)
	 */
	@Override
	public ArrayList<ReverseAuction> getReverseAuctionsForStatus(
			AuctionStatus status) {
		return this.reverse.getAuctionsForStatus(status);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * domain.persistanceInterface.ReverseAuctionPersistor#saveReverseAuction
	 * (domain.auctions.ReverseAuction)
	 */
	@Override
	public void saveReverseAuction(ReverseAuction auction) {
		this.reverse.saveAuction(auction);
	}

	@Override
	public Auction getAuctionById(long id) {
		Auction res = this.incrementals.getAuctionById(id);
		if (res == null)
			res = this.reverse.getAuctionById(id);
		return res;
	}

	@Override
	public void saveAuction(Auction auction) {
		if (auction.getType() == AuctionType.REVERSE) {
			this.reverse.saveAuction((ReverseAuction) auction);
		} else {
			this.incrementals.saveAuction((IncrementalAuction) auction);
		}
	}

	@Override
	public ArrayList<IncrementalAuction> getIncrementalAuctionsForBidder(
			Bidder bidder) {
		ArrayList<IncrementalAuction> list = new ArrayList<IncrementalAuction>();
		for (IncrementalAuction auction : incrementals.getAuctions()) {
			for (Bid bid : auction.getBids()) {
				if (bid.getOwner().equals(bidder)) {
					list.add(auction);
					break;
				}
			}
		}
		return list;
	}

}
