package domain.persistenceInterface;

import java.util.ArrayList;
import java.util.Date;

import domain.auctions.Auction;
import domain.auctions.Bid;
import domain.customers.Group;
import domain.customers.User;

public interface BidPersistor {

	public ArrayList<Bid> getBidsForUser (User user);
	public ArrayList<Bid> getBidsForUserSinceDate (User user, Date dateFrom);
	public ArrayList<Bid> getBidsForUserBetweenDates (User user, Date dateFrom, Date dateUntill);
	
	public ArrayList<Bid> getBidsForGroup(Group group);
	public ArrayList<Bid> getBidsForGroupSinceDate (Group group, Date dateFrom);
	public ArrayList<Bid> getBidsForGroupBetweenDates (Group group, Date dateFrom, Date dateUntill);
	
	public ArrayList<Bid> getBidsForAuction(Auction auction);
	
	public void saveBid(Bid bid);
	
}
