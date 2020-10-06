package com.opensource.dada.problems.pattern.subSets;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * Given an expression containing digits and operations (+, -, *),
 * find all possible ways in which the expression can be evaluated by grouping
 * the numbers and operators using parentheses.
 *
 * Example 1:
 *
 * Input: "1+2*3"
 * Output: 7, 9
 * Explanation: 1+(2*3) => 7 and (1+2)*3 => 9
 * Example 2:
 *
 * Input: "2*3-4-5"
 * Output: 8, -12, 7, -7, -3
 * Explanation: 2*(3-(4-5)) => 8, 2*(3-4-5) => -12, 2*3-(4-5) => 7, 2*(3-4)-5 => -7, (2*3)-4-5 => -3
 */
public class EvaluateExpressionInDifferentWay {
    public static void main(String[] args) {
        System.out.println("Result:"+differentWayToEvaluateExpression("1+2*3"));
        System.out.println("Result:"+differentWayToEvaluateExpression("2*3-4-5"));
    }

    static List<Integer> differentWayToEvaluateExpression(String input) {
        List<Integer> result = new ArrayList<>();
        // base case: if the input string is a number, parse and add it to output.
        if(!input.contains("+") && !input.contains("-") && !input.contains("*")) {
            result.add(Integer.parseInt(input));
        } else {
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if (!Character.isDigit(ch)) {
                    // break the equation here into two parts and make recursively calls
                    List<Integer> leftParts = differentWayToEvaluateExpression(input.substring(0, i));
                    List<Integer> rightParts = differentWayToEvaluateExpression(input.substring(i+1));
                    for (Integer left: leftParts) {
                        for (Integer right: rightParts) {
                            if (ch=='+') {
                                result.add(left + right);
                            } else if (ch=='-') {
                                result.add(left - right);
                            } else if (ch=='*') {
                                result.add(left * right);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
