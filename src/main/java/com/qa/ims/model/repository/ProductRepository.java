package com.qa.ims.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.ims.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
