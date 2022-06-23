package other.spiral;

import java.util.Arrays;

public class SpiralArrayFiller {
    public static void main(String[] args) {
        int[][] array = create(3,3);
        System.out.println(Arrays.deepToString(array));
    }

    public static int[][] create(int rows, int cols) {
        int[][] array = new int[rows][cols];
        int numberCounter = 1;
        int dimensionDecrease = 0;

        int currentRow = 0;
        int currentCol = 0;

        int lastRow = rows - 1;
        int lastCol = cols - 1;

        //right -> down -> left -> up -> repeat
        while (numberCounter != rows*cols+1) {
            if (isLastItem(array, numberCounter)) {
                array[currentRow][currentCol] = numberCounter;
                break;
            }

            for (;currentCol < lastCol-dimensionDecrease; currentCol++) {
                if (notEmpty(array, currentRow, currentCol)) break;
                array[currentRow][currentCol] = numberCounter;
                numberCounter++;
            }
            for (;currentRow < lastRow-dimensionDecrease; currentRow++) {
                if (notEmpty(array, currentRow, currentCol)) break;
                array[currentRow][currentCol] = numberCounter;
                numberCounter++;
            }
            for (;currentCol > dimensionDecrease; currentCol--) {
                if (notEmpty(array, currentRow, currentCol)) break;
                array[currentRow][currentCol] = numberCounter;
                numberCounter++;
            }

            dimensionDecrease++;

            for (;currentRow > dimensionDecrease; currentRow--) {
                if (notEmpty(array, currentRow, currentCol)) break;
                array[currentRow][currentCol] = numberCounter;
                numberCounter++;
            }
        }

        return array;
    }

    private static boolean isLastItem(int[][] array, int numberCounter) {
        int rows = array.length;
        int cols = array[0].length;
        return numberCounter == rows * cols;
    }

    private static boolean notEmpty(int[][] array, int currentRow, int currentCol) {
        return array[currentRow][currentCol] != 0;
    }
}
