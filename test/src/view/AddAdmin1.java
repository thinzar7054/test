package view;
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedHashMap;
import java.util.Map;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
 
public class AddAdmin1 extends JFrame {
 
	private JPanel contentPanel;
	private CardLayout cardLayout;
	private Map<String, JPanel> panels = new LinkedHashMap<>();
	private Map<String, JLabel> navLabels = new LinkedHashMap<>();
	private Color normalColor = Color.WHITE;
	private Color hoverColor = new Color(0, 0, 0); // Black
	private Color activeColor = new Color(34, 139, 34); // Forest Green
 
	private JLabel activeLabel = null;
	private JTextField textField;
 
	public AddAdmin1() {
		setTitle("Employee Directory");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(995, 700);
		setLocationRelativeTo(null);
 
		JPanel mainPanel = new JPanel(new BorderLayout());
		JPanel menuBar = createMenuBar();
		mainPanel.add(menuBar, BorderLayout.NORTH);
 
		cardLayout = new CardLayout();
		contentPanel = new JPanel(cardLayout);
		contentPanel.setBackground(Color.WHITE);
		createPanels();
 
		for (Map.Entry<String, JPanel> entry : panels.entrySet()) {
			contentPanel.add(entry.getValue(), entry.getKey());
		}
 
		cardLayout.show(contentPanel, "EmployeeDashboard");
		setActiveNav("Employee Dashboard");
 
		mainPanel.add(contentPanel, BorderLayout.CENTER);
 
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		contentPanel.add(panel, "name_3002885783000");
		panel.setLayout(null);
 
		textField = new JTextField();
		textField.setBounds(142, 83, 456, 32);
		panel.add(textField);
		textField.setColumns(10);
 
		JButton btnSearch = new JButton("Search");
		btnSearch.setBackground(new Color(255, 0, 0));
		btnSearch.setForeground(new Color(255, 255, 255));
		btnSearch.setBounds(625, 88, 85, 21);
		panel.add(btnSearch);
 
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setBackground(Color.RED);
		btnAdd.setBounds(738, 88, 85, 21);
		panel.add(btnAdd);
		getContentPane().add(mainPanel);
	}
 
	private JPanel createMenuBar() {
		JPanel menuBar = new JPanel(new BorderLayout());
		menuBar.setBackground(new Color(230, 230, 250));
		menuBar.setPreferredSize(new Dimension(getWidth(), 50));
		menuBar.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
 
		// Left: logo + system name
		JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
		leftPanel.setOpaque(false);
 
		JLabel menuIcon = new JLabel("\u2630");
		menuIcon.setFont(new Font("Arial", Font.PLAIN, 20));
		menuIcon.setForeground(Color.WHITE);
 
		JLabel systemName = new JLabel("Employee Directory");
		systemName.setFont(new Font("Arial", Font.BOLD, 16));
		systemName.setForeground(Color.WHITE);
 
		leftPanel.add(menuIcon);
		leftPanel.add(systemName);
 
		// Center: navigation labels
		JPanel navPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0));
		navPanel.setOpaque(false);
 
		String[] menuItems = { "Employee Dashboard", "Employee Detail", "Admin Dashboard", "Add Admin" };
 
		for (String item : menuItems) {
			JLabel navLabel = createNavLabel(item);
			navLabels.put(item, navLabel);
			navPanel.add(navLabel);
		}
 
		// Right: logout button
		JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
		rightPanel.setOpaque(false);
 
		JButton logoutButton = new JButton("Logout");
		logoutButton.setFocusPainted(false);
		logoutButton.setForeground(Color.WHITE);
		logoutButton.setBackground(new Color(220, 53, 69)); // Bootstrap Danger color
		logoutButton.setFont(new Font("Arial", Font.PLAIN, 14));
		logoutButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		logoutButton.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
 
		// Button hover effect
		logoutButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				logoutButton.setBackground(new Color(200, 35, 50));
			}
 
			@Override
			public void mouseExited(MouseEvent e) {
				logoutButton.setBackground(new Color(220, 53, 69));
			}
		});
 
		logoutButton.addActionListener(e -> {
			int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Logout",
					JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				dispose(); // or redirect to login form
				System.exit(0);
			}
		});
 
		rightPanel.add(logoutButton);
 
		menuBar.add(leftPanel, BorderLayout.WEST);
		menuBar.add(navPanel, BorderLayout.CENTER);
		menuBar.add(rightPanel, BorderLayout.EAST);
 
		return menuBar;
	}
 
	private JLabel createNavLabel(String name) {
		JLabel label = new JLabel(name);
		label.setFont(new Font("Arial", Font.PLAIN, 14));
		label.setForeground(normalColor);
		label.setCursor(new Cursor(Cursor.HAND_CURSOR));
		label.setOpaque(false);
		label.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
 
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (label != activeLabel) {
					label.setForeground(hoverColor);
				}
			}
 
			@Override
			public void mouseExited(MouseEvent e) {
				if (label != activeLabel) {
					label.setForeground(normalColor);
				}
			}
 
			@Override
			public void mouseClicked(MouseEvent e) {
				setActiveNav(name);
				cardLayout.show(contentPanel, name.replace(" ", ""));
			}
		});
 
		return label;
	}
 
	private void setActiveNav(String name) {
		if (activeLabel != null) {
			activeLabel.setForeground(normalColor);
		}
		activeLabel = navLabels.get(name);
		if (activeLabel != null) {
			activeLabel.setForeground(activeColor);
		}
	}
 
	private void createPanels() {
		panels.put("EmployeeDashboard", panelWithLabel("EmployeeDashboard"));
		panels.put("EmployeeDetail", panelWithLabel("Employee Detail"));
		panels.put("AdminDashboard", panelWithLabel("Admin Dashboard"));
		panels.put("AddAdmin", createAddAdmin());
	}
 
	private JPanel panelWithLabel(String text) {
		JPanel panel = new JPanel();
		panel.add(new JLabel(text));
		return panel;
	}
 
	private JPanel createAddAdmin() {
		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.setBackground(Color.WHITE);
 
		// Top panel: Search field + buttons
		JPanel topPanel = new JPanel(null); // Absolute positioning
		topPanel.setPreferredSize(new Dimension(995, 60));
		topPanel.setBackground(Color.WHITE);
 
		textField = new JTextField();
		textField.setBounds(142, 15, 456, 32);
		topPanel.add(textField);
 
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(625, 20, 85, 21);
		topPanel.add(btnNewButton);
 
		JButton btnAdd = new JButton("Add");
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setBackground(Color.RED);
		btnAdd.setBounds(738, 20, 85, 21);
		topPanel.add(btnAdd);
 
		// Employee Grid Panel
		mainPanel.add(topPanel, BorderLayout.NORTH);
 
		return mainPanel;
	}
 
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			AddAdmin1 view = new AddAdmin1();
			view.setVisible(true);
		});
	}
}