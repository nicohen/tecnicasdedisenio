package domain.customers;

import domain.auctions.Auction;
import domain.auctions.AuctionType;

public interface Bidder {

	public void bid(Auction anAuction);

	/**
	 * Valida que el tipo de remate este permitido para el bidder
	 * 
	 * @param type
	 */
	public void validateAuctionType(AuctionType type) throws Throwable; // TODO: throw tiene que tirar una excepción mucho más definida

	public boolean isAllowedToWin();

	public void win(Auction auction);
}
