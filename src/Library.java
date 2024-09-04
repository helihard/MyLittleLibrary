import java.util.ArrayList;
import java.util.Scanner;

public class Library {
  private ArrayList<Book> books;

  public Library() {
    this.books = new ArrayList<>();
  }

  // method for adding a book to the library
  public void addBook(Book book) {
    books.add(book);
  }
  
  // method for adding a book to the library via user input
  public void addBook(Scanner scanner) {
    String title, author;
    int year, edition;

    System.out.print("Add a title: ");
    title = scanner.nextLine();
    System.out.print(String.format("Add name of author of %s: ", title));
    author = scanner.nextLine();
    System.out.print(String.format("Add year %s was published: ", title));
    year = Integer.parseInt(scanner.nextLine());
    System.out.print(String.format("Add edition of %s: ", title));
    edition = Integer.parseInt(scanner.nextLine());
    books.add(new Book(title, author, year, edition));
    System.out.println(String.format("%s, by %s (%s, %s ed.) was successfully added to the library.", title, author, year, edition));
  }

  // method for searching for a book by name
  // error handling: what if several books by same title
  public void searchBooks(Scanner scanner) {
    String searchTerm;
        
    System.out.print("Enter title: ");
    searchTerm = scanner.nextLine();

    for (Book book : books) {
      if (book.getTitle().equalsIgnoreCase(searchTerm)) {
        System.out.println("This title was found:");
        System.out.println(book);
        if (book.getAvailabilityStatus()) {
          loan(scanner, book);
        } else {
          reserve(scanner, book);
        }
        return;
      } 
    }
    System.out.println(String.format("No book by the title %s was found in the library.", searchTerm));
  }

  // method for listing all available books
  public void listAvailableBooks() {
    ArrayList<Book> availableBooks = new ArrayList<>();
    for (Book book : books) {
      if (book.getAvailabilityStatus()) {
        availableBooks.add(book);
      }
    }

    if (books.isEmpty()) {
      System.out.println("The library does not contain any books.");
    } else if (availableBooks.isEmpty()) {
      System.out.println("All books are currently on loan.");
    } else if (availableBooks.size() == 1) {
      System.out.println("This book is currently available for loan:");
      System.out.println(availableBooks.get(0));
    } else {
      System.out.println("These books are currently available for loan:");
      for (Book availableBook : availableBooks) {
        System.out.println(availableBook);
      }
    }
  }

  // method for loaning a book
  public boolean loan(Scanner scanner, Book book) {
    System.out.print("This book is available for loan. Do you want to loan this book? Y/N ");
    String loanChoice = scanner.nextLine();
    if (loanChoice.equalsIgnoreCase("y")) {
      book.setAvailabilityStatus(false);
      System.out.println(String.format("You have successfully loaned %s.", book.getTitle()));
      return true;
    } 
    return false;
  }

  // method for reserving a book from search
  public void reserve(Scanner scanner, Book book) {
    System.out.println(String.format("%s is currently on loan. Do you want to reserve this book? Y/N ", book.getTitle()));
    String reserveChoice = scanner.nextLine();
    if (reserveChoice.equalsIgnoreCase("y")) {
      System.out.print("Enter your name: ");
      String name = scanner.nextLine();
      book.setReservations(name);
      System.out.println(String.format("%s was successfully reserved.", book.getTitle()));
    }
  }

  // method for returning a book
  public void returnBook(Scanner scanner) {
    System.out.print("Enter title: ");
    String searchTerm = scanner.nextLine();

    for (Book book : books) {
      if (book.getTitle().equalsIgnoreCase(searchTerm)) {
        if (book.getAvailabilityStatus()) {
          System.out.println(String.format("%s is already in the library.", book.getTitle()));
        } else if (book.getReservations().isEmpty()) {
          book.setAvailabilityStatus(true);
          System.out.println(String.format("%s was successfully returned to the library.", book.getTitle()));
        } else {
          System.out.println(String.format("%s was successfully returned to the library.", book.getTitle()));
          System.out.println(String.format("%s, %s is now available for pickup.", book.getReservations().get(0), book.getTitle()));
          book.getReservations().remove(0);
        }
        return;
      }
    } 
    System.out.println(String.format("No book by the title %s was found in the library.", searchTerm)); 
  }

  // method for reserving a book from menu
  public void reserveBook(Scanner scanner) {
    System.out.print("Enter title: ");
    String input = scanner.nextLine();

    for (Book book : books) {
      if (book.getTitle().equalsIgnoreCase(input)) {
        if (!book.getAvailabilityStatus()) {
          System.out.print("Enter your username: ");
          String userName = scanner.nextLine();
          book.setReservations(userName);
          System.out.println(String.format("%s was successfully reserved.", book.getTitle()));
        } else {
          loan(scanner, book);
        }
        return;
      }
    } 
    System.out.println(String.format("No book by the title %s was found in the library.", input)); 
  }
}
