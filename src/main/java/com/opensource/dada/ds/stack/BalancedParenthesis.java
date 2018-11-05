package com.opensource.dada.ds.stack;

import java.util.Stack;

/**
 * Problem:
 * A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].
 * <p>
 * Two brackets are considered to be a matched pair if the an opening bracket (i.e., (, [, or {)
 * occurs to the left of a closing bracket (i.e., ), ], or }) of the exact same type.
 * There are three types of matched pairs of brackets: [], {}, and ().
 * <p>
 * A matching pair of brackets is not balanced if the set of brackets it encloses are not matched.
 * For example, {[(])} is not balanced because the contents in between { and } are not balanced.
 * The pair of square brackets encloses a single, unbalanced opening bracket, (,
 * and the pair of parentheses encloses a single, unbalanced closing square bracket, ].
 * <p>
 * By this logic, we say a sequence of brackets is balanced if the following conditions are met:
 * <p>
 * It contains no unmatched brackets.
 * The subset of brackets enclosed within the confines of a matched pair of brackets
 * is also a matched pair of brackets.
 * Given  strings of brackets, determine whether each sequence of brackets is balanced.
 * If a string is balanced, return YES. Otherwise, return NO.
 * <p>
 * Function Description
 * <p>
 * Complete the function isBalanced in the editor below. It must return a string:
 * YES if the sequence is balanced or NO if it is not.
 * <p>
 * isBalanced has the following parameter(s):
 * <p>
 * s: a string of brackets
 * Input Format
 * <p>
 * The first line contains a single integer , the number of strings.
 * Each of the next  lines contains a single string , a sequence of brackets.
 * <p>
 * Constraints
 * <p>
 * , where  is the length of the sequence.
 * All chracters in the sequences ∈ { {, }, (, ), [, ] }.
 * Output Format
 * <p>
 * For each string, return YES or NO.
 * <p>
 * Sample Input
 * <p>
 * 3
 * {[()]}
 * {[(])}
 * {{[[(())]]}}
 * Sample Output
 * <p>
 * YES
 * NO
 * YES
 * Explanation
 * <p>
 * The string {[()]} meets both criteria for being a balanced string, so we print YES on a new line.
 * The string {[(])} is not balanced because the brackets enclosed by the matched pair { and } are not balanced: [(]).
 * The string {{[[(())]]}} meets both criteria for being a balanced string, so we print YES on a new line.
 */
public class BalancedParenthesis {

    public static void main(String[] args) {
        String exp1 = "{[()]}"; //true
        System.out.println(":"+exp1+": "+isBalanced(exp1));

        String exp2 = "{[(])}"; //false
        System.out.println(":"+exp2+": "+isBalanced(exp2));

        String exp3 = "{{[[(())]]}}"; //true
        System.out.println(":"+exp3+": "+isBalanced(exp3));

        String exp4 = "{{([])}}"; //true
        System.out.println(":"+exp4+": "+isBalanced(exp4));

        String exp5 = "{{)[](}}"; //false
        System.out.println(":"+exp5+": "+isBalanced(exp5));

        String exp6 = "{(([])[])[]}"; //true
        System.out.println(":"+exp6+": "+isBalanced(exp6));

        String exp7 = "{(([])[])[]]}"; //false
        System.out.println(":"+exp7+": "+isBalanced(exp7));

        String exp8 = "{(([])[])[]}[]"; //true
        System.out.println(":"+exp8+": "+isBalanced(exp8));
    }

    public static boolean isBalanced(String expStr) {
        return isBalanced(expStr.toCharArray());
    }

    public static boolean isBalanced(char[] exp) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < exp.length; i++) {
            if (exp[i] == '{' || exp[i] == '(' || exp[i] == '[') {
                stack.push(exp[i]);
            } else if (exp[i] == '}' || exp[i] == ')' || exp[i] == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                if (!isMatching(stack.pop(), exp[i])) {
                    return false;
                }
            }
        }

        if (stack.isEmpty()) {
            return true;
        }

        return false;
    }

    private static boolean isMatching(char left, char right) {
        return ((left == '{' && right == '}') || (left == '(' && right == ')') || (left == '[' && right == ']'));
    }
}
