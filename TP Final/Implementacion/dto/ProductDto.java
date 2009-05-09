package dto;

public class ProductDto {
	private String brand;
	private String model;
	private String description;

	public ProductDto(String brand, String model) {
		this.brand = brand;
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
