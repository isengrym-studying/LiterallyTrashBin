import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import searchings.BinarySearch;
import searchings.Search;

public class SearchingTest {
    Search search;
    int[] sortedArray;
    int index;

    @BeforeEach
    public void createData() {
        sortedArray = new int[] {-6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 3, 3, 4, 5, 6, 7, 7, 8, 9, 10};
        index = 15;
    }

    @Test
    public void isBinarySearchWorkingCorrectly() {
        search = new BinarySearch();
        Assertions.assertEquals(index, search.findIndex(sortedArray, sortedArray[index]));
    }

}
