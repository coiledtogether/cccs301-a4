/**
 * Class: CCCS-301-774
 * Name: Nil Mackay
 * ID: 261077199
 */

import java.io.IOException;
import java.util.*;

public class Main {

    private static MarketSpace marketSpace;

    public static void main(String[] args) throws IOException {
        
        // Init the marketspace
        marketSpace = MarketSpace.getInstance();

        // args[0] = fileName in resources dir = products.txt
        marketSpace.loadProducts(args[0]);

        // Input scanner
        Scanner sc = new Scanner(System.in);

        mainMenu(sc);

    }

    // Main menu
    public static void mainMenu(Scanner sc) {
        while (true) {
            printBreak();
            System.out.println("Hi, what would you like to do?");
            System.out.println("1: Buy a computer");
            System.out.println("2: See my shopping cart");
            System.out.println("3: Sort by order ID (Descending)");
            System.out.println("4: Sort by order price (Descending)");
            System.out.println("0: Quit");

            switch (sc.nextLine()) {
                case "1": // Buy
                    buyMenu(sc);
                    break;
                case "2": // View cart
                    cartMenu();
                    break;
                case "3": // Sort by ID
                    marketSpace.setSortByID();
                    marketSpace.sort();
                    printBreak();
                    System.out.println("Sorted cart by ID.");
                    break;
                case "4": // Sort by price
                    marketSpace.setSortByPrice();
                    marketSpace.sort();
                    printBreak();
                    System.out.println("Sorted cart by price.");
                    break;
                case "q": // Quit
                    return;
                default:
                    break;
            }

        }
    }
    public static void buyMenu(Scanner sc) {

        Computer computer = new DefaultComputer();

        while (true) {
            printBreak();
            System.out.println("Selection: " + computer.getDescription());
            System.out.println("Price: $" + computer.getPrice());
            System.out.println("What would you like to add to your order?");

            Map<Integer, Component> productList = marketSpace.getProducts();

            // Show all available products
            // This feels inefficient, TODO FIX ME
            for (int i = 1; i <= productList.size(); i++) {
                System.out.println("~ " + i + ": " + productList.get(i));

            }
            System.out.println("~ a: Add to cart");
            System.out.println("~ c: Clear selection");

            // Menu selection
            String productKey = sc.nextLine();

            try {

                if (productKey.equals("a")) { // Exit code
                    marketSpace.addToCart(computer);
                    return; // TODO figure out what's making the main menu print twice after this

                } else if (productKey.equals("c")) { // Reset the computer TODO make this interact nicely with auto-incrementing id
                    computer = new DefaultComputer();

                    // Create new component with chosen product info
                } else {

                    // Parse key to int first
                    int productKeyInt = Integer.parseInt(productKey);

                    Component componentChoice = marketSpace.getProducts().get(productKeyInt);

                    computer = new Component(componentChoice, computer);
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Press any key to continue.");
                sc.nextLine();

            } catch (NullPointerException e) {
                System.out.println("Product not found! Press any key to continue.");
                sc.nextLine();
            }
        }

    }

    public static void cartMenu() {
        printBreak();

        List<Computer> cart = marketSpace.getCart();

        printBreak();
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");

        } else {
            System.out.println(cart);
        }

    }

    public static void printBreak() {
        System.out.println("********************************");
    }


}
