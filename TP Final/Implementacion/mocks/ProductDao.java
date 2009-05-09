package mocks;

import domain.products.Product;

public abstract class ProductDao implements IDao<Product> {
	
	public abstract void add(Product product);
	
	public abstract Product get(int productId);
	
	
	
}
