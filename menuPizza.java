package MariosPizza;

/**
 *
 * menuPizza = Nikolaj
 *
 */


public class menuPizza {
  private int ID;
  private String name;
  private String ingredients;
  private int price;

  public menuPizza(int ID, String name, String ingredients, int price){
    setID(ID);
    setName(name);
    setIngredients(ingredients);
    setPrice(price);
  }

  public int getID() {
    return ID;
  }

  public String getName() {
    return name;
  }

  public String getIngredients() {
    return ingredients;
  }

  public int getPrice() {
    return price;
  }

  public void setID(int ID) {
    this.ID = ID;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setIngredients(String ingredients) {
    this.ingredients = ingredients;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return getID() + ". " + getName() + " " + getIngredients() + "\nPris: " + getPrice() + " DKK\n";
  }
}
