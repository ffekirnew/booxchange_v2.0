package profiles.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import gui.modifiedcomponents.*;
import gui.*;

public class UserSearch {

	private JFrame frame;
	private JPanel searchPanel;
	private String searchKey;
    private JLabel titleLabel;
    private JTextField searchTextField;
    private JButton searchButton;
    private JLabel resultsLabel;
    private JList resultsList;
    private JScrollPane resultsScrollPane;
    private JLabel footerQuestionLabel;
    private JButton backButton;

    public UserSearch() {
    	frame = new JFrame(new Commons().APPNAME);
		buildSearchPanel();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(searchPanel);
        frame.pack();
        frame.setIconImage(new Commons().LOGO.getImage());
        frame.setVisible (true);
    }

    public void search(){
    	String[] resultsListItems = new String[10];
    	for (int count = 0; count < resultsListItems.length; count++) {
    		resultsListItems[count] = searchKey;    	
    	}
    	resultsList = new JList(resultsListItems);
    	resultsScrollPane = new JScrollPane();
        resultsScrollPane.setViewportView(resultsList);
        searchPanel.add(resultsScrollPane);
        resultsScrollPane.setBounds(100, 180, 300, 450);
    }

    public void buildSearchPanel() {
    	// set background color
    	searchPanel = new JPanel();
		searchPanel.setBackground(new Commons().BLUE);
        // construct pre components
        String[] resultsListItems = {"hey"};

        //construct components
        titleLabel = new CLabel("Search Books", 30);
        searchTextField = new JTextField ("Search here...");
        searchButton = new JButton ("Search");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchKey = searchTextField.getText();
                search();
            }
        });
        resultsLabel = new CLabel("Results: ", 15);

        footerQuestionLabel = new CLabel("Didn't find what you were looking for?", 12);
        backButton = new FButton("Go back", 12);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //
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
        searchPanel.add(footerQuestionLabel);
        searchPanel.add(backButton);

        //set component bounds (only needed by Absolute Positioning)
        titleLabel.setBounds (0, 25, 500, 50);
        searchTextField.setBounds (100, 100, 225, 25);
        searchButton.setBounds (325, 100, 75, 25);
        resultsLabel.setBounds (100, 150, 300, 30);
        footerQuestionLabel.setBounds (0, 650, 250, 25);
        backButton.setBounds (255, 650, 100, 25);
    }
}