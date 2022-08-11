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

public class Main {

	private JFrame frame;
	private JPanel panel;
    private JLabel titleLabel;
    private JLabel promptLabel;
    private JButton userButton;
    private JButton adminButton;
    private JLabel footerPrompt;
    private JButton aboutUsButton;

    public Main() {
        frame = new JFrame("Booxchange");
        frame.setResizable(false);
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        buildPanel();
        frame.getContentPane().add (panel);
        frame.pack();
        ImageIcon logo = new ImageIcon("./gui/temp.jpg");
        frame.setIconImage(logo.getImage());
        frame.setVisible (true);
    }

    public void buildPanel(){
    	panel = new JPanel();
    	// set background color
        panel.setBackground(new Commons().BLUE);

        //construct components
        titleLabel = new CLabel ("Booxchange", 50);
        promptLabel = new CLabel ("What are you?", 20);
        userButton = new FButton ("User", 20);
        userButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().remove(panel);
				User user = new User();
				frame.getContentPane().add(user.currentPanel);
				frame.invalidate();
				frame.validate();
            }
        });
        
        adminButton = new FButton ("Admin", 20);
        adminButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().remove(panel);
				Administrator administrator = new Administrator();
				administrator.buildLoginPanel();
				frame.getContentPane().add(administrator.loginPanel);
				frame.invalidate();
				frame.validate();
            }
        });
        footerPrompt = new CLabel ("Wanna know more?", 12);
        aboutUsButton = new FButton ("About Us.", 12);

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

    public static void main(String[] args) {
        new Main();
    }
}