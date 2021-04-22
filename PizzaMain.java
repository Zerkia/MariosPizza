package MariosPizza;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * Nikolaj, Mads
 *
 * Technically finished, but some methods have room for improvement and probably some sort of optimization.
 *
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

  //Doesn't work if aktiveOrdre.txt is empty
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

    return new Pizza(ID, customerName, formattedDate);
  }

  //Doesn't work if færdigeOrdre.txt is empty
  public void deleteActiveOrder() {
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

  //Could maybe have a sorting logic for the most recent time?
  //A.k.a. the most urgent order that needs to be completed within the 1 hour.
  public void viewActiveOrders(){
    for (int i = 0; i < activePizzas.size(); i++) {
      System.out.println(activePizzas.get(i));
    }
  }

  public void viewCompletedOrders(){
    for (int i = 0; i < completedPizzas.size(); i++) {
      System.out.println(completedPizzas.get(i));
    }
  }

  //Could have a formula for displaying a sentence saying which pizza is the most popular?
  public void ViewStatistics(){
    int[] arr = new int[menu.menuKort.size()];
    int compPiz;

    for (int j = 0; j < completedPizzas.size(); j++) {
      compPiz = completedPizzas.get(j).getID();
      arr[compPiz-1] += 1;
    }

    for (int i = 0; i < arr.length; i++) {
      System.out.println("Total amount of no. " + (i+1) + " " + menu.menuKort.get(i).getName() + "'s: " + arr[i]);
    }
  }

  //Doesn't work if either aktiveOrdre.txt or færdigeOrdre.txt is empty
  void run(){
    DisplayMenu displayMenu =
        new DisplayMenu(
            "Menu:",
            "Please choose option: ",
            new String[] {
            "1. View pizza menu", "2. Create new order", "3. Delete order / Add completed order",
            "4. View active orders", "5. view completed orders", "6. View statistics over completed orders",
            "9. Quit"});

    displayMenu.printMenu();
    boolean isRunning = true;

    while(isRunning){
      int choice = displayMenu.readChoice();
      switch (choice) {
        case 1:
          menu.displayMenuKort();
          displayMenu.printMenu();
          break;

        case 2:
          activePizzas.add(createNewOrder());
          pizzaFiles.saveActivePizzas(activePizzas);
          displayMenu.printMenu();
          break;

        case 3:
          deleteActiveOrder();
          pizzaFiles.saveCompletedPizzas(completedPizzas);
          pizzaFiles.saveActivePizzas(activePizzas);
          displayMenu.printMenu();
          break;

        case 4:
          viewActiveOrders();
          displayMenu.printMenu();
          break;

        case 5:
          viewCompletedOrders();
          displayMenu.printMenu();
          break;

        case 6:
          ViewStatistics();
          displayMenu.printMenu();
          break;

        case 42:
          System.out.println("Du har fundet meningen med livet! Hav en go' dag! :)");
          displayMenu.printMenu();
          break;

        case 9:
          isRunning = false;
          break;

        default:
          System.out.println("Choose one of the designated numbers please.");
      }
    }
    pizzaFiles.saveActivePizzas(activePizzas);
    pizzaFiles.saveCompletedPizzas(completedPizzas);
  }

  public static void main(String[] args) {
    new PizzaMain().run();
  }
}
