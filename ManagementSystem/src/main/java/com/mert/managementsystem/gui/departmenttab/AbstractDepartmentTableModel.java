package com.mert.managementsystem.gui.departmenttab;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.mert.managementsystem.entities.Department;
import com.mert.managementsystem.services.ManagementService;
import com.mert.managementsystem.services.ServiceFactory;

public class AbstractDepartmentTableModel extends AbstractTableModel {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private final String[] columnNames = { "Id", "Name" };
	private final Class[] columnTypes = { Integer.class, String.class };

	private final ManagementService managementService = (ManagementService) ServiceFactory
			.getService(ManagementService.class);
	private final List<Department> departmentList = this.managementService.getDepartmentList();

	@Override
	public Class<?> getColumnClass(final int columnIndex) {
		return this.columnTypes[columnIndex];
	}

	@Override
	public String getColumnName(final int column) {
		return this.columnNames[column];
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public int getRowCount() {
		return this.departmentList.size();
	}

	@Override
	public Object getValueAt(final int rowIndex, final int columnIndex) {
		switch (columnIndex) {
		case 0:
			return this.departmentList.get(rowIndex).getId();
		case 1:
			return this.departmentList.get(rowIndex).getName();

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

}
