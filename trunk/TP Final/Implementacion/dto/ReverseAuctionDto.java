package dto;

import domain.customers.User;

public class ReverseAuctionDto extends AuctionDto {
	private User winner;
	private int id;
	private AuctionDto auction;
	
	public ReverseAuctionDto(ProductDto product) {
		super(product);
	}
	
	public void publicAutionInverse(){
		
	}
	public User getUserWinner(){
		return winner;
		
	}
	 public void toOfferInverse(){
		 
	 }
	 
	 public AuctionDto getAuctionInverse(){
		return auction;
		 
	 }

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

}
