package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

public class AdminDashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNAndD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminDashboard frame = new AdminDashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminDashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 794, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel titlepanel = new JPanel();
		titlepanel.setBounds(0, 0, 778, 104);
		contentPane.add(titlepanel);
		titlepanel.setLayout(null);
		
		JLabel lblAdminDashboard = new JLabel("Admin Dashboard");
		lblAdminDashboard.setBounds(25, 10, 168, 24);
		titlepanel.add(lblAdminDashboard);
		lblAdminDashboard.setFont(new Font("Arial", Font.BOLD, 20));
		
		txtNAndD = new JTextField();
		txtNAndD.setBounds(79, 55, 422, 26);
		titlepanel.add(txtNAndD);
		txtNAndD.setFont(new Font("Arial", Font.PLAIN, 14));
		txtNAndD.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBounds(525, 54, 91, 26);
		titlepanel.add(btnNewButton);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setForeground(Color.WHITE);
		
		JPanel listpanel = new JPanel();
		listpanel.setBackground(Color.WHITE);
		listpanel.setBounds(0, 103, 778, 458);
		contentPane.add(listpanel);
		listpanel.setLayout(new GridLayout(0, 1, 10, 10));
	}
}
