package com.opensource.dada.problems.hackerrank;

/**
 * Problem:
 * https://www.hackerrank.com/challenges/the-time-in-words/problem
 */
public class TimeInWords {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    static void test1() {
        int h = 5;
        int m = 47;
        System.out.println(h + ":" + m + "=>" + timeInWords(h, m));
        //thirteen minutes to six
    }

    static void test2() {
        int h = 3;
        int m = 00;
        System.out.println(h + ":" + m + "=>" + timeInWords(h, m));
        //three o' clock
    }

    static void test3() {
        int h = 7;
        int m = 15;
        System.out.println(h + ":" + m + "=>" + timeInWords(h, m));
        //quarter past seven
    }
    static void test4() {
        int h = 10;
        int m = 57;
        System.out.println(h + ":" + m + "=>" + timeInWords(h, m));
        //quarter past seven
    }

    static String timeInWords(int h, int m) {
        if (h >23 || m >59) {
            return "Invalid Time";
        }
        String[] digits = new String[]{"zero", "one",
                "two", "three", "four",
                "five", "six", "seven",
                "eight", "nine", "ten", "eleven", "twelve",
                "thirteen", "fourteen",
                "fifteen", "sixteen", "seventeen",
                "eighteen", "nineteen","twenty","twenty one",
                "twenty two", "twenty three", "twenty four",
                "twenty five", "twenty six", "twenty seven",
                "twenty eight", "twenty nine","thirty"};

        String outPut = "";
        String hour = "";
        String minute = "";
        String concatinator = "";
        if (m == 0) {
            concatinator = " o' clock";
            hour = digits[h];
            outPut = hour+concatinator;
        } else if (m <= 30) {
            concatinator = " past ";
            if (m==15) {
                minute = "quarter";
            } else if (m==30) {
                minute = "half";
            } else {
                minute = digits[m];
                minute += " minute";
                if (m>1) {
                    minute+="s";
                }
            }
            hour = digits[h];
            outPut = minute+concatinator+hour;
        } else {
            concatinator = " to ";
            m = 60 -m;
            h += 1;
            if (m==15) {
                minute = "quarter";
            } else {
                minute = digits[m];
                minute += " minute";
                if (m>1) {
                    minute+="s";
                }
            }
            hour = digits[h];
            outPut = minute+concatinator+hour;
        }
        return outPut;
    }
}
