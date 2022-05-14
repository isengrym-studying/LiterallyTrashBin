package sortings;

import java.util.List;

public class InsertionSort implements Sorting {
    @Override
    public List<Integer> sort(List<Integer> items) {
        for (int i = 0; i < items.size(); i++) {
            int j = i;

            if (i != 0 && items.get(i) < items.get(i-1)) {
                while(j >= 0) {
                    if(items.get(j) < items.get(i)) {
                        items.add(j+1, items.get(i));
                        items.remove(i+1);
                        break;
                    }
                    else if (j == 0) {
                        items.add(0, items.get(i));
                        items.remove(i+1);
                    }
                    j--;
                }
            }
        }
        return items;
    }
}
