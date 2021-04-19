package MariosPizza;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * Nikolaj, Mads
 *
 */

public class PizzaMain {
  MenuKort menu = new MenuKort();

  private final String ACTIVE = "src/aktiveOrdre.txt";
  //private final String COMPLETED = "MariosPizza/færdigeOrdre.txt";
  private static final FileHandler pizzaFiles = new FileHandler();
  ArrayList<Pizza> pizzas = loadActiveOrders();

  public ArrayList<Pizza> loadActiveOrders() {
   ArrayList<String> load = pizzaFiles.readActiveOrders();
    ArrayList<Pizza> pizzas = new ArrayList<>();

    for (int i = 0; i < load.size(); i++) {

      int fetchID = Integer.parseInt(load.get(i));
      String fetchName = load.get(i);
      int fetchPrice = Integer.parseInt(load.get(i));

      pizzas.add(new Pizza(fetchID, fetchName, fetchPrice));
    }

    return pizzas;
  }

  public Pizza createNewOrder(){
    Scanner scan = new Scanner(System.in);

    System.out.print("Enter ID: ");
    int ID = scan.nextInt();
    scan.nextLine();

    System.out.print("Enter name: ");
    String name = scan.nextLine();

    System.out.print("Enter price: ");
    int price = scan.nextInt();

    return new Pizza(ID, name, price);
  }

  public void viewActiveOrders(){
    for (int i = 0; i < pizzas.size(); i++) {
      System.out.println(pizzas.get(i));
    }
  }

  void run(){
    //menu.makeMenuKort();
    //menu.displayMenuKort();
    //System.out.println();
    viewActiveOrders();
    //createNewOrder();
    //pizzaFiles.saveFile(pizzas);
  }

  public static void main(String[] args) {
    new PizzaMain().run();
  }
}
