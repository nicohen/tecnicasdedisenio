package domain.auctions;

import domain.customers.User;
import domain.products.Product;

public interface IAuction<T> {
	public T createAuction(Product product);

	public void finalizeAuction();

	public void bid();

	public User getWinner();
}