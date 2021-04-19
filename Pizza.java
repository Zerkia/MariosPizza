package MariosPizza;

public class Pizza {
  private int ID;
  private String name;

  public Pizza(int ID, String name) {
    setID(ID);
    setName(name);
  }

  public String getName() {
    return name;
  }

  public int getID() {
    return ID;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setID(int ID) {
    this.ID = ID;
  }

  @Override
  public String toString() {
    return "Pizza: " + ID + " name: " + name;
  }
}
