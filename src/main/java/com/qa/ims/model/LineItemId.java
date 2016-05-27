package com.qa.ims.model;

import java.io.Serializable;

public class LineItemId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6306655185965811041L;
	private Order order;
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	private Product product;
	
	public LineItemId(){
		
	}
	
	public LineItemId(Order order, Product product){
		this.order = order;
		this.product = product;
	}

}
