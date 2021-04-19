package MariosPizza;

import java.util.ArrayList;

public class MenuKort {
  ArrayList<Pizza> menuKort = new ArrayList<>();

  //Pizza Vesuvio = new Pizza(1, "Vesuvio");

  public void makeMenuKort(){
    menuKort.add(new Pizza(1, "Vesuvio"));
    menuKort.add(new Pizza(2, "test"));
  }
}
