package view;
import javax.swing.*;

import controller.AdminController;
import model.AdminModel;

import java.awt.*;
import java.awt.event.ActionListener;

public class AdminView extends JFrame {

    private JMenuBar menuBar;
    private JMenu employeeMenu, adminMenu;
    private JMenuItem employeeDirectoryItem, employeeDashboardItem, adminDashboardItem, addAdminItem, logoutItem;
    
    public AdminView() {
        setTitle("Employee Directory");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Menu Bar
        menuBar = new JMenuBar();
        
        // Employee Menu
        employeeMenu = new JMenu("Employee");
        employeeDirectoryItem = new JMenuItem("Employee Directory");
        employeeDashboardItem = new JMenuItem("Employee Dashboard");
        employeeMenu.add(employeeDirectoryItem);
        employeeMenu.add(employeeDashboardItem);
        
        // Admin Menu
        adminMenu = new JMenu("Admin");
        adminDashboardItem = new JMenuItem("Admin Dashboard");
        addAdminItem = new JMenuItem("Add Admin");
        adminMenu.add(adminDashboardItem);
        adminMenu.add(addAdminItem);
        
        // Logout Menu
        logoutItem = new JMenuItem("Logout");
        
        // Add menus to the menu bar
        menuBar.add(employeeMenu);
        menuBar.add(adminMenu);
        menuBar.add(logoutItem);
        
        // Set menu bar
        setJMenuBar(menuBar);
    }
    
    // Add Action Listeners
    public void addMenuActionListener(ActionListener listener) {
        employeeDirectoryItem.addActionListener(listener);
        employeeDashboardItem.addActionListener(listener);
        adminDashboardItem.addActionListener(listener);
        addAdminItem.addActionListener(listener);
        logoutItem.addActionListener(listener);
    }
    
    public class Main {
        public static void main(String[] args) {
            // Create model, view, and controller
            AdminModel model = new AdminModel();
            AdminView view = new AdminView();
            AdminController controller = new AdminController();
            
            // Display the view
            view.setVisible(true);
        }
    }

}
