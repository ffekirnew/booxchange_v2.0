package gui;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import accounts.*;
import profiles.gui.*;
import books.*;
import gui.*;
import gui.modifiedcomponents.*;
import datatypes.*;
import exceptions.*;
import profiles.*;

public class Home {

	public JPanel currentPanel;
    private JPanel panel;

    public Home() {
        currentPanel = new JPanel(new FlowLayout());
        currentPanel.setBackground(new Commons().BLUE);
        buildPanel();
        currentPanel.add(panel);
    }

    public void buildPanel(){
    	panel = new JPanel();
    	// set background color
        panel.setBackground(new Commons().BLUE);

        JLabel titleLabel = new CLabel ("Booxchange", 50);
        JLabel promptLabel = new CLabel ("What are you?", 20);
        JButton userButton = new FButton ("User", 20);
        userButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentPanel.remove(panel);
                currentPanel.add(new User().currentPanel);
                currentPanel.revalidate();
                currentPanel.repaint();
            }
        });
        JButton adminButton = new FButton ("Admin", 20);
        adminButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentPanel.remove(panel);
                Administrator new_admin = new Administrator();
                new_admin.buildLoginPanel();
                currentPanel.add(new_admin.loginPanel);
                currentPanel.revalidate();
                currentPanel.repaint();
            }
        });
        JLabel footerPrompt = new CLabel ("Wanna know more?", 12);
        JButton aboutUsButton = new FButton ("About Us.", 12);
        aboutUsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentPanel.remove(panel);
                currentPanel.add(new AboutUs().currentPanel);
                currentPanel.revalidate();
                currentPanel.repaint();
            }
        });

        //adjust size and set layout
        panel.setPreferredSize (new Dimension (500, 700));
        panel.setLayout (null);

        //add components
        panel.add(titleLabel);
        panel.add(promptLabel);
        panel.add(userButton);
        panel.add(adminButton);
        panel.add(footerPrompt);
        panel.add(aboutUsButton);

        //set component bounds (only needed by Absolute Positioning)
        titleLabel.setBounds (0, 50, 500, 100);
        promptLabel.setBounds (100, 300, 300, 50);
        userButton.setBounds (100, 350, 150, 150);
        adminButton.setBounds (250, 350, 150, 150);
        footerPrompt.setBounds (0, 650, 250, 25);
        aboutUsButton.setBounds (255, 650, 100, 25);
    }
}