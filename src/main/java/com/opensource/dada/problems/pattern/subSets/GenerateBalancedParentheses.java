package com.opensource.dada.problems.pattern.subSets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem:
 * For a given number ‘N’, write a function to generate all combination of ‘N’ pairs of balanced parentheses.
 * Example 1:
 *
 * Input: N=2
 * Output: (()), ()()
 * Example 2:
 *
 * Input: N=3
 * Output: ((())), (()()), (())(), ()(()), ()()()
 */
public class GenerateBalancedParentheses {
    static class ParenthesisString {
        String str;
        int openCount;
        int closeCount;

        public ParenthesisString(String str, int openCount, int closeCount) {
            this.str = str;
            this.openCount = openCount;
            this.closeCount = closeCount;
        }
    }
    public static void main(String[] args) {
        System.out.println("Result:"+generateValidParentheses(2));
        System.out.println("Result:"+generateValidParentheses(3));
    }

    static List<String> generateValidParentheses(int num) {
        List<String> result = new ArrayList<>();
        Queue<ParenthesisString> queue = new LinkedList<>();
        queue.add(new ParenthesisString("", 0, 0));
        while (!queue.isEmpty()) {
            ParenthesisString ps = queue.poll();
            // if we've reached the maximum number of open and close parentheses, add to the result
            if (ps.openCount==num && ps.closeCount==num) {
                result.add(ps.str);
            } else {
                // if we can add an open parentheses, add it
                if (ps.openCount < num) {
                    queue.add(new ParenthesisString(ps.str+"(", ps.openCount+1, ps.closeCount));
                }
                // if we can add a close parentheses, add it
                if (ps.openCount > ps.closeCount) {
                    queue.add(new ParenthesisString(ps.str+")", ps.openCount, ps.closeCount+1));
                }
            }
        }
        return result;
    }
}
