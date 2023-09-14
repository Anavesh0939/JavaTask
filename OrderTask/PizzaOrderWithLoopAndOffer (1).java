package Basic;

import java.util.Scanner;

public class PizzaOrderWithLoopAndOffer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define pizza details
        String[] pizzaNames = {"Small Pizza", "Medium Pizza", "Large Pizza", "Monster Pizza"};
        double[] pizzaPrices = {150.0, 250.0, 300.0, 600.0};

        // Initialize variables to store order details
        int[] pizzaQuantities = new int[pizzaNames.length];
        double totalBill = 0.0;
        String moreOrders = null;

        // Start ordering loop
        do {
            // Display menu and take user input
            System.out.println("Pizza Menu:");
            for (int i = 0; i < pizzaNames.length; i++) {
                System.out.println((i + 1) + ". " + pizzaNames[i] + " - Rs. " + pizzaPrices[i]);
            }
            System.out.print("Enter the number of the pizza you want to order: ");
            int pizzaType = scanner.nextInt();

            // Input validation
            if (pizzaType < 1 || pizzaType > pizzaNames.length) {
                System.out.println("Invalid pizza type. Please choose a valid option.");
                continue; // Skip the rest of the loop iteration
            }

            System.out.print("Enter the quantity: ");
            int quantity = scanner.nextInt();

            // Check if the order qualifies for a free big cold drink
            if (quantity >= 4) {
                System.out.println("Congratulations! You get a free big cold drink with your order.");
            }

            // Update pizza quantities
            pizzaQuantities[pizzaType - 1] += quantity;

            // Calculate the total bill
            totalBill += pizzaPrices[pizzaType - 1] * quantity;

            // Ask if the user wants to order more
            System.out.print("Do you want to order more (yes/no)? ");
            moreOrders = scanner.next().toLowerCase();

        } while (moreOrders.equals("yes"));

        // Display the final bill
        System.out.println("Your order summary:");
        for (int i = 0; i < pizzaQuantities.length; i++) {
            if (pizzaQuantities[i] > 0) {
                System.out.println(pizzaNames[i] + " - Quantity: " + pizzaQuantities[i]);
            }
        }
        System.out.println("Total Bill: Rs. " + totalBill);

        // Close the scanner
        scanner.close();
    }
}
