package com.mert.managementsystem.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mert.managementsystem.dao.impl.DepartmentDaoImpl;
import com.mert.managementsystem.dao.impl.EmployeeDaoImpl;
import com.mert.managementsystem.entities.Customer;
import com.mert.managementsystem.entities.Department;
import com.mert.managementsystem.entities.Employee;
import com.mert.managementsystem.entities.Goods;

public class ManagementService implements Service {
	private static ManagementService INSTANCE;

	// Here is where Spring actually is to be used to inject Daos.
	private final DepartmentDaoImpl departmentDao = new DepartmentDaoImpl();
	private final EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
	Session session;

	private ManagementService() {

	}

	public void createSingleEmployee(Employee employee) {
		try {
			session = FACTORY.openSession();
			employeeDao.setSession(session);
			session.beginTransaction();
			employeeDao.addEmployee(employee);
			session.getTransaction().commit();
		} finally {
			session.close();
		}
	}

	public void createSingleEmployee(Employee employee, Department department) {
		try {
			session = FACTORY.openSession();
			employeeDao.setSession(session);
			session.beginTransaction();
			department.add(employee);

			employeeDao.addEmployee(employee);
			session.getTransaction().commit();
		} finally {
			session.close();
		}

	}

	public void createDepartment() {
	}

	public List<Department> getDepartmentList() {
		List<Department> departmentList;
		try {
			session = FACTORY.openSession();
			departmentDao.setSession(session);
			session.beginTransaction();
			departmentList = departmentDao.listDepartments();
			session.getTransaction().commit();
		} finally {
			session.close();

		}
		return departmentList;
	}

	public static ManagementService getINSTANCE() {
		return INSTANCE == null ? new ManagementService() : INSTANCE;
	}

	public List<Employee> getEmployeeList() {
		List<Employee> employeeList;
		try {
			session = FACTORY.openSession();
			employeeDao.setSession(session);
			session.beginTransaction();
			employeeList = employeeDao.listEmployees();
			session.getTransaction().commit();
		} finally {
			session.close();
		}
		return employeeList;
	}

}
