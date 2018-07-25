package com.mert.managementsystem.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.mert.managementsystem.dao.DepartmentDao;
import com.mert.managementsystem.entities.Department;

public class DepartmentDaoImpl implements DepartmentDao {

	Session session;

	@Override
	public void addDepartment(Department dept) {
		session.persist(dept);
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Department> listDepartments() {
		return session.createCriteria(Department.class).list();
	}

	@Override
	public Department getDepartmentById(int id) {
		return session.get(Department.class, id);
	}

	@Override
	public void deleteDepartment(int id) {
		session.delete(id);

	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

}