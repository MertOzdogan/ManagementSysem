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
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String username;
	@Column
	private String name;
	@Column
	private String age;
	@Column
	private String cardnumber;
	@Column
	private String credits;

	@ManyToMany
	@JoinTable(name = "orders", joinColumns = @JoinColumn(name = "customerId"), inverseJoinColumns = @JoinColumn(name = "goodsId"))
	private List<Goods> goods;

	public int getId() {
		return this.id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getAge() {
		return this.age;
	}

	public void setAge(final String age) {
		this.age = age;
	}

	public String getCardnumber() {
		return this.cardnumber;
	}

	public void setCardnumber(final String cardnumber) {
		this.cardnumber = cardnumber;
	}

	public String getCredits() {
		return this.credits;
	}

	public void setCredits(final String credits) {
		this.credits = credits;
	}

	public List<Goods> getGoods() {
		return this.goods;
	}

	public void setGoods(final List<Goods> goods) {
		this.goods = goods;
	}

	public Customer(final String username, final String name, final String age, final String cardnumber,
			final String credits) {
		super();
		this.username = username;
		this.name = name;
		this.age = age;
		this.cardnumber = cardnumber;
		this.credits = credits;
	}

	public Customer() {
		super();
	}

}
