package persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import domain.auctions.Auction;
import domain.querys.Query;
import domain.customers.User;
import domain.persistenceInterface.QueryPersistor;


public class QuerysPersistor implements QueryPersistor{

	private static QuerysPersistor instance=null;
	
	private Map<Long, Query> querys;
	
	private QuerysPersistor (){
		this.querys = new HashMap<Long, Query>();
	}
	
	public static QuerysPersistor getQuerysPersistorInstance(){
		if(QuerysPersistor.instance==null){
			QuerysPersistor.instance = new QuerysPersistor();
		}
		return QuerysPersistor.instance;
	}
	@Override
	public ArrayList<Query> getQueriesBetweenDates(Date dateSince,
			Date dateUntill) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Query> getQueriesForAuction(Auction auction) {
		ArrayList<Query> querysForAuction = new ArrayList<Query>();
		Iterator<Long> it = this.querys.keySet().iterator();
		while(it.hasNext()){
			Query q = this.querys.get(it.next());
			if(q.getAuction().equals(auction))
				querysForAuction.add(q);
		}
		return querysForAuction;
	}

	@Override
	public ArrayList<Query> getQueriesForAuctionSinceDate(Auction auction,
			Date dateSince) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Query> getQueriesForUser(User user) {
		ArrayList<Query> querysForUser = new ArrayList<Query>();
		Iterator<Long> it = this.querys.keySet().iterator();
		while(it.hasNext()){
			Query q = this.querys.get(it.next());
			if(q.getUser().equals(user))
				querysForUser.add(q);
		}
		return querysForUser;
	}

	@Override
	public ArrayList<Query> getQueriesForUserBetweenDates(User user,
			Date dateSince, Date dateUntill) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveQuery(Query query) {
		this.querys.put(query.getQueryId(), query);
		
	}

}
