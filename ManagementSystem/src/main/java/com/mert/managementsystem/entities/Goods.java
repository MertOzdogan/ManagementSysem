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
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(final String price) {
		this.price = price;
	}

	public int getStock() {
		return this.stock;
	}

	public void setStock(final int stock) {
		this.stock = stock;
	}

	public List<Customer> getCustomer() {
		return this.customer;
	}

	public void setCustomer(final List<Customer> customer) {
		this.customer = customer;
	}

	public Goods(final String name, final String price, final int stock) {
		super();
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

	public Goods() {
	}

}
