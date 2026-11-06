package lab4.library;
 
public class Book {

	// GRASP Principle: Information Expert
	// Manages its own state (available or borrowed).
	private String title; 
	private String author;
	private boolean isAvailable; 
	
	// TODO: implement Book functionality 
	
	// Constructor: creates a new available book 
	public Book(String title, String author) {
		this.title = title; 
		this.author = author; 
		this.isAvailable = true;
	}
	
	// Returns the book title 
	public String getTitle() {
		return title;
	}
	
	// Checks whether the book is available 
	public boolean isAvailable() {
		return isAvailable;
	}
	
	// Information Expert: Book manages its own borrowing status 
	public boolean borrow() {
		if (!isAvailable) {
			return false;
		}
		
		isAvailable = false; 
		return true;
	}
	
	// Makes the book available again 
	public void returnBook() {
		isAvailable = true;
	}

	// Returns the author of the book 
	public String getAuthor() {
		return author;
	}
	
}
