package com.mert.managementsystem.gui.eventlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import com.mert.managementsystem.entities.Department;
import com.mert.managementsystem.gui.constants.AddModifyType;
import com.mert.managementsystem.gui.constants.Constants;
import com.mert.managementsystem.gui.departmenttab.AddModifyDepartmentPanel;
import com.mert.managementsystem.services.ManagementService;
import com.mert.managementsystem.services.ServiceFactory;

public class DepartmentButtonClickListener implements ActionListener {

	private final ManagementService managementService = (ManagementService) ServiceFactory
			.getService(ManagementService.class);
	private JTextField nameTxt;

	public DepartmentButtonClickListener(final JTextField nameTxt) {
		this.nameTxt = nameTxt;
	}

	public DepartmentButtonClickListener() {
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		final AddModifyDepartmentPanel addModifyDepartmentPanel = AddModifyDepartmentPanel.getINSTANCE();
		switch (e.getActionCommand()) {
		case Constants.ADD_DEPARTMENT_CMD:
			addModifyDepartmentPanel.setVisible(true);
			addModifyDepartmentPanel.setCommandType(AddModifyType.ADD);
			break;
		case Constants.SAVE_DEPARTMENT_CMD:
			this.managementService.createDepartment(new Department(this.nameTxt.getText()));
			this.nameTxt.setText("");
		default:
			break;
		}
	}

}
