package com.opensource.dada.ds.hash;

import java.util.*;

/** Problem:
 * Given two integers representing the numerator and denominator of a fraction,
 * return the fraction in string format.
 *
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 *
 * Example :
 *
 * Given numerator = 1, denominator = 2, return "0.5"
 * Given numerator = 2, denominator = 1, return "2"
 * Given numerator = 2, denominator = 3, return "0.(6)"
 */
public class HashingFractionProblem {

    public static void main(String[] args) {

        int A = 1, B = 2;
        String res = fractionToDecimal(A, B);
        System.out.println("numerator = "+ A +", denominator = "+B+", return "+res);

        A = 2;
        B = 1;
        res = fractionToDecimal(A, B);
        System.out.println("numerator = "+ A +", denominator = "+B+", return "+res);

        A = 2;
        B = 3;
        res = fractionToDecimal(A, B);
        System.out.println("numerator = "+ A +", denominator = "+B+", return "+res);

    }

    public static String fractionToDecimal(int A, int B) {
        if (A == 0)
            return "0";
        if (B == 0)
            return "";

        String result = "";

        if ((A < 0) ^ (B < 0)) {
            result += "-";
        }

        long num = A, den = B;
        num = Math.abs(num);
        den = Math.abs(den);

        long res = num / den;
        result += String.valueOf(res);

        long remainder = (num % den) * 10;
        if (remainder == 0)
            return result;

        Map<Long, Integer> map = new HashMap<>();
        result += ".";
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                int beg = map.get(remainder);
                String part1 = result.substring(0, beg);
                String part2 = result.substring(beg, result.length());
                result = part1 + "(" + part2 + ")";
                return result;
            }

            map.put(remainder, result.length());
            res = remainder / den;
            result += String.valueOf(res);
            remainder = (remainder % den) * 10;
        }

        return result;
    }
}
