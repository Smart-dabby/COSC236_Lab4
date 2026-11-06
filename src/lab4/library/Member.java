package lab4.library;

import java.util.ArrayList; 
import java.util.Collections; 
import java.util.List;

// Represents a registered library member 
public class Member {
	// GRASP Principle: Information Expert and Low Coupling

	private int memberId;
	private String name;
	// private borrowedbBooks TODO: implement collection of borrowed books 
	private List<Book> borrowedBooks;
	
	// Constructor: initializes a member and their borrowed books.
	public Member(int memberId, String name) {
		this.memberId = memberId; 
		this.name = name; 
		this.borrowedBooks = new ArrayList<>();
	}
	
	// Returns the member ID. 
	public int getMemberId() {
		return memberId;
	}
	
	// Returns the member's name. 
	public String getName() {
		return name;
	}
	
	// Returns a read-only view of borrowed books. 
	public List<Book> getBorrowedBooks() {
		return Collections.unmodifiableList(borrowedBooks);
	}
	
	// TODO: implement functionality of Member class
	// Can borrow and return books.
	// Book manages its own availability. 
	public boolean borrowBook (Book book) {
		if (book == null || !book.borrow()) {
			return false;
		}
		
		borrowedBooks.add(book);
		return true;
	}
	
	// Returns a borrowed book to the library. 
	public boolean returnBook (Book book) {
		if (book == null || !borrowedBooks.contains(book)) {
			return false; 
		}
		
		borrowedBooks.remove(book);
		book.returnBook();
		return true;
	}
	
	// Displays the books currently borrowed by this member.
    public void displayBorrowedBooks() {
        System.out.println("Books borrowed by " + name + ":");

        if (borrowedBooks.isEmpty()) {
            System.out.println("No borrowed books.");
            return;
        }

        for (Book book : borrowedBooks) {
            System.out.println("- " + book.getTitle());
        }
    }

}
