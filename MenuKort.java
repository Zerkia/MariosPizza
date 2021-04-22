package MariosPizza;

import java.util.ArrayList;

/**
 *
 * menuKort = Nikolaj, Mads
 *
 */

public class MenuKort {
  ArrayList<menuPizza> menuKort = new ArrayList<>();

  public MenuKort(){
    menuKort.add(new menuPizza(1, "Vesuvio", "tomatsauce, ost, skinke og oregano",  57));
    menuKort.add(new menuPizza(2, "Amerikaner", "tomatsauce ost, oksefars, og oregano",  53));
    menuKort.add(new menuPizza(3, "Cacciatore", "tomatsauce, ost, pepperoni og oregano", 57));
    menuKort.add(new menuPizza(4, "Carbona", "tomatsauce, ost, kødsauce, spaghetti, cocktailpølser og oregano", 63));
    menuKort.add(new menuPizza(5, "Dennis", "tomatsauce, ost, skinke, pepperoni, cocktailpølser og oregano", 63));
    menuKort.add(new menuPizza(6, "Bertil", "tomatsauce, ost, bacon og oregano", 65));
    menuKort.add(new menuPizza(7, "Silvia", "tomatsauce, ost, pepperoni, rød peber, løg, oliven og oregano", 61));
    menuKort.add(new menuPizza(8, "Victoria", "tomatsauce, ost,  skinke, ananas, champignon, løg og oregano", 61));
    menuKort.add(new menuPizza(9, "Toronfo", "tomatsauce, ost, skinke, bacon, kebab, chili og oregano", 61));
    menuKort.add(new menuPizza(10, "Capricciosa", "tomatsauce, ost, skinke, champignon og oregano", 61));
    menuKort.add(new menuPizza(11, "Hawaii", "tomatsauce, ost, skinke, ananas og oregano", 61));
    menuKort.add(new menuPizza(12, "Le Blissola", "tomatsauce, ost, skinke, rejer og oregano", 61));
    menuKort.add(new menuPizza(13, "Venezia", "tomatsauce, ost, skinke, bacon og oregano", 61));
    menuKort.add(new menuPizza(14,"Mafia", "tomatsauce, ost, pepperoni, bacon, løg og oregano", 61));
  }

  public void displayMenuKort(){
    for (int i = 0; i < menuKort.size(); i++) {
      System.out.println(menuKort.get(i));
    }
  }
}
