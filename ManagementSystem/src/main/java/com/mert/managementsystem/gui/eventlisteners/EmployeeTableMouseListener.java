package com.mert.managementsystem.gui.eventlisteners;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JTable;

import com.mert.managementsystem.entities.Department;
import com.mert.managementsystem.entities.Employee;
import com.mert.managementsystem.gui.employeetab.AbstractEmployeeTableModel;
import com.mert.managementsystem.gui.employeetab.AddEmployeePanel;
import com.mert.managementsystem.gui.employeetab.AddModifyEmployePanelType;
import com.mert.managementsystem.services.ManagementService;
import com.mert.managementsystem.services.ServiceFactory;

public class EmployeeTableMouseListener implements MouseListener {
	ManagementService managementService = (ManagementService) ServiceFactory.getService(ManagementService.class);

	@Override
	public void mouseClicked(final MouseEvent e) {
		final AddEmployeePanel addEmployeePanel = AddEmployeePanel.getINSTANCE();
		addEmployeePanel.getDepartmentCombo().removeAllItems();
		List<Department> departmentList = this.managementService.getDepartmentList();
		departmentList.forEach(addEmployeePanel.getDepartmentCombo()::addItem);

		final JTable table = (JTable) e.getSource();
		final Point point = e.getPoint();
		final int row = table.rowAtPoint(point);
		if ((e.getClickCount() == 2) && (table.getSelectedRow() != -1)) {
			// your valueChanged overridden method
			final AddEmployeePanel addModifyEmployeePanel = AddEmployeePanel.getINSTANCE();
			final AbstractEmployeeTableModel abstractEmployeeTableModel = (AbstractEmployeeTableModel) table.getModel();
			final int id = (int) abstractEmployeeTableModel.getValueAt(row, 0);
			addModifyEmployeePanel.setCommandType(AddModifyEmployePanelType.MODIFY);
			final Employee findEmployeeById = abstractEmployeeTableModel.findEmployeeById(id);
			addModifyEmployeePanel.setModifyValues(findEmployeeById);
		}

	}

	@Override
	public void mouseEntered(final MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(final MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(final MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(final MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
