package com.mert.managementsystem.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee.deptId")
	private Department deptId;

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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Department getDeptId() {
		return deptId;
	}

	public void setDeptId(Department deptId) {
		this.deptId = deptId;
	}

	public Employee(String username, String name, String surname, String mail, String password, String salary,
			String type) {
		super();
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.mail = mail;
		this.password = password;
		this.salary = salary;
		this.type = type;
	}

	public Employee() {
		super();
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", username=" + username + ", name=" + name + ", surname=" + surname + ", mail="
				+ mail + ", password=" + password + ", salary=" + salary + ", type=" + type + ", deptId=" + deptId
				+ "]";
	}

}
