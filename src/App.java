import java.util.Scanner;

public class App {

    // method for printing main menu
    static void printMenu() {
        System.out.println("1. Add a book to the library");
        System.out.println("2. Search for a book by name");
        System.out.println("3. List all available books");
        System.out.println("4. Return a book");
        System.out.println("5. Quit");
    }

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        Library myLittleLibrary = new Library();

        myLittleLibrary.addBook(new Book("The Cloisters", "Katy Hays", 2022, 1));
        myLittleLibrary.addBook(new Book("The Deathless Girls", "Kiran Millwood Hargrave", 2020, 1));
        myLittleLibrary.addBook(new Book("Folk", "Zoe Gilbert", 2018, 1));
        myLittleLibrary.addBook(new Book("Huntress", "Malinda Lo", 2011, 1));

        String input;

        while (true) {
            printMenu();
            input = scanner.nextLine().trim();

            if (input.equals("1")) {
                myLittleLibrary.addBook(scanner);
            } else if (input.equals("2")) {
                myLittleLibrary.searchBooks(scanner);
            } else if (input.equals("3")) {
                myLittleLibrary.listAvailableBooks();
            } else if (input.equals("4")) {
                myLittleLibrary.returnBook(scanner);
            } else if (input.equals("5")) {
                System.out.println("Thank you for visiting the library. Welcome back anytime!");
                scanner.close();
                return;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
