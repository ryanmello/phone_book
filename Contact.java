public class Contact{
  private String firstName;
  private String lastName;
  private long homeNumber;
  private long officeNumber;
  private String emailAddress;

  public Contact(String firstName, String lastName, 
                 long homeNumber, long officeNumber, String emailAddress){
    this.firstName = firstName;
    this.lastName = lastName;
    this.homeNumber = homeNumber;
    this.officeNumber = officeNumber;
    this.emailAddress = emailAddress;
  }

  public String getFirstName(){
    return firstName;
  }

  public void setFirstName(String firstName){
    this.firstName = firstName;
  }

  public String getLastName(){
    return lastName;
  }

  public void setLastName(String lastName){
    this.lastName = lastName;
  }

  public long getHomeNumber(){
    return homeNumber;
  }

  public void setHomeNumber(long homeNumber){
    this.homeNumber = homeNumber;
  }

  public long getOfficeNumber(){
    return officeNumber;
  }

  public void setOfficeNumber(long officeNumber){
    this.officeNumber = officeNumber;
  }

  public String getEmailAddress(){
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress){
    this.emailAddress = emailAddress;
  }
  
  // toString
  public String toString(){
    return firstName + " " + lastName + " " + homeNumber + " " + officeNumber + " " + emailAddress;
  }
}