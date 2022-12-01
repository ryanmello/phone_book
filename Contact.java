/**
 * The Contact class acts an an object that holds a person's information that can 
 * be used within a phoneBook. The contact class has field values that are firstName,
 * lastName, homeNumber, officeNumber, and emailAddress. All of these values have
 * getters and setters. Lastly there is a toString method that returns a String
 * containing all of the users information.
 * @author Ryan Mello
 * @version 1.0.0
 */

public class Contact{
  private String firstName;
  private String lastName;
  private long homeNumber;
  private long officeNumber;
  private String emailAddress;

/**
 * Intializes a Contact object with the parameters being a person's first and last
 * name, their home and office number, and email address. All of these objects
 * field values will be set to these parameters.
 * @param firstName
 * @param lastName
 * @param homeNumber
 * @param officeNumber
 * @param emailAddress
 */

  public Contact(String firstName, String lastName, 
                 long homeNumber, long officeNumber, String emailAddress){
    this.firstName = firstName;
    this.lastName = lastName;
    this.homeNumber = homeNumber;
    this.officeNumber = officeNumber;
    this.emailAddress = emailAddress;
  }

/**
 * Returns the first name of current contact object
 * @return firstName 
 */

  public String getFirstName(){
    return firstName;
  }

/**
 * Sets the first name of current contact object
 * @param firstName 
 */

  public void setFirstName(String firstName){
    this.firstName = firstName;
  }

/**
 * Returns the last name of current contact object
 * @return lastName 
 */

  public String getLastName(){
    return lastName;
  }

/**
 * Sets the last name of current contact object
 * @param lastName 
 */

  public void setLastName(String lastName){
    this.lastName = lastName;
  }

/**
 * Returns the home number of current contact object
 * @return homeNumber 
 */

  public long getHomeNumber(){
    return homeNumber;
  }

/**
 * Sets the home number of current contact object
 * @param homeNumber 
 */

  public void setHomeNumber(long homeNumber){
    this.homeNumber = homeNumber;
  }

/**
 * Returns the office number of current contact object
 * @return officeNumber 
 */

  public long getOfficeNumber(){
    return officeNumber;
  }

/**
 * Sets the office number of current contact object
 * @param officeNumber 
 */

  public void setOfficeNumber(long officeNumber){
    this.officeNumber = officeNumber;
  }

/**
 * Returns the emailAddress of current contact object
 * @return emailAddress 
 */

  public String getEmailAddress(){
    return emailAddress;
  }

/**
 * Sets the email address of current contact object
 * @param emailAddress 
 */

  public void setEmailAddress(String emailAddress){
    this.emailAddress = emailAddress;
  }

/**
 * Returns a string value of contact object
 * @reurn String 
 */
  
  public String toString(){
    if(homeNumber == 0){
      return firstName + " " + lastName + " " + "-" + " " + officeNumber + " " + emailAddress;
    } else if(officeNumber == 0){
      return firstName + " " + lastName + " " + homeNumber + " " + "-" + " " + emailAddress;
    } else {
      return firstName + " " + lastName + " " + homeNumber + " " + officeNumber + " " + emailAddress;
    }
  }
}