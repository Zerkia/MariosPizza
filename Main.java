package MariosPizza;

public class Main {

  MenuKort menu = new MenuKort();

  public void displayMenuKort(){
    for (int i = 0; i < menu.menuKort.size(); i++) {
      System.out.println(menu.menuKort.get(i));
    }
  }

  void run(){
    displayMenuKort();
  }

  public static void main(String[] args) {
    new Main().run();
  }
}
