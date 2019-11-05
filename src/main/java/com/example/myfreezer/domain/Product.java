package com.example.myfreezer.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name, date, lastdate;
	private int quantity;
	
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="categoryid")
	private Category category;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(long id, String name, String date, String lastdate, int quantity, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.lastdate = lastdate;
		this.quantity = quantity;
		this.category = category;
	}

	public Product(long id, String name, String date, String lastdate, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.lastdate = lastdate;
		this.quantity = quantity;
	}

	public Product(String name, String date, String lastdate, int quantity, Category category) {
		super();
		this.name = name;
		this.date = date;
		this.lastdate = lastdate;
		this.quantity = quantity;
		this.category = category;
	}
	
	public Product(String name, String date, String lastdate, int quantity) {
		super();
		this.name = name;
		this.date = date;
		this.lastdate = lastdate;
		this.quantity = quantity;
	}

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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}
	
	public String getLastdate() {
		return lastdate;
	}

	public void setLastdate(String lastdate) {
		this.lastdate = lastdate;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", date=" + date + ", lastdate=" + lastdate + ", quantity="
				+ quantity + ", category=" + category + "]";
	}







	
	
}
