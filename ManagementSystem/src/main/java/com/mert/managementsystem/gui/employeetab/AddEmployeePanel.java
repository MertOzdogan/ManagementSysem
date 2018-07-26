package com.mert.managementsystem.gui.employeetab;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.mert.managementsystem.entities.Department;
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

	private final JButton saveBtn = new JButton("Save");
	private final JButton cancelBtn = new JButton("Cancel");
	private final AddEmployeeButtonClickListener buttonClickListener = new AddEmployeeButtonClickListener(userNameTxt, nameTxt, surnameTxt,
			mailTxt, passwordTxt, salaryTxt, departmentCombo, typeCombo);

	private AddEmployeePanel() {
		this.setLayout(new GridLayout(9, 2));

		this.add(userNameLbl);
		this.add(userNameTxt);
		this.add(nameLbl);
		this.add(nameTxt);
		this.add(surnameLbl);
		this.add(surnameTxt);
		this.add(mailLBl);
		this.add(mailTxt);
		this.add(passwordLbl);
		this.add(passwordTxt);
		this.add(salaryLbl);

		this.add(salaryTxt);
		this.add(deptLbl);
		this.add(departmentCombo);
		this.add(typeLbl);
		this.add(typeCombo);
		this.add(cancelBtn);
		this.add(saveBtn);

		this.saveBtn.setActionCommand(Constants.SAVE_EMPLOYEE_CMD);
		this.cancelBtn.setActionCommand(Constants.CANCEL_EMPLOYEE_CMD);

		this.saveBtn.addActionListener(buttonClickListener);
		this.cancelBtn.addActionListener(buttonClickListener);

		this.setPreferredSize(new Dimension(300, 300));
		this.pack();
		this.validate();
	}

	public static AddEmployeePanel getINSTANCE() {
		return INSTANCE == null ? INSTANCE = new AddEmployeePanel() : INSTANCE;
	}

	public JTextField getUserNameTxt() {
		return userNameTxt;
	}

	public JTextField getNameTxt() {
		return nameTxt;
	}

	public JTextField getSurnameTxt() {
		return surnameTxt;
	}

	public JTextField getMailTxt() {
		return mailTxt;
	}

	public JTextField getPasswordTxt() {
		return passwordTxt;
	}

	public JTextField getSalaryTxt() {
		return salaryTxt;
	}

	public JComboBox<Department> getDepartmentCombo() {
		return departmentCombo;
	}

	public JComboBox<String> getTypeCombo() {
		return typeCombo;
	}
}
