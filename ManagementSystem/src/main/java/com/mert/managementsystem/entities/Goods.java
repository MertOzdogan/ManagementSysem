package com.mert.managementsystem.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "goods")
public class Goods {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	@Column
	private String price;
	@Column
	private int stock;

	@ManyToMany
	@JoinTable(name = "orders", joinColumns = @JoinColumn(name = "goodsId"), inverseJoinColumns = @JoinColumn(name = "customerId"))
	private List<Customer> customer;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}

	public Goods(String name, String price, int stock) {
		super();
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

	public Goods() {
	}

}
