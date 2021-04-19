package com.xdmeta;

import java.util.Arrays;

// Given the array and int. Find and replace int in array with 1. and Move all once to the left and rest to the left
public class HealthifyPracticalOne {

    public static void main(String[] args) {
        int[] ar = {2, 4, 24, 55, 6, 7, 8, 3, 24};
        int[] outAr = {1, 1, 2, 6, 55, 6, 7, 8, 3};
        int x = 24;
        filterArray(ar, x, 0, ar.length - 1);
        System.out.println(Arrays.toString(ar));
    }

    private static void filterArray(int[] ar, int x, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;
            filterArray(ar, x, startIndex, mid);
            filterArray(ar, x, mid + 1, endIndex);
            filter(ar, x, startIndex, endIndex, mid);
        }
    }

    private static void filter(int[] ar, int x, int startIndex, int endIndex, int mid) {
        int i = startIndex, j = mid + 1;

        while (i <= mid && j <= endIndex) {
            if (ar[i] == x || ar[j] == x) {
                if (ar[i] == x) {
                    ar[i] = 1;
                } else {
                    ar[j] = 1;
                }
            }
            i++; j++;
        }

        int buffer = -1;
        for (int k = 0; k < ar.length; k++) {
            if (ar[k] != 1) {
                if (buffer == -1) buffer = k;
            } else if (buffer != -1) {
                ar[k] = ar[buffer];
                ar[buffer] = 1;
                buffer = -1;
            }
        }
    }

}
