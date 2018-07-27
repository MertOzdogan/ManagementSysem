package com.mert.managementsystem.services;

import java.util.List;

import org.hibernate.Session;

import com.mert.managementsystem.dao.impl.DepartmentDaoImpl;
import com.mert.managementsystem.dao.impl.EmployeeDaoImpl;
import com.mert.managementsystem.entities.Department;
import com.mert.managementsystem.entities.Employee;

public class ManagementService implements Service {
	private static ManagementService INSTANCE;

	// Here is where Spring actually is to be used to inject Daos.
	private final DepartmentDaoImpl departmentDao = new DepartmentDaoImpl();
	private final EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
	Session session;

	private ManagementService() {

	}

	public void createSingleEmployee(final Employee employee) {
		try {
			this.session = Service.FACTORY.openSession();
			this.employeeDao.setSession(this.session);
			this.session.beginTransaction();
			this.employeeDao.addEmployee(employee);
			this.session.getTransaction().commit();
		} finally {
			this.session.close();
		}
	}

	public void createSingleEmployee(final Employee employee, final Department department) {
		try {
			this.session = Service.FACTORY.openSession();
			this.employeeDao.setSession(this.session);
			this.session.beginTransaction();
			department.add(employee);

			this.employeeDao.addEmployee(employee);
			this.session.getTransaction().commit();
		} finally {
			this.session.close();
		}

	}

	public void createDepartment() {
	}

	public List<Department> getDepartmentList() {
		List<Department> departmentList;
		try {
			this.session = Service.FACTORY.openSession();
			this.departmentDao.setSession(this.session);
			this.session.beginTransaction();
			departmentList = this.departmentDao.listDepartments();
			this.session.getTransaction().commit();
		} finally {
			this.session.close();

		}
		return departmentList;
	}

	public static ManagementService getINSTANCE() {
		return ManagementService.INSTANCE == null ? new ManagementService() : ManagementService.INSTANCE;
	}

	public List<Employee> getEmployeeList() {
		List<Employee> employeeList;
		try {
			this.session = Service.FACTORY.openSession();
			this.employeeDao.setSession(this.session);
			this.session.beginTransaction();
			employeeList = this.employeeDao.listEmployees();
			this.session.getTransaction().commit();
		} finally {
			this.session.close();
		}
		return employeeList;
	}

	public void updateSingleEmployee(final Employee employee, final Department department) {
		try {
			this.session = Service.FACTORY.openSession();
			this.employeeDao.setSession(this.session);
			this.session.beginTransaction();
			department.add(employee);
			this.employeeDao.updateEmployee(employee);
			this.session.getTransaction().commit();
		} finally {
			this.session.close();
		}
	}

}
