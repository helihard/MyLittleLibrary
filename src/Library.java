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

    System.out.println("Add a title:");
    title = scanner.nextLine().trim();
    System.out.println(String.format("Add name of author of %s:", title));
    author = scanner.nextLine().trim();
    System.out.println(String.format("Add year %s was published:", title));
    year = Integer.parseInt(scanner.nextLine().trim());
    System.out.println(String.format("Add edition of %s:", title));
    edition = Integer.parseInt(scanner.nextLine().trim());
    books.add(new Book(title, author, year, edition));
    System.out.println(String.format("%s, by %s (%s, %s ed.), was successfully added to the library.", title, author, year, edition));
  }

  // method for searching for a book by title
  // error handling: what if several books by same title
  public void searchBooks(Scanner scanner) {
    String input;
        
    System.out.println("Enter title:");
    input = scanner.nextLine().trim();

    for (Book book : books) {
      if (book.getTitle().equalsIgnoreCase(input)) {
        System.out.println("This title was found:");
        System.out.println(book);
        if (book.getAvailabilityStatus()) {
          loan(scanner, book);
        } else {
          System.out.println(reserve(scanner, book));
        }
        return;
      } 
    }
    System.out.println(String.format("No book by the title %s was found to belong to the library.", input));
  }

  // method for listing all available books
  public void listAvailableBooks() {
    ArrayList<Book> availableBooks = new ArrayList<>();
    for (Book book : books) {
      if (book.getAvailabilityStatus()) {
        availableBooks.add(book);
      }
    }

    // for future: read up on streams

    if (books.isEmpty()) {
      System.out.println("The library does not yet have any books.");
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
    System.out.println("This book is available for loan. Do you want to loan this book? Y/N");
    String input = scanner.nextLine().trim();
    if (input.equalsIgnoreCase("y")) {
      book.setAvailabilityStatus(false);
      System.out.println(String.format("You have successfully loaned %s.", book.getTitle()));
      return true;
    } 
    return false;
  }

  // method for reserving a book from search
  public String reserve(Scanner scanner, Book book) {
    System.out.println(String.format("%s is currently on loan. Do you want to reserve this book? Y/N", book.getTitle()));
    String input = scanner.nextLine().trim();
    if (input.equalsIgnoreCase("y")) {
      System.out.println("Enter your username:");
      String userName = scanner.nextLine().trim();
      book.setReservations(userName);
      return String.format("%s was successfully reserved.", book.getTitle());
    }
    return String.format("%s was not reserved.", book.getTitle());
  }

  // method for returning a book
  public void returnBook(Scanner scanner) {
    System.out.println("Enter title:");
    String input = scanner.nextLine().trim();

    for (Book book : books) {
      if (book.getTitle().equalsIgnoreCase(input)) {
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
    System.out.println(String.format("No book by the title %s was found to belong to the library.", input)); 
  }

  // method for reserving a book from menu
  // for future: combine reserve and reserveBook methods?
  public void reserveBook(Scanner scanner) {
    System.out.println("Enter title:");
    String input = scanner.nextLine().trim();

    for (Book book : books) {
      if (book.getTitle().equalsIgnoreCase(input)) {
        if (!book.getAvailabilityStatus()) {
          System.out.println("Enter your username:");
          String userName = scanner.nextLine().trim();
          book.setReservations(userName);
          System.out.println(String.format("%s was successfully reserved.", book.getTitle()));
        } else {
          loan(scanner, book);
        }
        return;
      }
    } 
    System.out.println(String.format("No book by the title %s was found to belong to the library.", input)); 
  }
}
