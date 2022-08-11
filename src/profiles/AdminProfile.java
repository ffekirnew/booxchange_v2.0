package profiles;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import datatypes.*;
import gui.*;
import gui.modifiedcomponents.*;
import accounts.*;

public class AdminProfile extends Profile implements DatabaseHandler {
	
	public JPanel addAdminPanel;
	public JPanel enlistingRequestsPanel;
	public JPanel searchUserPanel;
	public JPanel reportsPanel;
	public JPanel banUserPanel;
	public JPanel currentPanel;
	public JPanel frontPanel;

	// Constructor
	public AdminProfile(String name, int age, Gender gender, long phone, String email, Picture profilePicture, String profilePassword){
		super(name, age, gender, phone, email, profilePicture, profilePassword);
		currentPanel = new JPanel(new FlowLayout());
currentPanel.setBackground(new Commons().BLUE);
	    buildFrontPanel();
	    currentPanel.add(frontPanel);
	}

	public boolean banUser(Profile profile){
		// this should note and archive a users profile into a file and delete the user from the database
		return true;
	}

	public boolean approveEnlisting(){
		// this method should allow the administrator to approve an enlisted book
		return true;
	}

	public boolean approveRequest(){
		// this method should allow the administrator to approve a requested book
		return true;
	}

	public boolean checkUserActivity(Report report){
		// this method should return all information about a user
		return true;
	}

	public boolean addRoom(){
		//
		return true;
	}

	// these methods should allow the administrator to change the states of the database
	public void create(){

	}

	public void read(){

	}

	public void update(){

	}

	public void delete(){

	}

	public void buildFrontPanel() {
		frontPanel = new JPanel();

	    frontPanel.setBackground(new Commons().BLUE);

	    //construct components
		JLabel titleLabel = new CLabel ("Administrator", 30);
	    JButton enlistingRequestButton = new FButton ("Enlisting Requests", 15);
        enlistingRequestButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	buildEnlistingRequestsPanel();
                currentPanel.remove(frontPanel);
                currentPanel.add(enlistingRequestsPanel);
                currentPanel.revalidate();
                currentPanel.repaint();
            }
        });
	    JButton addAdminButton = new FButton ("Add another Admin", 15);
        addAdminButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	buildAddAdminPanel();
                currentPanel.remove(frontPanel);
                currentPanel.add(addAdminPanel);
                currentPanel.revalidate();
                currentPanel.repaint();
            }
        });
	    JButton reportsButton = new FButton ("Reports", 15);
        reportsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	buildReportsPanel();
                currentPanel.remove(frontPanel);
                currentPanel.add(reportsPanel);
                currentPanel.revalidate();
                currentPanel.repaint();
            }
        });
	    JButton banButton = new FButton ("Ban User - Report on User", 15);
        banButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	buildBanUserPanel();
                currentPanel.remove(frontPanel);
                currentPanel.add(banUserPanel);
                currentPanel.revalidate();
                currentPanel.repaint();
            }
        });
	    JLabel backLabel = new CLabel ("Wanna use the system as a user?", 12);
	    JButton backButton = new FButton ("Log out.", 12);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentPanel.remove(frontPanel);
                User new_user = new User();
                currentPanel.add(new_user.currentPanel);
                currentPanel.revalidate();
                currentPanel.repaint();
            }
        });

        //adjust size and set layout
        frontPanel.setPreferredSize (new Dimension (500, 700));
        frontPanel.setLayout (null);

        //add components
        frontPanel.add(titleLabel);
        frontPanel.add(enlistingRequestButton);
        frontPanel.add(addAdminButton);
        frontPanel.add(reportsButton);
        frontPanel.add(banButton);
        frontPanel.add(backLabel);
        frontPanel.add(backButton);

        //set component bounds (only needed by Absolute Positioning)
        titleLabel.setBounds (0, 50, 500, 50);
        enlistingRequestButton.setBounds (150, 150, 200, 100);
        addAdminButton.setBounds (150, 250, 200, 100);
        reportsButton.setBounds (150, 350, 200, 100);
        banButton.setBounds (150, 450, 200, 100);
        backLabel.setBounds (0, 650, 250, 25);
        backButton.setBounds (255, 650, 100, 25);
	}

	public void buildEnlistingRequestsPanel() {
		enlistingRequestsPanel = new JPanel();

		// set background color
		enlistingRequestsPanel.setBackground(new Commons().BLUE);

		//construct preComponents
        String[] allListItems = {"Item 1", "Item 2", "Item 3", "Item 1", "Item 2", "Item 3", "Item 1", "Item 2", "Item 3", "Item 1", "Item 2", "Item 3", "Item 1", "Item 2", "Item 3", "Item 1", "Item 2", "Item 3", "Item 1", "Item 2", "Item 3", "Item 1", "Item 2", "Item 3"};

		//construct components
		JLabel titleLabel = new CLabel("Enlisting Requests", 30);
	    JLabel promptLabel = new CLabel("Here are the current requests: ", 15);
	    JList allList = new JList(allListItems);
	    JScrollPane allListScrollPane = new JScrollPane();
        allListScrollPane.setViewportView(allList);
	    JLabel footerQuestionLabel = new CLabel("Done here?", 12);
	    JButton backButton = new FButton("Go back", 12);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentPanel.remove(enlistingRequestsPanel);
                currentPanel.add(frontPanel);
                currentPanel.revalidate();
                currentPanel.repaint();
            }
        });

        //adjust size and set layout
        enlistingRequestsPanel.setPreferredSize(new Dimension (500, 700));
        enlistingRequestsPanel.setLayout(null);

        //add components
        enlistingRequestsPanel.add(titleLabel);
        enlistingRequestsPanel.add(promptLabel);
        enlistingRequestsPanel.add(allListScrollPane);
        enlistingRequestsPanel.add(footerQuestionLabel);
        enlistingRequestsPanel.add(backButton);

        //set component bounds (only needed by Absolute Positioning)
        titleLabel.setBounds (0, 25, 500, 50);
        promptLabel.setBounds (100, 80, 300, 30);
        allListScrollPane.setBounds(100, 120, 300, 400);
        footerQuestionLabel.setBounds (0, 650, 250, 25);
        backButton.setBounds (255, 650, 100, 25);
	}

	public void buildAddAdminPanel() {

		addAdminPanel = new JPanel();

		// set background color
		addAdminPanel.setBackground(new Commons().BLUE);

		//construct components
		JLabel titleLabel = new CLabel ("Booxchange", 50);
	    JLabel promptLabel = new CLabel ("Add Another Admin", 20);

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

	    JButton signupButton = new FButton("Add the admin", 18);

	    JLabel footerPrompt = new CLabel ("Done here?", 12);
	    JButton backButton = new FButton ("Go back", 12);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentPanel.remove(addAdminPanel);
                currentPanel.add(frontPanel);
                currentPanel.revalidate();
                currentPanel.repaint();
            }
        });

        //adjust size and set layout
        addAdminPanel.setPreferredSize(new Dimension (500, 700));
        addAdminPanel.setLayout(null);

        //add components
        addAdminPanel.add(titleLabel);
        addAdminPanel.add(promptLabel);
        //--------------------------
        addAdminPanel.add(nameLabel);
        addAdminPanel.add(ageLabel);
        addAdminPanel.add(genderLabel);
        addAdminPanel.add(genderComboBox);
        addAdminPanel.add(phoneLabel);
        addAdminPanel.add(phoneStartLabel);
        addAdminPanel.add(emailLabel);
        addAdminPanel.add(passWordLabel);
        addAdminPanel.add(confirmPassWordLabel);
        //--------------------------
        addAdminPanel.add(nameField);
        addAdminPanel.add(ageField);
        addAdminPanel.add(genderComboBox);
        addAdminPanel.add(phoneField);
        addAdminPanel.add(emailField);
        addAdminPanel.add(passWordField);
        addAdminPanel.add(confirmPassWordField);
        //--------------------------
        addAdminPanel.add(signupButton);
        addAdminPanel.add(footerPrompt);
        addAdminPanel.add(backButton);

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
        signupButton.setBounds (175, 450, 150, 30);
        footerPrompt.setBounds (100, 650, 150, 25);
        backButton.setBounds (255, 650, 100, 25);
	}

	public void buildReportsPanel() {
		reportsPanel = new JPanel();

		// set background color
		reportsPanel.setBackground(new Commons().BLUE);

		//construct preComponents
        String[] allListItems = {"Item 1", "Item 2", "Item 3", "Item 1", "Item 2", "Item 3", "Item 1", "Item 2", "Item 3", "Item 1", "Item 2", "Item 3", "Item 1", "Item 2", "Item 3", "Item 1", "Item 2", "Item 3", "Item 1", "Item 2", "Item 3", "Item 1", "Item 2", "Item 3"};

		//construct components
		JLabel titleLabel = new CLabel("User Reports", 30);
	    JLabel promptLabel = new CLabel("Here are the current reports: ", 15);
	    JList allList = new JList(allListItems);
	    JScrollPane allListScrollPane = new JScrollPane();
        allListScrollPane.setViewportView(allList);
	    JLabel footerQuestionLabel = new CLabel("Done here?", 12);
	    JButton backButton = new FButton("Go back", 12);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentPanel.remove(reportsPanel);
                currentPanel.add(frontPanel);
                currentPanel.revalidate();
                currentPanel.repaint();
            }
        });

        //adjust size and set layout
        reportsPanel.setPreferredSize(new Dimension (500, 700));
        reportsPanel.setLayout(null);

        //add components
        reportsPanel.add(titleLabel);
        reportsPanel.add(promptLabel);
        reportsPanel.add(allListScrollPane);
        reportsPanel.add(footerQuestionLabel);
        reportsPanel.add(backButton);

        //set component bounds (only needed by Absolute Positioning)
        titleLabel.setBounds (0, 25, 500, 50);
        promptLabel.setBounds (100, 80, 300, 30);
        allListScrollPane.setBounds(100, 120, 300, 400);
        footerQuestionLabel.setBounds (0, 650, 250, 25);
        backButton.setBounds (255, 650, 100, 25);
	}

	public void buildBanUserPanel() {

        banUserPanel = new JPanel();

        // set background color
        banUserPanel.setBackground(new Commons().BLUE);

        // construct pre components
        String[] resultsListItems = {"Item 1", "Item 2", "Item 3", "Item 1", "Item 2", "Item 3", "Item 1", "Item 2", "Item 3", "Item 1", "Item 2", "Item 3", "Item 1", "Item 2", "Item 3", "Item 1", "Item 2", "Item 3", "Item 1", "Item 2", "Item 3", "Item 1", "Item 2", "Item 3"};

        //construct components
        JLabel titleLabel = new CLabel("Ban User", 30);
        JTextField searchTextField = new JTextField ("Search here...");
        JButton searchButton = new JButton ("Search");
        JLabel resultsLabel = new CLabel("Report on User: ", 15);
        JList resultsList = new JList(resultsListItems);
        JScrollPane resultsScrollPane = new JScrollPane();
        resultsScrollPane.setViewportView(resultsList);
        JButton banUserButton = new FButton ("Ban User", 12);
        banUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        JLabel footerQuestionLabel = new CLabel("Done here?", 12);
        JButton backButton = new FButton("Go back", 12);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentPanel.remove(banUserPanel);
                currentPanel.add(frontPanel);
                currentPanel.revalidate();
                currentPanel.repaint();
            }
        });

        //adjust size and set layout
        banUserPanel.setPreferredSize (new Dimension (500, 700));
        banUserPanel.setLayout (null);

        //add components
        banUserPanel.add(titleLabel);
        banUserPanel.add(searchTextField);
        banUserPanel.add(searchButton);
        banUserPanel.add(resultsLabel);
        banUserPanel.add(resultsScrollPane);
        banUserPanel.add(banUserButton);
        banUserPanel.add(footerQuestionLabel);
        banUserPanel.add(backButton);

        //set component bounds (only needed by Absolute Positioning)
        titleLabel.setBounds (0, 25, 500, 50);
        searchTextField.setBounds (100, 100, 225, 25);
        searchButton.setBounds (325, 100, 75, 25);
        resultsLabel.setBounds (100, 150, 300, 30);
        resultsScrollPane.setBounds(100, 180, 300, 350);
        banUserButton.setBounds(200, 550, 100, 50);
        footerQuestionLabel.setBounds (0, 650, 250, 25);
        backButton.setBounds (255, 650, 100, 25);
    }
}
