package com.xdmeta;

import java.util.Arrays;

public class MergeSort {

    private static void sort(int startIndex, int endIndex, int[] sampleAr) {
        if (startIndex < endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;
            sort(startIndex, mid, sampleAr);
            sort(mid+1, endIndex, sampleAr);
            merge(startIndex, endIndex, mid, sampleAr);
        }
    }

    private static void merge(int startIndex, int endIndex, int mid, int[] sampleAr) {
        // init parallel comparision for both parts
        int i = startIndex;

        int j = mid + 1;

        int k = 0;
        int[] tempAr = new int[endIndex - startIndex + 1];

        while (i <= mid && j <= endIndex) {
            if (sampleAr[i] <= sampleAr[j] ) {
                tempAr[k++] = sampleAr[i++];
            } else {
                tempAr[k++] = sampleAr[j++];
            }
        }


        while (i <= mid) {
            tempAr[k++] = sampleAr[i++];
        }

        while (j <= endIndex) {
            tempAr[k++] = sampleAr[j++];
        }

        int tempI = 0;
        for (int l = startIndex; l < endIndex - startIndex + 1; l++) {
            if (tempAr.length > tempI) {
                sampleAr[l] = tempAr[tempI++];
            }
        }
    }

    public static void main(String[] args) {
        int[] unsortedArray = {1, 55, 4, 92, 2 , 3 ,5};
        sort(0, unsortedArray.length -1, unsortedArray);

        System.out.println(Arrays.toString(unsortedArray));
    }
}
