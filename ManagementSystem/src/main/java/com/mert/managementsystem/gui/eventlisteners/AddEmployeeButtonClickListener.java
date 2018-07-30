package com.mert.managementsystem.gui.eventlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.mert.managementsystem.entities.Department;
import com.mert.managementsystem.entities.Employee;
import com.mert.managementsystem.gui.constants.AddModifyType;
import com.mert.managementsystem.gui.constants.Constants;
import com.mert.managementsystem.gui.employeetab.AddEmployeePanel;
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

	private final ManagementService managementService = (ManagementService) ServiceFactory
			.getService(ManagementService.class);

	public AddEmployeeButtonClickListener() {
		// TODO Auto-generated constructor stub
	}

	public AddEmployeeButtonClickListener(final JTextField userNameTxt, final JTextField nameTxt,
			final JTextField surnameTxt, final JTextField mailTxt, final JTextField passwordTxt,
			final JTextField salaryTxt, final JComboBox<Department> departmentCombo,
			final JComboBox<String> typeCombo) {
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
	public void actionPerformed(final ActionEvent e) {
		final AddEmployeePanel addEmployeePanel = AddEmployeePanel.getINSTANCE();
		switch (e.getActionCommand()) {
		case Constants.ADD_EMPLOYEE_CMD:
			addEmployeePanel.getDepartmentCombo().removeAllItems();
			this.managementService.getDepartmentList().forEach(addEmployeePanel.getDepartmentCombo()::addItem);
			addEmployeePanel.setCommandType(AddModifyType.ADD);
			addEmployeePanel.setVisible(true);

			break;
		case Constants.DELETE_EMPLOYEE_CMD:
			break;
		case Constants.MODIFY_EMPLOYEE_CMD:

			final Department departmentToUpdate = (Department) this.departmentCombo.getSelectedItem();
			final Employee employeeToUpdate = new Employee(this.userNameTxt.getText(), this.nameTxt.getText(),
					this.surnameTxt.getText(), this.mailTxt.getText(), this.passwordTxt.getText(),
					this.salaryTxt.getText(), "type");
			addEmployeePanel.getDepartmentCombo().removeAllItems();
			this.managementService.updateSingleEmployee(employeeToUpdate, departmentToUpdate);

			break;
		case Constants.SAVE_EMPLOYEE_CMD:
			try {
				if (this.departmentCombo.getSelectedItem() == null) {
					this.managementService.createSingleEmployee(new Employee(this.userNameTxt.getText(),
							this.nameTxt.getText(), this.surnameTxt.getText(), this.mailTxt.getText(),
							this.passwordTxt.getText(), this.salaryTxt.getText(), "type"));
				} else {
					final Department department = (Department) this.departmentCombo.getSelectedItem();
					final Employee employee = new Employee(this.userNameTxt.getText(), this.nameTxt.getText(),
							this.surnameTxt.getText(), this.mailTxt.getText(), this.passwordTxt.getText(),
							this.salaryTxt.getText(), "type");
					this.managementService.createSingleEmployee(employee, department);
				}
				this.userNameTxt.setText("");
				this.nameTxt.setText("");
				this.surnameTxt.setText("");
				this.mailTxt.setText("");
				this.passwordTxt.setText("");
				this.passwordTxt.setText("");
				this.salaryTxt.setText("");
				this.departmentCombo.setSelectedIndex(0);
				JOptionPane.showMessageDialog(null, "Succcess", "Success", JOptionPane.INFORMATION_MESSAGE);

			} catch (final Exception e2) {
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
