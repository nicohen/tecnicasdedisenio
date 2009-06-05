package dao.mocks;

import java.util.HashMap;

import api.web.cache.Cache;

import domain.auctions.Auction;
import domain.auctions.AuctionType;
import domain.auctions.IncrementalAuction;
import domain.auctions.Product;
import domain.utils.VariationRateFunction;


public class AuctionsMock {

	private HashMap<Long, Auction> map;
	
	private static AuctionsMock instance;
	
	private AuctionsMock(){
		map = new HashMap<Long, Auction>();
	}
	
	public static AuctionsMock getInstance(){
		if (instance == null){
			instance = new AuctionsMock();
		}
		return instance;
	}
	
	public Auction get(long id){
		Auction a = map.get(id);
		
		if (a == null){
			a = new IncrementalAuction(new Product("Producto " + id),AuctionType.SINGLE,new VariationRateFunction(
					null),10);
			a.setAuctionId(id);
			map.put (id,a);
		}
		return a;
	}
	
	
	
	
}
