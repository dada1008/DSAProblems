package com.opensource.dada.ds.array;

public class LongestPalindromicSubString {
    public static void main(String[] args) {
        System.out.println("Result:"+findLongestPalindromicSubString("abaxyzzyxf"));//xyzzyx
        System.out.println("Result:"+findLongestPalindromicSubString("abccbaabcdeedcbac"));//abcdeedcba
    }

    static String findLongestPalindromicSubString(String str) {
        int[] currentLongestIndex = {0, 1};
        for (int i = 1; i < str.length(); i++) {
            int[] odd = getLongestPalindromeFrom(str, i-1, i+1);
            int[] even = getLongestPalindromeFrom(str, i-1, i);
            int[] longest = (odd[1] - odd[0]) > (even[1] - even[0])? odd: even;
            currentLongestIndex = (longest[1] - longest[0]) > (currentLongestIndex[1] - currentLongestIndex[0])
                    ? longest : currentLongestIndex;
        }
        return str.substring(currentLongestIndex[0], currentLongestIndex[1]);
    }

    private static int[] getLongestPalindromeFrom(String str, int leftIndex, int rightIndex) {
        while (leftIndex >= 0 && rightIndex < str.length()) {
            if (str.charAt(leftIndex) != str.charAt(rightIndex)) {
                break;
            }
            leftIndex -= 1;
            rightIndex += 1;
        }
        return new int[]{leftIndex + 1, rightIndex};
    }
}
