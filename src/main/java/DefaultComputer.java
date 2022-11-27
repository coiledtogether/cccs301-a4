public class DefaultComputer implements Computer {

    String orderID;
    String description;
    double price;

    public DefaultComputer(int id) {
        orderID = "Order@" + id;
        description = "Default Computer";
        price = 700.0;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getOrderID() {
        return orderID;
    }

    public String toString() {
        return orderID + " " + description + " " + price;
    }
}
