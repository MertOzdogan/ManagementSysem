package com.mert.managementsystem.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.mert.managementsystem.dao.DepartmentDao;
import com.mert.managementsystem.entities.Department;

public class DepartmentDaoImpl implements DepartmentDao {

	Session session;

	@Override
	public void addDepartment(final Department dept) {
		this.session.persist(dept);
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Department> listDepartments() {
		return this.session.createCriteria(Department.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	}

	@Override
	public Department getDepartmentById(final int id) {
		return this.session.get(Department.class, id);
	}

	@Override
	public void deleteDepartment(final int id) {
		this.session.delete(id);

	}

	public Session getSession() {
		return this.session;
	}

	public void setSession(final Session session) {
		this.session = session;
	}

}