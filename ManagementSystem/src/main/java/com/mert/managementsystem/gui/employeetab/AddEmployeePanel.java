package com.mert.managementsystem.gui.employeetab;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.mert.managementsystem.entities.Department;
import com.mert.managementsystem.entities.Employee;
import com.mert.managementsystem.gui.constants.Constants;
import com.mert.managementsystem.gui.eventlisteners.AddEmployeeButtonClickListener;

public class AddEmployeePanel extends JDialog {

	public static AddEmployeePanel INSTANCE;
	private final JTextField userNameTxt = new JTextField();
	private final JTextField nameTxt = new JTextField();
	private final JTextField surnameTxt = new JTextField();
	private final JTextField mailTxt = new JTextField();
	private final JTextField passwordTxt = new JTextField();
	private final JTextField salaryTxt = new JTextField();
	private final JComboBox<Department> departmentCombo = new JComboBox<>();
	private final JComboBox<String> typeCombo = new JComboBox<>();// Enum is to be added here.
	//
	private final JLabel userNameLbl = new JLabel("Username");
	private final JLabel nameLbl = new JLabel("Name:");
	private final JLabel surnameLbl = new JLabel("Surname");
	private final JLabel mailLBl = new JLabel("Mail");
	private final JLabel passwordLbl = new JLabel("Password");
	private final JLabel salaryLbl = new JLabel("Salary");
	private final JLabel deptLbl = new JLabel("Department");
	private final JLabel typeLbl = new JLabel("Type");
	//
	private final JButton saveBtn = new JButton("Save");
	private final JButton cancelBtn = new JButton("Cancel");
	//
	private final AddEmployeeButtonClickListener buttonClickListener = new AddEmployeeButtonClickListener(
			this.userNameTxt, this.nameTxt, this.surnameTxt, this.mailTxt, this.passwordTxt, this.salaryTxt,
			this.departmentCombo, this.typeCombo);

	private AddEmployeePanel() {
		this.setLayout(new GridLayout(9, 2));

		this.add(this.userNameLbl);
		this.add(this.userNameTxt);
		this.add(this.nameLbl);
		this.add(this.nameTxt);
		this.add(this.surnameLbl);
		this.add(this.surnameTxt);
		this.add(this.mailLBl);
		this.add(this.mailTxt);
		this.add(this.passwordLbl);
		this.add(this.passwordTxt);
		this.add(this.salaryLbl);
		this.add(this.salaryTxt);
		this.add(this.deptLbl);
		this.add(this.departmentCombo);
		this.add(this.typeLbl);
		this.add(this.typeCombo);
		this.add(this.cancelBtn);
		this.add(this.saveBtn);
		this.departmentCombo.insertItemAt(null, 0);
		this.cancelBtn.setActionCommand(Constants.CANCEL_EMPLOYEE_CMD);

		this.saveBtn.addActionListener(this.buttonClickListener);
		this.cancelBtn.addActionListener(this.buttonClickListener);
		this.setPreferredSize(new Dimension(300, 300));
		this.pack();
		this.validate();
	}

	public void setCommandType(final AddModifyEmployePanelType type) {
		if (type.equals(AddModifyEmployePanelType.ADD)) {
			this.saveBtn.setActionCommand(Constants.SAVE_EMPLOYEE_CMD);

		} else {
			this.saveBtn.setActionCommand(Constants.MODIFY_EMPLOYEE_CMD);

		}
	}

	public void setModifyValues(final Employee employee) {
		this.userNameTxt.setText(employee.getUsername());
		this.nameTxt.setText(employee.getName());
		this.surnameTxt.setText(employee.getSurname());
		this.mailTxt.setText(employee.getMail());
		this.passwordTxt.setText(employee.getPassword());
		this.salaryTxt.setText(employee.getSalary());
		this.departmentCombo.setSelectedItem(employee.getDeptId());
		this.setVisible(true);
	}

	// here all to be refactored with Spring with wiring. Idk how.
	public static AddEmployeePanel getINSTANCE() {
		if (AddEmployeePanel.INSTANCE == null) {

			AddEmployeePanel.INSTANCE = new AddEmployeePanel();
		}
		return AddEmployeePanel.INSTANCE;
	}

	public JTextField getUserNameTxt() {
		return this.userNameTxt;
	}

	public JTextField getNameTxt() {
		return this.nameTxt;
	}

	public JTextField getSurnameTxt() {
		return this.surnameTxt;
	}

	public JTextField getMailTxt() {
		return this.mailTxt;
	}

	public JTextField getPasswordTxt() {
		return this.passwordTxt;
	}

	public JTextField getSalaryTxt() {
		return this.salaryTxt;
	}

	public JComboBox<Department> getDepartmentCombo() {
		return this.departmentCombo;
	}

	public JComboBox<String> getTypeCombo() {
		return this.typeCombo;
	}
}
