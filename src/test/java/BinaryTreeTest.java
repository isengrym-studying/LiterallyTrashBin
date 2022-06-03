import dataStructures.BinaryTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

public class BinaryTreeTest {
    BinaryTree binaryTree;
    @BeforeEach
    public void createData() {
        binaryTree = new BinaryTree();
        binaryTree.add(10);
        binaryTree.add(15);
        binaryTree.add(26);
        binaryTree.add(5);
        binaryTree.add(16);
        binaryTree.add(17);
        binaryTree.add(1);
        binaryTree.add(12);
        binaryTree.add(20);
        binaryTree.add(6);
        binaryTree.add(31);
        binaryTree.add(13);
    }

    @Test
    public void containsValueShouldReturnTrue() {
        Assertions.assertTrue(binaryTree.contains(5));
    }
    @Test
    public void containsValueShouldReturnFalse() {
        Assertions.assertFalse(binaryTree.contains(657));
    }
    @Test
    public void deleteMethodWorksCorrectly() {
        Assertions.assertTrue(binaryTree.contains(15));
        binaryTree.delete(15);
        Assertions.assertFalse(binaryTree.contains(15));
    }
    @Test
    public void traverseMethodGathersNodesInAscOrder() {
        String actual = binaryTree.traverse().toString();
        String expected = "[1, 5, 6, 10, 12, 13, 15, 16, 17, 20, 26, 31]";
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void sizeMethodWorksCorrectly() {
        int actual = binaryTree.size();
        int expected = 12;
        Assertions.assertEquals(expected, actual);
    }

}
