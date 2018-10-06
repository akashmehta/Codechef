package com.xdmeta;

import java.util.LinkedList;

/**
 * Created by stllpt031 on 6/10/18.
 */
public class Arrays {

    private static final int ARRAY = 0;
    private static final int LINK_LIST = 1;

    public static void main(String a[]) {
        findMismatch(new int[]{10,3,5,7,2,8,1}, 4, ARRAY);
    }

    /**
     * Find a missing number in given integer array of 1 to 100?

     Read more: http://www.java67.com/2018/06/data-structure-and-algorithm-interview-questions-programmers.html#ixzz5T86IXbtD

     * @param array input array.
     * @param i missing item count.
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
            case ARRAY : {
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
