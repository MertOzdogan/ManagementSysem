package com.mert.managementsystem.gui.employeetab;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class EmployeeTabPanel extends JPanel
{
   private final GridBagLayout mainLayout = new GridBagLayout();

   private final JTable employeeTable;

   private final AbstractEmployeeTableModel employeeTableModel =
         new AbstractEmployeeTableModel();

   private final JButton deleteEmployeeBtn = new JButton( "Delete Employee" );

   private final JButton modifyEmployeeBtn = new JButton( "Modify Employee" );

   private final JButton addEmployeeBtn = new JButton( "Add Employee" );

   private final GridBagConstraints mainLayoutConstraints = new GridBagConstraints();


   public EmployeeTabPanel( )
   {
      this.setLayout( this.mainLayout );
      this.setBorder( BorderFactory.createTitledBorder( "Employee" ) );
      this.employeeTable = new JTable( this.employeeTableModel );
      //   this.mainLayoutConstraints.fill = GridBagConstraints.HORIZONTAL;
      this.mainLayoutConstraints.gridwidth = 1;
      this.mainLayoutConstraints.gridx = 0;
      this.mainLayoutConstraints.gridy = 0;
      this.add( this.addEmployeeBtn, this.mainLayoutConstraints );
      //
      this.mainLayoutConstraints.gridwidth = 4;
      this.mainLayoutConstraints.gridx = 0;
      this.mainLayoutConstraints.gridy = 1;
      this.add( new JScrollPane( this.employeeTable ), this.mainLayoutConstraints );
      //
      this.mainLayoutConstraints.gridwidth = 1;
      this.mainLayoutConstraints.gridx = 0;
      this.mainLayoutConstraints.gridy = 2;
      this.add( this.deleteEmployeeBtn, this.mainLayoutConstraints );
      //
      this.mainLayoutConstraints.gridx = 1;
      this.mainLayoutConstraints.gridy = 2;
      this.add( this.modifyEmployeeBtn, this.mainLayoutConstraints );

      this.validate();
   }
}