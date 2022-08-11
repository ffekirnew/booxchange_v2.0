package books;

import datatypes.*;

public abstract class Request extends Book {
	
	protected boolean isAccepted;
	protected String requesterID;
	protected Date createdDate;
	protected Date yearOfPurchase;

	public Request(String bookName, String authorName, Date yearOfPublication, Enum genre, boolean isAvailable, boolean isAccepted, String requesterID, Date createdDate){
		super(bookName, authorName, yearOfPublication, genre, isAvailable);
		this.isAccepted = isAccepted;
		this.requesterID = requesterID;
		this.createdDate = createdDate;
	}
	
	public Date getYearOfPurchse(){
		return this.yearOfPurchase;
	}
}