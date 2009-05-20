package domain.auctions;

/**
 * Los distintos estados por los que pasa, o podr�a pasar, un remate desde que
 * se instancia hasta que se resuelva.
 */
public enum AuctionStatus {
	NEW, ACTIVE, CLOSED, PENDING;
}
