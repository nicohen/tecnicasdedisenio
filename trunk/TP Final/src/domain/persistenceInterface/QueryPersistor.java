/**
 * 
 */
package domain.persistenceInterface;

import java.util.ArrayList;
import java.util.Date;

import domain.auctions.Auction;
import domain.customers.User;
import domain.querys.Query;

/**
 *
 */
public interface QueryPersistor {

	public void saveQuery(Query query);
	
	public ArrayList<Query> getQueriesForUser (User user);
	public ArrayList<Query> getQueriesForUserBetweenDates(User user, Date dateSince, Date dateUntill);
	
	public ArrayList<Query> getQueriesForAuction (Auction auction);
	public ArrayList<Query> getQueriesForAuctionSinceDate (Auction auction, Date dateSince);
	
	public ArrayList<Query> getQueriesBetweenDates(Date dateSince, Date dateUntill);
	
}
