package datatypes;

public class Gender {
	
 	private String gender;

	// Constructor
	public Gender(String gender){
		if (gender.charAt(0) == 'F' || gender.charAt(0) == 'f')
			this.gender = "F";
		else if (gender.charAt(0) == 'M' || gender.charAt(0) == 'm')
			this.gender = "M";
	}

	public Gender(char gender){
		if (gender == 'F' || gender == 'f')
			this.gender = "F";
		else if (gender == 'M' || gender == 'm')
			this.gender = "M";
	}

	public String toString(){
		return this.gender;
	}
	
}