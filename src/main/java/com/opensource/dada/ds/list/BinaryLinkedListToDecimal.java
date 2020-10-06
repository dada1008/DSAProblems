package com.opensource.dada.ds.list;

import java.math.BigInteger;
/**
 * Problem:
 * https://www.hackerrank.com/contests/code-cpp-may-2015/challenges/linked-list-to-binary/problem
 * https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 */

public class BinaryLinkedListToDecimal {

    public static void main(String[] args) {
        LinkedListNode root = new LinkedListNode(0);
        root.next = new LinkedListNode(0);
        root.next.next = new LinkedListNode(1);
        root.next.next.next = new LinkedListNode(1);
        root.next.next.next.next = new LinkedListNode(0);
        root.next.next.next.next.next = new LinkedListNode(1);
        root.next.next.next.next.next.next = new LinkedListNode(0);
        long binary = getNumber(root);
        System.out.println("Binary:" + binary);

        long binary2 = getNumber(covertToNode("01111111" +
                "11111111" +
                "11111111" +
                "11111111" +
                "11111111" +
                "11111111" +
                "11111111" +
                "11111111"));
        System.out.println("Binary2:" + binary2);
    }

    static LinkedListNode covertToNode(String str) {
        LinkedListNode root = new LinkedListNode(isZeroOrOne(str.charAt(0)));
        LinkedListNode temp = root;
        char[] chars = str.toCharArray();
        for (int i=1; i<chars.length; i++) {
            LinkedListNode node = new LinkedListNode(isZeroOrOne(str.charAt(i)));
            temp.next = node;
            temp = node;
        }
        return root;
    }
    static int isZeroOrOne(char c) {
        if (c=='0') {
            return 0;
        }
        return 1;
    }
    //best solution
    static long getDecimalValue(LinkedListNode head) {
        int num = 0;
        while(head != null) {
            num <<= 1;
            num = num | head.value;
            head = head.next;
        }
        return num;
    }
    //My solution
    static long getNumber(LinkedListNode binary) {
        StringBuilder str = new StringBuilder();
        while (binary != null) {
            str.append(binary.value);
            binary = binary.next;
        }
        //return binaryToDecimal(Long.parseLong(str.toString()));
        BigInteger result = binaryToDecimal(new BigInteger(str.toString()));
        System.out.println("Result:"+result);
        return result.longValue();
    }

    static long binaryToDecimal(long binaryNum) {
        long decimalNum = 0;
        long base = 1;
        long temp = binaryNum;
        while (temp > 0) {
            long reminder = temp % 10;
            temp = temp / 10;
            decimalNum += reminder * base;
            base = base * 2;
        }
        return decimalNum;
    }

    static BigInteger binaryToDecimal(BigInteger binaryNum) {
        BigInteger decimalNum =  new BigInteger("0");
        BigInteger base = new BigInteger("1");
        BigInteger temp = binaryNum;
        BigInteger ten = new BigInteger("10");
        BigInteger two = new BigInteger("2");
        BigInteger zero =  new BigInteger("0");
        while (temp.compareTo(zero)>0) {
            BigInteger reminder = temp.mod(ten);
            temp = temp.divide(ten);
            decimalNum = decimalNum.add(reminder.multiply(base)) ;
            base = base.multiply(two);
        }
        return decimalNum;
    }
}
