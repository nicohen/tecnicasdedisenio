package dto;

import domain.customers.User;

public class SingleAuctionDto extends AuctionDto {
	private User winner;
	private int id;
	private AuctionDto auction;
	
	public SingleAuctionDto(ProductDto product) {
		super(product);
	}
	
	public void publicAution(){
		
	}
	public User getUserWinner(){
		return winner;
		
	}
	 public void toOffer(){
		 
	 }
	 
	 public AuctionDto getAuction(){
		return auction;
		 
	 }

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
