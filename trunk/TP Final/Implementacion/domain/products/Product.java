package domain.products;

import dto.ProductDto;
import mocks.ProductDao;

public class Product {
	
	ProductDao productDao;
	
	public Product(ProductDao dao) {
		this.productDao = dao;
	}
	
	public int createProduct(String marca, String modelo) {
		dto.ProductDto p = new dto.ProductDto();
		return productDao.add(p);
	}
	
	public ProductDto getProduct(int id) {
		return productDao.get(id);
	}

}
