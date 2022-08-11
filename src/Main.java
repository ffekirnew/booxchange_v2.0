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
    public static void main(String[] args) {
        JFrame frame = new JFrame("Booxchange");
        frame.setResizable(true);
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new Home().currentPanel);
        frame.pack();
        ImageIcon logo = new ImageIcon("./gui/temp.jpg");
        frame.setIconImage(logo.getImage());
        frame.setVisible (true);
    }
}