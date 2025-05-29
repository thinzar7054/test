package sample;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.SystemColor;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Controller.EmployeeController;
import DAO.EmployeeDAO;
import Model.Employee;

public class EmpDashboardAdmin extends JPanel {

    public JTextField searchField;
    private EmployeeController controller;
    private JPanel employeeListPanel;
    private JScrollPane scrollPane;
    public JButton btnSearch;
    public JButton btnAdd;

    public EmpDashboardAdmin() {
        setBackground(SystemColor.inactiveCaptionBorder);
        setLayout(null);

        JLabel lblTitle = new JLabel("Employee Dashboard");
        lblTitle.setFont(new Font("Pyidaungsu", Font.PLAIN, 25));
        lblTitle.setBounds(103, 39, 329, 29);
        add(lblTitle);

        searchField = new JTextField();
        searchField.setBounds(103, 97, 413, 37);
        add(searchField);
        searchField.setColumns(10);

        btnSearch = new JButton("Search");
        btnSearch.setBackground(new Color(255, 0, 0));
        btnSearch.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
        btnSearch.setBounds(526, 97, 85, 37);
        add(btnSearch);

        btnAdd = new JButton("Add");
        btnAdd.setBackground(new Color(255, 0, 0));
        btnAdd.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
        btnAdd.setBounds(632, 97, 85, 37);
        add(btnAdd);

        // Initialize panel
        employeeListPanel = new JPanel();
        employeeListPanel.setBounds(632, 97, 205, 170);
        employeeListPanel.setLayout(new BoxLayout(employeeListPanel, BoxLayout.Y_AXIS));
        employeeListPanel.setBackground(Color.WHITE);

        scrollPane = new JScrollPane(employeeListPanel);
        scrollPane.setBounds(103, 160, 600, 400);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollPane);

//        // Initialize controller
//        controller = new EmployeeController(this, new EmployeeDAO(DriverManager.getConnection("jdbc:mysql://localhost:3306/empdirectory", "username", "password"))); // Make sure the constructor exists

        // Load all employees
        loadEmployees("");

        // Add DocumentListener for live search
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                loadEmployees(searchField.getText());
            }
            public void removeUpdate(DocumentEvent e) {
                loadEmployees(searchField.getText());
            }
            public void changedUpdate(DocumentEvent e) {
                loadEmployees(searchField.getText());
            }
        });

        // Optional: Search button for manual filtering (if preferred)
        btnSearch.addActionListener(e -> loadEmployees(searchField.getText()));
    }

    private void loadEmployees(String keyword) {
        employeeListPanel.removeAll();

        List<Employee> employees = EmployeeController.getAllEmployees();
        for (Employee emp : employees) {
            if (keyword.isEmpty() || emp.getEmpName().toLowerCase().contains(keyword.toLowerCase())) {
                JPanel row = new JPanel(new BorderLayout());
                row.setBorder(new EmptyBorder(10, 10, 10, 10));
                row.setBackground(new Color(245, 245, 245));

                JLabel nameLabel = new JLabel("<html><u>" + emp.getEmpName() + "</u></html>");
                nameLabel.setForeground(Color.RED);
                nameLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
                nameLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        showEmployeeDetails(emp);
                    }
                });

                JLabel deptLabel = new JLabel(emp.getDepartment());
                deptLabel.setFont(new Font("Arial", Font.PLAIN, 14));

                JPanel left = new JPanel(new BorderLayout());
                left.setOpaque(false);
                left.add(nameLabel, BorderLayout.NORTH);
                left.add(deptLabel, BorderLayout.SOUTH);

                JButton deleteBtn = new JButton("🗑");
                deleteBtn.setBackground(Color.WHITE);
                deleteBtn.setBorder(null);
                deleteBtn.setToolTipText("Delete " + emp.getEmpName());
                deleteBtn.addActionListener(e -> {
                    controller.deleteEmployee(emp.getEmp_id());
                    loadEmployees(searchField.getText());
                });

                row.add(left, BorderLayout.CENTER);
                row.add(deleteBtn, BorderLayout.EAST);
                employeeListPanel.add(row);
            }
        }

        employeeListPanel.revalidate();
        employeeListPanel.repaint();
    }

    private void showEmployeeDetails(Employee emp) {
        JOptionPane.showMessageDialog(this,
                "Employee Name: " + emp.getEmpName() + "\nDepartment: " + emp.getDepartment(),
                "Employee Details",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void refreshEmployeeList(List<Employee> list, Object object, Object object2) {
        // TODO Auto-generated method stub
    }
    
    public static void main(String[] args) {
    	SwingUtilities.invokeLater(() -> {
            try {
                JFrame frame = new JFrame("Employee Dashboard");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(827, 682);
                frame.setContentPane(new EmpDashboardAdmin()); // Add the JPanel to the JFrame
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

	
}

