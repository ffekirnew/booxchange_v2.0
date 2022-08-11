package profiles;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import datatypes.*;
import books.*;
import java.sql.*;
import gui.*;
import gui.modifiedcomponents.*;

public class UserProfile extends Profile implements DatabaseHandler {

	public JPanel currentPanel;
	public JPanel enlistedBooksPanel;
	public JPanel enlistingPanel;
	public JPanel searchPanel;
	public JPanel reportPanel;
	public JPanel frontPanel;

	public UserProfile(String name, int age, Gender gender, long phone, String email, Picture profilePicture, String profilePassword) {
		super(name, age, gender, phone, email, profilePicture, profilePassword);
		currentPanel = new JPanel(new FlowLayout());
	    buildFrontPanel();
	    currentPanel.add(frontPanel);
	}
	
	public void enlistBook(int bookID) {
		// Book newEnlist = new EnlistingRequest(bookName, authorName, yearOfPublication, genre, isAvailable, isAccepted, requesterID, createdDate, enlistingID);
		// this  is where the data will be written to the database
	}
	public boolean requestBook(){
		// Book newRequest = OfferingRequest(bookName, authorName, yearOfPublication, genre, isAvailable, isAccepted, requesterID, createdDate, offeringID, requestedDate);
		// this is where the data will be written to the database
		return true;
	}
	public boolean reportUser() {
		// Report report = new Report(repoter, reported, reason);
		// this is where the report will be sent to the database
		return true;
	}
	public boolean search(){
		// this will primarily be a place to query the database
		return true;
	}

	public void create(){
		// this.QUERY = "INSERT INTO users " + request;
		// try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		  //        Statement statement = conn.createStatement();
		  //        ResultSet result = statement.executeQuery(QUERY);) {
		  //        // Extract data from result set
		  //        while (result.next()) {
		  //           // Retrieve by column name
		  //           System.out.print("ID: " + result.getInt("id"));
		  //           System.out.print(", Age: " + result.getInt("name"));
		  //        }
		  //     } 

		  //     catch (SQLException e) {
		  //        e.printStackTrace();
		  //     }
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

		JLabel titleLabel = new CLabel ("Booxchange", 50);
	    JLabel promptLabel = new CLabel (("Welcome back, " + name + "."), 20);
	    JButton enlistedButton = new FButton ("Enlisted Books", 15);
        enlistedButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	buildEnlistedBooksPanel();
                currentPanel.remove(frontPanel);
                currentPanel.add(enlistedBooksPanel);
                currentPanel.revalidate();
                currentPanel.repaint();
            }
        });
	    JButton requestButton = new FButton ("Request Books", 15);
        requestButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentPanel.remove(frontPanel);
            	buildEnlistPanel();
                currentPanel.add(enlistingPanel);
                currentPanel.revalidate();
                currentPanel.repaint();
            }
        });
	    JButton searchButton = new FButton ("Search Books", 15);
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	buildSearchPanel();
                currentPanel.remove(frontPanel);
                currentPanel.add(searchPanel);
                currentPanel.revalidate();
                currentPanel.repaint();
            }
        });
	    JButton reportButton = new FButton ("Report User", 15);
        reportButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	buildReportPanel();
            	currentPanel.remove(frontPanel);
                currentPanel.add(reportPanel);
                currentPanel.revalidate();
                currentPanel.repaint();
            }
        });
	    JLabel footerPrompt = new CLabel ("Wanna know more?", 12);
	    JButton aboutUsButton = new FButton ("About Us.", 12);

        //adjust size and set layout
        frontPanel.setPreferredSize (new Dimension (500, 700));
        frontPanel.setLayout (null);

        //add components
        frontPanel.add(titleLabel);
        frontPanel.add(promptLabel);
        frontPanel.add(enlistedButton);
        frontPanel.add(requestButton);
        frontPanel.add(searchButton);
        frontPanel.add(reportButton);
        frontPanel.add(footerPrompt);
        frontPanel.add(aboutUsButton);

        //set component bounds (only needed by Absolute Positioning)
        titleLabel.setBounds (0, 50, 500, 100);
        promptLabel.setBounds (100, 150, 300, 50);
        enlistedButton.setBounds (100, 250, 150, 150);
        requestButton.setBounds (250, 250, 150, 150);
        searchButton.setBounds (100, 400, 150, 150);
        reportButton.setBounds (250, 400, 150, 150);
        footerPrompt.setBounds (0, 650, 250, 25);
        aboutUsButton.setBounds (255, 650, 100, 25);	
	}

	public void buildEnlistPanel(){
		enlistingPanel = new JPanel();

		// set background color
		enlistingPanel.setBackground(new Commons().BLUE);

		//construct components
		JLabel titleLabel = new CLabel("Request Books", 30);
	    JLabel promptLabel = new CLabel ("Fill the following list...", 15);
	    JLabel bookNameLabel = new LLabel ("Book Name", 15);
	    JTextField bookNameField = new JTextField (5);
	    JLabel purchaseYearLabel = new LLabel ("Preferable Purchase Year", 15);
	    JTextField purchaseYearTextField;purchaseYearTextField = new JTextField (5);
	    JTextField releaseTextField = new JTextField (5);
	    JLabel releaseLabel = new LLabel ("Release Year", 15);
	    JLabel authorNameLabel = new LLabel ("Author Name", 15);
	    JTextField authorNameTextField;authorNameTextField = new JTextField (5);
	    JButton submitButton = new FButton ("Submit", 18);
	    JLabel footerQuestionLabel = new CLabel("If you are done", 12);
	    JButton backButton = new FButton("Go back", 12);        
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentPanel.remove(reportPanel);
                currentPanel.add(frontPanel);
                currentPanel.revalidate();
                currentPanel.repaint();
            }
        });

        //adjust size and set layout
        enlistingPanel.setPreferredSize (new Dimension (500, 700));
        enlistingPanel.setLayout (null);

        //add components
        enlistingPanel.add(titleLabel);
        enlistingPanel.add(promptLabel);
        enlistingPanel.add(bookNameLabel);
        enlistingPanel.add(bookNameField);
        enlistingPanel.add(purchaseYearLabel);
        enlistingPanel.add(purchaseYearTextField);
        enlistingPanel.add(releaseTextField);
        enlistingPanel.add(releaseLabel);
        enlistingPanel.add(authorNameLabel);
        enlistingPanel.add(authorNameTextField);
        enlistingPanel.add(submitButton);
        enlistingPanel.add(footerQuestionLabel);
        enlistingPanel.add(backButton);

        //set component bounds (only needed by Absolute Positioning)
        titleLabel.setBounds (0, 25, 500, 50);
        promptLabel.setBounds (100, 200, 300, 50);
        //------------------------------------------------
        bookNameLabel.setBounds (75, 250, 175, 20);
        purchaseYearLabel.setBounds (75, 275, 175, 20);
        releaseLabel.setBounds (75, 300, 175, 20);
        authorNameLabel.setBounds (75, 325, 175, 20);
        bookNameField.setBounds (250, 250, 175, 20);
        purchaseYearTextField.setBounds (250, 275, 175, 20);
        releaseTextField.setBounds (250, 300, 175, 20);
        authorNameTextField.setBounds (250, 325, 175, 20);
        submitButton.setBounds (250, 350, 100, 20);
        //------------------------------------------------
        footerQuestionLabel.setBounds (0, 650, 250, 25);
        backButton.setBounds (255, 650, 100, 25);
	}

	public void buildSearchPanel() {

		searchPanel = new JPanel();

		// set background color
		searchPanel.setBackground(new Commons().BLUE);

	    // construct pre components
        String[] resultsListItems = {"Item 1", "Item 2", "Item 3", "Item 1", "Item 2", "Item 3", "Item 1", "Item 2", "Item 3", "Item 1", "Item 2", "Item 3", "Item 1", "Item 2", "Item 3", "Item 1", "Item 2", "Item 3", "Item 1", "Item 2", "Item 3", "Item 1", "Item 2", "Item 3"};

        //construct components
		JLabel titleLabel = new CLabel("Search Books", 30);
	    JTextField searchTextField = new JTextField ("Search here...");
	    JButton searchButton = new JButton ("Search");
	    JLabel resultsLabel = new CLabel("Results: ", 15);
	    JList resultsList = new JList(resultsListItems);
	    JScrollPane resultsScrollPane = new JScrollPane();
	    resultsScrollPane.setViewportView(resultsList);
	    JLabel footerQuestionLabel = new CLabel("Didn't find what you were looking for?", 12);
	    JButton backButton = new FButton("Go back", 12);
		backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentPanel.remove(searchPanel);
                currentPanel.add(frontPanel);
                currentPanel.revalidate();
                currentPanel.repaint();
            }
        });

        //adjust size and set layout
        searchPanel.setPreferredSize (new Dimension (500, 700));
        searchPanel.setLayout (null);

        //add components
        searchPanel.add(titleLabel);
        searchPanel.add(searchTextField);
        searchPanel.add(searchButton);
        searchPanel.add(resultsLabel);
        searchPanel.add(resultsScrollPane);
        searchPanel.add(footerQuestionLabel);
        searchPanel.add(backButton);

        //set component bounds (only needed by Absolute Positioning)
        titleLabel.setBounds (0, 25, 500, 50);
        searchTextField.setBounds (100, 100, 225, 25);
        searchButton.setBounds (325, 100, 75, 25);
        resultsLabel.setBounds (100, 150, 300, 30);
        resultsScrollPane.setBounds(100, 180, 300, 450);
        footerQuestionLabel.setBounds (0, 650, 250, 25);
        backButton.setBounds (255, 650, 100, 25);
	}

	public void buildReportPanel() {
		reportPanel = new JPanel();

		// set background color
		reportPanel.setBackground(new Commons().BLUE);

		//construct components
		JLabel titleLabel = new CLabel("Report User", 30);
	    JLabel promptLabel = new CLabel ("Fill the following list...", 15);
	    JLabel userIDLabel = new LLabel ("userID", 15);
	    JTextField userIDTextField = new JTextField (5);
	    JLabel reasonLabel = new LLabel ("Reason (<100)", 15);
	    JTextArea reasonTextArea = new JTextArea (5, 5);
	    JButton submitButton = new JButton ("Submit Report");
	    submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
	    JLabel footerQuestionLabel = new CLabel("Done Here?", 12);
	    JButton backButton = new FButton("Go back", 12);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentPanel.remove(reportPanel);
                currentPanel.add(frontPanel);
                currentPanel.revalidate();
                currentPanel.repaint();
            }
        });

        //adjust size and set layout
        reportPanel.setPreferredSize (new Dimension (500, 700));
        reportPanel.setLayout (null);

        //add components
        reportPanel.add(titleLabel);
        reportPanel.add(promptLabel);
        reportPanel.add(userIDLabel);
        reportPanel.add(userIDTextField);
        reportPanel.add(reasonLabel);
        reportPanel.add(reasonTextArea);
        reportPanel.add(submitButton);
        reportPanel.add(footerQuestionLabel);
        reportPanel.add(backButton);

        //set component bounds (only needed by Absolute Positioning)
        titleLabel.setBounds (0, 25, 500, 50);
        promptLabel.setBounds (100, 75, 300, 30);
        userIDLabel.setBounds (50, 120, 150, 25);
        reasonLabel.setBounds (50, 150, 150, 25);
        userIDTextField.setBounds (200, 120, 250, 25);
        reasonTextArea.setBounds (200, 150, 250, 250);
        submitButton.setBounds (150, 420, 200, 25);
        footerQuestionLabel.setBounds (0, 650, 250, 25);
        backButton.setBounds (255, 650, 100, 25);
	}

	public void buildEnlistedBooksPanel() {
		enlistedBooksPanel = new JPanel();

		// set background color
		enlistedBooksPanel.setBackground(new Commons().BLUE);

	    //construct preComponents
        String[] allListItems = {"Item 1", "Item 2", "Item 3", "Item 1", "Item 2", "Item 3", "Item 1", "Item 2", "Item 3", "Item 1", "Item 2", "Item 3", "Item 1", "Item 2", "Item 3", "Item 1", "Item 2", "Item 3", "Item 1", "Item 2", "Item 3", "Item 1", "Item 2", "Item 3"};
        String[] nearByListItems = {"Item 1", "Item 2", "Item 3", "Item 1", "Item 2", "Item 3", "Item 1", "Item 2", "Item 3", "Item 1", "Item 2", "Item 3", "Item 1", "Item 2", "Item 3", "Item 1", "Item 2", "Item 3", "Item 1", "Item 2", "Item 3", "Item 1", "Item 2", "Item 3"};

        //construct components
		JLabel titleLabel = new CLabel("Enlisted Books", 30);
	    JLabel promptLabel = new CLabel("Today's Picks: ", 15);
	    JList allList = new JList(allListItems);
	    JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(allList);
	    JLabel promptLabel2 = new CLabel("Near by to you: ", 15);
	    JList nearByList = new JList(nearByListItems);
	    JScrollPane scrollPane2 = new JScrollPane();
        scrollPane2.setViewportView(nearByList);
	    JLabel footerQuestionLabel = new CLabel("Didn't find what you were looking for?", 12);
	    JButton backButton = new FButton("Go back", 12);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPanel.remove(enlistedBooksPanel);
                currentPanel.add(frontPanel);
                currentPanel.revalidate();
                currentPanel.repaint();
            }
        });

        //adjust size and set layout
        enlistedBooksPanel.setPreferredSize (new Dimension (500, 700));
        enlistedBooksPanel.setLayout (null);

        //add components
        enlistedBooksPanel.add(titleLabel);
        enlistedBooksPanel.add(promptLabel);
        enlistedBooksPanel.add(scrollPane);
        enlistedBooksPanel.add(promptLabel2);
        enlistedBooksPanel.add(scrollPane2);
        enlistedBooksPanel.add(footerQuestionLabel);
        enlistedBooksPanel.add(backButton);

        //set component bounds (only needed by Absolute Positioning)
        titleLabel.setBounds (0, 25, 500, 50);
        promptLabel.setBounds (100, 80, 300, 30);
        scrollPane.setBounds(100, 115, 300, 225);
        promptLabel2.setBounds (100, 370, 300, 30);
        scrollPane2.setBounds(100, 400, 300, 225);
        footerQuestionLabel.setBounds (0, 650, 250, 25);
        backButton.setBounds (255, 650, 100, 25);
	}
}