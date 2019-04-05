package com.opensource.dada.problems.hackerrank;

import java.util.ArrayList;
import java.util.List;

/** Problem:
 * https://www.hackerrank.com/challenges/kaprekar-numbers/problem
 */
public class ModifiedKaprekarNumbers {
    public static void main(String[] args) {
        test1();
    }
    static void test1() {
        int p = 1, q = 100;
        kaprekarNumbers(p,q);
    }

    static void kaprekarNumbers(int p, int q) {
        List<Integer> resultList = new ArrayList<>();
        for (int i =p; i<=q; i++) {
            long square = (long)Math.pow(i,2);
            int d = String.valueOf(i).length();
            String squareStr = String.valueOf(square);
            int subIndex = 0;
            if (squareStr.length()%2==0) {
                subIndex = d;
            } else {
                subIndex = d-1;
            }
            String lStr = squareStr.substring(0,subIndex);
            String rStr = squareStr.substring(subIndex);

            int l = 0;
            if(!lStr.isEmpty()) {
                l = Integer.valueOf(lStr);
            }
            int r = 0;
            if(!rStr.isEmpty()) {
                r = Integer.valueOf(rStr);
            }
            if(l+r==i) {
                resultList.add(i);
            }
        }

        if (resultList.isEmpty()) {
            System.out.println("INVALID RANGE");
        } else {
            for (Integer num: resultList) {
                System.out.print(num);
                System.out.print(" ");
            }
            System.out.println("");
        }

    }
}
