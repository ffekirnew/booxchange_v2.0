package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import gui.modifiedcomponents.*;
import accounts.*;

public class AboutUs {
	
	public JPanel currentPanel;
	public JPanel aboutUsPanel;
	
	// Constructor
	public AboutUs(){
		currentPanel = new JPanel(new FlowLayout());
        currentPanel.setBackground(new Commons().BLUE);
		buildAboutUsPanel();
		currentPanel.add(aboutUsPanel);
	}

	public void buildAboutUsPanel() {
		aboutUsPanel = new JPanel();

    	// set background color
        aboutUsPanel.setBackground(new Commons().BLUE);

        //construct components
        JLabel titleLabel = new CLabel ("Booxteam, The Team", 25);
        JLabel bini = new CLabel ("Biniyam Seid, UGR/9483/13", 13);
        JLabel fiker = new CLabel ("Fikernew Birhanu, UGR/9932/13", 13);
        JLabel leul = new CLabel ("Leul Degarege, UGR/6806/13", 13);
        JLabel lidu = new CLabel ("Lidya Ejigu, UGR/5038/13", 13);
        JLabel yabsira = new CLabel ("Yeabsira Yetwale, UGR/8664/13", 13);
        JLabel yohannes = new CLabel ("Yohannes Bekele, UGR/3361/13", 13);
        JLabel footerPrompt = new CLabel ("Finished knowing the team?", 12);
        JButton logInButton = new FButton ("Go Home.", 12);
        logInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentPanel.remove(aboutUsPanel);
                currentPanel.add(new Home().currentPanel);
                currentPanel.revalidate();
                currentPanel.repaint();
            }
        });

        //adjust size and set layout
        aboutUsPanel.setPreferredSize (new Dimension (500, 700));
        aboutUsPanel.setLayout (null);

        //add components
        aboutUsPanel.add(titleLabel);
        aboutUsPanel.add(bini);
        aboutUsPanel.add(fiker);
        aboutUsPanel.add(leul);
        aboutUsPanel.add(lidu);
        aboutUsPanel.add(yabsira);
        aboutUsPanel.add(yohannes);
        aboutUsPanel.add(footerPrompt);
        aboutUsPanel.add(logInButton);

        //set component bounds (only needed by Absolute Positioning)
        titleLabel.setBounds (0, 50, 500, 100);
        bini.setBounds (100, 200, 300, 50);
        fiker.setBounds (100, 250, 300, 50);
        leul.setBounds (100, 300, 300, 50);
        lidu.setBounds (100, 350, 300, 50);
        yabsira.setBounds (100, 400, 300, 50);
        yohannes.setBounds (100, 450, 300, 50);
        footerPrompt.setBounds (0, 650, 250, 25);
        logInButton.setBounds (255, 650, 100, 25);
	}
	
}