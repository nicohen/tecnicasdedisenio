package mocks;
import java.util.ArrayList;
import java.util.List;

import domain.products.Product;




public class Products {
	List<Product> products;
	
	public Products() {
		products = new ArrayList<Product>();
	}

	/********************************************************************
	 * Funcionalidades principales
	 ********************************************************************/

	
	/********************************************************************
	 * Getters y setters
	 ********************************************************************/
	public void addProduct(Product p) { this.products.add(p); }
	public Product getProduct(int id) { return this.products.get(id); }
}
