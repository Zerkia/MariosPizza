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
  public void saveFile(ArrayList<Pizza> pizzas) {
    File file = new File("src/MariosPizza/aktiveOrdre.txt");
    try{
      PrintStream save = new PrintStream(file);
      for (int i = 0; i < pizzas.size(); i++) {
        save.println(pizzas.get(i).getID());
        save.println(pizzas.get(i).getName());
        save.println(pizzas.get(i).getPrice());
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
}
