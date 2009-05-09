package mocks;

import java.util.List;

import dto.ProductDto;

public class ProductMock extends ProductDao  {
	
	private static List<ProductDto> productList; 
	
	public int add(ProductDto product) {
		productList.add(product);
		return productList.size();
	}

	public ProductDto get(int productId) {
		return productList.get(productId);
	}

}
