package com.qa.ims.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;

/**
 * Author - Tom
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.qa.ims.util.ProductType;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@Column(name = "product_id")
	@GeneratedValue
	private long id;

	@NotNull
	private String name;

	@NotNull
	private String serial;

	@NotNull
	private String colour;

	@NotNull
	private Double price;

	@NotNull
	private boolean discountinued;

	@NotNull
	private String pictureLoc;

	@NotNull
	private int quantityAvailable;

	@JoinColumn(name = "TYPE")
	private ProductType productType;

	private String description;

	private int reorderThreshold;

	@NotNull
	private int reorderedAmount;
	
	 @OneToMany(mappedBy="product")
	    private List<LineItem> lineItems;

	@NotNull
	private Date lastUpdated;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public boolean isDiscountinued() {
		return discountinued;
	}

	public void setDiscountinued(boolean discountinued) {
		this.discountinued = discountinued;
	}

	public String getPictureLoc() {
		return pictureLoc;
	}

	public void setPictureLoc(String pictureLoc) {
		this.pictureLoc = pictureLoc;
	}

	public int getQuantityAvailable() {
		return quantityAvailable;
	}

	public void setQuantityAvailable(int quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getReorderThreshold() {
		return reorderThreshold;
	}

	public void setReorderThreshold(int reorderThreshold) {
		this.reorderThreshold = reorderThreshold;
	}

	public int getReorderedAmount() {
		return reorderedAmount;
	}

	public void setReorderedAmount(int reorderedAmount) {
		this.reorderedAmount = reorderedAmount;
	}

	public Product(String name, String serial, String colour, Double price, boolean discountinued, String pictureLoc,
			int quantityAvailable, ProductType productType, String description, int reorderThreshold,
			int reorderedAmount, Date lastUpdated) {
		super();
		this.name = name;
		this.serial = serial;
		this.colour = colour;
		this.price = price;
		this.discountinued = discountinued;
		this.pictureLoc = pictureLoc;
		this.quantityAvailable = quantityAvailable;
		this.productType = productType;
		this.description = description;
		this.reorderThreshold = reorderThreshold;
		this.reorderedAmount = reorderedAmount;
		this.lastUpdated = lastUpdated;
	}
}