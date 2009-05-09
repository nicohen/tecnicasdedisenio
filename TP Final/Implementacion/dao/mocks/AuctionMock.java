package dao.mocks;

import java.util.List;

public class AuctionMock<T> {

	protected List<T> auctionList;

	public int add(T auction) {
		auctionList.add(auction);
		return auctionList.size();
	}

	public T get(int auctionId) {
		return auctionList.get(auctionId);
	}
}
