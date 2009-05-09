package dao.mocks;

import java.util.List;

import dto.AuctionDto;

public class AuctionMock {

	private static List<AuctionDto> auctionList;

	public int add(AuctionDto auction) {
		auctionList.add(auction);
		return auctionList.size();
	}

	public AuctionDto get(int auctionId) {
		return auctionList.get(auctionId);
	}
}
