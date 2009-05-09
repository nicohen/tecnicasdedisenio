package mocks;

import dto.ProductDto;


public abstract class ProductDao implements IDao<ProductDto> {
	
	public abstract int add(ProductDto product);
	
	public abstract ProductDto get(int productId);
	
	
	
}
