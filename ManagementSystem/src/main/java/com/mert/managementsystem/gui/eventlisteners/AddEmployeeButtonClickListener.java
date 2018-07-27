package com.mert.managementsystem.gui.eventlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mert.managementsystem.entities.Department;
import com.mert.managementsystem.entities.Employee;
import com.mert.managementsystem.gui.constants.Constants;
import com.mert.managementsystem.gui.employeetab.AddEmployeePanel;
import com.mert.managementsystem.gui.employeetab.EmployeeTabPanel;
import com.mert.managementsystem.services.ManagementService;
import com.mert.managementsystem.services.ServiceFactory;

public class AddEmployeeButtonClickListener implements ActionListener {

	private JTextField userNameTxt;
	private JTextField nameTxt;
	private JTextField surnameTxt;
	private JTextField mailTxt;
	private JTextField passwordTxt;
	private JTextField salaryTxt;
	private JComboBox<Department> departmentCombo;
	private JComboBox<String> typeCombo;

	private ManagementService managementService = (ManagementService) ServiceFactory
			.getService(ManagementService.class);

	public AddEmployeeButtonClickListener() {
		// TODO Auto-generated constructor stub
	}

	public AddEmployeeButtonClickListener(JTextField userNameTxt, JTextField nameTxt, JTextField surnameTxt,
			JTextField mailTxt, JTextField passwordTxt, JTextField salaryTxt, JComboBox<Department> departmentCombo,
			JComboBox<String> typeCombo) {
		this.userNameTxt = userNameTxt;
		this.nameTxt = nameTxt;
		this.surnameTxt = surnameTxt;
		this.mailTxt = mailTxt;
		this.passwordTxt = passwordTxt;
		this.salaryTxt = salaryTxt;
		this.departmentCombo = departmentCombo;
		this.typeCombo = typeCombo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		case Constants.ADD_EMPLOYEE_CMD:
			AddEmployeePanel addEmployeePanel = AddEmployeePanel.getINSTANCE();
			addEmployeePanel.setVisible(true);
			addEmployeePanel.getDepartmentCombo().removeAllItems();
			managementService.getDepartmentList().forEach(addEmployeePanel.getDepartmentCombo()::addItem);
			break;
		case Constants.DELETE_EMPLOYEE_CMD:
			break;
		case Constants.MODIFY_EMPLOYEE_CMD:
			break;
		case Constants.SAVE_EMPLOYEE_CMD:
			try {
				if (departmentCombo.getSelectedItem() == null) {
					managementService.createSingleEmployee(new Employee(this.userNameTxt.getText(),
							this.nameTxt.getText(), this.surnameTxt.getText(), this.mailTxt.getText(),
							this.passwordTxt.getText(), this.salaryTxt.getText(), "type"));
				} else {
					Department department = (Department) this.departmentCombo.getSelectedItem();
					Employee employee = new Employee(this.userNameTxt.getText(), this.nameTxt.getText(),
							this.surnameTxt.getText(), this.mailTxt.getText(), this.passwordTxt.getText(),
							this.salaryTxt.getText(), "type");

					managementService.createSingleEmployee(employee, department);
				}
				userNameTxt.setText("");
				nameTxt.setText("");
				surnameTxt.setText("");
				mailTxt.setText("");
				passwordTxt.setText("");
				passwordTxt.setText("");
				salaryTxt.setText("");
				departmentCombo.setSelectedIndex(0);

				JOptionPane.showMessageDialog(null, "Succcess", "Success", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			break;
		case Constants.CANCEL_EMPLOYEE_CMD:
			break;

		default:
			break;
		}
	}

}
