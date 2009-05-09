package dao.mocks;

import java.util.List;

import dto.AuctionDto;

public class AuctionMock {

	private static List<AuctionDto> auctionList;

	public int add(AuctionDto product) {
		auctionList.add(product);
		return auctionList.size();
	}

	public AuctionDto get(int productId) {
		return auctionList.get(productId);
	}
}
