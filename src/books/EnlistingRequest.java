package books;

import datatypes.*;

public class EnlistingRequest extends Request{
	
	private int enlistingID;
	// Constructor
	public EnlistingRequest(String bookName, String authorName, Date yearOfPublication, Genre genre, boolean isAvailable, boolean isAccepted, String requesterID, Date createdDate, int enlistingID){
		super(bookName, authorName, yearOfPublication, genre, isAvailable, isAccepted, requesterID, createdDate);
		this.enlistingID = enlistingID; 
	}
	
}