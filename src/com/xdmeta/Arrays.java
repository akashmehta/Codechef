package com.xdmeta;

import java.util.LinkedList;

/**
 * Created by stllpt031 on 6/10/18.
 */
public class Arrays {

    private static final int ARRAY = 0;
    private static final int LINK_LIST = 1;
    private static int[] ar;
    public static void main(String a[]) {
//        findMismatch(new int[]{10, 3, 5, 7, 2, 8, 1}, 4, ARRAY);
        ar = new int[]{6,3,7,2,1,8};
        sort(ar);
        for (int anAr : ar) {
            System.out.println("ar[k] = " + anAr);
        }

    }


    private static void sort(int[] ar) {
        quickSort(0, ar.length - 1);
    }

    private static void quickSort(int low, int high) {
        int pivot = ar[low + (high - low)/2];
        int i = low, j = high;
        while (i <= j) {
            while (ar[i] < pivot) {
                i++;
            }
            while (ar[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }
        if (low < j) {
            quickSort(low, j);
        }
        if (high > i) {
            quickSort(  i, high);
        }
    }

    private static void swap(int i, int j) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    /**
     * Find a missing number in given integer array of 1 to 100?
     * <p>
     * Read more: http://www.java67.com/2018/06/data-structure-and-algorithm-interview-questions-programmers.html#ixzz5T86IXbtD
     *
     * @param array    input array.
     * @param i        missing item count.
     * @param strategy (optional) Used strategy to achieve task.
     */
    private static void findMismatch(int[] array, int i, int strategy) {
        switch (strategy) {
            case LINK_LIST: {
                LinkedList<Integer> list = new LinkedList<>();
                for (int j = 0; j < array.length + i; j++) {
                    list.add(j);
                }
                for (int item :
                        array) {
                    list.remove(list.indexOf(item));
                }
                for (Integer item :
                        list) {
                    System.out.println(item);
                }

            }
            case ARRAY: {
                int[] opArr = new int[i];
                int m = 0;
                for (int j = 0; j < array.length + i; j++) {
                    boolean match = true;
                    for (int anArray : array) {
                        if (anArray == j) {
                            match = false;
                            break;
                        }
                    }
                    if (match) opArr[m++] = j;

                }
                for (int anOpArr : opArr) {
                    System.out.println("opArr = " + anOpArr);
                }
            }
        }
    }

}
