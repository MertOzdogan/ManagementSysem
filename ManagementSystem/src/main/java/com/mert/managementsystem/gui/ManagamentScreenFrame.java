package com.mert.managementsystem.gui;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import com.mert.managementsystem.gui.employeetab.EmployeeTabPanel;

public class ManagamentScreenFrame extends JFrame
{
   public ManagamentScreenFrame( )
   {
      final JTabbedPane managementSystemTabbedPane = new JTabbedPane();
      managementSystemTabbedPane.add( "Employee", new EmployeeTabPanel() );
      this.add( managementSystemTabbedPane );
      this.pack();
      this.validate();
      this.setVisible( true );
      this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   }
   public static void main( String[] args )
   {
      new ManagamentScreenFrame ();
   }
}
