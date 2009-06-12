package persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import domain.auctions.Auction;
import domain.auctions.AuctionType;
import domain.auctions.Bid;
import domain.customers.Group;
import domain.customers.User;
import domain.persistenceInterface.BidPersistor;

public class BidsPersistor implements BidPersistor{

	private static BidsPersistor instance=null;
	
	private Map<Long, Bid> userBids;
	private Map<Long, Bid> groupBids;
	
	
	private BidsPersistor (){
		this.userBids = new HashMap<Long, Bid>();
		this.groupBids = new HashMap<Long, Bid>();
	}
	
	public static BidsPersistor getBidsPersistorInstance(){
		if(BidsPersistor.instance==null){
			BidsPersistor.instance = new BidsPersistor();
		}
		return BidsPersistor.instance;
	}

	@Override
	public void saveBid(Bid bid) {
		if(bid.getOwner().getClass()== User.class){
			this.userBids.put(bid.getBidId(), bid);
		}else{
			this.groupBids.put(bid.getBidId(), bid);
		}
	}
	
	@Override
	public ArrayList<Bid> getBidsForAuction(final Auction auction) {
		Map<Long, Bid> myMap = null;
		if (auction.getType() == AuctionType.SINGLE
				|| auction.getType() == AuctionType.REVERSE) {
			myMap = this.userBids;
		} else {
			myMap = this.groupBids;
		}
		SearchSolver<Bid> solver = new SearchSolver<Bid>(){
			@Override
			public boolean getCondition(Bid t) {
				return t.getAuction().equals(auction);
			}
		};
		return solver.solveCollection(myMap);
	}

	@Override
	public ArrayList<Bid> getBidsForGroup(final Group group) {
		SearchSolver<Bid> solver = new SearchSolver<Bid>(){
			@Override
			public boolean getCondition(Bid t) {
				return t.getOwner().equals(group);
			}
		};
		return solver.solveCollection(groupBids);
	}

	@Override
	public ArrayList<Bid> getBidsForUser(final User user) {
		SearchSolver<Bid> solver = new SearchSolver<Bid>(){
			@Override
			public boolean getCondition(Bid t) {
				return t.getOwner().equals(user);
			}
		};
		return solver.solveCollection(userBids);
	}

	@Override
	public ArrayList<Bid> getBidsForGroupBetweenDates(Group group, Date dateFrom,
			Date dateUntill) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Bid> getBidsForGroupSinceDate(Group group, Date dateFrom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Bid> getBidsForUserBetweenDates(User user, Date dateFrom,
			Date dateUntill) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Bid> getBidsForUserSinceDate(User user, Date dateFrom) {
		// TODO Auto-generated method stub
		return null;
	}

}
