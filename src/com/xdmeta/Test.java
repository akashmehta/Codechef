package com.xdmeta;

import java.util.Arrays;

public class Test {

    private static int[] A = {1,3,6,4,1,2} ;
    public static void main(String[] args) {
        Arrays.sort(A);
        System.out.println(Arrays.toString(A));
        if (A[0] == 1) {
            for (int i = 1; i < A.length; i++) {
                if (A[i] == A[i-1] || A[i] == (A[i-1]+1)) {
                    if (i == A.length - 1) {
                        System.out.println("A[i] = " + (A[i] + 1));
                    } else {
                        continue;
                    }
                } else {
                    System.out.println("A[i] = " + (A[i-1] + 1));
                    break;
                }
            }
        } else System.out.println("A = " + A[0]);
    }
}
