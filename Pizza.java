package MariosPizza;

public class Pizza {
  private int ID;
  private String name;
  private int pris;

  public Pizza(int ID, String name, int pris) {
    setID(ID);
    setName(name);
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

  public void setName(String name) {
    this.name = name;
  }

  public void setID(int ID) {
    this.ID = ID;
  }

  public void setPris(int pris) {
    this.pris = pris;
  }

  @Override
  public String toString() {
    return "Nummer: " + ID + " navn: " + name + " pris: " + pris;
  }
}
