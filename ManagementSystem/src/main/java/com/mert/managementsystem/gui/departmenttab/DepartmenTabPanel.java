package com.mert.managementsystem.gui.departmenttab;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import com.mert.managementsystem.gui.constants.Constants;
import com.mert.managementsystem.gui.eventlisteners.DepartmentButtonClickListener;
import com.mert.managementsystem.gui.eventlisteners.EmployeeTableMouseListener;

public class DepartmenTabPanel extends JPanel {
	private final GridBagLayout mainLayout = new GridBagLayout();
	private final GridBagConstraints mainLayoutConstraints = new GridBagConstraints();

	private final JTable departmentTable;
	private final AbstractDepartmentTableModel departmentTableModel = new AbstractDepartmentTableModel();
	private final JButton addDepartmentBtn = new JButton("Add Department");
	private final JButton deleteDepartmentBtn = new JButton("Delete Department");
	private final JButton refreshBtn = new JButton("Refresh");
	private final DepartmentButtonClickListener buttonClickListener = new DepartmentButtonClickListener();

	public DepartmenTabPanel() {
		this.setLayout(this.mainLayout);
		this.setBorder(BorderFactory.createTitledBorder("Department"));
		this.departmentTable = new JTable(this.departmentTableModel);

		this.mainLayoutConstraints.gridwidth = 1;
		this.mainLayoutConstraints.gridx = 0;
		this.mainLayoutConstraints.gridy = 0;
		this.add(this.addDepartmentBtn, this.mainLayoutConstraints);
		//
		this.mainLayoutConstraints.gridx = 1;
		this.add(this.refreshBtn, this.mainLayoutConstraints);

		//
		this.mainLayoutConstraints.gridwidth = 4;
		this.mainLayoutConstraints.gridx = 0;
		this.mainLayoutConstraints.gridy = 1;
		this.add(new JScrollPane(this.departmentTable), this.mainLayoutConstraints);
		//
		this.mainLayoutConstraints.gridwidth = 1;
		this.mainLayoutConstraints.gridx = 0;
		this.mainLayoutConstraints.gridy = 2;
		this.add(this.deleteDepartmentBtn, this.mainLayoutConstraints);
		//
		this.departmentTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.departmentTable.addMouseListener(new EmployeeTableMouseListener());
		//
		this.addDepartmentBtn.setActionCommand(Constants.ADD_DEPARTMENT_CMD);
		this.refreshBtn.setActionCommand(Constants.REFRESH_DEPARTMENT_TABLE_CMD);

		this.addDepartmentBtn.addActionListener(this.buttonClickListener);
		this.refreshBtn.addActionListener(e -> this.departmentTableModel.fireTableDataChanged());
//
		this.validate();

	}
}
