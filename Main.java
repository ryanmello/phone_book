import java.util.*;
import java.io.*;

/**
 * The Main class is a driver for the PhoneBook class. This class utilizes the
 * PhoneBook object and creates a menu for the user to interact with the PhoneBook.
 * The user has the options of printing the PhoneBook, sorting by last name and 
 * first name, search the phone book by last name, add contacts to the phone book,
 * and finally exit the phone book.
 */

class Main {
  private static PhoneBook phoneBook;
  private static File details;
  private static String menu;
  private static Scanner scan;

/**
 * The main method of this program runs a while loop with a menu that is outputted 
 * to the user. The user then can choose how they want to interact with the phone
 * book. A switch statement is used for choice, and other methods are called.
 * @param args
 */
  
  public static void main(String[] args) {
    phoneBook = new PhoneBook(details = new File("ContactDetails.txt"));

    menu = "Phone Book Menu:\nP: Print Phonebook\nB: Sort Phonebook by First Name\n" +
      "L: Sort Phonebook by Last Name\nS: Search Contact by Last Name\n" +
      "A: Add Contact to Phonebook\nQ: Quit\n";

    scan = new Scanner(System.in);
    String choice = null;
    boolean run = true;

    while(run){
      System.out.println(menu);
      System.out.println("Pick one of the options above: ");
      choice = scan.nextLine().toUpperCase();

      switch(choice) {
        case "P":
          print();
          break;
        case "B":
          System.out.println("Sorting by First Name\n");
          phoneBook.bubbleSort();
          break;
        case "L":
          System.out.println("Sorting by Last Name\n");
          phoneBook.selectionSort();
          break;
        case "S":
          search();
          break;
        case "A":
          add();
          break;
        case "Q":
          run = false;
          break;
        default:
          System.out.println("\nIncorrect Input, Please try again\n");
          break;
      }
    }
    System.out.println("Have a great day!");
  }
  
/**
 * The print method prints the entire phonebook
 */
  public static void print(){
    System.out.println(phoneBook.toString());
  }

/**
 * The search method initializes a scanner object and asks the user to input
 * a last name. The last name then runs through a binary search and will 
 * return true if the item is found and false if it is not.
 */

  public static void search(){
    Scanner input = new Scanner(System.in);
    System.out.println("Enter the last name: ");
    String lName = input.nextLine();
    System.out.println(phoneBook.binarySearch(lName));
  }

/**
 * The add method will ask the user for a first name, last name, email address
 * home number, and office number. Using that information a Contact object is 
 * created and added to the PhoneBook.
 */

  public static void add(){
    String first, last, email;
    Long home, office;
    
    System.out.println();
    Scanner input = new Scanner(System.in);
    System.out.println("Enter the first name: ");
    first = input.nextLine();
    
    System.out.println("Enter the last name: ");
    last = input.nextLine();

    System.out.println("Enter the email address: ");
    email = input.nextLine();
    
    System.out.println("Enter the home number: ");
    home = input.nextLong();
    
    System.out.println("Enter the office number: ");
    office = input.nextLong();

    System.out.println();
    System.out.println("Addding " + first + " " + last + "...");
    System.out.println();

    Contact contact = new Contact(first, last, home, office, email);
    phoneBook.add(contact);
  }
}