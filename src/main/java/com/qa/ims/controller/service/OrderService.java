package com.qa.ims.controller.service;

import java.util.List;

import com.qa.ims.model.LineItem;
import com.qa.ims.model.Order;
import com.qa.ims.model.UserModel;
import com.qa.ims.model.repository.OrderRepository;
import com.qa.ims.util.OrderStatus;

public class OrderService {

	private OrderRepository orderRepository;

	public void addToBasket(LineItem lineItem, UserModel user) {
		// TODO Auto-generated method stub

	}

	public void removeFromBasket(LineItem lineItem, UserModel user) {
		// TODO Auto-generated method stub

	}

	public void clearBasket(UserModel user) {
		List<Order> orders = orderRepository.findAll();
		Order order = null;
		for (Order o : orders) {
			if (o.getUser() == user && o.getOrderStatus() == OrderStatus.PENDING) {
				order = o;
				break;
			}
		}
		if (order != null) {
			orderRepository.delete(order);
		}

	}

}
