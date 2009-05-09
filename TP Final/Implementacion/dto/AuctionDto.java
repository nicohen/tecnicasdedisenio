package dto;

public class AuctionDto {

	private ProductDto product;
	
	public AuctionDto(ProductDto product) {
		this.product = product;
	}

	public ProductDto getProduct() {
		return product;
	}
	
}
