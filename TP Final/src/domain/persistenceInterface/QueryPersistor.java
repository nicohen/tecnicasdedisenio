/**
 * 
 */
package domain.persistenceInterface;

import java.util.Date;

import domain.auctions.Auction;
import domain.customers.User;
import domain.querys.Query;

/**
 *
 */
public interface QueryPersistor {

	public void saveQuery(Query query);
	
	public Query[] getQueriesForUser (User user);
	public Query[] getQueriesForUserBetweenDates(User user, Date dateSince, Date dateUntill);
	
	public Query[] getQueriesForAuction (Auction auction);
	public Query[] getQueriesForAuctionSinceDate (Auction auction, Date dateSince);
	
	public Query[] getQueriesBetweenDates(Date dateSince, Date dateUntill);
	
}
