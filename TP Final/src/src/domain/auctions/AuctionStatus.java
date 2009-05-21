package src.domain.auctions;

/**
 * Los distintos estados por los que pasa, o podr�a pasar, un remate desde que
 * se crea hasta que se resuelva.
 */
public enum AuctionStatus {
	NEW, ACTIVE, CLOSED, PENDING;
}
