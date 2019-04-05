package com.opensource.dada.problems.hackerrank;

/**
 * Problem:
 * https://www.hackerrank.com/challenges/encryption/problem
 */
public class Encryption {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    static void test1() {
        String s = "if man was meant to stay on the ground god would have given us roots";
        System.out.println("input: " + s);
        System.out.println("output: " + encryption(s));
        System.out.println("=========================================");
    }

    static void test2() {
        String s = "haveaniceday";
        System.out.println("input: " + s);
        System.out.println("output: " + encryption(s));
        System.out.println("=========================================");
    }

    static void test3() {
        String s = "feedthedog";
        System.out.println("input: " + s);
        System.out.println("output: " + encryption(s));
        System.out.println("=========================================");
    }

    static void test4() {
        String s = "chillout";
        System.out.println("input: " + s);
        System.out.println("output: " + encryption(s));
        System.out.println("=========================================");
    }

    static void test5() {

    }

    static String encryption(String s) {
        if (s == null) {
            return s;
        }
        s = s.replaceAll(" ", "");
        if (s.isEmpty()) {
            return s;
        }
        int row =0, col=0;
        double rowD = Math.sqrt(s.length());
        if (isCompleteSquare(rowD)) {
            row = (int)rowD;
            col = row;
        } else {
            row = (int)rowD;
            col = row + 1;
        }
        if (row * col < s.length()) {
            row = col;
        }
        Character[][] grid = new Character[row][col];
        for (int i =0; i <s.length(); i++) {
            int r = i /col;
            int c = i % col;
            grid[r][c] = s.charAt(i);
        }
        StringBuilder encryptedStr = new StringBuilder(s.length()+row);
        for (int i=0; i<col; i++) {
            for (int j=0; j<row; j++) {
                Character c = grid[j][i];
                if (c==null) {
                    break;
                }
                encryptedStr.append(c);
            }
            encryptedStr.append(' ');
        }
        encryptedStr.deleteCharAt(encryptedStr.length()-1);

        return encryptedStr.toString();
    }

    static boolean isCompleteSquare(double sqrt) {
        return ((sqrt - Math.floor(sqrt)) == 0);
    }
}
