package com.xdmeta;

public class QuickSort {

    private static int buffer1 = 0, buffer2 = 0;

    public static void main(String a[]) {
        int[] ar = new int[]{12,6,9,3,25,7,2,58,1,8};
        int[] sortedAr = sort(ar);
        for (int k = 0; k < sortedAr.length; k++) {
            System.out.println("sortedAr = " + sortedAr[k]);
        }
    }

    private static int[] sort(int ar[]) {
        int[] sortedAr = new int[ar.length];

        if (ar.length <= 1) {
            sortedAr = ar;
        } else if (ar.length == 2) {
            if (ar[0] > ar[1]) {
                buffer1 = ar[0];
                buffer2 = ar[1];
                ar[0] = buffer2;
                ar[1] = buffer1;
            }
            sortedAr = ar;
        } else {
            int i = 0;
            int pivot = ar[ar.length - 1];
            for (int j = 0; j < ar.length - 1; j++) {
                if (ar[j] < pivot) {
                    buffer1 = ar[j];
                    buffer2 = ar[i];
                    ar[j] = buffer2;
                    ar[i] = buffer1;
                    i++;
                }
            }
            if (ar[i] > pivot) {
                buffer1 = ar[ar.length - 1];
                buffer2 = ar[i];
                ar[ar.length - 1] = buffer2;
                ar[i] = buffer1;
            }
            int[] subAr1 = new int[i];
            for (int k = 0; k < i; k++) {
                subAr1[k] = ar[k];
            }
            int[] subAr2 = new int[ar.length - i -1];

            int n = 0;
            for (int k = i + 1; k < ar.length; k++) {
                subAr2[n++] = ar[k];
            }
            int[] subAr1Sorted = sort(subAr1);
            int[] subAr2Sorted = sort(subAr2);

            for (int k = 0; k < i; k++) {
                sortedAr[k] = subAr1Sorted[k];
            }
            sortedAr[i] = ar[i];
            int m = 0;
            for (int k = i + 1; k < ar.length; k++) {
                sortedAr[k] = subAr2Sorted[m++];
            }

        }

        return sortedAr;
    }
}
