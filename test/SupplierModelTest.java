import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.model.SupplierModel;

public class SupplierModelTest {
	private SupplierModel supplierModel1;
	private SupplierModel supplierModel2;

	@Before
	public void setUp() {
		supplierModel1 = new SupplierModel("Supplier of things");
		supplierModel2 = new SupplierModel("Supplier of stuff");
	}

	@Test
	public void testGetId() {
		assertNotNull(supplierModel1.getId());
	}

	@Test
	public void testGetName() {
		assertNotNull(supplierModel1.getName());
	}

	@Test
	public void testSetName() {
		supplierModel2.setName("Butt");
		assertSame(supplierModel2.getName(), "Butt");
	}

}
