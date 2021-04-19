package MariosPizza;

import java.util.ArrayList;

/**
 *
 * menuKort = Nikolaj, Mads,
 *
 */

public class MenuKort {
  ArrayList<Pizza> menuKort = new ArrayList<>();

  public void makeMenuKort(){
    menuKort.add(new Pizza(1, "Vesuvio", "tomatsauce, ost, skinke og oregano",  57));
    menuKort.add(new Pizza(2, "Amerikaner", "tomatsauce ost, oksefars, og oregano",  53));
    menuKort.add(new Pizza(3, "Cacciatore", "tomatsauce, ost, pepperoni og oregano", 57));
    menuKort.add(new Pizza(4, "Carbona", "tomatsauce, ost, kødsauce, spaghetti, cocktailpølser og oregano", 63));
  }

  public void displayMenuKort(){
    for (int i = 0; i < menuKort.size(); i++) {
      System.out.println(menuKort.get(i));
    }
  }
}
