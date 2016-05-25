import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.model.LineItem;
import com.qa.ims.model.Order;
import com.qa.ims.model.Product;
import com.qa.ims.model.UserModel;
import com.qa.ims.util.OrderStatus;
import com.qa.ims.util.ProductType;

public class OrderTest {

	private UserModel um1;
	private UserModel um2;
	private Order order1;
	private LineItem lineItem1;
	private LineItem lineItem2;
	private Product product1;
	
	@Before
	public void setUp(){
		product1 = new Product("Cheese", "tttt", "orange", 20.2, false, null, 9, ProductType.FURNITURE, "Thing",7, 0);
		um1 = new UserModel("Chicken", "Pigeon");
		um2 = new UserModel("Will", "PipeDown");
		order1 = new Order(20.2, new Date(), null, OrderStatus.PENDING, um1);
		lineItem1 = new LineItem(product1, 2, product1.getPrice()*2, 0);
		List<LineItem>li = new ArrayList<LineItem>();
		li.add(lineItem1);
		order1.setLineItem(li);
		lineItem2 = new LineItem(product1, 3, product1.getPrice()*3, 0);
	}

	@Test
	public void testGetId() {
		assertNotNull(order1.getId());
	}

	@Test
	public void testGetTotal() {
		assertNotNull(order1.getTotal());
	}

	@Test
	public void testSetTotal() {
		double total = 50.0;
		order1.setTotal(total);
		assertEquals(order1.getTotal(), total, 0.1);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testGetDate() {
		assertSame(order1.getDate().getDate(), new Date().getDate());
	}

	@Test
	public void testSetDate() {
		order1.setDate(new Date());
		assertSame(order1.getDate().getDate(), new Date().getDate());
	}

	@Test
	public void testGetDispatchDate() {
		assertNull(order1.getDispatchDate());
	}

	@Test
	public void testSetDispatchDate() {
		order1.setDispatchDate(new Date());
		assertSame(order1.getDispatchDate().getDate(), new Date().getDate());
	}

	@Test
	public void testGetOrderStatus() {
		assertNotNull(order1.getOrderStatus());
	}

	@Test
	public void testSetOrderStatus() {
		order1.setOrderStatus(OrderStatus.DELIVERED);
		assertSame(order1.getOrderStatus(), OrderStatus.DELIVERED);
	}

	@Test
	public void testGetLineItem() {
		assertNotNull(order1.getLineItem());
	}

	@Test
	public void testSetLineItem() {
		List<LineItem>li1 = new ArrayList<LineItem>();
		li1.add(lineItem2);
		li1.addAll(order1.getLineItem());
		order1.setLineItem(li1);
		assertSame(order1.getLineItem(), li1);
	}

	@Test
	public void testGetUser() {
		assertSame(order1.getUser(), um1);
	}

	@Test
	public void testSetUser() {
		order1.setUser(um2);
		assertSame(order1.getUser(), um2);
	}

}
