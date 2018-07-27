package com.mert.managementsystem.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;

import com.mert.managementsystem.dao.EmployeeDao;
import com.mert.managementsystem.entities.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	Session session;

	@Override
	public void addEmployee(final Employee employee) {
		this.session.save(employee);
	}

	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Employee> listEmployees() {

		return this.session.createCriteria(Employee.class).list();
	}

	@Override
	public Employee getEmployeeById(final int id) {
		return this.session.get(Employee.class, id);
	}

	@Override
	public void removeEmployee(final int id) {
		this.session.delete(this.session.get(Employee.class, id));
	}

	public void updateEmployee(final Employee employee) {
		this.session.update(employee);
	}

	public Session getSession() {
		return this.session;
	}

	public void setSession(final Session session) {
		this.session = session;
	}

}
