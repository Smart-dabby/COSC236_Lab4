package lab4.library;

//GRASP Controller: handles library requests and delegates
//responsibilities to Library, Member, and Book.
public class LibrarianController {

 private Library library;

 // Constructor receives the library to manage.
 public LibrarianController(Library library) {
     this.library = library;
 }

 // Handle a request to borrow a book.
 public boolean borrowBook(String memberName, String bookTitle) {

     Member member = library.findMemberByName(memberName);
     Book book = library.findBookByTitle(bookTitle);

     // Validate the member.
     if (member == null) {
         System.out.println("Borrow rejected: Member not found: "
                 + memberName);
         return false;
     }

     // Validate the book.
     if (book == null) {
         System.out.println("Borrow rejected: Book not found: "
                 + bookTitle);
         return false;
     }

     // Reject the request if the book is unavailable.
     if (!book.isAvailable()) {
         System.out.println("Borrow rejected: " + bookTitle
                 + " is currently unavailable.");
         return false;
     }

     // Delegate borrowing to the Member object.
     if (member.borrowBook(book)) {
         System.out.println(member.getName()
                 + " borrowed " + book.getTitle());
         return true;
     }

     System.out.println("Borrow request failed.");
     return false;
 }

 // Handle a request to return a book.
 public boolean returnBook(String memberName, String bookTitle) {

     Member member = library.findMemberByName(memberName);
     Book book = library.findBookByTitle(bookTitle);

     if (member == null || book == null) {
         System.out.println(
                 "Return rejected: Invalid member or book.");
         return false;
     }

     // Delegate returning to the Member object.
     if (member.returnBook(book)) {
         System.out.println(member.getName()
                 + " returned " + book.getTitle());
         return true;
     }

     System.out.println("Return rejected: "
             + memberName + " has not borrowed " + bookTitle);
     return false;
 }
}