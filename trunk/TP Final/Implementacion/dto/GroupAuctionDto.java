package dto;

import domain.customers.*;

public class GroupAuctionDto extends AuctionDto {
	private Group groupWinner;

	public GroupAuctionDto(ProductDto product) {
		super(product);
	}

	public Group getGroupWinner() {
		return this.groupWinner;
	}

}
