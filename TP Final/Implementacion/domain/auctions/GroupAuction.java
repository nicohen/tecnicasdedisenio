package domain.auctions;

import dao.GroupAuctionDao;
import domain.customers.User;
import dto.GroupAuctionDto;

public class GroupAuction implements IAuction<GroupAuctionDto> {

	GroupAuctionDao dao;

	public GroupAuction(GroupAuctionDao dao) {
		this.dao = dao;
	}

	public void finalizeAuction() {
		// TODO Auto-generated method stub

	}

	public User getWinner() {
		// TODO Auto-generated method stub
		return null;
	}

	public void bid() {
		// TODO Auto-generated method stub

	}

	public int createAuction(GroupAuctionDto auction) {
		// TODO Auto-generated method stub
		return 0;
	}

}
