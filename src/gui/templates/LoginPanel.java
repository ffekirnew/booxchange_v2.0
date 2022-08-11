package gui.templates;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import accounts.*;
import gui.*;
import gui.modifiedcomponents.*;

public class LoginPanel extends JPanel {

	public String loginName;
	public GuiHandler callerClass;	
	public JLabel titleLabel;
    public JLabel promptLabel;
	public JLabel userNameLabel;
    public JTextField userNameField;
	public JLabel passWordLabel;
    public JPasswordField passWordField;
    public JButton loginButton;
    public JLabel message;
	
	// Constructor
	public LoginPanel(String loginName, GuiHandler callerClass){
		
	
}