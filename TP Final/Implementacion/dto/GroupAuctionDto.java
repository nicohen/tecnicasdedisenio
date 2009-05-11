package dto;

import domain.customers.*;

public class GroupAuctionDto extends AuctionDto {
	private User winner;
	private Group groupWinner;
	private int id;
	public GroupAuctionDto(ProductDto product) {
		super(product);
	}
	
	public User getUserWinner(){
		return winner;
	}
	
	public Group getGroupWinner(){
		return this.groupWinner;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
	/*public Auction getGroupAuctionDto(){
		
	}
	
	public void bid(){
		
	}
	
	public void publicAuctionGroup(int idGroup,Product product){
		
	}*/
}
