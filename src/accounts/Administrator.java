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
    public JPanel currentPanel;
    public JPanel loginPanel;  
    public JLabel titleLabel;
    public JLabel promptLabel;
    public JLabel userNameLabel;
    public JTextField userNameField;
    public JLabel passWordLabel;
    public JPasswordField passWordField;
    public JButton loginButton;
    public JLabel message;

    public Administrator(){
        currentPanel = new JPanel(new FlowLayout());
        currentPanel.setBackground(new Commons().BLUE);
        buildLoginPanel();
        currentPanel.add(loginPanel);
    }

	public void signUp(){
		System.out.print(adminID + " " + adminPassword);
	}

	public void signIn(){
        System.out.println("function called");
		if (adminPassword.equals("") || adminID.equals("")) {
            message.setText("Please fill in all text fields.");
        }

        else {
            try {
                String myDriver = "com.mysql.cj.jdbc.Driver";
                String myUrl = "jdbc:mysql://localhost:3306/booxchange";
                Class.forName(myDriver);
                Connection conn = DriverManager.getConnection(myUrl, "root", "");
                Statement st = conn.createStatement();
                String query = "SELECT * FROM adminstrators WHERE adminID = " + adminID + ";";
                ResultSet rs = st.executeQuery(query);
                System.out.println("first trial");

                if (!rs.next()) {
                    message.setText("No admin with that username.");
                }

                else {
                    query = "SELECT * FROM adminstrators WHERE adminID = " + adminID + ";";
                    rs = st.executeQuery(query);
                    System.out.println("first else");
                    System.out.println(adminID);
                    System.out.println(adminPassword);
                    String databasePassword = "";
                    while (rs.next()) {
                        databasePassword = rs.getString(7);
                    }
                    if (!databasePassword.equals(adminPassword)) {
                        message.setText("The password is incorrect.");
                    }

                    else {
                        System.out.println("secont else");
                        query = "SELECT * FROM adminstrators WHERE adminID=" + adminID + ";";
                        rs = st.executeQuery(query);
                        message.setText("we're gon be successfull!");
                        while (rs.next()){
                            String name = rs.getString("name");
                            System.out.println(name);
                            int age = rs.getInt("age");

                            Gender gender = new Gender(rs.getString(4));
                            long phone = rs.getInt("phone");
                            String email = rs.getString("email");
                            String profilePassword = rs.getString("password");
                            System.out.println(profilePassword);
                            AdminProfile admin = new AdminProfile(name, age, gender, phone, email, new Picture(""), profilePassword);
                            System.out.println("adminachin");
                            currentPanel.remove(loginPanel);
                            currentPanel.add(admin.currentPanel);
                            currentPanel.repaint();
                            currentPanel.revalidate();
                            break;
                        }
                        
                    }
                }
            }

            catch (Exception e) {
                message.setText("try again");
            }
        }
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