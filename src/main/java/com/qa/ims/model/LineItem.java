package com.qa.ims.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Embeddable
@Table(name = "lineitems")
public class LineItem {

	@Id
	@GeneratedValue
	private long id;
	// @ManyToOne
	// @JoinTable(name = "orders")
	// private Order order;

	@ManyToOne
	@JoinTable(name = "product")
	private Product product;

	@Column(name = "QUANTITY", length = 10, nullable = false)
	@NotNull
	private int quantity;

	@Column(name = "SUBTOTAL", length = 12, nullable = false)
	@NotNull
	private double subtotal;

	@Column(name = "RETURNEDQTY", length = 10)
	private int returnedQty;

	public LineItem(Product product, int quantity, double subtotal, int returnedQty) {
		this.product = product;
		this.quantity = quantity;
		this.subtotal = subtotal;
		this.returnedQty = returnedQty;
	}

	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public int getReturnedQty() {
		return returnedQty;
	}

	public void setProduct(Product p) {
		this.product = p;
	}

	public void setQuantity(int q) {
		this.quantity = q;
	}

	public void setSubtotal(double s) {
		this.subtotal = s;
	}

	public void setReturnedQty(int rQty) {
		this.returnedQty = rQty;
	}
}
