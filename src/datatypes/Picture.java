package datatypes;

import javax.swing.ImageIcon;
import java.io.File;

import exceptions.*;

public class Picture extends ImageIcon {

	public String name;
	public double size;
	private ImageIcon file;
	
	// Constructor
	public Picture(String location) {
		this.set(location);
	}

	private String set(String location){
		try {
			File temp = new File(location);
			if (!temp.exists() || !temp.isFile()) {
				this.name = "Does not exist";
				this.size = 0;
				throw new DoesNotExistException();
			}

			this.name = temp.getName();
			this.size = (double) temp.length() / 1024;
			this.file = new ImageIcon(location);
			return this.name;
		}

		catch (DoesNotExistException e){
			return e.getMessage();
		}
	}
	
}