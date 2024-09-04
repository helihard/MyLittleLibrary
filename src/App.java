import java.util.ArrayList;
import java.util.Scanner;

public class App {

    // method for printing main menu
    static void printMenu() {
        System.out.println("1. Add a book to the library");
        System.out.println("2. Search for a book by name");
        System.out.println("3. List all available books");
        System.out.println("4. Return a book");
        System.out.println("5. Quit");
        System.out.println("C. Clear console");
    }

    // method for clearing console
    public static void clearConsole() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Book> myLittleLibrary = new ArrayList<>();
        myLittleLibrary.add(new Book("The Cloisters", "Katy Hays", 2022, 1));
        myLittleLibrary.add(new Book("The Deathless Girls", "Kiran Millwood Hargrave", 2020, 1));
        myLittleLibrary.add(new Book("Folk", "Zoe Gilbert", 2018, 1));
        myLittleLibrary.add(new Book("Huntress", "Malinda Lo", 2011, 1));

        String input;
        boolean isValidInput = false;

        while (true) {
            isValidInput = false;

            while (!isValidInput) {
                printMenu();
                input = scanner.nextLine();
                if (input.contains("1")) {
                    isValidInput = true;
                    Book.addBook(scanner, myLittleLibrary);
                } else if (input.contains("2")) {
                    isValidInput = true;
                    Book.searchBooks(scanner, myLittleLibrary);
                } else if (input.contains("3")) {
                    isValidInput = true;
                    Book.listAvailableBooks(myLittleLibrary);
                } else if (input.contains("4")) {
                    isValidInput = true;
                    Book.returnBook(scanner, myLittleLibrary);
                } else if (input.contains("5")) {
                    System.out.println("Thank you for visiting the library. Welcome back anytime!");
                    scanner.close();
                    return;
                } else if (input.toLowerCase().contains("c")) {
                    isValidInput = true;
                    clearConsole();
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }
}
