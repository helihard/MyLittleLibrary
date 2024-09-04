import java.util.ArrayList;
import java.util.Scanner;

public class Book {
  private String title;
  private String author;
  private int year;
  private int edition;
  private boolean available;

  // constructor
  public Book(String title, String author, int year, int edition) {
    this.title = title;
    this.author = author;
    this.year = year;
    this.edition = edition;
    this.available = true;
  }

  // book title getter
  public String getTitle() {
    return title;
  }

  // book title setter
  public void setTitle(String title) {
    this.title = title;
  }

  // book author getter
  public String getAuthor() {
    return author;
  }

  // book author setter
  public void setAuthor(String author) {
    this.author = author;
  }

  // publishing year getter
  public int getYear() {
    return year;
  }

  // publishing year setter
  public void setYear(int year) {
    this.year = year;
  }

  // edition getter
  public int getEdition() {
    return edition;
  }

  // edition setter
  public void setEdition(int edition) {
    this.edition = edition;
  }

  // availability status getter
  public boolean getAvailabilityStatus() {
    return available;
  }

  // availability status setter
  public void setAvailabilityStatus(boolean available) {
    this.available = available;
  }

  // method for adding a book to the library
  static void addBook(Scanner scanner, ArrayList<Book> books) {
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
  static void searchBooks(Scanner scanner, ArrayList<Book> books) {
    String searchTerm;
        
    System.out.print("Enter title: ");
    searchTerm = scanner.nextLine();

    for (Book book : books) {
      if (book.getTitle().toLowerCase().equals(searchTerm.toLowerCase())) {
        System.out.println("This title was found:");
        System.out.println(book);
        Book.loan(scanner, book);
        return;
      } 
    }
    System.out.println(String.format("No book by the title %s was found in the library.", searchTerm));
  }

  // method for listing all available books
  static void listAvailableBooks(ArrayList<Book> books) {
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
  public static boolean loan(Scanner scanner, Book book) {
    System.out.print("Do you want to loan this book? Y/N ");
    String loanChoice = scanner.nextLine();
    if (loanChoice.toLowerCase().contains("y") && book.getAvailabilityStatus() == true) {
      book.setAvailabilityStatus(false);
      // or, instead of feedback to user, just return true according to exercise description
      System.out.println(String.format("You have successfully loaned %s.", book.getTitle()));
      return true;
    } else {
      // or, instead of feedback to user, return false according to exercise description
      System.out.println(String.format("%s is currently already on loan.", book.getTitle()));
      return false;
    }
  }

    // method for returning a book
    static boolean returnBook(Scanner scanner, ArrayList<Book> books) {

      System.out.print("Enter title: ");
      String searchTerm = scanner.nextLine();

      for (Book book : books) {
        if (book.getTitle().equalsIgnoreCase(searchTerm)) {
          if (book.getAvailabilityStatus()) {
            System.out.println(String.format("%s is already in the library.", book.getTitle()));
            return false; 
          } else {
            book.setAvailabilityStatus(true);
            System.out.println(String.format("%s was successfully returned.", book.getTitle()));
            return true;
          }
        }
      } 
      System.out.println(String.format("No book by the title %s was found in the library.", searchTerm));
      return false;  
    }
  
  
  @Override
  public String toString() {
    return String.format("%s, by %s (%s, %s ed.)", title, author, year, edition);
  }
}
