package junitclasses;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qa.ims.App;
import com.qa.ims.controller.PurchaseController;
import com.qa.ims.controller.service.OrderService;
import com.qa.ims.model.LineItem;
import com.qa.ims.model.Order;
import com.qa.ims.model.Product;
import com.qa.ims.model.UserModel;
import com.qa.ims.model.repository.LineItemRepository;
import com.qa.ims.model.repository.OrderRepository;
import com.qa.ims.model.repository.ProductRepository;
import com.qa.ims.model.repository.UserModelRepository;
import com.qa.ims.util.LineItemStatus;
import com.qa.ims.util.OrderStatus;
import com.qa.ims.util.ProductType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = App.class)
public class PurchaseControllerTest {
	
	@Autowired
	private PurchaseController purchaseController;
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private LineItemRepository lineitemRepository;
	@Autowired
	private UserModelRepository usermodelRepository;
	@Autowired
	private ProductRepository productRepository;
	
	private UserModel user;
	private Order order;
	private LineItem lineItem;
	private Product product;
	
	@Before
	public void setUp(){
		product = new Product("Cheese", "tttt", "orange", 20.2, false, "ttt", 9, ProductType.FURNITURE, "Thing",7, 0);
		System.out.println("id - " + product.getId());
		System.out.println("name - " + product.getName());
		System.out.println("serial - " + product.getSerial());
		System.out.println("colour - " + product.getColour());
		System.out.println("price - " + product.getPrice());
		System.out.println("discontinued - " + product.isDiscountinued());
		System.out.println("pictureLoc - " + product.getPictureLoc());
		System.out.println("QuanitityAvailable - " + product.getQuantityAvailable());
		System.out.println("ProductType - " + product.getProductType());
		System.out.println("Desc - " + product.getDescription());
		System.out.println("Reorder thresh - " + product.getReorderThreshold());
		System.out.println("reorder amount - " + product.getReorderedAmount());
		productRepository.save(product);
		user = new UserModel("Chicken", "Pigeon");
		usermodelRepository.save(user);
		order = new Order(20.2, new Date(), null, OrderStatus.PENDING, user);
		orderRepository.save(order);
		lineItem = new LineItem(product, 2, product.getPrice()*2, 0, LineItemStatus.NORMAL);
		List<LineItem>li = new ArrayList<LineItem>();
		li.add(lineItem);
		order.setLineItem(li);
		lineitemRepository.save(lineItem);
		orderRepository.save(order);
	}
	
	@After
	public void cleanUp(){
		usermodelRepository.deleteAll();
		lineitemRepository.deleteAll();
		orderRepository.deleteAll();
	}

	@Test
	public void testAddToBasket() {
		purchaseController.addToBasket(lineItem);
		assertSame(order.getLineItem().size(), orderService.getUsersPendingOrder(user).getLineItem().size());
	}

	@Test
	public void testRemoveFromBasket() {
		fail("Not yet implemented");
	}

	@Test
	public void testClearBasket() {
		fail("Not yet implemented");
	}

}
