package com.mert.managementsystem.services;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mert.managementsystem.dao.impl.EmployeeDaoImpl;
import com.mert.managementsystem.entities.Customer;
import com.mert.managementsystem.entities.Department;
import com.mert.managementsystem.entities.Employee;
import com.mert.managementsystem.entities.Goods;

public interface Service {
	final static SessionFactory FACTORY = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Employee.class).addAnnotatedClass(Department.class)
			.addAnnotatedClass(EmployeeDaoImpl.class).addAnnotatedClass(Goods.class).addAnnotatedClass(Customer.class)
			.buildSessionFactory();

}
