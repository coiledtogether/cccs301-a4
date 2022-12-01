/**
 * Class: CCCS-301-774
 * Name: Nil Mackay
 * ID: 261077199
 */

public class DefaultComputer implements Computer {

    private final String orderID;
    private final String description;
    private final double price;
    private static int idCounter = 0; // Makes sure all IDs are unique

    public DefaultComputer() {
        idCounter++;
        this.orderID = "Order@" + idCounter;
        this.description = "Default Computer";
        this.price = 700.0;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getOrderID() {
        return this.orderID;
    }

    public String toString() {
        return this.orderID + " " + this.description + " " + this.price;
    }
}
