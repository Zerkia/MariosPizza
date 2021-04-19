package MariosPizza;

import java.util.ArrayList;

public class Main {

  ArrayList<MenuKort> menu = new ArrayList<>();

  public void displayMenuKort(){
    for (int i = 0; i < menu.size(); i++) {
      System.out.println(menu.get(i));
    }
  }

  void run(){
    displayMenuKort();
  }

  public static void main(String[] args) {
    new Main().run();
  }
}
