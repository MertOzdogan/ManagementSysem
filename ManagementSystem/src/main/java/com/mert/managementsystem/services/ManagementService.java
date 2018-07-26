package com.mert.managementsystem.services;

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
	final SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
			.addAnnotatedClass(Department.class).addAnnotatedClass(EmployeeDaoImpl.class).addAnnotatedClass(Goods.class)
			.addAnnotatedClass(Customer.class).buildSessionFactory();

	// Here is where Spring actually is to be used to inject Daos.
	private final DepartmentDaoImpl departmentDao = new DepartmentDaoImpl();
	private final EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
	Session session = factory.getCurrentSession();

	private ManagementService() {
		try {
			employeeDao.setSession(session);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	public void createSingleEmployee(Employee employee) {
		session.beginTransaction();
		employeeDao.addEmployee(employee);
		session.getTransaction().commit();
		System.out.println(session.isConnected() + " " + session.isOpen());

	}

	public void createSingleEmployee(Employee employee, Department department) {
		session.beginTransaction();
		department.add(employee);
		employeeDao.addEmployee(employee);
		session.getTransaction().commit();

	}

	public static ManagementService getINSTANCE() {
		return INSTANCE == null ? new ManagementService() : INSTANCE;
	}

}
