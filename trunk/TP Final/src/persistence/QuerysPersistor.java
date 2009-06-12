package persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
	public void saveQuery(Query query) {
		this.querys.put(query.getQueryId(), query);
		
	}

	@Override
	public ArrayList<Query> getQueriesForAuction(final Auction auction) {
		SearchSolver<Query> solver = new SearchSolver<Query>(){
			@Override
			public boolean getCondition(Query t) {
				return t.getAuction().equals(auction);
			}
		};
		return solver.solveCollection(querys);
	}

	@Override
	public ArrayList<Query> getQueriesForUser(final User user) {
		SearchSolver<Query> solver = new SearchSolver<Query>(){
			@Override
			public boolean getCondition(Query t) {
				return t.getUser().equals(user);
			}
		};
		return solver.solveCollection(querys);
	}

	@Override
	public ArrayList<Query> getQueriesBetweenDates(Date dateSince,
			Date dateUntill) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Query> getQueriesForAuctionSinceDate(Auction auction,
			Date dateSince) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Query> getQueriesForUserBetweenDates(User user,
			Date dateSince, Date dateUntill) {
		// TODO Auto-generated method stub
		return null;
	}


}
