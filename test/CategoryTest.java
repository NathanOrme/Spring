import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.model.Category;

public class CategoryTest {
	
	private Category category;
	
	@Before
	public void setUp(){
		category = new Category("Test Category");
	}

	@Test
	public void testGetID() {
		assertNotNull(category.getID());
	}

	@Test
	public void testGetName() {
		assertSame(category.getName(), "Test Category");
	}

	@Test
	public void testSetName() {
		category.setName("Test");
		assertSame(category.getName(), "Test");
	}

}
