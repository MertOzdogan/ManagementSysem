package com.mert.managementsystem.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String username;
	@Column
	private String name;
	@Column
	private String surname;
	@Column
	private String mail;
	@Column
	private String password;
	@Column
	private String salary;

	@Column
	private String type;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "deptId")
	private Department deptId;

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

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(final String surname) {
		this.surname = surname;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(final String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public String getSalary() {
		return this.salary;
	}

	public void setSalary(final String salary) {
		this.salary = salary;
	}

	public String getType() {
		return this.type;
	}

	public void setType(final String type) {
		this.type = type;
	}

	public Department getDeptId() {
		return this.deptId;
	}

	public void setDeptId(final Department deptId) {
		this.deptId = deptId;
	}

	public Employee(final String username, final String name, final String surname, final String mail,
			final String password, final String salary, final String type) {
		super();
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.mail = mail;
		this.password = password;
		this.salary = salary;
		this.type = type;
	}

	public Employee(final String username, final String name, final String surname, final String mail,
			final String password, final String salary, final String type, final Department deptId) {
		super();
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.mail = mail;
		this.password = password;
		this.salary = salary;
		this.type = type;
		this.deptId = deptId;
	}

	public Employee() {
		super();
	}

	@Override
	public String toString() {
		return "Employee [id=" + this.id + ", username=" + this.username + ", name=" + this.name + ", surname="
				+ this.surname + ", mail=" + this.mail + ", password=" + this.password + ", salary=" + this.salary
				+ ", type=" + this.type + ", deptId=" + this.deptId + "]";
	}

}
