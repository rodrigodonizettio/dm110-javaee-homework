package br.inatel.dm110.api.dto;

import java.io.Serializable;

public class ProductDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer code;
	private String name;
	private String description;
	private Float price;
	private String category;
	
	
	public ProductDTO() { }
	
	public ProductDTO(Integer code, String name, String description, Float price, String category) {
		super();
		this.code = code;
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
	}

	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "ProductDTO ["
				+ "code=" + code
				+ ", name=" + name
				+ ", description=" + description
				+ ", price=" + price
				+ ", category=" + category + "]";
	}
}
