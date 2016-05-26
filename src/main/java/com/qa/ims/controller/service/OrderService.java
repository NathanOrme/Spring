package com.qa.ims.controller.service;

import java.util.List;

import com.qa.ims.model.LineItem;
import com.qa.ims.model.Order;
import com.qa.ims.model.UserModel;
import com.qa.ims.model.repository.LineItemRepository;
import com.qa.ims.model.repository.OrderRepository;
import com.qa.ims.util.OrderStatus;


public class OrderService {

	private OrderRepository orderRepository;
	private LineItemRepository lineitemRepository;
	public void addToBasket(LineItem lineItem, UserModel user) {
		//TODO finish code
	}

	public void removeFromBasket(LineItem lineItem, UserModel user) {
		Order order = getUsersPendingOrder(user);
		for(LineItem l : order.getLineItem()){
			if(l == lineItem){
				List<LineItem> lineItems = order.getLineItem();
				lineItems.remove(l);
				order.setLineItem(lineItems);
			}
		}

	}

	public void clearBasket(UserModel user) {
		List<Order> orders = orderRepository.findAll();
		Order order = getPendingOrder(orders);
		if (order != null) {
			if(order.getLineItem()!= null){
				while(!order.getLineItem().isEmpty()){
					LineItem l = order.getLineItem().get(order.getLineItem().size() - 1);
					lineitemRepository.delete(l);
				}
			}
			orderRepository.delete(order);
		}

	}

	public Order getPendingOrder(List<Order> orders){
		for(Order o : orders){
			if(o.getOrderStatus() == OrderStatus.PENDING){
				return o;
			}
		}
		return null;
	}

	public Order getUsersPendingOrder(UserModel user){
		List<Order> orders = orderRepository.findAll();
		for(Order o : orders){
			if(o.getUser() == user){
				if(o.getOrderStatus() == OrderStatus.PENDING){
					return o;
				}
			}
		}
		return null;
	}

}
