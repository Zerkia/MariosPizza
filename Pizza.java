package MariosPizza;

/**
 *
 * Pizza = Nikolaj, Mads
 *
 */


public class Pizza {
  private int ID;
  private String customerName;

  //Constructors
  //Constructor for placing order
  /**public Pizza(int ID, String name){
    setID(ID);
    setName(name);
  }*/
  //Constructor for aktiveOrdre.txt file
  public Pizza(int ID, String customerName){
    setID(ID);
    setCustomerName(customerName);
  }

  public int getID() {
    return ID;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setID(int ID) {
    this.ID = ID;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  @Override
  public String toString() {
    return "Pizza Number: " + getID() + "\nCustomer name: " + getCustomerName();
  }
}