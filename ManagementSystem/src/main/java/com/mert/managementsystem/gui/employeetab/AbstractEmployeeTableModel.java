package com.mert.managementsystem.gui.employeetab;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.mert.managementsystem.entities.Department;
import com.mert.managementsystem.entities.Employee;
import com.mert.managementsystem.services.ManagementService;
import com.mert.managementsystem.services.ServiceFactory;

public class AbstractEmployeeTableModel extends AbstractTableModel {

	private final String[] columnNames = { "ID", "Username", "Name", "Surname", "Mail", "Password", "Salary",
			"Department", "Type" };

	private final Class columnTypes[] = { Integer.class, String.class, String.class, String.class, String.class,
			String.class, String.class, Department.class, String.class };
	private final ManagementService managementService = (ManagementService) ServiceFactory
			.getService(ManagementService.class);
	private final List<Employee> employeeList = this.managementService.getEmployeeList();

	private final List<Department> departmentList = this.managementService.getDepartmentList();

	@Override
	public String getColumnName(final int column) {
		return this.columnNames[column];
	}

	@Override
	public Class<?> getColumnClass(final int columnIndex) {
		return this.columnTypes[columnIndex];
	}

	public AbstractEmployeeTableModel() {

	}

	@Override
	public int getColumnCount() {
		return 9;
	}

	@Override
	public int getRowCount() {
		return this.employeeList.size();
	}

	@Override
	public Object getValueAt(final int rowIndex, final int columnIndex) {
		switch (columnIndex) {
		case 0:
			return this.employeeList.get(rowIndex).getId();
		case 1:
			return this.employeeList.get(rowIndex).getUsername();
		case 2:
			return this.employeeList.get(rowIndex).getName();
		case 3:
			return this.employeeList.get(rowIndex).getSurname();
		case 4:
			return this.employeeList.get(rowIndex).getMail();
		case 5:
			return this.employeeList.get(rowIndex).getPassword();
		case 6:
			return this.employeeList.get(rowIndex).getSalary();
		case 7:
			return this.employeeList.get(rowIndex).getDeptId().getName();
		case 8:
			return this.employeeList.get(rowIndex).getType();

		default:
			break;
		}
		return null;
	}

	public Department findDepartmentById(final int id) {
		for (final Department department : this.departmentList) {
			if (department.getId() == id) {
				return department;
			}
		}
		return null;
	}

	public Employee findEmployeeById(final int id) {
		for (final Employee employee : this.employeeList) {
			if (employee.getId() == id) {
				return employee;
			}
		}
		return null;
	}
}