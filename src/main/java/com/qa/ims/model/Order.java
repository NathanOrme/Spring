package com.qa.ims.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import com.qa.ims.util.OrderStatus;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@Column(name = "ORDER_ID", nullable = false)
	@GeneratedValue
	private long id;
	private double total;
	private Date date;
	private Date dispatchDate;
	private OrderStatus orderStatus;
	@ElementCollection
	@OrderColumn
	private List<LineItem> lineItem;
	@OneToOne
	@JoinColumn(name = "USER_ID")
	private UserModel user;

	public Order() {

	}

	public Order(double total, Date date, Date dispatchDate, OrderStatus orderStatus, UserModel user) {
		//this.id = id;
		this.total = total;
		this.date = date;
		this.dispatchDate = dispatchDate;
		this.setOrderStatus(orderStatus);
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDispatchDate() {
		return dispatchDate;
	}

	public void setDispatchDate(Date dispatchDate) {
		this.dispatchDate = dispatchDate;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	/**
	 * Gets the array of lineItems for the order
	 * 
	 */
	public List<LineItem> getLineItem() {
		return lineItem;
	}

	/**
	 * Sets the lineItems for the order
	 * 
	 * @param lineItem
	 *            the array of line items.
	 */
	public void setLineItem(List<LineItem> lineItem) {
		this.lineItem = lineItem;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

}
