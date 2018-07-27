package com.mert.managementsystem.gui.employeetab;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.mert.managementsystem.gui.constants.Constants;
import com.mert.managementsystem.gui.eventlisteners.AddEmployeeButtonClickListener;
import com.mert.managementsystem.services.ManagementService;
import com.mert.managementsystem.services.ServiceFactory;

public class EmployeeTabPanel extends JPanel {
	private final GridBagLayout mainLayout = new GridBagLayout();

	private final JTable employeeTable;

	private final AbstractEmployeeTableModel employeeTableModel = new AbstractEmployeeTableModel();

	private final JButton deleteEmployeeBtn = new JButton("Delete Employee");

	private final JButton modifyEmployeeBtn = new JButton("Modify Employee");

	private final JButton addEmployeeBtn = new JButton("Add Employee");

	private final GridBagConstraints mainLayoutConstraints = new GridBagConstraints();

	AddEmployeeButtonClickListener buttonClickListener = new AddEmployeeButtonClickListener();

	public EmployeeTabPanel() {
		this.setLayout(this.mainLayout);
		this.setBorder(BorderFactory.createTitledBorder("Employee"));
		this.employeeTable = new JTable(this.employeeTableModel);
		this.mainLayoutConstraints.gridwidth = 1;
		this.mainLayoutConstraints.gridx = 0;
		this.mainLayoutConstraints.gridy = 0;
		this.add(this.addEmployeeBtn, this.mainLayoutConstraints);
		//
		this.mainLayoutConstraints.gridwidth = 4;
		this.mainLayoutConstraints.gridx = 0;
		this.mainLayoutConstraints.gridy = 1;
		this.add(new JScrollPane(this.employeeTable), this.mainLayoutConstraints);
		//
		this.mainLayoutConstraints.gridwidth = 1;
		this.mainLayoutConstraints.gridx = 0;
		this.mainLayoutConstraints.gridy = 2;
		this.add(this.deleteEmployeeBtn, this.mainLayoutConstraints);
		//
		this.mainLayoutConstraints.gridx = 1;
		this.mainLayoutConstraints.gridy = 2;
		this.add(this.modifyEmployeeBtn, this.mainLayoutConstraints);

		addEmployeeBtn.setActionCommand(Constants.ADD_EMPLOYEE_CMD);
		deleteEmployeeBtn.setActionCommand(Constants.DELETE_EMPLOYEE_CMD);
		modifyEmployeeBtn.setActionCommand(Constants.MODIFY_EMPLOYEE_CMD);

		this.addEmployeeBtn.addActionListener(buttonClickListener);
		this.deleteEmployeeBtn.addActionListener(buttonClickListener);
		this.modifyEmployeeBtn.addActionListener(buttonClickListener);
		this.validate();
	}

}