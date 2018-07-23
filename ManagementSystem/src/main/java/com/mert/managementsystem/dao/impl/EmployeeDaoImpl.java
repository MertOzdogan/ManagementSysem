package com.mert.managementsystem.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mert.managementsystem.dao.EmployeeDao;
import com.mert.managementsystem.entities.Employee;

@Component
public class EmployeeDaoImpl implements EmployeeDao
{
   @Autowired
   private SessionFactory sessionFactory;


   public void addEmployee( Employee employee )
   {
      // TODO Auto-generated method stub
   }


   @Transactional
   @SuppressWarnings("unchecked")
   public List<Employee> listEmployees()
   {
      this.sessionFactory.getCurrentSession().beginTransaction();
      return this.sessionFactory.getCurrentSession().createCriteria( Employee.class ).list();
   }


   public Employee getEmployeeById( int id )
   {
      // TODO Auto-generated method stub
      return null;
   }


   public void removeEmployee( int id )
   {
      // TODO Auto-generated method stub

   }


   public SessionFactory getSessionFactory()
   {
      return this.sessionFactory;
   }


   public void setSessionFactory( SessionFactory sessionFactory )
   {
      this.sessionFactory = sessionFactory;
   }

}
