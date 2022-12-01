import java.util.*;
import java.io.*;

public class PhoneBook{
  public ArrayList<Contact> contacts;
  
  public PhoneBook(){
    contacts = new ArrayList<>();
  }

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

  public void add(Contact c){
    contacts.add(c);
  }

  public String toString(){
    // returns the entire phone book as String
    for(int i = 0; i < contacts.size(); i++){
      System.out.println(contacts.get(i));
    }
    return " ";
  }

  public void bubbleSort(){
    // sort phonebook by first name
    for(int i = 0; i < contacts.size(); i++){
      for(int j = i+1; j < contacts.size(); j++){
        if(contacts.get(j).getFirstName().compareTo(contacts.get(i).getFirstName())<0){
          /*
           * if the j index is less than the i index
           * have the j index switch places with the i index
           * j index comes after i index
           * if number in front is less than number behind, swap places
           * 
           */
          Contact temp = contacts.get(j);
          contacts.set(j, contacts.get(i));
          contacts.set(i, temp);
        }
      }
    }
  }

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

  public boolean binarySearch(String lastName){
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