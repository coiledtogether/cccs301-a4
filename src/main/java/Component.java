/**
 * Class: CCCS-301-774
 * Name: Nil Mackay
 * ID: 261077199
 */

public class Component extends ComputerDecorator {

    private String name;
    private double price;

    // Constructors TODO can't tell if i need this??
    public Component(Computer computer) {
        super(computer);
    }

    public Component(Component choice, Computer computer) {
        super(computer);
        this.name = choice.name;
        this.price = choice.price;
    }

    public Component(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getDescription() {
        return computer.getDescription() + " + " + name;
    }

    public double getPrice() {
        return computer.getPrice() + price;
    }

    public String toString() {
        if (this.computer == null) {
            return this.name + " ($" + this.price + ")";

        } else {
            return this.computer.getOrderID() + " " + this.getDescription() + " " + this.getPrice();

        }
    }

}
