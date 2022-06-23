import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import other.spiral.SpiralArrayFiller;

import java.util.Arrays;

public class SpiralArrayFillerTest {
    @Test
    public void shouldWorkFor1x1Array() {
        int[][] actual = SpiralArrayFiller.create(1,1);
        int[][] expected = {{1}};
        Assertions.assertTrue(Arrays.deepEquals(actual, expected));
    }
    @Test
    public void shouldWorkFor2x2Array() {
        int[][] actual = SpiralArrayFiller.create(2,2);
        int[][] expected = {{1,2},{4,3}};
        Assertions.assertTrue(Arrays.deepEquals(actual, expected));
    }
    @Test
    public void shouldWorkFor3x3Array() {
        int[][] actual = SpiralArrayFiller.create(3,3);
        int[][] expected = {{1,2,3},{8,9,4},{7,6,5}};
        Assertions.assertTrue(Arrays.deepEquals(actual, expected));
    }
    @Test
    public void shouldWorkFor4x4Array() {
        int[][] actual = SpiralArrayFiller.create(4,4);
        int[][] expected = {{1,2,3,4},{12,13,14,5},{11,16,15,6},{10,9,8,7}};
        Assertions.assertTrue(Arrays.deepEquals(actual, expected));
    }
    @Test
    public void shouldWorkFor5x5Array() {
        int[][] actual = SpiralArrayFiller.create(5,5);
        int[][] expected = {{1,2,3,4,5},{16,17,18,19,6}, {15,24,25,20,7}, {14,23,22,21,8}, {13,12,11,10,9}};
        Assertions.assertTrue(Arrays.deepEquals(actual, expected));
    }

    @Test
    public void shouldWorkFor4x2Array() {
        int[][] actual = SpiralArrayFiller.create(4,2);
        int[][] expected = {{1,2},{8,3},{7,4},{6,5}};
        Assertions.assertTrue(Arrays.deepEquals(actual, expected));
    }

    @Test
    public void shouldWorkFor2x4Array() {
        int[][] actual = SpiralArrayFiller.create(2,4);
        int[][] expected = {{1,2,3,4},{8,7,6,5}};
        Assertions.assertTrue(Arrays.deepEquals(actual, expected));
    }
}
