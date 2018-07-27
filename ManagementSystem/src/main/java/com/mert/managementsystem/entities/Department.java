package com.mert.managementsystem.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String name;

	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH }, mappedBy = "deptId")
	private List<Employee> employes;

	public void add(final Employee employee) {

		if (this.employes == null) {
			this.employes = new ArrayList<>();
		}

		this.employes.add(employee);
		employee.setDeptId(this);
	}

	public int getId() {
		return this.id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Department [id=" + this.id + ", name=" + this.name + "]";
	}

	public Department(final String name) {
		super();
		this.name = name;
	}

	public Department() {
		super();
	}

	public List<Employee> getEmployes() {
		return this.employes;
	}

	public void setEmployes(final List<Employee> employes) {
		this.employes = employes;
	}

}
