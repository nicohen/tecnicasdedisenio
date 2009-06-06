package domain.persistanceInterface;

import java.util.Date;

import domain.auctions.Auction;
import domain.auctions.Bid;
import domain.customers.Group;
import domain.customers.User;

public interface BidPersistor {

	public Bid[] getBidsForUser (User user);
	public Bid[] getBidsForUserSinceDate (User user, Date dateFrom);
	public Bid[] getBidsForUserBetweenDates (User user, Date dateFrom, Date dateUntill);
	
	public Bid[] getBidsForGroup(Group group);
	public Bid[] getBidsForGroupSinceDate (Group group, Date dateFrom);
	public Bid[] getBidsForGroupBetweenDates (Group group, Date dateFrom, Date dateUntill);
	
	public Bid[] getBidsForAuction(Auction auction);
	
	public void saveBid(Bid bid);
	
}
