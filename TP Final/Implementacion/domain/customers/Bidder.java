package domain.customers;

import domain.auctions.Auction;
import domain.auctions.AuctionType;

public interface Bidder {

	public void bid();

	/**
	 * Valida que el tipo de remate este permitido para el bidder
	 * 
	 * @param type
	 */
	public void validateAuctionType(AuctionType type) throws Throwable;

	public boolean isAllowedToWin();

	public void win(Auction auction);
}
