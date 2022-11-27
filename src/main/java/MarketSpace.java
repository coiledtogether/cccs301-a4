import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MarketSpace {



    private List<Computer> cart;
    private Map<String, Double> products;

    // CONSTRUCTORS
    public MarketSpace() {
        cart = new ArrayList<Computer>();
    }

    // SINGLETON
    private static MarketSpace marketSpace;

    public static MarketSpace getInstance() {
        if (marketSpace == null) {
            marketSpace = new MarketSpace();
        }

        return marketSpace;
    }

    // SORT STRATEGY
    private SortStrategy sortStrategy;

    public void sort() {
        sortStrategy.sort(cart);
    }

    public void setSortByPrice() {
        this.sortStrategy = new SortByPrice();
    }

    public void setSortByID() {
        this.sortStrategy = new SortByOrderID();
    }

    // LOAD PRODUCTS FROM GIVEN FILENAME
    public void loadProducts(String fileName) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            String line;
            String[] splitLine;
            String name;
            double price;

            while ((line = in.readLine()) != null) {
                splitLine = line.split(",", 2);
                name = splitLine[0];
                price = Double.parseDouble(splitLine[1]);
                products.put(name, price);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // GETSETS
    public List<Computer> getCart() {
        return cart;
    }

    public Map<String, Double> getProducts() {
        return products;
    }

}
