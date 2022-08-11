package accounts;

import java.sql.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import gui.*;
import gui.modifiedcomponents.*;
import datatypes.*;
import profiles.*;

public class User implements AccountActions {
	
    public String userName;
    public String name;
    public int age = 0;
    public Gender gender;
    public int phone = 0;
    public String email;
    public String password;
    public String confirm;
    public String adminID;
    public JPanel currentPanel;
    public JPanel loginPanel;
    public JPanel signupPanel;
    public JLabel message;

    public User() {
        currentPanel = new JPanel(new FlowLayout());
        buildLoginPanel();
        buildSignUpPanel();
        currentPanel.add(loginPanel);
    }
	
	public void signUp(){
        if (name.equals("") || age == 0 || gender.toString().equals("") || phone == 0 || email.equals("") || password.equals("") || confirm.equals(""))
            message.setText("Please fill in all text fields.");

        else
        {
            if (!password.equals(confirm))
                message.setText("The passwords you entered don't match.");

            else
            {
                if(true)// regex)
                    message.setText("The email you entered is not a valid email.");

                else
                {
                    try {
                        Connection conn = DriverManager.getConnection("jdbc:mysql://Booxchange:19112/users", "User", "Booxchange!2345678");
                        Statement st = conn.createStatement();
                        String query = "SELECT * FROM users WHERE userID ='" + userName + "';";
                        ResultSet rs = st.executeQuery(query);
                        if (!rs.next())
                            message.setText("There is a user with that same user name.");

                        else
                        {
                            // insertion into the database happens here
                        }
                    } 
                    catch (SQLException e) {
                        System.out.print(e.getMessage());
                    }

                }
            }
        }
    }
	
	public void signIn(){
		if (password.equals("") || userName.equals("")) {
            message.setText("Please fill in all text fields.");
        }

        else {
            try {
                Connection conn = DriverManager.getConnection("jdbc:mysql://Booxchange:19112/users", "User", "Booxchange!2345678");
                Statement st = conn.createStatement();
                String query = "SELECT * FROM users WHERE userID ='" + userName + "';";
                ResultSet rs = st.executeQuery(query);

                if (!rs.next()) {
                    message.setText("No user with that username.");
                }

                else {
                    query = "SELECT password FROM users WHERE userID = '" + userName + "';";
                    rs = st.executeQuery(query);

                    if (rs.getString(1) != password) {
                        message.setText("The password is incorrect.");
                    }

                    else {
                        query = "SELECT * FROM users WHERE userID ='" + userName + "';";
                        // some query processing happens here
                        String name = rs.getString(2);
                        int age = Integer.parseInt(rs.getString(3));
                        Gender gender = new Gender(rs.getString(4));
                        int phone = Integer.parseInt(rs.getString(5));
                        String email = rs.getString(6);
                        Picture profilePicture = new Picture("");
                        String profilePassword = rs.getString(7);
                        UserProfile admin = new UserProfile(name, age, gender, phone, email, profilePicture, profilePassword);
                    }
                }
            }

            catch (SQLException e) {
                message.setText("try again");
            }
        }
	}
	
	public void forgotPassword(){
		System.out.println("this is a huge mistake");
	}
	
	public void signOut(){
		System.out.println("this is a huge mistake");
	}

    public void buildLoginPanel() {

        loginPanel = new JPanel();

        // set background color
        loginPanel.setBackground(new Commons().BLUE);

        //construct components
        JLabel titleLabel = new CLabel ("Booxchange", 50);
        JLabel promptLabel = new CLabel ("User Login", 20);
        JLabel userNameLabel = new CLabel ("Username:", 15);
        JTextField userNameField = new JTextField();
        JLabel passWordLabel = new CLabel ("Password:", 15);
        JPasswordField passWordField = new JPasswordField();
        message = new CLabel("", 12);
        JButton loginButton = new FButton ("Login", 20);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userName = userNameField.getText();
                password = passWordField.getText();
                signIn();
            }
        });
        JLabel footerPrompt = new CLabel ("Don't have an account?", 12);
        JButton signUpButton = new FButton ("Sign up", 12);
        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentPanel.remove(loginPanel);
                currentPanel.add(signupPanel);
                currentPanel.revalidate();
                currentPanel.repaint();
            }
        });

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
        loginPanel.add(footerPrompt);
        loginPanel.add(signUpButton);

        //set component bounds (only needed by Absolute Positioning)
        titleLabel.setBounds (0, 50, 500, 100);
        promptLabel.setBounds (100, 250, 300, 50);
        userNameLabel.setBounds (100, 350, 150, 30);
        userNameField.setBounds (250, 350, 150, 30); 
        passWordLabel.setBounds (100, 400, 150, 30);
        passWordField.setBounds (250, 400, 150, 30);
        loginButton.setBounds (200, 450, 100, 30);
        message.setBounds (200, 500, 100, 30);
        footerPrompt.setBounds (100, 650, 150, 25);
        signUpButton.setBounds (255, 650, 100, 25);
    }

    public void buildSignUpPanel() {

        signupPanel = new JPanel();

        // set background color
        signupPanel.setBackground(new Commons().BLUE);

        //construct components
        JLabel titleLabel = new CLabel ("Booxchange", 50);
        JLabel promptLabel = new CLabel ("User Registration", 20);

        JLabel nameLabel = new LLabel ("Name", 15);
        JLabel ageLabel = new LLabel ("Age", 15);
        JLabel genderLabel = new LLabel ("Gender", 15);
        JLabel phoneLabel = new LLabel("Phone", 15);
        JLabel phoneStartLabel = new LLabel("+251 9", 15);
        JLabel emailLabel = new LLabel("Email", 15);
        JLabel passWordLabel = new LLabel("Passoword", 15); 
        JLabel confirmPassWordLabel = new LLabel("Confirm Password", 15);

        JTextField nameField = new JTextField();
        JTextField ageField = new JTextField();
        //Make the combo box
        final String[] genderComboBoxItems = {"Female", "Male"};
        JComboBox genderComboBox = new JComboBox (genderComboBoxItems);
        JTextField phoneField = new JTextField();
        JTextField emailField = new JTextField();
        JPasswordField passWordField = new JPasswordField();
        JPasswordField confirmPassWordField = new JPasswordField();

        JButton signupButton = new FButton("Sign Up!", 18);
        signupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userName = nameField.getText() + "123";
                name = nameField.getText();
                age = Integer.parseInt(ageField.getText());
                gender = new Gender("F"); //genderComboBox.getText()
                phone = Integer.parseInt(phoneField.getText());
                email = emailField.getText();
                password = passWordField.getText();
                confirm = confirmPassWordField.getText();
                signUp();
            }
        });
        JLabel footerPrompt = new CLabel ("Already have an account?", 12);
        JButton logInButton = new FButton ("Log in", 12);
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPanel.remove(signupPanel);
                currentPanel.add(loginPanel);
                currentPanel.revalidate();
                currentPanel.repaint();
            }
        });

        //adjust size and set layout
        signupPanel.setPreferredSize (new Dimension (500, 700));
        signupPanel.setLayout (null);

        //add components
        signupPanel.add(titleLabel);
        signupPanel.add(promptLabel);
        //--------------------------
        signupPanel.add(nameLabel);
        signupPanel.add(ageLabel);
        signupPanel.add(genderLabel);
        signupPanel.add(genderComboBox);
        signupPanel.add(phoneLabel);
        signupPanel.add(phoneStartLabel);
        signupPanel.add(emailLabel);
        signupPanel.add(passWordLabel);
        signupPanel.add(confirmPassWordLabel);
        //--------------------------
        signupPanel.add(nameField);
        signupPanel.add(ageField);
        signupPanel.add(genderComboBox);
        signupPanel.add(phoneField);
        signupPanel.add(emailField);
        signupPanel.add(passWordField);
        signupPanel.add(confirmPassWordField);
        //--------------------------
        signupPanel.add(signupButton);
        signupPanel.add(footerPrompt);
        signupPanel.add(logInButton);

        //set component bounds (only needed by Absolute Positioning)
        titleLabel.setBounds (0, 50, 500, 100);
        promptLabel.setBounds (100, 200, 300, 50);
        //--------------------------
        nameLabel.setBounds(75, 250, 175, 20);
        ageLabel.setBounds(75, 275, 175, 20);
        genderLabel.setBounds(75, 300, 175, 20);
        phoneLabel.setBounds(75, 325, 125, 20);
        phoneStartLabel.setBounds(150, 325, 50, 20);
        emailLabel.setBounds(75, 350, 175, 20);
        passWordLabel.setBounds(75, 375, 175, 20);
        confirmPassWordLabel.setBounds(75, 400, 175, 20);
        //--------------------------
        nameField.setBounds(250, 250, 175, 20);
        ageField.setBounds(250, 275, 175, 20);
        genderComboBox.setBounds(250, 300, 175, 20);
        phoneField.setBounds(250, 325, 175, 20);
        emailField.setBounds(250, 350, 175, 20);
        passWordField.setBounds(250, 375, 175, 20);
        confirmPassWordField.setBounds(250, 400, 175, 20);
        //--------------------------
        signupButton.setBounds (150, 450, 200, 50);
        footerPrompt.setBounds (100, 650, 150, 25);
        logInButton.setBounds (255, 650, 100, 25);
    }
	
}