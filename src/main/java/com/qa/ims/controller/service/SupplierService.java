package com.qa.ims.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.ims.model.SupplierModel;
import com.qa.ims.model.repository.SupplierModelRepository;

/**
 * Created by Nathan on 23/05/2016.
 */
@Service
public class SupplierService {

	@Autowired
	private SupplierModelRepository supplierModelRepository;

	public void persistSupplier(SupplierModel supplierModel) {
		if (supplierModel != null) {
			System.out.println("supplier Model id - " + supplierModel.getId());
			supplierModelRepository.save(supplierModel);
			System.out.println("supplier Saved");
		}

	}

	public List<SupplierModel> findSupplierByName(String name) {
		List<SupplierModel> suppliers = supplierModelRepository.findAll();
		for (SupplierModel s : suppliers) {
			if (!s.getName().toUpperCase().contains(name.toUpperCase())) {
				suppliers.remove(s);
			} else {
				System.out.println("Found Matching Supplier");
			}
		}
		return suppliers;
	}

	public List<SupplierModel> getAllSuppliers() {
		return supplierModelRepository.findAll();
	}

	public void deleteAllSuppliers() {
		supplierModelRepository.deleteAll();

	}

	public void deleteSupplier(SupplierModel supplierModel) {
		supplierModelRepository.delete(supplierModel);

	}

}
