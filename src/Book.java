import java.util.ArrayList;

public class Book {
  private String title;
  private String author;
  private int year;
  private int edition;
  private boolean available;
  private ArrayList<String> reservations;

  // constructor
  public Book(String title, String author, int year, int edition) {
    this.title = title;
    this.author = author;
    this.year = year;
    this.edition = edition;
    this.available = true;
    this.reservations = new ArrayList<String>();
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

  // reservations getter
  public ArrayList<String> getReservations() {
    return reservations;
  }

  // reservations setter
  public void setReservations(String name) {
    this.reservations.add(name);
  }

  @Override
  public String toString() {
    return String.format("%s, by %s (%s, %s ed.)", title, author, year, edition);
  }
}
