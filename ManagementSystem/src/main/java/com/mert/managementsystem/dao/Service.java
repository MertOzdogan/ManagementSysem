package com.mert.managementsystem.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mert.managementsystem.dao.impl.EmployeeDaoImpl;
import com.mert.managementsystem.entities.Department;
import com.mert.managementsystem.entities.Employee;

public class Service {
	public static void main(String[] args) {
		final SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class).addAnnotatedClass(Department.class)
				.addAnnotatedClass(EmployeeDaoImpl.class).buildSessionFactory();
		final Session session = factory.getCurrentSession();

		try {
			// mert.setDeptId(dept);

			session.beginTransaction();

			Department hard = session.get(Department.class, 10);
			// Employee janka = new Employee("friedcheesehero", "Janca", "Idk", "ja", "123",
			// "123", "123");
			// hard.add(janka);
			session.delete(hard);

			session.getTransaction().commit();

		} finally {
			session.close();
		}
		System.exit(0);

	}
}
