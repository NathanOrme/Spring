package com.qa.ims;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.qa.ims.model.Address;
import com.qa.ims.model.SupplierModel;
import com.qa.ims.model.repository.AddressRepository;
import com.qa.ims.model.repository.SupplierModelRepository;

@Component
public class InitialData implements CommandLineRunner {

	@Autowired
	private SupplierModelRepository smr;
	@Autowired
	private AddressRepository ar;

	@Override
	public void run(String... arg0) throws Exception {
		List<SupplierModel> suppliers = new ArrayList<SupplierModel>();
		Address address1 = new Address("Test Lane", "TT1 TT1");
		ar.save(address1);
		Address address2 = new Address("Test Road", "TR1 TR1");
		ar.save(address2);
		SupplierModel supplier1 = new SupplierModel("Nathan Orme", address1);
		suppliers.add(supplier1);
		SupplierModel supplier2 = new SupplierModel("Doug", address1);
		suppliers.add(supplier2);
		SupplierModel supplier3 = new SupplierModel("Tom", address2);
		suppliers.add(supplier3);
		SupplierModel supplier4 = new SupplierModel("Will (Pipe Down!)", address2);
		suppliers.add(supplier4);
		smr.save(suppliers);

	}

}
