package com.qa.ims.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.ims.model.SupplierModel;

@Repository
public interface SupplierModelRepository extends JpaRepository<SupplierModel, Long> {
	
}
