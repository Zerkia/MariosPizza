package MariosPizza;

/**
 *
 * Pizza = Nikolaj, Mads
 *
 */


public class Pizza {
  private int ID;
  private String name;
  private String ingredients;
  private int price;

  //Constructors
  //Constructor for placing order
  /**public Pizza(int ID, String name){
    setID(ID);
    setName(name);
  }*/
  //Constructor for aktiveOrdre.txt file
  public Pizza(int ID, String name, int price){
    setID(ID);
    setName(name);
    setPrice(price);
  }
  //Constructor for MenuKort.java file
  public Pizza(int ID, String name, String ingredients, int pris) {
    setID(ID);
    setName(name);
    setIngredients(ingredients);
    setPrice(pris);
  }

  public String getName() {
    return name;
  }

  public int getID() {
    return ID;
  }

  public int getPrice() {
    return price;
  }

  public String getIngredients() {
    return ingredients;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setID(int ID) {
    this.ID = ID;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public void setIngredients(String ingredients) {
    this.ingredients = ingredients;
  }


  @Override
  public String toString() {
    return getID() + ". " +  getName() + ": " + getIngredients() + "\npris: " + getPrice();
  }
}