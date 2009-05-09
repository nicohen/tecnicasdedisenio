package domain.products;

public class Product {
	private int id;
	private String brand;
	private String model;
	private String description;
	
	public Product(int id, String marca, String modelo) {
		// TODO Auto-generated constructor stub
	}
	
	/********************************************************************
	 * Funcionalidades principales
	 ********************************************************************/
	public Product getProduct(int id) {
		return null;
	}
	
	
	/*******d*************************************************************
	 * Getters y setters
	 ********************************************************************/
	public int getId() { return id; }
	public String getBrand() { return brand; }
	public String getModel() { return model; }
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	
	
}
