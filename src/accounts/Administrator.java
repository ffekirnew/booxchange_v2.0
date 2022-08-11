package accounts;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import profiles.*;
import datatypes.*;
import gui.*;
import gui.modifiedcomponents.*;

public class Administrator implements AccountActions {
	
	public String adminPassword;
	public String adminID;
	public JFrame frame;
    public JPanel loginPanel;  
    public JLabel titleLabel;
    public JLabel promptLabel;
    public JLabel userNameLabel;
    public JTextField userNameField;
    public JLabel passWordLabel;
    public JPasswordField passWordField;
    public JButton loginButton;
    public JLabel message;

	public void signUp(){
		System.out.print(adminID + " " + adminPassword);
	}

	public void signIn(){
		if (adminPassword.equals("") || adminID.equals("")) {
            message.setText("Please fill in all text fields.");
        }

        else {
            try {
                Connection conn = DriverManager.getConnection("jdbc:mysql://Booxchange:19112/administrators", "User", "Booxchange!2345678");
                Statement st = conn.createStatement();
                String query = "SELECT * FROM administrators WHERE admin_uid='" + adminID + "';";
                ResultSet rs = st.executeQuery(query);

                if (!rs.next()) {
                    message.setText("No admin with that username.");
                }

                else {
                    query = "SELECT password FROM administrators WHERE adminID = '" + adminID + "';";
                    rs = st.executeQuery(query);

                    if (rs.getString(1) != adminPassword) {
                        message.setText("The password is incorrect.");
                    }

                    else {
                        query = "SELECT * FROM administrators WHERE admin_id='" + adminID + "';";
                        rs = st.executeQuery(query);

                        String name = rs.getString(2);
                        int age = Integer.parseInt(rs.getString(3));
                        Gender gender = new Gender(rs.getString(4));
                        long phone = Integer.parseInt(rs.getString(5));
                        String email = rs.getString(6);
                        Picture profilePicture = new Picture(rs.getString(8));
                        String profilePassword = rs.getString(7);
                        AdminProfile admin = new AdminProfile(name, age, gender, phone, email, profilePicture, profilePassword);
                    }
                }
            }

            catch (SQLException e) {
                message.setText("try again");
            }
        }
	}

	public void forgotPassword(){
		int a = 5; 
        // this will allow the administrator to request to change their passwords
	}

	public void signOut(){
		int a = 5;
	}

    public static void main(String[] args) {
        
    }

    public void buildLoginPanel() {
        // create the loginPanel
        loginPanel = new JPanel();

        // set background color
        loginPanel.setBackground(new Commons().BLUE);

        //construct components
        titleLabel = new CLabel (new Commons().APPNAME, 50);
        promptLabel = new CLabel ("Admin Login", 20);
        userNameLabel = new CLabel ("Username:", 15);
        userNameField = new JTextField();
        passWordLabel = new CLabel ("Password:", 15);
        passWordField = new JPasswordField();
        loginButton = new FButton ("Login", 20);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adminID = userNameField.getText();
                adminPassword = passWordField.getText();
                signIn();
            }
        });
        message = new CLabel("", 12);

        //adjust size and set layout
        loginPanel.setPreferredSize (new Dimension (500, 700));
        loginPanel.setLayout (null);

        //add components
        loginPanel.add(titleLabel);
        loginPanel.add(promptLabel);
        loginPanel.add(userNameLabel);
        loginPanel.add(userNameField);
        loginPanel.add(passWordLabel);
        loginPanel.add(passWordField);
        loginPanel.add(loginButton);
        loginPanel.add(message);

        //set component bounds (only needed by Absolute Positioning)
        titleLabel.setBounds (0, 50, 500, 100);
        promptLabel.setBounds (100, 250, 300, 50);
        userNameLabel.setBounds (100, 350, 150, 30);
        userNameField.setBounds (250, 350, 150, 30); 
        passWordLabel.setBounds (100, 400, 150, 30);
        passWordField.setBounds (250, 400, 150, 30);
        loginButton.setBounds (200, 450, 100, 30);
        message.setBounds(100, 500, 300, 30);
    }
}