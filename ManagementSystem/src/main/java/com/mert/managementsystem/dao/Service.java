package com.mert.managementsystem.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mert.managementsystem.dao.impl.EmployeeDaoImpl;
import com.mert.managementsystem.entities.Department;
import com.mert.managementsystem.entities.Employee;

public class Service
{
   public static void main( String[] args )
   {
      final SessionFactory factory =
            new Configuration().configure( "hibernate.cfg.xml" )
            .addAnnotatedClass( Employee.class ).addAnnotatedClass( Department.class )
            .addAnnotatedClass( EmployeeDaoImpl.class ).buildSessionFactory();
      final Session session = factory.getCurrentSession();

      try
      {
         final Department dept = new Department( "Line Management" );
         final Employee mert =
               new Employee( "Natasha", "Another", "Ozd", "mert", "abc123", "131", "Junior" );

         final EmployeeDaoImpl impl = new EmployeeDaoImpl();
         impl.setSessionFactory( factory );
         impl.listEmployees();

      }
      finally
      {
         session.close();
      }

   }
}
