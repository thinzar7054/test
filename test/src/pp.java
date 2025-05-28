public JPanel createAdminDetailsPanel() {
    JPanel mainPanel = new JPanel(new BorderLayout());
    mainPanel.setBackground(Color.lightGray);
 
    // Title Panel with left alignment
    JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Using FlowLayout for title alignment
    titlePanel.setBackground(Color.LIGHT_GRAY);
 
    JLabel titleLabel = new JLabel("Admin Details", SwingConstants.LEFT);
    titleLabel.setBorder(BorderFactory.createEmptyBorder(5, 180, 5, 10));
    titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
     
    titlePanel.add(titleLabel);
    mainPanel.add(titlePanel, BorderLayout.NORTH);
 
    // Form panel with a border and padding
    JPanel formPanel = new JPanel();
    formPanel.setLayout(null);  
    formPanel.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 10));
    formPanel.setBackground(Color.WHITE);
    
    // Adjust the form width based on the window size
    int formWidth = (int)(getWidth() * 0.6);  // 70% of the width
    int fieldWidth = formWidth - 60 ;  // Account for padding
   
 
	        // Field positioning
	        int labelHeight = 20;
	        int fieldHeight = 30;
	        int labelYSpacing = 9;
	        int groupSpacing = 15;
	        int currentY = 15;
	        int leftMargin = 30;
 
	        // Name Field
	        addFormField(formPanel, "Name:", leftMargin, currentY, fieldWidth, labelHeight, labelYSpacing);
	        nameField = createTextField();
	        nameField.setBounds(leftMargin, currentY + labelHeight + labelYSpacing, fieldWidth, fieldHeight);
	        formPanel.add(nameField);
	        currentY += labelHeight + labelYSpacing + fieldHeight + groupSpacing;
 
	        // Phone Field
	        addFormField(formPanel, "Phone Number:", leftMargin, currentY, fieldWidth, labelHeight, labelYSpacing);
	        txtPhoneNumber = createTextField();
	        txtPhoneNumber.setBounds(leftMargin, currentY + labelHeight + labelYSpacing, fieldWidth, fieldHeight);
	        formPanel.add(txtPhoneNumber);
	        currentY += labelHeight + labelYSpacing + fieldHeight + groupSpacing;
 
	        // Email Field
	        addFormField(formPanel, "Email:", leftMargin, currentY, fieldWidth, labelHeight, labelYSpacing);
	        txtEmail = createTextField();
	        txtEmail.setBounds(leftMargin, currentY + labelHeight + labelYSpacing, fieldWidth, fieldHeight);
	        formPanel.add(txtEmail);
	        currentY += labelHeight + labelYSpacing + fieldHeight + groupSpacing;
 
	        // Hiring Date Field
	        addFormField(formPanel, "Hiring Date:", leftMargin, currentY, fieldWidth, labelHeight, labelYSpacing);
	        txtHiringDate = createTextField();
	        txtHiringDate.setBounds(leftMargin, currentY + labelHeight + labelYSpacing, fieldWidth, fieldHeight);
	        formPanel.add(txtHiringDate);
	        currentY += labelHeight + labelYSpacing + fieldHeight + groupSpacing;
 
	        // Checkbox Fields
	        addFormField(formPanel, "Is Manager:", leftMargin, currentY, fieldWidth, labelHeight, labelYSpacing);
	        chkIsManager = createCheckBox();
	        chkIsManager.setBounds(leftMargin, currentY + labelHeight + labelYSpacing, fieldWidth, fieldHeight);
	        formPanel.add(chkIsManager);
	        currentY += labelHeight + labelYSpacing + fieldHeight + groupSpacing;
 
	        addFormField(formPanel, "Is Active:", leftMargin, currentY, fieldWidth, labelHeight, labelYSpacing);
	        chkIsActive = createCheckBox();
	        chkIsActive.setBounds(leftMargin, currentY + labelHeight + labelYSpacing, fieldWidth, fieldHeight);
	        formPanel.add(chkIsActive);
	        currentY += labelHeight + labelYSpacing + fieldHeight + groupSpacing;
 
	        addFormField(formPanel, "Is Accepted:", leftMargin, currentY, fieldWidth, labelHeight, labelYSpacing);
	        chkIsIsAgreement = createCheckBox();
	        chkIsIsAgreement.setBounds(leftMargin, currentY + labelHeight + labelYSpacing, fieldWidth, fieldHeight);
	        formPanel.add(chkIsIsAgreement);
	        currentY += labelHeight + labelYSpacing + fieldHeight + groupSpacing;
 
	        // Deparment  Field
	        addFormField(formPanel, "Deparment:", leftMargin, currentY, fieldWidth, labelHeight, labelYSpacing);
	        txtDepartment = createTextField();
	        txtDepartment.setBounds(leftMargin, currentY + labelHeight + labelYSpacing, fieldWidth, fieldHeight);
	        formPanel.add(txtDepartment);
	        currentY += labelHeight + labelYSpacing + fieldHeight + groupSpacing;
 
	        // Job Title Field
	        addFormField(formPanel, "Job Title:", leftMargin, currentY, fieldWidth, labelHeight, labelYSpacing);
	        txtJobTitle = createTextField();
	        txtJobTitle.setBounds(leftMargin, currentY + labelHeight + labelYSpacing, fieldWidth, fieldHeight);
	        formPanel.add(txtJobTitle);
	        currentY += labelHeight + labelYSpacing + fieldHeight + groupSpacing;
 
	     // Save Button
	        JButton saveButton = new JButton("Save");
	        saveButton.setFont(new Font("Arial", Font.BOLD, 14));
	        saveButton.setBounds(leftMargin, currentY,80, 35);
	        saveButton.setBackground(new Color(34,139,34));  
	        saveButton.setForeground(Color.WHITE);
	        saveButton.setBorder(BorderFactory.createEmptyBorder(5, 8, 5, 8));
	        saveButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
 
	        saveButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Here you can handle the save logic
	                // Example: Saving form data or displaying a success message
	                JOptionPane.showMessageDialog(AdminDetailsView.this, "Admin details saved successfully!");
	            }
	        });
 
	        formPanel.add(saveButton);
	       currentY += 35 + groupSpacing; // Adjust the currentY for the button height
 
	        
	        // Update form height
	        formPanel.setPreferredSize(new Dimension(formWidth, currentY+10));
 
	       // int formContainerHeight = currentY +30;
	     // Create a container panel to wrap the formPanel and manage scrolling
	        JPanel formContainer = new JPanel();
	       // formContainer.setPreferredSize(new Dimension(formWidth,));
	        formContainer.setBackground(Color.LIGHT_GRAY);
	        formContainer.add(formPanel);
 
	     // Add the scrollable container to the main panel
	        JScrollPane scrollPane = new JScrollPane(formContainer);
	        scrollPane.setBorder(BorderFactory.createEmptyBorder());
	        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	        scrollPane.getVerticalScrollBar().setUnitIncrement(40);  // Scroll speed
 
	        // Get the vertical and horizontal scrollbars from the JScrollPane
	        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
	        JScrollBar horizontalScrollBar = scrollPane.getHorizontalScrollBar();
 
	        // Set the preferred width/height for the scrollbars
	        verticalScrollBar.setPreferredSize(new Dimension(10, Integer.MAX_VALUE)); // 10px wide vertical scrollbar
	        horizontalScrollBar.setPreferredSize(new Dimension(Integer.MAX_VALUE, 10)); // 10px high horizontal scrollbar
 
	        // Optional: Set scrollbar background colors (this is customizable)
	        verticalScrollBar.setBackground(new Color(240, 240, 240)); // Light background color for vertical scrollbar
	        horizontalScrollBar.setBackground(new Color(240, 240, 240)); // Light background color for horizontal scrollbar
 
	        // Add the scrollPane to the mainPanel
	        mainPanel.add(scrollPane, BorderLayout.CENTER);
 
	        return mainPanel;
}
 
private void addFormField(JPanel panel, String labelText, int x, int y, int width, int height, int spacing) {
	        JLabel label = new JLabel(labelText);
	        label.setBounds(x, y, width, height);
	        panel.add(label);
	    }
 
	    private JTextField createTextField() {
	        JTextField field = new JTextField();
	        field.setEditable(true);
	        field.setBackground(Color.WHITE);
	        field.setBorder(BorderFactory.createCompoundBorder(
	            BorderFactory.createLineBorder(Color.LIGHT_GRAY),
	            BorderFactory.createEmptyBorder(5, 8, 5, 8)
	        ));
	        field.setFont(new Font("Arial", Font.PLAIN, 14));
	        return field;
	    }
 
	    private JCheckBox createCheckBox() {
	        JCheckBox checkBox = new JCheckBox();
	        checkBox.setEnabled(true);
	        checkBox.setBackground(Color.WHITE);
	        return checkBox;
	    }
 
	private JPanel panelWithLabel(String text) {
		JPanel panel = new JPanel();
		panel.add(new JLabel(text));
		return panel;
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
 
	    public void setAdminDetails(String name, String phone, String email, String hiringDate,
	                              boolean isManager, boolean isActive, boolean isAccepted,
	                              String jobTitle) {
	        nameField.setText(name);
	        txtPhoneNumber.setText(phone);
	        txtEmail.setText(email);
	        txtHiringDate.setText(hiringDate);
	        chkIsManager.setSelected(isManager);
	        chkIsActive.setSelected(isActive);
	        chkIsIsAgreement.setSelected(isAccepted);
	        txtJobTitle.setText(jobTitle);
	    }
 
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AdminDetailsView frame = new AdminDetailsView();
				frame.setVisible(true);
			}
		});
	}
}
 
 