package MariosPizza;

import java.util.Scanner;

public class DisplayMenu {
  private String menuHeader;
  private String leadText;
  private String[] menuItems;

  public DisplayMenu(String menuHeader, String leadText, String[] menuItems){
    this.menuHeader = menuHeader;
    this.leadText = leadText;
    this.menuItems = menuItems;
  }

  public void printMenu(){
    String printString = menuHeader + "\n";

    for (int i = 0; i < menuItems.length; i++) {
      printString += menuItems[i] + "\n";
    }
    System.out.println("\n" + printString);
  }

  public int readChoice(){
    Scanner scan = new Scanner(System.in);
    boolean validChoice = false;
    int choice = 0;

    while(!validChoice){
      System.out.print(leadText);
      if(scan.hasNextInt()){
        choice = scan.nextInt();
        validChoice = true;
      } else {
        scan.nextLine();
      }
    }
    return choice;
  }
}
