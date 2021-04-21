package MariosPizza;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * Nikolaj, Mads
 *
 * Statistics unfinished, needs menu in the end to more easily navigate everything
 * Nikolaj has menu file from other project that can be transferred semi-easily
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

    //fails if aktiveOrdre.txt is empty, if load.size() <= 0 didn't work.
    //maybe a throw needed?
    for (int i = 0; i < load.size(); i+=4) {
      int fetchID = Integer.parseInt(load.get(i));
      String fetchCustomerName = load.get(i+1);
      String fetchTime = load.get(i+2);

      activePizzas.add(new Pizza(fetchID, fetchCustomerName, fetchTime));
    }

    return activePizzas;
  }

  public ArrayList<Pizza> loadCompletedOrders() {
    ArrayList<String> load = pizzaFiles.readCompletedOrders();
    ArrayList<Pizza> completedPizzas = new ArrayList<>();

    //fails if færdigeOrdre.txt is empty, if load.size() <= 0 didn't work.
    //maybe a throw needed?
    for (int i = 0; i < load.size(); i+=4) {
      int fetchID = Integer.parseInt(load.get(i));
      String fetchCustomerName = load.get(i+1);
      String fetchTime = load.get(i+2);

      completedPizzas.add(new Pizza(fetchID, fetchCustomerName, fetchTime));
    }

    return completedPizzas;
  }

  public Pizza createNewOrder(){
    Scanner scan = new Scanner(System.in);
    LocalTime time = LocalTime.now();
    DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
    String formattedDate = time.format(format);

    System.out.print("Enter ID / Pizza Number: ");
    int ID = scan.nextInt();
    scan.nextLine();

    System.out.print("Enter name of customer: ");
    String customerName = scan.nextLine();

    String fetchTime = formattedDate;

    return new Pizza(ID, customerName, fetchTime);
  }

  public void viewActiveOrders(){
    for (int i = 0; i < activePizzas.size(); i++) {
      System.out.println(activePizzas.get(i));
    }
  }

  public void statistics(){
    int[] arr = new int[20];
    int compPiz;

    //Seems to only count 1's?
    //needs to somehow count each pizza ID and display how many of each
    //I.e. 2 1's, 5 2's, 3 3's.
    for (int i = 0; i < completedPizzas.size(); i++) {
      compPiz = completedPizzas.get(i).getID();
      arr[compPiz-1] += 1;
    }
    System.out.println("Total: " + arr[0]);
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
    LocalTime time = LocalTime.now();
    DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
    String formattedDate = time.format(format);

    //failsafe
    if(removalInt < 0){
      removalInt = 0;
    } else if (removalInt > activePizzas.size()) {
      removalInt = activePizzas.size()-1;
    }

    completedPizzas.add(new Pizza(
        activePizzas.get(removalInt).getID(),
        activePizzas.get(removalInt).getCustomerName(),
        formattedDate
    ));
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
