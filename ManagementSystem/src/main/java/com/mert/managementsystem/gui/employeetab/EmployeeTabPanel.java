package com.mert.managementsystem.gui.employeetab;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import com.mert.managementsystem.gui.constants.Constants;
import com.mert.managementsystem.gui.eventlisteners.AddEmployeeButtonClickListener;
import com.mert.managementsystem.gui.eventlisteners.EmployeeTableMouseListener;

public class EmployeeTabPanel extends JPanel {
	private final GridBagLayout mainLayout = new GridBagLayout();

	private final JTable employeeTable;

	private final AbstractEmployeeTableModel employeeTableModel = new AbstractEmployeeTableModel();

	private final JButton deleteEmployeeBtn = new JButton("Delete Employee");

	private final JButton modifyEmployeeBtn = new JButton("Modify Employee");

	private final JButton addEmployeeBtn = new JButton("Add Employee");
	final JButton refreshBtn = new JButton("Refresh");

	private final GridBagConstraints mainLayoutConstraints = new GridBagConstraints();

	private final AddEmployeeButtonClickListener buttonClickListener = new AddEmployeeButtonClickListener();

	public EmployeeTabPanel() {
		this.setLayout(this.mainLayout);
		this.setBorder(BorderFactory.createTitledBorder("Employee"));
		this.employeeTable = new JTable(this.employeeTableModel);
		this.mainLayoutConstraints.gridwidth = 1;
		this.mainLayoutConstraints.gridx = 0;
		this.mainLayoutConstraints.gridy = 0;
		this.add(this.addEmployeeBtn, this.mainLayoutConstraints);
		//
		this.mainLayoutConstraints.gridx = 1;
		this.add(this.refreshBtn, this.mainLayoutConstraints);

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

		//
		this.employeeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.employeeTable.addMouseListener(new EmployeeTableMouseListener());
		//
		this.addEmployeeBtn.setActionCommand(Constants.ADD_EMPLOYEE_CMD);

		this.deleteEmployeeBtn.setActionCommand(Constants.DELETE_EMPLOYEE_CMD);
		this.modifyEmployeeBtn.setActionCommand(Constants.MODIFY_EMPLOYEE_CMD);
		this.refreshBtn.setActionCommand(Constants.REFRESH_EMPLOYEE_TABLE_CMD);

		// this.buttonClickListener.setTable(this.employeeTable);
		this.addEmployeeBtn.addActionListener(this.buttonClickListener);
		this.deleteEmployeeBtn.addActionListener(this.buttonClickListener);
		this.modifyEmployeeBtn.addActionListener(this.buttonClickListener);
		this.refreshBtn.addActionListener(e -> this.employeeTableModel.fireTableDataChanged());
		this.validate();
	}

}