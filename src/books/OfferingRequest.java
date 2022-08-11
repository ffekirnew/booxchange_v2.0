package books;

import datatypes.*;

public class OfferingRequest extends Request {
	
	private int offeringID;
	private Date requestedDate;

	// Constructor
	public OfferingRequest(String bookName, String authorName, Date yearOfPublication, Enum genre, boolean isAvailable, boolean isAccepted, String requesterID, Date createdDate, int offeringID, Date requestedDate){
		super(bookName, authorName, yearOfPublication, genre, isAvailable, isAccepted, requesterID, createdDate);
		this.offeringID = offeringID; 
		this.requestedDate = requestedDate; 
	}
	
}