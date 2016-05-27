package junitclasses;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qa.ims.App;
import com.qa.ims.controller.UserController;
import com.qa.ims.model.UserModel;
import com.qa.ims.model.repository.UserModelRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = App.class)
public class UserControllerTest {

	@Autowired
	private UserController userController;
	@Autowired
	private UserModelRepository usermodelRepository;

	private UserModel user;

	@Before
	public void setUp(){
		user = new UserModel("Sam", "Chicken");
		usermodelRepository.save(user);

	}

	@After
	public void cleanUp(){
		if(!usermodelRepository.findAll().isEmpty()){
			usermodelRepository.deleteAll();
		}
	}

	@Test
	public void testAuthenticate() {
		assertSame(userController.authenticate(user.getUsername(), user.getPassword()), true);
	}

}
