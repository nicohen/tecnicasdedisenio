package dao.mocks;

import java.util.List;

import dto.BidDto;

public class BidMock {
	private static List<BidDto> bidList;

	public int add(BidDto bid) {
		bidList.add(bid);
		return bidList.size();
	}

	public BidDto get(int bidId) {
		return bidList.get(bidId);
	}
}
