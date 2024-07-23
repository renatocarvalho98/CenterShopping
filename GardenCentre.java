
package CenterShopping;

import java.util.Scanner;

public class GardenCentre {
    public static void main(String[] args) {
        // Create a shopping trolley to put items
        ShoppingTrolley myTrolley = new ShoppingTrolley();
        Scanner scanner = new Scanner(System.in);
        
     // Main menu looping 
     
        while (true) {
             // Display the menu options
            System.out.println("Welcome to the Renato Fruts! Please choose an option:");
            System.out.println("1. Buy Banana ($0.50 each)");
            System.out.println("2. Buy Apple ($1.00 each)");
            System.out.println("3. Buy Watermelon ($1.50 each)");
            System.out.println("4. Buy Grape ($0.90 each)");
            System.out.println("5. Check Trolley");
            System.out.println("6. Proceed to Checkout");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            try {
                int option = Integer.parseInt(choice);
                if (option == 1) {
                    System.out.print("Enter quantity: ");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < quantity; i++) {
                        myTrolley.buyItem(new Banana(0.50));
                    }
                    System.out.println(quantity + " Banana(s) added to the trolley.");
                    
                } else if (option == 2) {
                    System.out.print("Enter quantity: ");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < quantity; i++) {
                        myTrolley.buyItem(new Apple(1.00));
                    }
                    System.out.println(quantity + " Apple(s) added to the trolley.");
                    
                      } else if (option == 3) {
                    System.out.print("Enter quantity: ");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < quantity; i++) {
                        myTrolley.buyItem(new Watermelon(1.50));
                    }
                    System.out.println(quantity + " Watermelon(s) added to the trolley.");
                    
                       } else if (option == 4) {
                    System.out.print("Enter quantity: ");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < quantity; i++) {
                        myTrolley.buyItem(new Grape(0.90));
                    }
                    System.out.println(quantity + " Grape(s) added to the trolley.");
                       }
                    else if (option == 5) {
                        // Check trolley contents (what has inside)
                    System.out.println("Checking trolley...");
                    String trolleyContents = myTrolley.viewTrolley();
                    if (trolleyContents.isEmpty()) {
                        System.out.println("Trolley is empty.");
                        
                    } else {
                        System.out.println("Items in your trolley:");
                        System.out.println(trolleyContents);
                    }
                   
                    // Prompt to clean trolley or return to menu
                    System.out.println("1. Clean Trolley");
                    System.out.println("2. Back to Menu");
                    System.out.print("Enter your choice: ");
                    String subChoice = scanner.nextLine();
                    
                    if (subChoice.equals("1")) {
                        myTrolley.clearTrolley();
                        System.out.println("Trolley has been cleaned.");
                    } else if (!subChoice.equals("2")) {
                        System.out.println("Invalid option. Returning to menu.");
                    }
                    
                } else if (option == 6) {
                    // Proceed to checkout
                    System.out.println("Proceeding to checkout...");
                    System.out.println("Items in your trolley:");
                    System.out.println(myTrolley.emptyTrolley());
                    break;
                } else {
                     // Handle invalid menu options
                    System.out.println("Invalid option. Please try again.");
                }
            } catch (NumberFormatException e) {
                 // Handle invalid input (non-integer input)
                System.out.println("Invalid input. Please enter numbers only.");
            }
        }

        scanner.close();
    }
}

