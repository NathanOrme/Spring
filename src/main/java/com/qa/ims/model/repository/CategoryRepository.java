package com.qa.ims.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.ims.model.SupplierModel;

@Repository
public interface CategoryRepository extends JpaRepository<SupplierModel, Long> {
	
}
