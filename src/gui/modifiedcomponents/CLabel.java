package gui.modifiedcomponents;

import javax.swing.JLabel;
import java.awt.Font;

public class CLabel extends JLabel {
	// Stands for centered label, will automatically center elements created from this class
	
	// Constructor
	public CLabel(String text, int fontSize){
		super(text);
		setFont(new Font("Arial", Font.PLAIN, fontSize));
		setHorizontalAlignment(JLabel.CENTER);
		setVerticalAlignment(JLabel.CENTER);
	}
	
}