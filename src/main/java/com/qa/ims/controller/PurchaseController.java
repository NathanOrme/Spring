package com.qa.ims.controller;

import org.springframework.stereotype.Controller;

import com.qa.ims.controller.service.OrderService;
import com.qa.ims.model.LineItem;
import com.qa.ims.model.UserModel;

@Controller
public class PurchaseController {
	
	private OrderService orderService;
	private UserModel user;
	
	public void addToBasket(LineItem lineItem){
		orderService.addToBasket(lineItem, user);
		
	}
	
	public void removeFromBasket(LineItem lineItem){
		orderService.removeFromBasket(lineItem, user);
	}
	
	public void clearBasket(UserModel user){
		orderService.clearBasket(user);
	}

}
