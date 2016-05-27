package com.qa.ims.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "supplier")
public class SupplierModel {

	@Id
	@Column(name = "supplier_id")
	@GeneratedValue
	private long id;

	@NotNull
	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SupplierModel(String name) {
		this.name = name;
	}

	public SupplierModel() {

	}

}
