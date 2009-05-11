package dto;

import java.util.ArrayList;
import java.util.List;

import domain.customers.User;

public class AuctionDto {

	private int id;
	private ProductDto product;
	private List<BidDto> bids;
	private boolean active;
	private User winner;
	
	public int getId() {
		return id;
	}
	
	
	public User getWinner(){
		return winner;
	}
	
	
	public AuctionDto(ProductDto product) {
		this.product = product;
		this.bids=new ArrayList <BidDto>();
		this.setIsActive(true);
	}

	public ProductDto getProduct() {
		return product;
	}
	
	public void publishAuction(){
		
	}
	public void finalizeAuction(){
		this.setIsActive(false);	
	}

	public void setIsActive(boolean activeAuction) {
		this.active = activeAuction;
	}

	public boolean isActive() {
		return active;
	}
	
}