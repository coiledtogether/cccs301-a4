/**
 * Class: CCCS-301-774
 * Name: Nil Mackay
 * ID: 261077199
 */

import java.util.Comparator;
import java.util.List;

public class SortByPrice implements SortStrategy {

    @Override
    public void sort(List<Computer> cart) {
        cart.sort(new PriceComparator());
    }

    class PriceComparator implements Comparator<Computer> {

        @Override
        public int compare(Computer c, Computer v) {
            return Double.compare(c.getPrice(), v.getPrice());
        }
    }


}
