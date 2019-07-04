package com.opensource.dada.problems.pattern.kWayMerge;

import java.util.*;

/**
 * Problem: https://www.interviewbit.com/problems/n-max-pair-combinations/
 * https://www.geeksforgeeks.org/k-maximum-sum-combinations-two-arrays/
 */
public class KMaxPairCombinations {
    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        List<Integer> A = new ArrayList<>(List.of(1, 4, 2, 3));
        List<Integer> B = new ArrayList<>(List.of(2, 5, 1, 6));
        /**
         * Maximum 4 elements of combinations sum are
         * 10   (4+6),
         * 9    (3+6),
         * 9    (4+5),
         * 8    (2+6)
         */
        List<Integer> result = solve(A, B);
        System.out.println("Result:" + result);
    }

    static void test2() {
        List<Integer> A = new ArrayList<>(List.of(36, 27, -35, 43, -15, 36,
                42, -1, -29, 12, -23, 40,
                9, 13, -24, -10, -24, 22,
                -14, -39, 18, 17, -21, 32,
                -20, 12, -27, 17, -15, -21, -48,
                -28, 8, 19, 17, 43, 6, -39, -8, -21, 23,
                -29, -31, 34, -13, 48, -26, -35, 20, -37,
                -24, 41, 30, 6, 23, 12, 20, 46, 31, -45, -25,
                34, -23, -14, -45, -4, -21, -37, 7, -26, 45,
                32, -5, -36, 17, -16, 14, -7, 0, 37, -42, 26, 28));
        List<Integer> B = new ArrayList<>(List.of(38, 34, -47, 1, 4, 49, -18, 10, 26, 18, -11,
                -38, -24, 36, 44, -11, 45, 20, -16, 28, 17, -49, 47, -48, -33,
                42, 2, 6, -49, 30, 36, -9, 15, 39, -6, -31, -10, -21, -19, -33,
                47, 21, 31, 25, -41, -23, 17, 6, 47, 3, 36, 15, -44, 33, -31, -26,
                -22, 21, -18, -21, -47, -31, 20, 18, -42, -35, -10, -1, 46, -27, -32,
                -5, -4, 1, -29, 5, 29, 38, 14, -22, -9, 0, 43));
        /**
         * Expected:
         * 97 95 95 95 95
         * 94 94
         * 93 93 93 93
         * 92 92 92 92 92 92 92
         * 91 91 91 91
         * 90 90 90 90 90 90 90 90 90 90
         * 89 89 89 89 89 89 89 89
         * 88 88 88 88 88 88 88 88
         * 87 87 87 87 87 87 87 87 87
         * 86 86 86 86 86 86 86 86
         * 85 85 85 85 85 85 85 85
         * 84 84 84 84 84 84 84 84 84 84
         */
        List<Integer> expectedResult = List.of(97, 95, 95, 95, 95,
                94, 94,
                93, 93, 93, 93,
                92, 92, 92, 92, 92, 92, 92,
                91, 91, 91, 91,
                90, 90, 90, 90, 90, 90, 90, 90, 90, 90,
                89, 89, 89, 89, 89, 89, 89, 89,
                88, 88, 88, 88, 88, 88, 88, 88,
                87, 87, 87, 87, 87, 87, 87, 87, 87,
                86, 86, 86, 86, 86, 86, 86, 86,
                85, 85, 85, 85, 85, 85, 85, 85,
                84, 84, 84, 84, 84, 84, 84, 84, 84, 84);
        List<Integer> result = solve(A, B);
        System.out.println("Expected and actual matched:" + result.equals(expectedResult));
        System.out.println("Result:" + result);
    }

    public static ArrayList<Integer> solve(List<Integer> A, List<Integer> B) {
        return solveUsingHeap(A, B);
    }

    public static ArrayList<Integer> solveUsingHeap(List<Integer> A, List<Integer> B) {
        int n = A.size();
        Collections.sort(A);
        Collections.sort(B);
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>((a, b) -> b.get(0) - a.get(0));
        Set<String> set = new HashSet<>();
        int sum = A.get(n - 1) + B.get(n - 1);
        queue.offer(List.of(sum, n - 1, n - 1));
        String setKey = (n - 1) + "|" + (n - 1);
        set.add(setKey);
        int count = 0;
        while (count < n && !queue.isEmpty()) {
            List<Integer> cur = queue.poll();
            int a = cur.get(1);
            int b = cur.get(2);
            sum = A.get(a) + B.get(b);
            result.add(sum);
            count++;
            if (a == 0 || b == 0) {
                break;
            }
            setKey = (a - 1) + "|" + (b);
            if (!set.contains(setKey)) {
                sum = A.get(a - 1) + B.get(b);
                queue.offer(List.of(sum, a - 1, b));
                set.add(setKey);
            }
            setKey = (a) + "|" + (b - 1);
            if (!set.contains(setKey)) {
                sum = A.get(a) + B.get(b - 1);
                queue.offer(List.of(sum, a, b - 1));
                set.add(setKey);
            }
        }
        return result;
    }

    public static ArrayList<Integer> solveUsingHeapForJava8(List<Integer> A, List<Integer> B) {
        int n = A.size();
        Collections.sort(A);
        Collections.sort(B);
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>((a, b) -> b.get(0) - a.get(0));
        Set<String> set = new HashSet<>();
        int sum = A.get(n - 1) + B.get(n - 1);
        List<Integer> list = new ArrayList<>();
        list.add(sum);
        list.add(n - 1);
        list.add(n - 1);
        queue.offer(list);
        String setKey = (n - 1) + "|" + (n - 1);
        set.add(setKey);

        int count = 0;
        while (count < n && !queue.isEmpty()) {
            List<Integer> cur = queue.poll();
            result.add(cur.get(0));
            int a = cur.get(1);
            int b = cur.get(2);
            count++;
            if (a == 0 || b == 0) {
                break;
            }

            setKey = (a - 1) + "|" + (b);
            if (!set.contains(setKey)) {
                sum = A.get(a - 1) + B.get(b);
                list = new ArrayList<>();
                list.add(sum);
                list.add(a - 1);
                list.add(b);
                queue.offer(list);
                set.add(setKey);
            }
            setKey = (a) + "|" + (b - 1);
            if (!set.contains(setKey)) {
                sum = A.get(a) + B.get(b - 1);
                list = new ArrayList<>();
                list.add(sum);
                list.add(a);
                list.add(b - 1);
                queue.offer(list);
                set.add(setKey);
            }
        }
        return result;
    }
}
