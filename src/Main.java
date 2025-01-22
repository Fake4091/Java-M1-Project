import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Order order = new Order();
    System.out.println("Welcome to JavaBurger, may I take your order?");
    printMenu();

    String option = "";
    Scanner scanner = new Scanner(System.in);
    while (!option.toLowerCase().equals("q")) {
      System.out.println(
          "Type the Item you'd like to order, or type [print] to print out\nthe menu again, [subtotal] to print out the subtotal, or [q] if you're done ordering.");
      System.out.print("> ");
      option = scanner.nextLine();

      switch (option.toLowerCase()) {
        case "cheeseburger":
          System.out.println("Adding a cheeseburger");
          order.addItem("Cheeseburger", 5.20f);
          break;
        case "hamburger":
          System.out.println("Adding a hamburger");
          order.addItem("Hamburger", 4.99f);
          break;
        case "fries":
          System.out.println("Adding fries");
          order.addItem("Fries", 3.50f);
          break;
        case "drink":
          System.out.println("Adding a dring");
          order.addItem("Drink", 1.99f);
          break;
        case "subtotal":
          System.out.print("Subtotal: $");
          System.out.printf("%.2f", order.processOrder());
          System.out.println();
          break;
        case "print":
          printMenu();
          System.out.println();
          break;
        case "q":
          System.out.println("Thanks for coming in! You have ordered:");
          order.printOrder();
          break;
        default:
          System.out.println("Invalid option");
          break;
      }
      System.out.println();
    }

    order.printOrder();
    System.out.print("Your total is $");
    System.out.printf("%.2f", order.processOrder());
    System.out.println();
    System.out.println("Thanks for visting JavaBurger, come again!");
  }

  private static void printMenu() {
    System.out.println("Cheeseburger - $5.20");
    System.out.println("Hamburger - $4.99");
    System.out.println("Fries - $3.50");
    System.out.println("Drink - $1.99");
  }
}

class Order {
  Map<String, Float> items = new HashMap<String, Float>();

  void addItem(String item, Float price) {
    items.put(item, price);
  }

  void printOrder() {
    System.out.println("Order: ");
    for (int i = 0; i < items.size(); i++) {
      String item = items.keySet().toArray()[i].toString();
      System.out.print("  " + item + " - $");
      System.out.printf("%.2f", items.get(item));
      System.out.println();
    }
  }

  Float processOrder() {
    Float total = 0f;
    for (int i = 0; i < items.size(); i++) {
      total += items.get(items.keySet().toArray()[i]);
    }
    return total;
  }
}
