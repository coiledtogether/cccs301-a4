/**
 * Class: CCCS-301-774
 * Name: Nil Mackay
 * ID: 261077199
 */

import java.io.*;
import java.util.*;

public class MarketSpace {



    private List<Computer> cart;
    private final Map<Integer, Component> products;
    private SortStrategy sortStrategy;
    private static MarketSpace marketSpace;

    // Constructor
    public MarketSpace() {
        this.cart = new ArrayList<>(); this.products = new HashMap<>();
    }

    // Singleton (getInstance)
    public static MarketSpace getInstance() {
        if (marketSpace == null) {
            marketSpace = new MarketSpace();
        }

        return marketSpace;
    }

    // Sort strategies
    public void sort() {
        sortStrategy.sort(cart);
    }

    public void setSortByPrice() {
        this.sortStrategy = new SortByPrice();
    }

    public void setSortByID() {
        this.sortStrategy = new SortByOrderID();
    }

    // Loads products from a file path
    public void loadProducts(String fileName) throws IOException {
        try (InputStream inStrm = getClass().getResourceAsStream(fileName)) {
            InputStreamReader inStrmRead = new InputStreamReader(inStrm);
            BufferedReader in = new BufferedReader(inStrmRead);

            String line;
            String[] splitLine;
            String name;
            double price;
            int counter = 1;

            // Reads each line from the file
            while ((line = in.readLine()) != null) {
                splitLine = line.split(",", 2); // Splits each line into two

                name = splitLine[0];
                price = Double.parseDouble(splitLine[1]);

                products.put(counter, new Component(name, price));
                counter++; // Ensures each product's key is unique
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException("Error while reading products list from file, check your args!", e);
        }
    }

    // Gets/sets
    public List<Computer> getCart() {
        return cart;
    }

    // Adds a computer to the cart
    public void addToCart(Computer computer) {
        this.cart.add(computer);
    }

    // Gets the product list (map)
    public Map<Integer, Component> getProducts() {
        return products;
    }

}
