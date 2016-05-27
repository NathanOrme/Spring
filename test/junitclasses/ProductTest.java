package junitclasses;
import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.model.Product;
import com.qa.ims.util.ProductType;

public class ProductTest {

	private Product product;

	@Before
	public void setUp() {
		product = new Product("Cheesey Chair", "hhhh-tttt-1111", "orange", 20.2, false, null, 5, ProductType.FURNITURE,
				"Cheese Gromit, Cheese", 4, 0, new Date());
	}

	@Test
	public void testGetId() {
		assertNotNull(product.getId());
	}

	@Test
	public void testGetName() {
		assertSame(product.getName(), "Cheesey Chair");
	}

	@Test
	public void testSetName() {
		product.setName("Mister PoPo");
		assertSame(product.getName(), "Mister PoPo");
	}

	@Test
	public void testGetSerial() {
		assertSame(product.getSerial(), "hhhh-tttt-1111");
	}

	@Test
	public void testSetSerial() {
		product.setSerial("ht1x");
		assertSame(product.getSerial(), "ht1x");
	}

	@Test
	public void testGetColour() {
		assertSame(product.getColour(), "orange");
	}

	@Test
	public void testSetColour() {
		product.setColour("gold");
		assertSame(product.getColour(), "gold");
	}

	@Test
	public void testGetPrice() {
		assertEquals(product.getPrice(), 20.2, 0.1);
	}

	@Test
	public void testSetPrice() {
		product.setPrice(20.34);
		assertEquals(product.getPrice(), 20.34, 0.1);
	}

	@Test
	public void testIsDiscountinued() {
		assertSame(product.isDiscountinued(), false);
	}

	@Test
	public void testSetDiscountinued() {
		product.setDiscountinued(true);
		assertSame(product.isDiscountinued(), true);
	}

	@Test
	public void testGetPictureLoc() {
		assertSame(product.getPictureLoc(), null);
	}

	@Test
	public void testSetPictureLoc() {
		product.setPictureLoc("xxxx");
		assertSame(product.getPictureLoc(), "xxxx");
	}

	@Test
	public void testGetQuantityAvailable() {
		assertSame(product.getQuantityAvailable(), 5);
	}

	@Test
	public void testSetQuantityAvailable() {
		product.setQuantityAvailable(10);
		assertSame(product.getQuantityAvailable(), 10);
	}

	@Test
	public void testGetProductType() {
		assertSame(product.getProductType(), ProductType.FURNITURE);
	}

	@Test
	public void testSetProductType() {
		product.setProductType(ProductType.TOOL);
		assertSame(product.getProductType(), ProductType.TOOL);
	}

	@Test
	public void testGetDescription() {
		assertSame(product.getDescription(), "Cheese Gromit, Cheese");
	}

	@Test
	public void testSetDescription() {
		product.setDescription("Cheese");
		assertSame(product.getDescription(), "Cheese");
	}

	@Test
	public void testGetReorderThreshold() {
		assertSame(product.getReorderThreshold(), 4);
	}

	@Test
	public void testSetReorderThreshold() {
		product.setReorderThreshold(8);
		assertSame(product.getReorderThreshold(), 8);
	}

	@Test
	public void testGetReorderedAmount() {
		assertSame(product.getReorderedAmount(), 0);
	}

	@Test
	public void testSetReorderedAmount() {
		product.setReorderedAmount(10);
		assertSame(product.getReorderedAmount(), 10);
	}

}
