import java.util.*;
import java.io.*;

public class PhoneBook{
  public ArrayList<Contact> contacts;
  
  public PhoneBook(){
    // create arraylist of contacts by reading data from the file
    contacts = new ArrayList<>();
  }

  public PhoneBook(File file){
    contacts = new ArrayList<>();
    Scanner fileReader = null;

    try {
      fileReader = new Scanner(file);
    } catch(FileNotFoundException e){
      System.out.println("File was not found.")
    }
  }

  public void add(Contact c){
    // add contact to arraylist
    contacts.add(c);
  }

  public String toString(){
    // returns the entire phone book as String
    return null;
  }

  public void bubbleSort(){
    // sort phonebook by first name
    for(int i = 0; i < contacts.size(); i++){
      for(int j = i+1; j < contacts.size(); j++){
        if(contacts.get(j).getFirstName().compareTo(contacts.get(i).getFirstName())<0){
          //
        }
      }
    }
  }

  public void selectionSort(){
    // sort phone book by last name
    for(int i = 0; i < contacts.size(); i++){
      Contact smallest = contacts.get(i);
      int smallestIndex = i;
      
      for(int j = 1; j < contacts.size(); j++){
        String value = contacts.get(j).getLastName();
        if(value.compareTo(smallest.getLastName())<0){
          //
        }
          
      }
      if(smallestIndex != i){
        //
      }
    }
  }

  public boolean binarySearch(){
    // search contact by last name using binary search
    // return true if contact is found
    if(this.contacts.size() >= 0){
      if(this.contacts.size() > 14){
        this.selectionSort();
      }
      
      int foundIndex;
      int min = 0;
      int max = contacts.size() - 1;

      while(min <= max){
        int middle = (min + max) / 2;
        int current = lastName.compareToIgnoreCase(String.valueOf(contacts.get(middle).getLastName()))

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