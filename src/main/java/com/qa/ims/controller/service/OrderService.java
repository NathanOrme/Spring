package com.qa.ims.controller.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qa.ims.model.LineItem;
import com.qa.ims.model.Order;
import com.qa.ims.model.UserModel;
import com.qa.ims.model.repository.LineItemRepository;
import com.qa.ims.model.repository.OrderRepository;
import com.qa.ims.util.OrderStatus;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private LineItemRepository lineitemRepository;

	@Transactional
	public void addToBasket(LineItem lineItem, UserModel user) {
		Order order = getUsersPendingOrder(user);
		if (order != null) {
			if (!order.getLineItem().isEmpty()) {
				int index = 0;
				for (LineItem l : order.getLineItem()) {
					if (l.getProduct().equals(lineItem.getProduct())) {
						updateQuanity(order, lineItem, index);
					}
				}
			} else {
				newLineItem(order, lineItem);
			}

		} else {
			order = new Order(0.0, new Date(), null, OrderStatus.PENDING, user);
			newLineItem(order, lineItem);
		}
	}

	@Transactional
	private void updateQuanity(Order order, LineItem lineItem, int index) {
		lineItem.setQuantity(lineItem.getQuantity() + 1);
		lineitemRepository.save(lineItem);
		List<LineItem> lineItems = new ArrayList<LineItem>();
		lineItems.set(index, lineItem);
		order.setLineItem(lineItems);
		orderRepository.save(order);
	}

	@Transactional
	public void newLineItem(Order order, LineItem lineItem) {
		List<LineItem> lineItems = new ArrayList<LineItem>();
		if (!order.getLineItem().isEmpty()) {
			lineItems = order.getLineItem();
		}
		lineItems.add(lineItem);
		order.setLineItem(lineItems);
		orderRepository.save(order);
	}

	public void removeFromBasket(LineItem lineItem, UserModel user) {
		Order order = getUsersPendingOrder(user);
		for (LineItem l : order.getLineItem()) {
			if (l == lineItem) {
				List<LineItem> lineItems = order.getLineItem();
				lineItems.remove(l);
				order.setLineItem(lineItems);
			}
		}

	}

	@Transactional
	public void clearBasket(UserModel user) {
		List<Order> orders = orderRepository.findAll();
		Order order = getPendingOrder(orders);
		if (order != null) {
			if (order.getLineItem() != null) {
				while (!order.getLineItem().isEmpty()) {
					LineItem l = order.getLineItem().get(order.getLineItem().size() - 1);
					lineitemRepository.delete(l);
				}
			}
			orderRepository.delete(order);
		}

	}

	public Order getPendingOrder(List<Order> orders) {
		for (Order o : orders) {
			if (o.getOrderStatus() == OrderStatus.PENDING) {
				return o;
			}
		}
		return null;
	}

	@Transactional
	public Order getUsersPendingOrder(UserModel user) {
		List<Order> orders = orderRepository.findAll();
		for (Order o : orders) {
			if (o.getUser() == user) {
				if (o.getOrderStatus() == OrderStatus.PENDING) {
					return o;
				}
			}
		}
		return null;
	}

}
