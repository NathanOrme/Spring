package com.qa.ims.model;

/**
 * Author - Tom
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "prodcat")
public class ProdCat {
	
	@Id
	@GeneratedValue
	private long id;

	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID")
	private Product product;

	@ManyToOne
	@JoinColumn(name = "CATEGORY_ID")
	private Category category;

	public ProdCat(Product product, Category category) {
		this.product = product;
		this.category = category;
	}

	public Product getProduct() {
		return product;
	}

	public Category getCategory() {
		return category;
	}

}
