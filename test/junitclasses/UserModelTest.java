package junitclasses;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.model.UserModel;

public class UserModelTest {
	
	private UserModel user;
	
	@Before
	public void setUp(){
		user = new UserModel("Sam", "Peas");
	}

	@Test
	public void testGetId() {
		assertNotNull(user.getId());
	}

	@Test
	public void testGetUsername() {
		assertSame(user.getUsername(), "Sam");
	}

	@Test
	public void testSetUsername() {
		user.setUsername("Cheese");
		assertSame(user.getUsername(), "Cheese");
	}

	@Test
	public void testGetPassword() {
		assertSame(user.getPassword(), "Peas");
	}

	@Test
	public void testSetPassword() {
		user.setPassword("Chicken");
		assertSame(user.getPassword(), "Chicken");
	}

}
