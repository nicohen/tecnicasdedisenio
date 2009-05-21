package domain.auctions;

/**
 * El tipo del remate determina los clientes que podr�n ofertar en el mismo. Por
 * ejemplo, s�lo los grupos podr�a ofertar en remates grupales.
 */
public enum AuctionType {
	SINGLE, GROUP, REVERSE;
}
