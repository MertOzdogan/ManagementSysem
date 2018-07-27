package com.mert.managementsystem.gui.employeetab;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.mert.managementsystem.entities.Department;
import com.mert.managementsystem.entities.Employee;
import com.mert.managementsystem.services.ManagementService;
import com.mert.managementsystem.services.ServiceFactory;

public class AbstractEmployeeTableModel extends AbstractTableModel {

	String[] columnNames = { "ID", "Username", "Name", "Surname", "Mail", "Password", "Salary", "Department", "Type" };
	ManagementService managementService = (ManagementService) ServiceFactory.getService(ManagementService.class);
	List<Employee> employeeList = managementService.getEmployeeList();
	List<Department> departmentList = managementService.getDepartmentList();

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	public AbstractEmployeeTableModel() {

	}

	public int getColumnCount() {
		return 9;
	}

	public int getRowCount() {
		return employeeList.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return employeeList.get(rowIndex).getId();
		case 1:
			return employeeList.get(rowIndex).getUsername();
		case 2:
			return employeeList.get(rowIndex).getName();
		case 3:
			return employeeList.get(rowIndex).getSurname();
		case 4:
			return employeeList.get(rowIndex).getMail();
		case 5:
			return employeeList.get(rowIndex).getPassword();
		case 6:
			return employeeList.get(rowIndex).getSalary();
		case 7:
			return employeeList.get(rowIndex).getDeptId().getName();
		case 8:
			return employeeList.get(rowIndex).getType();

		default:
			break;
		}
		return null;
	}

	private Department findDepartmentById(int id) {
		for (Department department : departmentList) {
			if (department.getId() == id)
				return department;
		}
		return null;
	}
}