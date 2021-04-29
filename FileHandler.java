package MariosPizza;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * FileHandler = Nikolaj, Mads
 *
 */

public class FileHandler {
  public void saveActivePizzas(ArrayList<Pizza> activePizzas) {
    File file = new File("src/MariosPizza/aktiveOrdre.txt");

    try{
      PrintStream save = new PrintStream(file);
      for (int i = 0; i < activePizzas.size(); i++) {
        save.println(activePizzas.get(i).getID());
        save.println(activePizzas.get(i).getCustomerName());
        save.println(activePizzas.get(i).getTime());
        save.println();
      }
      save.close();
    } catch(FileNotFoundException e) {
      System.out.println("No file found");
    }
  }

  public void saveCompletedPizzas(ArrayList<Pizza> completedPizzas) {
    File file = new File("src/MariosPizza/færdigeOrdre.txt");
    try{
      PrintStream save = new PrintStream(file);
      for (int i = 0; i < completedPizzas.size(); i++) {
        save.println(completedPizzas.get(i).getID());
        save.println(completedPizzas.get(i).getCustomerName());
        save.println(completedPizzas.get(i).getTime());
        save.println();
      }
      save.close();
    } catch(FileNotFoundException e) {
      System.out.println("No file found");
    }
  }

  //Prototype file handler for multiple files at once rather than
  //having to duplicate code.
  //Is called by savePizzas(Arraylist type (activePizzas, completedPizzas etc),
  //followed by file name
  //Example: pizzaFiles.savePizza(activePizza, "aktiveOrdre.txt")
  /**public void savePizzas(ArrayList<Pizza> pizzas, String fileName) {
    File file = new File("src/MariosPizza/" + fileName);
    try{
      PrintStream save = new PrintStream(file);
      for (int i = 0; i < pizzas.size(); i++) {
        save.println(pizzas.get(i).getID());
        save.println(pizzas.get(i).getCustomerName());
        save.println(pizzas.get(i).getTime());
        save.println();
      }
      save.close();
    } catch(FileNotFoundException e) {
      System.out.println("No file found");
    }
  }*/

  public ArrayList<String> readActiveOrders() {
    File file = new File("src/MariosPizza/aktiveOrdre.txt");
    ArrayList<String> output = new ArrayList<>();

    try{
      Scanner scan = new Scanner(file);
      while (scan.hasNextLine()){
        output.add(scan.nextLine());
      }
    } catch(FileNotFoundException e) {
      System.out.println("No File Found");
    }
    return output;
  }

  public ArrayList<String> readCompletedOrders() {
    File file = new File("src/MariosPizza/færdigeOrdre.txt");
    ArrayList<String> output = new ArrayList<>();

    try{
      Scanner scan = new Scanner(file);
      while (scan.hasNextLine()){
        output.add(scan.nextLine());
      }
    } catch(FileNotFoundException e) {
      System.out.println("No File Found");
    }
    return output;
  }
}
