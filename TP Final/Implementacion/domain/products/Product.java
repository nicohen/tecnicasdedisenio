package domain.products;

import dao.ProductDao;
import dto.ProductDto;

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
