package books;

import datatypes.*;

public abstract class Book {
	
	protected String bookName;
	protected String authorName;
	protected Date yearOfPublication;
	protected Genre genre;
	protected boolean isAvailable;

	public Book(String bookName, String authorName, Date yearOfPublication, Genre genre, boolean isAvailable) {
		this.bookName = bookName;
		this.authorName = authorName;
		this.yearOfPublication = yearOfPublication;
		this.genre = genre;
		this.isAvailable = isAvailable;
	}

	public String getName(){
		return this.bookName;
	}

	public String getAuthorName(){
		return this.authorName;
	}

	public Date getYearOfPublication(){
		return this.yearOfPublication;
	}

	public abstract Date getYearOfPurchase();

	public Genre getGenre(){
		return this.genre;
	}
}