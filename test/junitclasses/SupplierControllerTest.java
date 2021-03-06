package junitclasses;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qa.ims.App;
import com.qa.ims.controller.SupplierController;
import com.qa.ims.model.SupplierModel;
import com.qa.ims.model.repository.SupplierModelRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = App.class)
public class SupplierControllerTest {

	@Autowired
	private SupplierController supplierController;
	@Autowired
	private SupplierModelRepository supplierRepository;
	private SupplierModel supplierModel;

	@Before
	public void setUp() {
		supplierModel = new SupplierModel("Test");
		if(supplierController.getAllSuppliers() != null){
			supplierController.deleteAllSuppliers();
		}
	}

	@Test
	public void testPersistSupplier() {
		supplierController.persistSupplier(supplierModel);
		List<SupplierModel> sm = supplierRepository.findAll();
		assertNotEquals(sm.size(), 0);
	}

	@Test
	public void testFindSupplierByName() {
		supplierController.persistSupplier(supplierModel);
		assertEquals(supplierController.findSupplierByName("Test").size(), 1);
	}

	@Test
	public void testGetAllSuppliers() {
		supplierController.persistSupplier(supplierModel);
		assertNotEquals(supplierController.getAllSuppliers().isEmpty(), true);
	}

	@Test
	public void testDeleteSupplier(){
		supplierController.persistSupplier(supplierModel);
		assertNotEquals(supplierController.getAllSuppliers().isEmpty(), true);
		supplierController.deleteSupplier(supplierModel);
		assertSame(supplierController.findSupplierByName("Test").isEmpty(), true);
	}
	@Test
	public void testDeleteAllSuppliers(){
		supplierController.persistSupplier(supplierModel);
		assertNotEquals(supplierController.getAllSuppliers().isEmpty(), true);
		supplierController.deleteAllSuppliers();
		assertSame(supplierController.getAllSuppliers().isEmpty(), true);
	}

}
