package MariosPizza;

import java.util.ArrayList;

public class Main {

  //ArrayList<MenuKort> menu = new ArrayList<>();
  MenuKort menu = new MenuKort();

  void run(){
    menu.makeMenuKort();
    menu.displayMenuKort();
  }

  public static void main(String[] args) {
    new Main().run();
  }
}
