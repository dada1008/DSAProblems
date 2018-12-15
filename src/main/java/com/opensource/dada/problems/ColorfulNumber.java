package com.opensource.dada.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * For Given Number N find if its COLORFUL number or not
 * <p>
 * Return 0/1
 * <p>
 * COLORFUL number:
 * <p>
 * A number can be broken into different contiguous sub-subsequence parts.
 * Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
 * And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different
 * Example:
 * <p>
 * N = 23
 * 2 3 23
 * 2 -> 2
 * 3 -> 3
 * 23 -> 6
 * this number is a COLORFUL number since product of every digit of a sub-sequence are different.
 * <p>
 * Output : 1
 */
public class ColorfulNumber {
    public static void main(String[] args) {
        int num = 3245;
        System.out.println(num + " : " + colorful(num));
        num = 23;
        System.out.println(num + " : " + colorful(num));
        num = 121;
        System.out.println(num + " : " + colorful(num));
        num = 99;
        System.out.println(num + " : " + colorful(num));
        num = 102;
        System.out.println(num + " : " + colorful(num));
    }

    public static int colorful(int A) {
        List<Integer> numList = new ArrayList<>();
        int num = A;
        while (num >= 10) {
            int mod = num % 10;
            num /= 10;
            numList.add(0, mod);
        }
        numList.add(0, num);
        System.out.println("numList: " + numList);
        Set<Integer> productSet = new HashSet<>();
        int subSequenceLength = 1;
        int length = numList.size();
        boolean isColour = true;
        while (subSequenceLength <= length) {
            int left = 0;
            int right = 0;
            int product = 1;
            while (right < length) {

                int digit = numList.get(right);
                product *= digit;
                right++;

                if ((right-left)>=subSequenceLength) {
                    left++;
                    right = left;
                    if (productSet.contains(product)) {
                        isColour = false;
                        break;
                    }
                    productSet.add(product);
                    product =1;
                }
            }
            if (!isColour) {
                break;
            }
            subSequenceLength++;
        }
        System.out.println("productSet: " + productSet);
        return isColour ? 1 : 0;
    }
}
