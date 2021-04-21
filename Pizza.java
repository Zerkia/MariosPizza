package MariosPizza;

/**
 *
 * Pizza = Nikolaj, Mads
 *
 */


public class Pizza {
  private int ID;
  private String customerName;
  private String time;

  //Constructors
  //Constructor for placing order
  /**public Pizza(int ID, String name){
    setID(ID);
    setName(name);
  }*/
  //Constructor for aktiveOrdre.txt file
  public Pizza(int ID, String customerName, String time){
    setID(ID);
    setCustomerName(customerName);
    setTime(time);
  }

  public int getID() {
    return ID;
  }

  public String getCustomerName() {
    return customerName;
  }

  public String getTime() { return time; }

  public void setID(int ID) {
    this.ID = ID;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public void setTime(String time) { this.time = time; }

  @Override
  public String toString() {
    return "Pizza Number: " + getID() + "\nCustomer name: " + getCustomerName() + "\nTime: " + getTime();
  }
}