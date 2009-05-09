package domain.auctions;

import domain.products.Product;

public interface IAuction {
	public IAuction createAuction(Product product);	
	public void finalizeAuction();
	public void bid();
}