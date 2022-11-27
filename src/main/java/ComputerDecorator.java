public class ComputerDecorator implements Computer {

    Computer computer;

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

    @Override
    public String getOrderID() {
        return this.computer.getOrderID();
    }
}
