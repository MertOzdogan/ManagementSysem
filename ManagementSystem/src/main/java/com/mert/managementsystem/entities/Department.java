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

import org.hibernate.annotations.Cascade;

@Entity(name = "department")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String name;

	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH }, mappedBy = "deptId")
	private List<Employee> employes;

	public void add(Employee employee) {

		if (employes == null)
			employes = new ArrayList<>();

		employes.add(employee);
		employee.setDeptId(this);
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Department [id=" + this.id + ", name=" + this.name + "]";
	}

	public Department(String name) {
		super();
		this.name = name;
	}

	public Department() {
		super();
	}

	public List<Employee> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employee> employes) {
		this.employes = employes;
	}

}
