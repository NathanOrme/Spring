import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.model.Address;
import com.qa.ims.model.SupplierModel;

public class SupplierModelTest {
	private SupplierModel supplierModel1;
	private SupplierModel supplierModel2;
	public Address address1;
	public Address address2;

	@Before
	public void setUp() {
		address1 = new Address("1 Rainbow Road", "RR11 RR1");
		address2 = new Address("2 Rainbow Road", "RR22 RR2");
		supplierModel1 = new SupplierModel("Supplier of things", address1);
		supplierModel2 = new SupplierModel("Supplier of stuff", address1);
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
	
	@Test
	public void testGetAddress(){
		assertNotNull(supplierModel1.getAddress());
	}
	
	@Test
	public void testSetAddress(){
		supplierModel2.setAddress(address2);
		assertSame(supplierModel2.getAddress(), address2);
	}

}
