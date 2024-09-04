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
        loan(scanner, book);
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
    System.out.print("Do you want to loan this book? Y/N ");
    String loanChoice = scanner.nextLine();
    if (loanChoice.equalsIgnoreCase("y") && book.getAvailabilityStatus()) {
      book.setAvailabilityStatus(false);
      System.out.println(String.format("You have successfully loaned %s.", book.getTitle()));
      return true;
    } else if ((loanChoice.equalsIgnoreCase("y") && !book.getAvailabilityStatus())) {
      System.out.println(String.format("%s is currently on loan.", book.getTitle()));
      return false;
    }
    return false;
  }

  // method for returning a book
  public boolean returnBook(Scanner scanner) {
    System.out.print("Enter title: ");
    String searchTerm = scanner.nextLine();

    for (Book book : books) {
      if (book.getTitle().equalsIgnoreCase(searchTerm)) {
        if (book.getAvailabilityStatus()) {
          System.out.println(String.format("%s is already in the library.", book.getTitle()));
          return false; 
        } else {
          book.setAvailabilityStatus(true);
          System.out.println(String.format("%s was successfully returned to the library.", book.getTitle()));
          return true;
        }
      }
    } 
    System.out.println(String.format("No book by the title %s was found in the library.", searchTerm));
    return false;  
  }
}