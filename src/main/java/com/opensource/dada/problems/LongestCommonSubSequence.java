package com.opensource.dada.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestCommonSubSequence {
    public static void main(String[] args) {
        String str1 = "zxvvyzw";
        String str2 = "xkykzpw";
        System.out.println("1. Result:"+getLongestCommonSubSequence1(str1, str2));//xyzw
        System.out.println("2. Result:"+getLongestCommonSubSequence2(str1, str2));//xyzw
    }
    //Complexity Time: O(n*m*min(n,m)), Space: O(n*m*min(n,m))
    static String getLongestCommonSubSequence1(String str1, String str2) {
        String[][] lcs = new String[str2.length()+1][str1.length()+1];
        for (int i = 0; i < lcs.length; i++) {
            Arrays.fill(lcs[i], "");
        }
        for (int i = 1; i < str2.length()+1; i++) {
            for (int j = 1; j < str1.length()+1; j++) {
                if (str2.charAt(i-1)==str1.charAt(j-1)) {
                    lcs[i][j] = lcs[i-1][j-1] + str2.substring(i-1,i);
                } else {
                    String temp1 = lcs[i-1][j];
                    String temp2 = lcs[i][j-1];
                    lcs[i][j] = temp1.length() > temp2.length()? temp1: temp2 ;
                }
            }

        }
        return lcs[str2.length()][str1.length()];
    }

    //Complexity Time: O(n*m), Space: O(n*m)
    static String getLongestCommonSubSequence2(String str1, String str2) {
        String[][] lcs = new String[str2.length()+1][str1.length()+1];
        for (int i = 0; i < lcs.length; i++) {
            Arrays.fill(lcs[i], "$0$$");
        }
        for (int i = 1; i < str2.length()+1; i++) {
            for (int j = 1; j < str1.length()+1; j++) {
                if (str2.charAt(i-1)==str1.charAt(j-1)) {
                    lcs[i][j] = str2.substring(i-1,i)
                            + (Integer.valueOf(lcs[i-1][j-1].substring(1,2))+1)
                            +(i-1)
                            +(j-1);
                } else {
                    int num1 = Integer.valueOf(lcs[i-1][j].substring(1,2));
                    int num2 = Integer.valueOf(lcs[i][j-1].substring(1,2));
                    if(num1 > num2) {
                        lcs[i][j] = "$"
                                +lcs[i-1][j].substring(1,2)
                                +(i-1)
                                +(j);
                    } else {
                        lcs[i][j] = "$"
                                +lcs[i][j-1].substring(1,2)
                                +(i)
                                +(j-1);
                    }
                }
            }

        }
        return buildSequence(lcs);
    }

    private static String buildSequence(String[][] lcs) {
        StringBuilder result = new StringBuilder();
        int i = lcs.length -1;
        int j = lcs[0].length -1;
        while (i!=0 && j!=0) {
            String currentEntry = lcs[i][j];
            if (currentEntry.charAt(0)!='$') {
                result.append(currentEntry.charAt(0));
            }
            i = Integer.valueOf(currentEntry.substring(2,3));
            j = Integer.valueOf(currentEntry.substring(3));
        }
        return result.reverse().toString();
    }
}
