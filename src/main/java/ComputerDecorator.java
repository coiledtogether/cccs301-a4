/**
 * Class: CCCS-301-774
 * Name: Nil Mackay
 * ID: 261077199
 */

public abstract class ComputerDecorator implements Computer {

    Computer computer;

    public ComputerDecorator() {}

    public ComputerDecorator(Computer computer) {
        this.computer = computer;
    }


    @Override
    public String getDescription() {
        return this.computer.getDescription();
    }

    @Override
    public double getPrice() {
        return this.computer.getPrice();
    }

    public String toString() {
        return this.computer.toString();
    }

    @Override
    public String getOrderID() {
        return this.computer.getOrderID();
    }
}
