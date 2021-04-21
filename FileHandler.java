package MariosPizza;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

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
        save.println();
      }
      save.close();
    } catch(FileNotFoundException e) {
      System.out.println("No file found");
    }
  }

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
