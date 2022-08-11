package gui.modifiedcomponents;

import javax.swing.JButton;
import java.awt.Font;

public class FButton extends JButton {
	// named FButton for it will set font sizes for button texts
	// Constructor
	public FButton(String text, int fontSize){
		super(text);
		setFont(new Font("Arial", Font.PLAIN, fontSize));
	}
	
}