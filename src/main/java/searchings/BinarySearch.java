package searchings;

import java.util.NoSuchElementException;

public class BinarySearch implements Search {
    @Override
    public int findIndex(int[] array, int elementToBeSearched) {
        int arrayLength = array.length;
        int leftIndex = 0;
        int rightIndex = arrayLength - 1;
        int middleIndex;
        int middleIndexIncremented;

        while(leftIndex != rightIndex) {
            middleIndex = leftIndex + (rightIndex - leftIndex) / 2;
            middleIndexIncremented = middleIndex + 1;

            if (array[middleIndex] == elementToBeSearched) {
                if (middleIndex == leftIndex) {
                    return middleIndex;
                }
                else {
                    rightIndex = middleIndex;
                }
            }
            else if (elementToBeSearched > array[middleIndex]) {
                leftIndex = middleIndexIncremented;
            }
            else if (elementToBeSearched < array[middleIndex]) {
                rightIndex = middleIndexIncremented;
            }
        }

        throw new NoSuchElementException();
    }
}
