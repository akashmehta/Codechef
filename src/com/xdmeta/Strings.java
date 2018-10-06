package com.xdmeta;

import java.util.Arrays;


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


    private static void printFirstNonRepeatedChar(String s) {
        for (int j = 0; j < s.length(); j++) {
            if (!s.substring(j+1).contains(s.charAt(j)+"")) {
                System.out.println("s.charAt(j) = " + s.charAt(j));
                break;
            }
        }
    }

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

    private static void checkAnagram(String s, String s1) {
        char[] a = s.toCharArray();
        char[] a2 = s1.toCharArray();
        Arrays.sort(a);
        Arrays.sort(a2);
        System.out.println(Arrays.equals(a, a2));
    }

    public static String reverseString(String s) {
        if (s.length() > 0 && i-- > 0) {
            return reverseString(s.substring(1)) + s.charAt(0);
        } else {
            return s;
        }
    }

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
