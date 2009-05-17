package domain.auctions;

import java.util.Date;

import domain.customers.Bidder;
import domain.customers.NotEnoughMembersInGroupForBidException;
import domain.utils.VariationRateFunction;

public class ReverseAuction extends Auction {

	public static int STEP_SIZE_IN_MINUTES = 1;

	private Bid firstBid;
	private Date startingDate;
	private Date lastCheckedDate;
	private int startingValue;

	public ReverseAuction(Product prize, VariationRateFunction varFunction,
			int startUpValue) {
		super(prize, varFunction, AuctionType.REVERSE, startUpValue);
		this.firstBid = null;
		this.lastCheckedDate = this.startingDate = new Date();
		this.startingValue = startUpValue;
	}

	@Override
	public void finish() {
		this.status = AuctionStatus.CLOSED;
		Bidder bidder = this.firstBid.getOwner();
		bidder.win(this, this.firstBid);
		this.winner = this.firstBid.getOwner();
	}

	@Override
	public int getAmountForNextBid() {
		// TODO: Se debería tener un objeto Syncronizer, en un thread aparte,
		// que dispare los eventos de actualización de este tipo de casos.
		long startingMS = this.lastCheckedDate.getTime();
		this.lastCheckedDate = new Date();
		long actualMS = this.lastCheckedDate.getTime();
		long diff = (actualMS - startingMS) / 60000;
		diff /= ReverseAuction.STEP_SIZE_IN_MINUTES;

		for (long i = 0; i < diff; i++) {
			this.value -= this.variationRateFunction.nextDelta();
		}
		return this.value;
	}

	@Override
	/*package visibility*/ 
	void takeNewBid(Bid newBid) throws NotEnoughMembersInGroupForBidException {
		if (newBid.getValue() != this.value)
			throw new NotEnoughMembersInGroupForBidException("El valor ofertado es incorrecto");
		if (!newBid.getOwner().isAllowedToWin()) {
			throw new NotEnoughMembersInGroupForBidException(
					"El usuario no esta habilitado para ofertar");
		}
		this.firstBid = newBid;
		this.finish();
	}

	public Date getStartingDate() {
		return startingDate;
	}

	public int getStartingValue() {
		return startingValue;
	}
}
