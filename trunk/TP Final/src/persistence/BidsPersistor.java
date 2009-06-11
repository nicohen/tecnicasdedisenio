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
	public ArrayList<Bid> getBidsForAuction(Auction auction) {
		ArrayList<Bid> bidsForAuction = new ArrayList<Bid>();
		if(auction.getType()==AuctionType.SINGLE||auction.getType()==AuctionType.REVERSE){
			Iterator<Long> it = this.userBids.keySet().iterator();
			while(it.hasNext()){
				Bid b = this.userBids.get(it.next());
				if(b.getAuction().equals(auction))
					bidsForAuction.add(b);
			}
		}else{
			Iterator<Long> it = this.groupBids.keySet().iterator();
			while(it.hasNext()){
				Bid b = this.groupBids.get(it.next());
				if(b.getAuction().equals(auction))
					bidsForAuction.add(b);
			}
		}
		return bidsForAuction;
	}

	@Override
	public ArrayList<Bid> getBidsForGroup(Group group) {
		ArrayList<Bid> bidsForGroup = new ArrayList<Bid>();
		Iterator<Long> it = this.groupBids.keySet().iterator();
		while(it.hasNext()){
			Bid b = this.groupBids.get(it.next());
			if(b.getOwner().equals(group))
				bidsForGroup.add(b);
		}
		return bidsForGroup;
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
	public ArrayList<Bid> getBidsForUser(User user) {
		ArrayList<Bid> bidsForUser = new ArrayList<Bid>();
		Iterator<Long> it = this.userBids.keySet().iterator();
		while(it.hasNext()){
			Bid b = this.userBids.get(it.next());
			if(b.getOwner().equals(user))
				bidsForUser.add(b);
		}
		return bidsForUser;
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

	@Override
	public void saveBid(Bid bid) {
		// TODO Auto-generated method stub
		
	}

}
