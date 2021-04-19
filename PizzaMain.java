package MariosPizza;

import java.util.ArrayList;
import java.util.Scanner;

public class PizzaMain {
  private final String ACTIVE = "MariosPizza/aktiveOrdre.txt";
  private final String COMPLETED = "MariosPizza/færdigeOrdre.txt";
  private static final FileHandler pizzaFiles = new FileHandler();

  ArrayList<Pizza> pizzas = loadActiveOrders();
  MenuKort menu = new MenuKort();

  public ArrayList<Pizza> loadActiveOrders(){
    ArrayList<String> load = pizzaFiles.readActiveOrders();
    ArrayList<Pizza> pizzas = new ArrayList<>();
    return pizzas;
  }

  public Pizza createNewOrder(){
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter ID: ");
    int ID = scan.nextInt();
    scan.nextLine();
    System.out.println("Enter name: ");
    String name = scan.nextLine();

    return new Pizza(ID, name);
  }

  void run(){
    menu.makeMenuKort();
    menu.displayMenuKort();
    createNewOrder();
  }

  public static void main(String[] args) {
    new PizzaMain().run();
  }
}
