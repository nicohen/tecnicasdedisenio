package domain.auctions;

import domain.customers.User;

public interface IAuction<T> {
	public int createAuction(T auction);

	public void finalizeAuction();

	public void bid();

	public User getWinner();
}