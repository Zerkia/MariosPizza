package MariosPizza;

import java.util.ArrayList;

public class MenuKort {
  ArrayList<Pizza> menuKort = new ArrayList<>();

  public void makeMenuKort(){
    menuKort.add(new Pizza(1, "Vesuvio", 57));
    menuKort.add(new Pizza(2, "Amerikaner", 53));
    menuKort.add(new Pizza(3, "Cacciatore", 57));
    menuKort.add(new Pizza(4, "Carbona", 63));
  }

  public void displayMenuKort(){
    for (int i = 0; i < menuKort.size(); i++) {
      System.out.println(menuKort.get(i));
    }
  }
}
