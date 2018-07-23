package com.mert.managementsystem.dao;

import java.util.List;

import com.mert.managementsystem.entities.Employee;

public interface EmployeeDao
{
   public void addEmployee( Employee employee );


   public List<Employee> listEmployees();


   public Employee getEmployeeById( int id );


   public void removeEmployee( int id );
}
