package com.mert.managementsystem.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mert.managementsystem.dao.impl.EmployeeDaoImpl;
import com.mert.managementsystem.entities.Department;
import com.mert.managementsystem.entities.Employee;

public class Service {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Department.class).buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			Department dept = new Department("Line Management");
			Employee mert = new Employee("Natasha", "Another", "Ozd", "mert", "abc123", "131", "Junior");
			mert.setDeptId(dept);
			session.beginTransaction();
			session.save(mert);
			session.getTransaction().commit();

		} finally {
			session.close();
		}

	}
}
