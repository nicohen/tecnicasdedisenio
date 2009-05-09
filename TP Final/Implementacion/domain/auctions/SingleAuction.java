package domain.auctions;

import domain.customers.User;
import domain.products.Product;

public class SingleAuction implements IAuction<SingleAuction> {

	/**
	 * 1-  
	 * 
	 * */
	public void bid() {
	}

	public SingleAuction createAuction(Product product) {
		return this;
	}

	public void finalizeAuction() {
		// TODO Auto-generated method stub
		
	}

	public User getWinner() {
		// TODO Auto-generated method stub
		return null;
	}

}
