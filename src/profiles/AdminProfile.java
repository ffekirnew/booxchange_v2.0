package profiles;

import datatypes.*;

public class AdminProfile extends Profile implements DatabaseHandler {
	
	// Constructor
	public AdminProfile(String name, int age, Gender gender, int phone, String email, Picture profilePicture, String profilePassword){
		super(name, age, gender, phone, email, profilePicture, profilePassword);
	}

	public boolean banUser(Profile profile){
		// this should note and archive a users profile into a file and delete the user from the database
		return true;
	}

	public boolean approveEnlisting(){
		// this method should allow the administrator to approve an enlisted book
		return true;
	}

	public boolean approveRequest(){
		// this method should allow the administrator to approve a requested book
		return true;
	}

	public boolean checkUserActivity(Report report){
		// this method should return all information about a user
		return true;
	}

	public boolean addRoom(){
		//
		return true;
	}

	// these methods should allow the administrator to change the states of the database
	public void create(){

	}

	public void read(){

	}

	public void update(){

	}

	public void delete(){

	}
}
