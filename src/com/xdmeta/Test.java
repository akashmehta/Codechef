package com.xdmeta;

import java.util.Arrays;

/**
 * Codality Test.
 */
public class Test {

    private static int[] A = {102, 103, 104, 105};

    public static void main(String[] args) {
        System.out.println("Arrays.toString(A) = " + Arrays.toString(A));
        System.out.println(new Solution1().solution(A));

    }
}

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution1 {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        boolean containOne = false;
        if (A.length == 1) {
            if (A[0] == 1) return 2;
            else return 1;
        }
        for (int  i = 1; i < A.length ; i++)  {
            if (A[i] < 1) continue;
            else {
                if (A[0] != 1 && A[i] != 1 && !containOne) return 1;
                else {
                    containOne = true;
                    if (A[i] == A[i-1] || A[i] == (A[i-1] + 1)) {
                        if (i == A.length - 1) return A[i] + 1;
                        else continue;
                    } else return A[i-1] + 1;
                }
            }
        }
        return 1;
    }
}