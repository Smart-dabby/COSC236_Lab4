package lab4.library;

// Main application for the Library Management System.
// Demonstrates the five GRASP principles:
// Information Expert, Creator, Controller,
// Low Coupling, and High Cohesion.

public class LibraryApp {

    public static void main(String[] args) {

        // Create the Library and LibrarianController objects.
        Library library = new Library();
        LibrarianController controller =
                new LibrarianController(library);

        System.out.println("=== LIBRARY MANAGEMENT SYSTEM ===");

        // SCENARIO 1: Add books to the library.
        System.out.println("\n--- Adding Books ---");

        library.addBook("Dune", "Frank Herbert");
        library.addBook("1984", "George Orwell");
        library.addBook("Moby Dick", "Herman Melville");

        // SCENARIO 2: Display all books.
        System.out.println("\n--- Display All Books ---");
        library.displayCatalog();

        // SCENARIO 3: Register members.
        System.out.println("\n--- Register Members ---");

        library.registerMember(1, "Alice");
        library.registerMember(2, "Bob");

        // SCENARIO 4: Display registered members.
        System.out.println("\n--- Display All Members ---");
        library.displayMembers();

        // SCENARIO 5: Alice borrows Dune.
        System.out.println("\n--- Alice Borrows Dune ---");
        controller.borrowBook("Alice", "Dune");

        // Display the catalog after borrowing.
        library.displayCatalog();

        // SCENARIO 6: Bob borrows 1984.
        System.out.println("\n--- Bob Borrows 1984 ---");
        controller.borrowBook("Bob", "1984");

        // Display the catalog after borrowing.
        library.displayCatalog();

        // SCENARIO 7: Bob attempts to borrow Dune.
        // This request should be rejected because Alice has it.
        System.out.println("\n--- Bob Attempts to Borrow Dune ---");
        controller.borrowBook("Bob", "Dune");

        // SCENARIO 8: Search for a book.
        System.out.println("\n--- Search for Moby Dick ---");

        Book foundBook = library.findBookByTitle("Moby Dick");

        if (foundBook != null) {
            System.out.println("Book found: "
                    + foundBook.getTitle()
                    + " by " + foundBook.getAuthor());
        } else {
            System.out.println("Book not found.");
        }

        // SCENARIO 9: Search for a member.
        System.out.println("\n--- Search for Alice ---");

        Member foundMember = library.findMemberByName("Alice");

        if (foundMember != null) {
            System.out.println("Member found: "
                    + foundMember.getName()
                    + " (ID: " + foundMember.getMemberId() + ")");
        } else {
            System.out.println("Member not found.");
        }

        // SCENARIO 10: Display Alice's borrowed books.
        System.out.println("\n--- Alice's Borrowed Books ---");

        Member alice = library.findMemberByName("Alice");

        if (alice != null) {
            alice.displayBorrowedBooks();
        }

        // SCENARIO 11: Attempt to remove a borrowed book.
        System.out.println("\n--- Attempt to Remove Borrowed Book ---");
        library.removeBook("Dune");

        // SCENARIO 12: Alice returns Dune.
        System.out.println("\n--- Alice Returns Dune ---");
        controller.returnBook("Alice", "Dune");

        // Display catalog after returning.
        library.displayCatalog();

        // SCENARIO 13: Bob borrows Dune after Alice returns it.
        System.out.println("\n--- Bob Borrows Returned Dune ---");
        controller.borrowBook("Bob", "Dune");

        // Display catalog after borrowing.
        library.displayCatalog();

        // SCENARIO 14: Bob returns both borrowed books.
        System.out.println("\n--- Bob Returns His Books ---");

        controller.returnBook("Bob", "1984");
        controller.returnBook("Bob", "Dune");

        // SCENARIO 15: Remove a book from the library.
        System.out.println("\n--- Remove Moby Dick ---");
        library.removeBook("Moby Dick");

        // SCENARIO 16: Remove a registered member.
        System.out.println("\n--- Remove Bob ---");
        library.removeMember("Bob");

        // SCENARIO 17: Display final library status.
        System.out.println("\n--- Final Library Catalog ---");
        library.displayCatalog();

        System.out.println("\n--- Final Registered Members ---");
        library.displayMembers();

        System.out.println("\n=== APPLICATION COMPLETED ===");
    }
}