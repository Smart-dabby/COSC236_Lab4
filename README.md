# COSC 236 — Lab #4: Implementing GRASP Principles in Java

## Project Overview

This project demonstrates the application of five GRASP (General Responsibility Assignment Software Patterns) principles by refactoring a simplified Library Management System using Java.

The original application handled most operations in a single class. The refactored system separates responsibilities across five classes to improve maintainability, readability, and object-oriented design.

## GRASP Principles Implemented

1. **Information Expert:** The `Book` class manages book availability, while `Member` manages borrowed books.
2. **Creator:** The `Library` class creates and manages books and registered members.
3. **Controller:** `LibrarianController` processes borrowing and returning requests.
4. **Low Coupling:** Classes interact through clearly defined public methods.
5. **High Cohesion:** Each class focuses on its own responsibilities.

## Java Classes

- `Book.java` — Stores book information and manages availability.
- `Member.java` — Stores member information and manages borrowed books.
- `Library.java` — Manages the book catalog and registered members.
- `LibrarianController.java` — Coordinates borrowing and returning requests.
- `LibraryApp.java` — Contains the main method and demonstrates the application.

## Features

- Add and remove books.
- Register and remove library members.
- Borrow and return books.
- Search for books and members.
- Display the library catalog and registered members.
- Prevent borrowing unavailable books.
- Prevent removing books that are currently borrowed.

## Testing

The application was tested using three books: Dune, 1984, and Moby Dick, and two members: Alice and Bob.

The tests confirmed that books could be borrowed and returned successfully, unavailable books could not be borrowed, and the catalog and member records were updated correctly.

The application executed successfully in Eclipse without errors.

## UML Diagrams

The project includes:

- UML Use Case Diagram — illustrates the system's operations and interactions.
- UML Class Diagram — illustrates the five classes, their attributes, methods, and relationships.

## How to Run

1. Open Eclipse IDE.
2. Import the Java project or create a Java project and add the source files.
3. Ensure the Java files are in the `lab4.library` package.
4. Open `LibraryApp.java`.
5. Right-click and select **Run As → Java Application**.
6. Review the output in the Eclipse Console. 


## GRASP Refactoring Verification

The refactored application was tested in Eclipse.

### Verified Test Scenarios

- Alice successfully borrowed Dune.
- Bob successfully borrowed 1984.
- Bob's attempt to borrow Dune was rejected while unavailable.
- Alice successfully returned Dune.
- Bob successfully borrowed Dune after it was returned.
- The system prevented removal of a borrowed book.
- Books and members were successfully searched.
- Moby Dick was successfully removed.
- Bob was successfully removed after returning his books.

### Final Application State

- Available books: Dune and 1984.
- Registered member: Alice.
- Application completed without runtime errors.

These results demonstrate Information Expert, Creator,
Controller, Low Coupling, and High Cohesion in the
refactored Library Management System.

## Conclusion

This lab demonstrates how GRASP principles can improve object-oriented software design by assigning responsibilities to appropriate classes and reducing unnecessary dependencies.