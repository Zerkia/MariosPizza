package MariosPizza;

import java.util.ArrayList;

public class Main {

  //ArrayList<MenuKort> menu = new ArrayList<>();
  MenuKort menu = new MenuKort();

  public void displayMenuKort(){
    for (int i = 0; i < menu.menuKort.size(); i++) {
      System.out.println(menu.menuKort.get(i));
    }
  }

  void run(){
    menu.makeMenuKort();
    displayMenuKort();
  }

  public static void main(String[] args) {
    new Main().run();
  }
}
