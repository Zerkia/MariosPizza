package MariosPizza;

/**
 *
 * Pizza = Nikolaj, Mads, Nicholas
 *
 */


public class Pizza {
  private int ID;
  private String name;
  private String ingredients;
  private int pris;

  public Pizza(int ID, String name, String ingredients, int pris) {
    setID(ID);
    setName(name);
    setIngredients(ingredients);
    setPris(pris);
  }

  public String getName() {
    return name;
  }

  public int getID() {
    return ID;
  }

  public int getPris() {
    return pris;
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

  public void setPris(int pris) {
    this.pris = pris;
  }

  public void setIngredients(String ingredients) {
    this.ingredients = ingredients;
  }

  @Override
  public String toString() {
    return ID + ". " +  name + ": " + ingredients + "\npris: " + pris;
  }
}
