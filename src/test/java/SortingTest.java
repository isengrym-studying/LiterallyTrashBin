import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sortings.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SortingTest {
    List<Integer> objectsToBeSorted;
    List<Integer> expected;
    Sorting sorting;

    @BeforeEach
    public void createDataToSort() {
        objectsToBeSorted = new ArrayList<>(Arrays.asList(
                1, 6, 8, -2, 3, 7, 9, 12, 2, 3, 15, 8, 0, 4, -7, 6, 7
        ));
        expected = new ArrayList<>(Arrays.asList(
                -7, -2, 0, 1, 2, 3, 3, 4, 6, 6, 7, 7, 8, 8, 9, 12, 15
        ));
    }
    @Test
    public void isBubbleSortingWorksCorrectly() {
        sorting = new BubbleSort();
        assertEquals(expected, sorting.sort(objectsToBeSorted));
    }

    @Test
    public void isInsertionSortingWorksCorrectly() {
        sorting = new InsertionSort();
        assertEquals(expected, sorting.sort(objectsToBeSorted));
    }

    @Test
    public void isQuickSortingWorksCorrectly() {
        sorting = new QuickSort();
        assertEquals(expected, sorting.sort(objectsToBeSorted));
    }

    @Test
    public void isCocktailSortingWorksCorrectly() {
        sorting = new CocktailSort();
        assertEquals(expected, sorting.sort(objectsToBeSorted));
    }
}
