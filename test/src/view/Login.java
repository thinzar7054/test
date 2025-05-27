package view;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtUserName;
    private JTextField txtPassword;
    private JLabel lblMessage;  // Added a label to display the message

    /**
     * Launch the application.
     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    Login frame = new Login();
//                    frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

    public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			Login view = new Login();
			view.setVisible(true);
		});
	}
    /**
     * Create the frame.
     */
    public Login() {
    	setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 651, 476);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("EmployeeDirectory");
        lblNewLabel.setBounds(228, 120, 121, 21);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Username");
        lblNewLabel_1.setBounds(102, 184, 90, 21);
        contentPane.add(lblNewLabel_1);
        
        txtUserName = new JTextField();
        txtUserName.setBounds(226, 185, 178, 28);
        contentPane.add(txtUserName);
        txtUserName.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("Password");
        lblNewLabel_2.setBounds(102, 255, 90, 13);
        contentPane.add(lblNewLabel_2);
        
        txtPassword = new JTextField();
        txtPassword.setBounds(228, 249, 176, 28);
        contentPane.add(txtPassword);
        txtPassword.setColumns(10);
        
        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = txtUserName.getText();
                String password = txtPassword.getText();  // Capture password text

                // Check credentials
                if ("admin".equals(username) && "password123".equals(password)) {
                    lblMessage.setText("Login Successful!");  // Show success message
                } else {
                    lblMessage.setText("Invalid username or password!");  // Show error message
                }
            }
        });
        btnLogin.setBounds(268, 361, 91, 21);
        contentPane.add(btnLogin);
        btnLogin.addActionListener(e ->{
        	new EmpDashboardAdminView().setVisible(true);
        	dispose();
        }
        );
        
        // Label to show messages (login result)
        lblMessage = new JLabel("");
        lblMessage.setBounds(226, 305, 204, 28);
        contentPane.add(lblMessage);
        
      //  ImageIcon icon = new ImageIcon(getClass().getResource("C:\\OJTProject\\image\\icon.jfif"));
        
		// Scale image to desired size (e.g., 100x100)
		//Image img = icon.getImage().getScaledInstance(120, 100, Image.SCALE_SMOOTH);
		//icon = new ImageIcon(img);
 
    }
}
