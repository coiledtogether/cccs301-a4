import java.util.Comparator;
import java.util.List;

public class SortByOrderID implements SortStrategy {

    @Override
    public void sort(List<Computer> cart) {
        cart.sort(new OrderIDComparator());
    }

    class OrderIDComparator implements Comparator<Computer> {

        @Override
        public int compare(Computer c, Computer v) {
            return Integer.compare(c.getOrderID(), v.getOrderID());
        }
    }
}
