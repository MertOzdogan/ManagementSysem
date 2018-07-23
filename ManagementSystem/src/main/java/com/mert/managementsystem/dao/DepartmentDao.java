package com.mert.managementsystem.dao;

import java.util.List;

import com.mert.managementsystem.entities.Department;

public interface DepartmentDao {

   public void addDepartment(Department dept);
   public List<Department> listDepartments();
   public Department getDepartmentById(int id);
   public void deleteDepartment(int id);
}
