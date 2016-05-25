package com.qa.ims.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "suppliers")
public class SupplierModel {

	@Id
	@GeneratedValue
	private long id;

	@NotNull
	private String name;

	@JoinColumns({ @JoinColumn(name = "LINE1"), @JoinColumn(name = "POSTCODE") })
	private Address address;

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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public SupplierModel(String name, Address address) {
		this.name = name;
		this.address = address;
	}

	public SupplierModel() {

	}

}
