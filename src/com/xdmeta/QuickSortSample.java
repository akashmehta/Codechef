package com.xdmeta;

import java.util.Arrays;

public class QuickSortSample {

    public static void main(String[] args) {
        int[] unsortedArray = {1, 55, 3, 36, 75, 12, 33, 90};
        sort(0, unsortedArray);
    }

    private static void sort(int pivotIndex, int[] unsortedArray) {
        if (pivotIndex < unsortedArray.length) {
            int pivot = unsortedArray[pivotIndex];
            int higherPropertyIndex = 0;
            for (int i = pivotIndex + 1; i < unsortedArray.length; i++) {
                if (pivot > unsortedArray[i]) {
                    if (higherPropertyIndex > 0) {
                        int swapComponent = unsortedArray[higherPropertyIndex] + unsortedArray[i];
                        unsortedArray[higherPropertyIndex] = swapComponent - unsortedArray[higherPropertyIndex];
                        unsortedArray[i] = swapComponent - unsortedArray[i];
                        higherPropertyIndex = i;
                    }
                } else {
                    if (higherPropertyIndex == 0) {
                        higherPropertyIndex = i;
                    }
                }
            }
            if (higherPropertyIndex != pivotIndex + 1) {
                int pivotSwapComponent = unsortedArray[higherPropertyIndex - 1] + pivot;
                unsortedArray[pivotIndex] = pivotSwapComponent - unsortedArray[pivotIndex];
                unsortedArray[higherPropertyIndex - 1] = pivotSwapComponent - unsortedArray[higherPropertyIndex - 1];
            }
            sort(pivotIndex + 1, unsortedArray);
        } else {
            System.out.println(Arrays.toString(unsortedArray) + "" + pivotIndex);
        }
    }
}

// pick first index as pivot
// iterate from second index till the end
// if number is less then pivot then keep updating lessNumberIndex and keep item at position and continue.
    // If greater number came then don't update lessNumberIndex and when smaller number came then replace (lessNumberIndex + 1)
    // with that smaller number index. (Doubt.. should we replace the smaller and bigger number or move all number to next position)
// pivot will pick it's position and new number will be pivot on previous pivot's position which will be lessNumberIndex

// pick pivot and continue


