/* Made By Dean + Nabs */
package com.qa.ims.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "category")
public class Category {

	@Id
	@Column(name = "CATEGORY_ID")
	@GeneratedValue
	private long id;

	@Column(name = "NAME", length = 255, nullable = false)
	@NotNull
	private String name;

	public long getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setID(long newID) {
		this.id = newID;
	}

	public void setName(String n) {
		this.name = n;
	}

	public Category(String name) {
		super();
		this.name = name;
	}

}
