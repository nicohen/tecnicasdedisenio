package domain.auctions;

import dao.ReverseAuctionDao;
import domain.customers.User;
import dto.ReverseAuctionDto;

public class ReverseAuction implements IAuction<ReverseAuctionDto> {

	ReverseAuctionDao dao;
	
	public ReverseAuction(ReverseAuctionDao dao) {
		this.dao = dao;
	}
	
	public void bid() {
		// TODO Auto-generated method stub
	}

	public void finalizeAuction() {
		// TODO Auto-generated method stub
	}

	public User getWinner() {
		// TODO Auto-generated method stub
		return null;
	}

	public int createAuction(ReverseAuctionDto auction) {
		// TODO Auto-generated method stub
		return 0;
	}

}
