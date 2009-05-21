package domain.auctions;

/**
 * El tipo del remate determina los clientes que podrán ofertar en el mismo. Por
 * ejemplo, sólo los grupos podría ofertar en remates grupales.
 */
public enum AuctionType {
	SINGLE, GROUP, REVERSE;
}
