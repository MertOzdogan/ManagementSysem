package com.mert.managementsystem.gui.departmenttab;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.mert.managementsystem.entities.Department;
import com.mert.managementsystem.gui.constants.AddModifyType;
import com.mert.managementsystem.gui.constants.Constants;
import com.mert.managementsystem.gui.eventlisteners.DepartmentButtonClickListener;

public class AddModifyDepartmentPanel extends JDialog {
	public static AddModifyDepartmentPanel INSTANCE;
	private final JTextField nameTxt = new JTextField();
	private final JLabel nameNameLbl = new JLabel("Department Name");
//
	private final JButton saveBtn = new JButton("Save");
	private final JButton cancelBtn = new JButton("Cancel");
	private final DepartmentButtonClickListener buttonClickListener = new DepartmentButtonClickListener(this.nameTxt);

	public AddModifyDepartmentPanel() {
		this.setLayout(new GridLayout(2, 2));
		this.add(this.nameNameLbl);
		this.add(this.nameTxt);
		this.add(this.cancelBtn);
		this.add(this.saveBtn);
		//
		this.cancelBtn.setActionCommand(Constants.CANCEL_DEPARTMENT_CMD);
		this.saveBtn.addActionListener(this.buttonClickListener);
		this.cancelBtn.addActionListener(this.buttonClickListener);
		this.pack();
		this.validate();
	}

	public void setModifyValues(final Department dept) {
		this.nameTxt.setText(dept.getName());
		this.setVisible(true);

	}

	public void setCommandType(final AddModifyType type) {
		if (type.equals(AddModifyType.ADD)) {
			this.saveBtn.setActionCommand(Constants.SAVE_DEPARTMENT_CMD);

		} else {
			this.saveBtn.setActionCommand(Constants.MODIFY_DEPARTMENT_CMD);
		}
	}

	// here all to be refactored with Spring with wiring. Idk how.
	public static AddModifyDepartmentPanel getINSTANCE() {
		if (AddModifyDepartmentPanel.INSTANCE == null) {

			AddModifyDepartmentPanel.INSTANCE = new AddModifyDepartmentPanel();
		}
		return AddModifyDepartmentPanel.INSTANCE;
	}

	public JTextField getNameTxt() {
		return this.nameTxt;
	}

	public JLabel getNameNameLbl() {
		return this.nameNameLbl;
	}

	public JButton getSaveBtn() {
		return this.saveBtn;
	}

	public JButton getCancelBtn() {
		return this.cancelBtn;
	}

}
