package com.opensource.dada.alg.string.algorithms;

import java.util.Arrays;

public class Knuth_Morris_Pratt_Algorithm {
    public static void main(String[] args) {
        String subStr = "aefaedaefaefa";
        String str= "aefaefaefaedaefaedaefaefa";
        System.out.println("Result:"+knuthMorrisPrattAlgorithm(str,subStr));
    }

    //Complexity time: O(n + m), space: O(m)
    //where n is length of String, m is length of sub String
    static boolean knuthMorrisPrattAlgorithm(String str, String subStr){
        return doesMatch(str, subStr, buildPattern(subStr));
    }

    static int[] buildPattern(String subStr) {
        int[] pattern = new int[subStr.length()];
        Arrays.fill(pattern, -1);
        int j = 0;
        int i = 1;
        while (i < subStr.length()) {
            if (subStr.charAt(i)==subStr.charAt(j)) {
                pattern[i] = j;
                i++;
                j++;
            } else if (j > 0) {
                j = pattern[j -1] + 1;
            } else {
                i++;
            }
        }
        return pattern;
    }

    private static boolean doesMatch(String str, String subStr, int[] pattern) {
        int i = 0;
        int j = 0;
        while (i + subStr.length() - j <=str.length()) {
            if (str.charAt(i)==subStr.charAt(j)) {
                if (j==subStr.length()-1) {
                    return true;
                }
                i++;
                j++;
            } else if (j > 0) {
                j = pattern[j -1] + 1;
            } else {
                i++;
            }
        }
        return false;
    }
}
