import java.util.*;

public class Main {

    private static MarketSpace marketSpace;

    public static void main(String[] args) {

        // init the marketspace
        marketSpace = MarketSpace.getInstance();

        // args[0] = file name = products.txt
        marketSpace.loadProducts(args[0]);

        // UI
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Hi, what would you like to do?");
            System.out.println("1: Buy a computer");
            System.out.println("2: See my shopping cart");
            System.out.println("3: Sort by order ID (Descending)");
            System.out.println("4: Sort by order price (Descending)");
            System.out.println("5: Quit");

            switch (sc.nextLine()) {
                case "1": // buy
                    break;
                case "2": // cart
                    break;
                case "3": // id sort
                    marketSpace.setSortByID();
                    marketSpace.sort();
                    System.out.println("Sorted by ID!");
                    break;
                case "4": // price sort
                    marketSpace.setSortByPrice();
                    marketSpace.sort();
                    System.out.println("Sorted by price!");
                    break;
                case "5": // exit
                    break;
                default:
                    break;
            }

        }
    }

    public void showBuyMenu() {
        Map<String, Map<String, Integer>> menuItems = new HashMap<>();
        String item;

        for (int i = 1; i <= marketSpace.getProducts().size(); i++) {
            menuItems.add
        }

        for (String s : marketSpace.getProducts().keySet()) {
            item = ++i + ": " + s + " " + marketSpace.getProducts().get(s);
            menuItems.add(item);
            System.out.println(item);
        }
    }

    public String showCartMenu() {
        List<Computer> cart = marketSpace.getCart();

        if (cart.isEmpty()) {
            return "No items";
        } else {
            return cart.toString();
        }

    }


}
