package mocks;

import java.util.List;

import domain.products.Product;

public class ProductMock extends ProductDao  {

	
	private static List<Product> productList; 
	
	@Override
	public void add(Product product) {
		ProductMock.productList.add(product);
	}

	@Override
	public Product get(int productId) {
		return ProductMock.productList.get(productId);
	}

}
