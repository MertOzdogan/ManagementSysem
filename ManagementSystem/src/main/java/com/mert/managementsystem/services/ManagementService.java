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
	private final DepartmentDaoImpl departmentDao = new DepartmentDaoImpl();
	private final EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();

	private ManagementService() {
		System.out.println("here");
		final Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			employeeDao.setSession(session);
			Department dept = new Department("Yeni departmant");
			Employee employee = new Employee("Fried", "Getting", "Dangerous", "Janka", "Gosh", "60", "Hot");

			employeeDao.addEmployee(employee);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	public static ManagementService getINSTANCE() {
		return INSTANCE == null ? new ManagementService() : INSTANCE;
	}

}
