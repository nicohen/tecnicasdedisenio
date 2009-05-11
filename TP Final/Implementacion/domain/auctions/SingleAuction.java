package domain.auctions;

import dao.SingleAuctionDao;
import domain.customers.User;
import dto.SingleAuctionDto;

public class SingleAuction implements IAuction<SingleAuctionDto> {

	SingleAuctionDao dao;

	public SingleAuction(SingleAuctionDao dao) {
		this.dao = dao;
	}

	public void bid() {
	}

	public int createAuction(SingleAuctionDto auction) {
		return dao.add(auction);
	}

	public void finalizeAuction() {
		// TODO Auto-generated method stub

	}

	public User getWinner() {
		// TODO Auto-generated method stub
		return null;
	}

}
