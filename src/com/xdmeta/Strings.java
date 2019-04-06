package com.xdmeta;

import java.util.Arrays;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Created by stllpt031 on 2/10/18.
 */
public class Strings {
    private static int i = 0;

    public static void main(String a[]) {
        String s = "akaskah";
        String s1 = "aaakahs";
        i = s.length();
//        System.out.println(reverseString(s));
//        printDublicateChars(s);
//        System.out.println(checkAnagramManually(s, s1));
        printFirstNonRepeatedChar(s1);
    }

    /**
     * Print first non repeated character from String?
     *
     * @param s input string
     */
    private static void printFirstNonRepeatedChar(String s) {
        for (int j = 0; j < s.length(); j++) {
            if (!s.substring(j + 1).contains(s.charAt(j) + "")) {
                System.out.println("s.charAt(j) = " + s.charAt(j));
                break;
            }
        }
    }

    /**
     * Check if two Strings are anagrams of each other?
     * Anagram : The anagram of string contains same characters with same occurrence but with different arrangement
     *
     * @param word    actual word
     * @param anagram anagram word
     * @return true if both words are anagram
     */
    private static boolean checkAnagramManually(String word, String anagram) {
        if (word.length() != anagram.length()) {
            return false;
        }

        char[] chars = word.toCharArray();

        for (char c : chars) {
            int index = anagram.indexOf(c);
            if (index != -1) {
                anagram = anagram.substring(0, index) + anagram.substring(index + 1, anagram.length());
            } else {
                return false;
            }
        }

        return anagram.isEmpty();
    }

    /**
     * Check anagram using utility methods.
     *
     * @param s  actual string
     * @param s1 anagram string
     */
    private static void checkAnagram(String s, String s1) {
        char[] a = s.toCharArray();
        char[] a2 = s1.toCharArray();
        Arrays.sort(a);
        Arrays.sort(a2);
        System.out.println(Arrays.equals(a, a2));
    }

    /**
     * Reverse a given String using recursion?
     *
     * @param s input string
     * @return reversed string
     */
    public static String reverseString(String s) {
        if (s.length() > 0 && i-- > 0) {
            return reverseString(s.substring(1)) + s.charAt(0);
        } else {
            return s;
        }
    }

    /**
     * Find duplicate characters in a String?
     *
     * @param s input string
     */
    public static void printDublicateChars(String s) {
        StringBuilder output = new StringBuilder();
        for (int j = 0; j < s.length() - 1; j++) {
            if (s.substring(j + 1).contains(s.charAt(j) + "") && !output.toString().contains(s.charAt(j) + "")) {
                output.append(s.charAt(j)).append("");
                System.out.println("s.charAt(j) = " + s.charAt(j));
            }
        }
    }


}

class Solution {
    public static String output = "";

    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        String input = "I Live in India";
        System.out.println(Solution.reverseSentence(input, 0));
    }

    public static String reverseSentence(String input, int i) {
        System.out.println("input = " + input);
        String[] inputAr = input.split(" ");
        if (i < inputAr.length) {
            String str = "";
            for (int j = i; j < inputAr.length; j++) {
                str = inputAr[j] + str;
            }
            output = str + output;
            return reverseSentence(str, ++i);
        } else {
            return output;
        }
    }
}
