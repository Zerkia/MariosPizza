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

  private static final FileHandler pizzaFiles = new FileHandler();
  ArrayList<Pizza> activePizzas = loadActiveOrders();
  ArrayList<Pizza> completedPizzas = loadCompletedOrders();

  public ArrayList<Pizza> loadActiveOrders() {
    ArrayList<String> load = pizzaFiles.readActiveOrders();
    ArrayList<Pizza> activePizzas = new ArrayList<>();

    for (int i = 0; i < load.size(); i+=3) {
      int fetchID = Integer.parseInt(load.get(i));
      String fetchCustomerName = load.get(i+1);

      activePizzas.add(new Pizza(fetchID, fetchCustomerName));
    }

    return activePizzas;
  }

  public ArrayList<Pizza> loadCompletedOrders() {
    ArrayList<String> load = pizzaFiles.readCompletedOrders();
    ArrayList<Pizza> completedPizzas = new ArrayList<>();

    for (int i = 0; i < load.size(); i+=3) {
      int fetchID = Integer.parseInt(load.get(i));
      String fetchCustomerName = load.get(i+1);

      completedPizzas.add(new Pizza(fetchID, fetchCustomerName));
    }

    return completedPizzas;
  }

  public Pizza createNewOrder(){
    Scanner scan = new Scanner(System.in);

    System.out.print("Enter ID / Pizza Number: ");
    int ID = scan.nextInt();
    scan.nextLine();

    System.out.print("Enter name of customer: ");
    String customerName = scan.nextLine();

    return new Pizza(ID, customerName);
  }

  public void viewActiveOrders(){
    for (int i = 0; i < activePizzas.size(); i++) {
      System.out.println(activePizzas.get(i));
    }
  }

  public void statistics(){
    int[] arr = new int[20];
    for (int i = 0; i < completedPizzas.size(); i++) {
      int compPiz = completedPizzas.get(i).getID();
      arr[compPiz-1] += 1;

    }
    System.out.println(arr[1]);
  }

  public void viewCompletedOrders(){
    for (int i = 0; i < completedPizzas.size(); i++) {
      System.out.println(completedPizzas.get(i));
    }
  }

  public void deleteUser() {
    System.out.print("Please enter a number to remove the corresponding order number: ");
    Scanner scan = new Scanner(System.in);
    int removalInt = scan.nextInt()-1;

    //failsafe
    if(removalInt < 0){
      removalInt = 0;
    } else if (removalInt > activePizzas.size()) {
      removalInt = activePizzas.size()-1;
    }

    completedPizzas.add(new Pizza(activePizzas.get(removalInt).getID(), activePizzas.get(removalInt).getCustomerName()));
    activePizzas.remove(removalInt);
  }

  void run(){
    statistics();
    //menu.makeMenuKort();
    //menu.displayMenuKort();
    //System.out.println();
    //viewActiveOrders();
    //viewCompletedOrders();
    //activePizzas.add(createNewOrder());
    //System.out.println(activePizzas);
    //deleteUser();
    //pizzaFiles.saveCompletedPizzas(completedPizzas);
    //pizzaFiles.saveActivePizzas(activePizzas);
  }

  public static void main(String[] args) {
    new PizzaMain().run();
  }
}
