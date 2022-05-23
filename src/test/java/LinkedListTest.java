import dataStructures.LinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LinkedListTest {
    LinkedList<Integer> items;

    @BeforeEach
    public void createTestItems() {
        items = new LinkedList<>();
        items.add(5);
        items.add(2);
        items.add(7);
        items.add(5);
        items.add(-2);
    }
    @Test
    public void addMethodWorksCorrectly() {

        Assertions.assertEquals("5 2 7 5 -2", items.toString().trim());
    }

    @Test
    public void addByIndexInEmptyListMethodWorksCorrectly() {
        items = new LinkedList<>();
        items.add(-20, 4);
        Assertions.assertEquals("-20", items.toString().trim());
    }

    @Test
    public void addByIndexInsideMethodWorksCorrectly() {
        items.add(-20, 2);
        Assertions.assertEquals("5 2 -20 7 5 -2", items.toString().trim());
    }

    @Test
    public void addByIndexZeroMethodWorksCorrectly() {
        items.add(-20, 0);
        Assertions.assertEquals("-20 5 2 7 5 -2", items.toString().trim());
    }


    @Test
    public void getFirstElementByIndexWorksCorrectly() {
        Assertions.assertEquals( 5, items.get(0));
    }

    @Test
    public void getElementBetweenOtherByIndexWorksCorrectly() {
        Assertions.assertEquals( 2, items.get(1));
    }

    @Test
    public void getElementByIndexInEmptyListShouldThrowException() {
        items = new LinkedList<>();
        Assertions.assertThrows(IllegalArgumentException.class, () ->
            items.get(2));
    }

    @Test
    public void getElementByIndexBiggerThanListSizeShouldThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                items.get(10));
    }


    @Test
    public void removeFirstElementByIndexWorksCorrectly() {
        items.remove(0);
        Assertions.assertEquals("2 7 5 -2", items.toString().trim());
    }

    @Test
    public void removeElementBetweenOtherByIndexWorksCorrectly() {
        items.remove((2));
        Assertions.assertEquals( "5 2 5 -2", items.toString().trim());
    }

    @Test
    public void removeElementByIndexInEmptyListShouldThrowException() {
        items = new LinkedList<>();
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                items.remove(2));
    }

    @Test
    public void removeElementByIndexBiggerThanListSizeShouldThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                items.remove(10));
    }

    @Test
    public void sizeMethodWorksCorrectly() {
        Assertions.assertEquals( 5, items.size());
    }

    @Test
    public void iteratorWorksCorrectly() {
        StringBuilder actual = new StringBuilder();
        for (int item : items) {
            actual.append(item);
            actual.append(" ");
        }
        Assertions.assertEquals("5 2 7 5 -2", actual.toString().trim());
    }
}
