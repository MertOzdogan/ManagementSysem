package com.mert.managementsystem.gui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import com.mert.managementsystem.gui.departmenttab.DepartmenTabPanel;
import com.mert.managementsystem.gui.employeetab.EmployeeTabPanel;

public class ManagamentScreenFrame extends JFrame {

	private EmployeeTabPanel employeeTabPanel = new EmployeeTabPanel();
	DepartmenTabPanel departmenTabPanel = new DepartmenTabPanel();

	public ManagamentScreenFrame() {

		final JTabbedPane managementSystemTabbedPane = new JTabbedPane();
		managementSystemTabbedPane.add("Employee", employeeTabPanel);
		managementSystemTabbedPane.add("Department", departmenTabPanel);

		this.add(managementSystemTabbedPane);
		this.setPreferredSize(new Dimension(600, 600));
		this.pack();
		this.validate();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}