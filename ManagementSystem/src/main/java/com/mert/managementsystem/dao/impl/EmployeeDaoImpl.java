package com.mert.managementsystem.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mert.managementsystem.dao.EmployeeDao;
import com.mert.managementsystem.entities.Employee;

@Component
public class EmployeeDaoImpl implements EmployeeDao {

	Session session;

	public void addEmployee(Employee employee) {
		this.session.persist(employee);
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<Employee> listEmployees() {
		return this.session.createCriteria(Employee.class).list();
	}

	public Employee getEmployeeById(int id) {
		return session.get(Employee.class, id);
	}

	public void removeEmployee(int id) {
		session.delete(session.get(Employee.class, id));

	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

}
