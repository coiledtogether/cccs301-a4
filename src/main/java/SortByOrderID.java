/**
 * Class: CCCS-301-774
 * Name: Nil Mackay
 * ID: 261077199
 */

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
            String[] splitC = c.getOrderID().split("@", 2);
            String[] splitV = v.getOrderID().split("@", 2);

            int intC = Integer.parseInt(splitC[1]);
            int intV = Integer.parseInt(splitV[1]);

            return Integer.compare(intC, intV);
        }
    }
}
