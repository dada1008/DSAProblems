package com.opensource.dada.problems;

import java.math.BigInteger;

public class FindNextPalindromeNumber {
    public static void main(String[] args) {
        int number1 = 45312;
        int number2 = 12345;
        int number3 = 12945;
        int number4 = 4531;
        int number5 = 1459;
        int number6 = 1997;
        System.out.print("For the number " + number1);
        getNextPalindrome(number1);
        System.out.print("For the number " + number2);
        getNextPalindrome(number2);
        System.out.print("For the number " + number3);
        getNextPalindrome(number3);
        System.out.print("For the number " + number4);
        getNextPalindrome(number4);
        System.out.print("For the number " + number5);
        getNextPalindrome(number5);
        System.out.print("For the number " + number6);
        getNextPalindrome(number6);
    }

    public static void nextPalindrome2(String num) {
        int len = num.length();
        String left = num.substring(0, len / 2);
        String middle = num.substring(len / 2, len - len / 2);
        String right = num.substring(len - len / 2);

        if (right.compareTo(reverse(left)) < 0) {
            System.out.println(" the next palindrome is " + ( left + middle + reverse(left)));
            return;
        }

        String next = new BigInteger(left + middle).add(BigInteger.ONE).toString();
        String convertTopalindrome = next.substring(0, left.length() + middle.length())
                + reverse(next).substring(middle.length());
        System.out.println(" the next palindrome is " + convertTopalindrome);
    }

    private static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    private static void getNextPalindrome(int number) {
        //nextPalindrome1(number);
        nextPalindrome2(String.valueOf(number));
    }

    private static void nextPalindrome1(int number) {
        if (isSizeEven(number)) {

            getNextPalindromeForEvenLengthNumbers(number);
        } else {
            getNextPalindromeForOddLengthNumbers(number);
        }
    }

    private static boolean isSizeEven(int number) {
        if (String.valueOf(number).length() % 2 == 0)
            return true;
        return false;
    }

    private static void getNextPalindromeForEvenLengthNumbers(int number) {
        StringBuilder testPalindromeString = new StringBuilder();
        testPalindromeString.append(number);

        StringBuilder convertTopalindrome = new StringBuilder();
        convertTopalindrome.append(testPalindromeString.substring(0, testPalindromeString.length() / 2));

        convertTopalindrome.append(testPalindromeString.delete(testPalindromeString.length() / 2,
                testPalindromeString.length()).reverse());

        //if the palindrome is greater than the original number
        if (Integer.parseInt(convertTopalindrome.toString()) > number) {
            System.out.println(" the next palindrome is " + convertTopalindrome);
        } else {
            //get the middle elements in case of even numbers
            String middleElements =
                    convertTopalindrome.substring(convertTopalindrome.length() / 2 - 1,
                            convertTopalindrome.length() / 2 + 1);
            int middleElementsInt = Integer.valueOf(middleElements);
            //we are going to increment the middle elements by 1 so check if after this the value is not greater than 99
            if (middleElementsInt + 11 < 99) {
                convertTopalindrome.replace(convertTopalindrome.length() / 2 - 1,
                        convertTopalindrome.length() / 2 + 1, String.valueOf(middleElementsInt + 11));
                System.out.println(" the next palindrome is " + convertTopalindrome);
            } else {
                String numberTillMiddleElement =
                        convertTopalindrome.substring(0, convertTopalindrome.length() / 2 + 1);
                int numberTillMiddleElementInt = Integer.valueOf(numberTillMiddleElement);
                convertTopalindrome.replace(0, convertTopalindrome.length() / 2 + 1,
                        String.valueOf(numberTillMiddleElementInt + 1));
                getNextPalindrome(Integer.valueOf(convertTopalindrome.toString()));
            }
        }
    }

    private static void getNextPalindromeForOddLengthNumbers(int number) {

        StringBuilder testPalindromeString = new StringBuilder();
        testPalindromeString.append(number);

        StringBuilder convertTopalindrome = new StringBuilder();
        convertTopalindrome.append(testPalindromeString.substring(0, testPalindromeString.length() / 2 + 1));

        convertTopalindrome.append(testPalindromeString.delete(testPalindromeString.length() / 2,
                testPalindromeString.length()).reverse());

        //if the palindrome is greater than the original number
        if (Integer.parseInt(convertTopalindrome.toString()) > number) {
            System.out.println(" the next palindrome is " + convertTopalindrome);
        } else {

            char middleElement = convertTopalindrome.charAt(convertTopalindrome.length() / 2);
            int middleElementInt = Character.getNumericValue(middleElement);
            //we are going to increment the middle element by 1 so check if after this the value is not greater than 9
            if (middleElementInt < 9) {
                convertTopalindrome.replace(convertTopalindrome.length() / 2,
                        convertTopalindrome.length() / 2 + 1, String.valueOf(middleElementInt + 1));
                System.out.println(" the next palindrome is " + convertTopalindrome);
            } else {
                String numberTillMiddleElement =
                        convertTopalindrome.substring(0, convertTopalindrome.length() / 2 + 1);
                int numberTillMiddleElementInt = Integer.valueOf(numberTillMiddleElement);
                convertTopalindrome.replace(0, convertTopalindrome.length() / 2 + 1,
                        String.valueOf(numberTillMiddleElementInt + 1));
                getNextPalindrome(Integer.valueOf(convertTopalindrome.toString()));
            }

        }

    }

}