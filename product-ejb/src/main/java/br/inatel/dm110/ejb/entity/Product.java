package br.inatel.dm110.ejb.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer code;
	private String name;
	private String description;
	private Float price;
	private String category;

	
	public Product() { }
	
	public Product(Integer code, String name, String description, Float price, String category) {
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
}
