package com.opensource.dada.microsoft;

import org.junit.jupiter.api.Test;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.TestPlan;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;

import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

/**
 * Problem: https://www.interviewcake.com/question/python/permutation-palindrome
 */
public class PermutationPalindrome {

    public static boolean hasPalindromePermutation(String theString) {
        //return doublePassSolution(theString);
        return singlePassSolution(theString);
    }

    private static boolean doublePassSolution(String theString) {
        // check if any permutation of the input is a palindrome
        int[] charCounts = new int[26];

        int left = 0;
        int right = theString.length() -1;

        while (left <=right) {
            char leftChar = theString.charAt(left);
            char rightChar = theString.charAt(right);
            if (left==right) {
                charCounts[leftChar-'a']++;
            } else {
                charCounts[leftChar-'a']++;
                charCounts[rightChar-'a']++;
            }
            left++;
            right--;
        }

        int oddNoOfChar = 0;

        for (int i=0; i< charCounts.length; i++) {
            int count = charCounts[i];
            if (count!=0 && count%2!=0) {
                oddNoOfChar++;
            }
        }

        return oddNoOfChar<=1;
    }

    private static boolean singlePassSolution(String theString) {
        int[] charCounts = new int[26];

        int count = 0;

        for (int i=0; i< theString.length(); i++) {
            charCounts[theString.charAt(i)-'a']++;

            if (charCounts[theString.charAt(i)-'a'] % 2 == 0)
                count--;
            else
                count++;
        }

        return count <= 1;
    }

    // tests

    @Test
    public void permutationWithOddNumberOfCharsTest() {
        final boolean result = hasPalindromePermutation("aabcbcd");
        assertTrue(result);
    }

    @Test
    public void permutationWithEvenNumberOfCharsTest() {
        final boolean result = hasPalindromePermutation("aabccbdd");
        assertTrue(result);
    }

    @Test
    public void noPermutationWithOddNumberOfChars() {
        final boolean result = hasPalindromePermutation("aabcd");
        assertFalse(result);
    }

    @Test
    public void noPermutationWithEvenNumberOfCharsTest() {
        final boolean result = hasPalindromePermutation("aabbcd");
        assertFalse(result);
    }

    @Test
    public void emptyStringTest() {
        final boolean result = hasPalindromePermutation("");
        assertTrue(result);
    }

    @Test
    public void oneCharacterStringTest() {
        final boolean result = hasPalindromePermutation("a");
        assertTrue(result);
    }

    public static void main(String[] args) {
        /*Result result = JUnitCore.runClasses(Solution.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }*/
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(selectClass(PermutationPalindrome.class))
                .build();
        Launcher launcher = LauncherFactory.create();
        TestPlan testPlan = launcher.discover(request);
        launcher.registerTestExecutionListeners(listener);
        launcher.execute(request);

        listener.getSummary()
                .printTo(new PrintWriter(System.out));
    }
}
