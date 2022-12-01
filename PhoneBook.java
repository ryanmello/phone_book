import java.util.*;
import java.io.*;

/**
 * The PhoneBook class is a class that creates PhoneBook objects. This class has a default 
 * and regular constructor. The regular constructor uses a file to fill up the contacts 
 * field values in contacts listed in the file. This class has the ability to search the 
 * contacts with a binary search. A user can also use this class driver to add more contacts
 * to the list. This class can also be sorted by either first name or last name. Lastly, 
 * this class has a toString method that provides a nicely formatted list of all of the
 * contacts in the phone book.
 * @author Ryan Mello
 * @version 1.0.0
 */

public class PhoneBook{
  public ArrayList<Contact> contacts;

/**
 * Initializes a PhoneBook object without parameters, The contacts field value will be empty
 */
  
  public PhoneBook(){
    contacts = new ArrayList<>();
  }

/**
 * Initialized a PhoneBook object with a File as a parameter. The constructor then initializes 
 * the contacts arrayList and begins to iterate the File to add contacts to the contacts
 * arraylist. It will iterate the entire file. 
 * @param file
 */

  public PhoneBook(File file){
    contacts = new ArrayList<>();
    Scanner fileReader = null;

    try {
      fileReader = new Scanner(file);
    } catch(FileNotFoundException e){
      System.out.println("File was not found.");
    }

    String[] info;
    String line;

    while(fileReader.hasNextLine()){
      line = fileReader.nextLine();
      info = line.split(",");

      if(info[2].equals("-")){
        info[2] = "0";
      }

      if(info[3].equals("-")){
        info[3] = "0";
      }

      Contact contact = new Contact(info[0], info[1], Long.valueOf(info[2]), 
                                    Long.valueOf(info[3]), info[4]);
      contacts.add(contact);
    }
    fileReader.close();
  }

/**
 * The add method adds a contact object to the contacts arraylist
 * @param c
 */

  public void add(Contact c){
    contacts.add(c);
  }

/**
 * The toString method uses a for loop to iterate the entire contacts arraylist
 * and toString every item in the list and add it to a String.
 * @return
 */

  public String toString(){
    for(int i = 0; i < contacts.size(); i++){
      System.out.println(contacts.get(i));
    }
    return " ";
  }

/**
 * The bubble sort method is used to sort the contacts arraylist by first name
 */

  public void bubbleSort(){
    for(int i = 0; i < contacts.size(); i++){
      for(int j = i+1; j < contacts.size(); j++){
        if(contacts.get(j).getFirstName().compareTo(contacts.get(i).getFirstName())<0){
          Contact temp = contacts.get(j);
          contacts.set(j, contacts.get(i));
          contacts.set(i, temp);
        }
      }
    }
  }

/**
 * The selection sort method is used to sort the contacts arraylist by last name
 */

  public void selectionSort(){
    for(int i = 0; i < contacts.size(); i++){
      Contact smallest = contacts.get(i);
      int smallestIndex = i;

      for(int j = i; j < contacts.size(); j++){
        String value = contacts.get(j).getLastName();
        if(value.compareTo(smallest.getLastName())<0){
          smallestIndex = j;
          smallest = contacts.get(j);
        }
      }
      
      if(smallestIndex != i){
        Contact temp = contacts.get(i);
        contacts.set(i, smallest);
        contacts.set(smallestIndex, temp);
      }
    }
  }

/**
 * The binarySearch method takes a String lastName as parameter. This method then
 * uses a sorted contacts array to search and narrow down the last by half until
 * it find the lastName of the person. If not found, then false is returned.
 * @param lastName
 * @return
 */

  public boolean binarySearch(String lastName){
    if(this.contacts.size() >= 0){
      if(this.contacts.size() > 14){
        this.selectionSort();
      }
      
      int min = 0;
      int max = contacts.size() - 1;

      while(min <= max){
        int middle = (min + max) / 2;
        int current = lastName.compareToIgnoreCase(String.valueOf(contacts.get(middle).getLastName()));

        if(current == 0){
          System.out.println(contacts.get(middle).toString());
          return true;
        } else if(current < 0){
          max = middle - 1;
        } else {
          min = middle + 1;
        }
      }
    }
    return false;
  }
}