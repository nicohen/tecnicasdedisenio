package domain.auctions;

import java.util.Date;

import domain.customers.Bidder;
import domain.customers.NotEnoughMembersInGroupForBidException;
import domain.querys.Transaction;

public class Bid extends Transaction {

	private Bidder owner;
	private int value;

	public Bid(Bidder owner, Auction auction, int amountToBid) throws NotEnoughMembersInGroupForBidException {
		super(new Date());
		this.owner = owner;
		this.value = amountToBid;
		auction.takeNewBid(this);
	}

	public Bidder getOwner() {
		return owner;
	}

	public int getValue() {
		return value;
	}

	/**
	 * @param anotherBid
	 * @return 0 if equals, -1 if this<another, 1 if this>another
	 */
	public int compareTo(Bid anotherBid) {
		int res = 0;
		if (this.value < anotherBid.value)
			res = -1;
		if (this.value > anotherBid.value)
			res = 1;
		return res;
	}
}
