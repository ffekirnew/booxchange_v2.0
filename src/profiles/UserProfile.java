package profiles;

import datatypes.*;
import books.*;
import java.sql.*;

public class UserProfile extends Profile implements DatabaseHandler {

	public JPanel currentPanel;
	public JPanel enlistedBooksPanel;
	public JPanel enlistingPanel;
	public JPanel searchPanel;
	public JPanel reportPanel;
	public JPanel frontPanel;

	public UserProfile(String name, int age, Gender gender, int phone, String email, Picture profilePicture, String profilePassword) {
		super(name, age, gender, phone, email, profilePicture, profilePassword);
		currentPanel = new JPanel(new FlowLayout());
	    buildEnlistPanel();
	    buildEnlistedBooksPanel();
	    buildSearchPanel();
	    buildReportPanel();
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

	    frontPanel..setBackground(new Customization().BLUE);

		JLabel titleLabel = new CLabel ("Booxchange", 50);
	    JLabel promptLabel = new CLabel ("What do you want to do?", 20);
	    JButton enlistedButton = new FButton ("Enlisted Books", 15);
        enlistedButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
                currentPanel.add(enlistingPanel);
                currentPanel.revalidate();
                currentPanel.repaint();
            }
        });
	    JButton searchButton = new FButton ("Search Books", 15);
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentPanel.remove(frontPanel);
                currentPanel.add(searchPanel);
                currentPanel.revalidate();
                currentPanel.repaint();
            }
        });
	    JButton reportButton = new FButton ("Report User", 15);
        reportButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
	}

	public void buildEnlistPanel(){

	}

	public void buildSearchPanel() {

	}

	public void buildReportPanel() {

	}

	public void buildEnlistedBooksPanel() {

	}
}