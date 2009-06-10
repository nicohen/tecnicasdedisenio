/**
 * 
 */
package persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import domain.auctions.Auction;
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

	private Map<Long, IncrementalAuction> incrementals;
	private Map<Long, ReverseAuction> reverse;
	private Set<Long> ids;

	private AuctionPersistor() {
		this.incrementals = new HashMap<Long, IncrementalAuction>();
		this.reverse = new HashMap<Long, ReverseAuction>();
		this.ids = new HashSet<Long>();
	}
	
	public AuctionPersistor getInstance() {
		if(AuctionPersistor.instance == null){
			AuctionPersistor.instance=new AuctionPersistor();
		}
		return AuctionPersistor.instance;
		
	}

	/*
	 * (non-Javadoc) // TODO: debe haber un método que devuelva un remate o el
	 * otro indistintamente
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
		Iterator<Long> it = this.incrementals.keySet().iterator();
		while (it.hasNext()){
			IncrementalAuction a = this.incrementals.get(it.next());
			if(prize.equals(a.getPrize())){
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
	@Override
	public IncrementalAuction getIncrementalAuctionForPrize(
			String prizeDescription) {
		Iterator<Long> it = this.incrementals.keySet().iterator();
		while (it.hasNext()){
			IncrementalAuction a = this.incrementals.get(it.next());
			if(prizeDescription.equals(a.getPrize().getDescription())){
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
	@Override
	public IncrementalAuction getIncrementalAuctionForWinner(Bidder bidder) {
		Iterator<Long> it = this.incrementals.keySet().iterator();
		while (it.hasNext()){
			IncrementalAuction a = this.incrementals.get(it.next());
			if((a.getStatus()==AuctionStatus.CLOSED)
					&&(a.getWinner()!=null)
					&&(bidder.equals(a.getWinner()))){
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
	@Override
	public IncrementalAuction[] getIncrementalAuctions() {
		if(this.incrementals.size()==0)
			return null;
		Iterator<Long> it = this.incrementals.keySet().iterator();
		IncrementalAuction[] res = new IncrementalAuction[this.incrementals.size()];
		int i=0;
		while (it.hasNext()){
			res[i++] = this.incrementals.get(it.next());
		}
		return res;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.persistanceInterface.IncrementalAuctionPersistor#getIncrementalAuctionsForHighestBidder(domain.customers.Bidder)
	 */
	@Override
	public IncrementalAuction[] getIncrementalAuctionsForHighestBidder(
			Bidder bidder) {
		if(this.incrementals.size()==0)
			return null;
		Iterator<Long> it = this.incrementals.keySet().iterator();
		IncrementalAuction[] res = new IncrementalAuction[this.incrementals.size()];
		int i=0;
		while (it.hasNext()){
			IncrementalAuction ia = this.incrementals.get(it.next());
			try {
				if(ia.getHighestBidder().equals(bidder)){
					res[i++] = ia;
				}
			} catch (NoBiddersException e) {}
		}
		IncrementalAuction[] truncated = new IncrementalAuction[i];
		for(int j=0; j<i; j++){
			truncated[j] = res[j];
		}
		return res;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.persistanceInterface.IncrementalAuctionPersistor#getIncrementalAuctionsForStatus(domain.auctions.AuctionStatus)
	 */
	@Override
	public IncrementalAuction[] getIncrementalAuctionsForStatus(
			AuctionStatus status) {
		if(this.incrementals.size()==0)
			return null;
		Iterator<Long> it = this.incrementals.keySet().iterator();
		IncrementalAuction[] res = new IncrementalAuction[this.incrementals.size()];
		int i=0;
		while (it.hasNext()){
			IncrementalAuction ia = this.incrementals.get(it.next());
			if(ia.getStatus().equals(status)){
				IncrementalAuction[] truncated = new IncrementalAuction[i];
				for(int j=0; j<i; j++){
					truncated[j] = res[j];
				}
				res[i++] = ia;
			}
		}
		return res;
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
		Iterator<Long> it = this.reverse.keySet().iterator();
		while (it.hasNext()){
			ReverseAuction a = this.reverse.get(it.next());
			if(prize.equals(a.getPrize())){
				return a;
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.persistanceInterface.ReverseAuctionPersistor#getReverseAuctionForPrize(java.lang.String)
	 */
	@Override
	public ReverseAuction getReverseAuctionForPrize(String prizeDescription) {
		Iterator<Long> it = this.reverse.keySet().iterator();
		while (it.hasNext()){
			ReverseAuction a = this.reverse.get(it.next());
			if(prizeDescription.equals(a.getPrize().getDescription())){
				return a;
			}
		}
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
