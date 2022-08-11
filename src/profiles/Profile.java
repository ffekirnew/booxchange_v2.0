package profiles;

import datatypes.*;

public abstract class Profile {
 	protected String name;
 	protected int age;
 	protected Gender gender;
 	protected long phone;
 	protected String email;
	protected String profileID;
 	protected String profilePassword;

 	public Profile(String name, int age, Gender gender, long phone, String email, String profilePassword){
	 	this.name = name;
	 	this.age = age;
	 	this.gender = gender;
	 	this.phone = phone;
	 	this.email = email;
	 	this.profilePicture = profilePicture;
	 	this.profilePassword = profilePassword;
	}

	public String getName(){
		return this.name;
	}
	public int getAge(){
		return this.age;
	}
	public String getGender(){
		return this.gender.toString();
	}
	public long getPhone(){
		return this.phone;
	}
	public String getEmail(){
		return this.email;
	}
	public Picture getProfilePicture(){
		return this.profilePicture;
	}

	public int getProfileID(){
		return Integer.parseInt(this.profileID);
	}

	public boolean editProfile(String name, int age, Gender gender, long phone, String email, ){
	 	this.name = name;
	 	this.age = age;
	 	this.gender = gender;
	 	this.phone = phone;
	 	this.email = email;
	 	this.profilePicture = profilePicture;
	 	return true;
	}
}