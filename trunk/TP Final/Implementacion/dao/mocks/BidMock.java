package dao.mocks;

import java.util.ArrayList;
import java.util.List;

import dao.BidDao;
import dto.BidDto;

public class BidMock extends BidDao {

	private static List<BidDto> bidList;

	public BidMock() {
		bidList = new ArrayList<BidDto>();
	}

	public int add(BidDto bid) {
		bidList.add(bid);
		return bidList.size() - 1;
	}

	public BidDto get(int bidId) {
		return bidList.get(bidId);
	}
}
