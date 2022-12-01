import java.util.*;
import java.io.*;

class Main {
  private static PhoneBook phoneBook;
  private static File details;
  private static String menu;
  private static Scanner scan;
  
  public static void main(String[] args) {
    phoneBook = new PhoneBook(details = new File("ContactDetails.txt"));

    menu = "Phone Book Menu:\nP: Print Phonebook\nB: Sort Phonebook by First Name\n" +
      "L: Sort Phonebook by Last Name\nS: Search Contact by Last Name\n" +
      "A: Add Contact to Phonebook\nQ: Quit\n";

    // System.err.println(menu);

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

  public static void print(){
    System.out.println(phoneBook.toString());
  }

  public static void search(){
    Scanner input = new Scanner(System.in);
    System.out.println("Enter the last name: ");
    String lName = input.nextLine();
    System.out.println(phoneBook.binarySearch(lName));
  }

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