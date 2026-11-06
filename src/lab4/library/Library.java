package lab4.library;

import java.util.ArrayList;
import java.util.List;

// Manages the library's book catalog and registered members.
// GRASP: Creator and Information Expert.
public class Library {

    private List<Book> catalog;
    private List<Member> members;

    // Initialize the library's collections.
    public Library() {
        catalog = new ArrayList<>();
        members = new ArrayList<>();
    }

    // Creator: Library creates and manages Book objects.
    public Book addBook(String title, String author) {
        if (title == null || title.isBlank()
                || author == null || author.isBlank()) {
            System.out.println("Invalid book information.");
            return null;
        }

        if (findBookByTitle(title) != null) {
            System.out.println("Book already exists: " + title);
            return null;
        }

        Book book = new Book(title, author);
        catalog.add(book);

        System.out.println("Book added: " + title);
        return book;
    }

    // Remove a book only if it is available.
    public boolean removeBook(String title) {
        Book book = findBookByTitle(title);

        if (book == null) {
            System.out.println("Book not found: " + title);
            return false;
        }

        if (!book.isAvailable()) {
            System.out.println(
                "Cannot remove a borrowed book: " + title);
            return false;
        }

        catalog.remove(book);
        System.out.println("Book removed: " + title);
        return true;
    }

    // Creator: Library creates and registers Member objects.
    public Member registerMember(int memberId, String name) {
        if (memberId <= 0 || name == null || name.isBlank()) {
            System.out.println("Invalid member information.");
            return null;
        }

        for (Member member : members) {
            if (member.getMemberId() == memberId
                    || member.getName().equalsIgnoreCase(name)) {
                System.out.println(
                    "Member already exists: " + name);
                return null;
            }
        }

        Member member = new Member(memberId, name);
        members.add(member);

        System.out.println("Member registered: " + name);
        return member;
    }

    // Remove a member only if they have returned all books.
    public boolean removeMember(String name) {
        Member member = findMemberByName(name);

        if (member == null) {
            System.out.println("Member not found: " + name);
            return false;
        }

        if (!member.getBorrowedBooks().isEmpty()) {
            System.out.println(
                "Cannot remove member with borrowed books: " + name);
            return false;
        }

        members.remove(member);
        System.out.println("Member removed: " + name);
        return true;
    }

    // Information Expert: Library knows its catalog.
    public Book findBookByTitle(String title) {
        if (title == null) {
            return null;
        }

        for (Book book : catalog) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }

        return null;
    }

    // Information Expert: Library knows its members.
    public Member findMemberByName(String name) {
        if (name == null) {
            return null;
        }

        for (Member member : members) {
            if (member.getName().equalsIgnoreCase(name)) {
                return member;
            }
        }

        return null;
    }

    // Display all books and their availability.
    public void displayCatalog() {
        System.out.println("\nLibrary Catalog:");

        if (catalog.isEmpty()) {
            System.out.println("No books in the catalog.");
            return;
        }

        for (Book book : catalog) {
            String status = book.isAvailable()
                    ? "Available" : "Borrowed";

            System.out.println("- " + book.getTitle()
                    + " by " + book.getAuthor()
                    + " [" + status + "]");
        }
    }

    // Display all registered members.
    public void displayMembers() {
        System.out.println("\nRegistered Members:");

        if (members.isEmpty()) {
            System.out.println("No registered members.");
            return;
        }

        for (Member member : members) {
            System.out.println("- " + member.getName()
                    + " (ID: " + member.getMemberId() + ")");
        }
    }
}