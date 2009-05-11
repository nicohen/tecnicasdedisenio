package dto;

import java.util.ArrayList;
import java.util.List;

public class AuctionDto {

	private ProductDto product;
	private List<BidDto> bids;
	private boolean activeAuction;
	
	public AuctionDto(ProductDto product) {
		this.product = product;
		this.bids=new ArrayList <BidDto>();
		this.setActiveAuction(true);
	}

	public ProductDto getProduct() {
		return product;
	}
	
	public void finalizeAuction(){
		this.setActiveAuction(false);	
	}

	public void setActiveAuction(boolean activeAuction) {
		this.activeAuction = activeAuction;
	}

	public boolean isActiveAuction() {
		return activeAuction;
	}
	
}
