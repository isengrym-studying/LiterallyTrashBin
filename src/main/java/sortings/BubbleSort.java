package sortings;

import java.util.Collections;
import java.util.List;

public class BubbleSort implements Sorting {
    @Override
    public List<Integer> sort(List<Integer> items) {
        boolean isSorted;
        int endIndex = items.size() - 1;

        do {
            isSorted = true;
            for (int i = 0; i < endIndex; i++) {
                if (i != items.size()-1 &&
                        items.get(i) > items.get(i+1)) {

                    Collections.swap(items, i, i+1);
                    isSorted = false;
                }
            }
            endIndex -= 1;
        } while(!isSorted);

        return items;
    }
}
