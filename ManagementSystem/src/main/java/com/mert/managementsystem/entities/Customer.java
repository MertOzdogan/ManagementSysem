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
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}

	public String getCredits() {
		return credits;
	}

	public void setCredits(String credits) {
		this.credits = credits;
	}


	
	public List<Goods> getGoods() {
		return goods;
	}

	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}

	public Customer(String username, String name, String age, String cardnumber, String credits) {
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
