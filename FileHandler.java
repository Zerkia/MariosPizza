package MariosPizza;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * FileHandler = Nikolaj ide (Work in Progress, ownership can change)
 *
 */

public class FileHandler {
  /**public void saveFile(ArrayList<User> users) {
    File file = new File("MariosPizza/aktiveOrdre.txt");
    try{
      PrintStream save = new PrintStream(file);
      for (int i = 0; i < users.size(); i++) {
        save.println(users.get(i));
      }
      save.close();
    } catch(FileNotFoundException e) {
      System.out.println("No file found");
    }
  }*/

  public ArrayList<String> readActiveOrders() {
    File file = new File("MariosPizza/aktiveOrdre.txt");
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
    File file = new File("MariosPizza/færdigeOrdre.txt");
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
