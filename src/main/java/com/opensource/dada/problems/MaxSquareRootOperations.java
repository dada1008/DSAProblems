package com.opensource.dada.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.lang.Integer.max;

class MaxSquareRootOperations {

    private static final Long squareSet[] = init();
    private static final long MAX = 1000000000;
    private static final long MAX_ROOT = 31623;

    public static void main(String[] args) {
        MaxSquareRootOperations obj = new MaxSquareRootOperations();
        System.out.println(obj.solution(1, 20));
        System.out.println(obj.solution(10, 20));
        System.out.println(obj.solution(6000, 7000));
        System.out.println(obj.solution(1, 36));
    }
    private static Long[] init() {
        Set<Long> squareSet = new HashSet<>();
        for (int i = 2; i <= MAX_ROOT; i++) {
            long n = i;
            while (n <= MAX) {
                if (isPerfectSquare(n)) {
                    squareSet.add((long) n);
                }
                n = n * n;
            }
        }
        Long sq[] = new Long[squareSet.size()];
        squareSet.toArray(sq);
        Arrays.sort(sq);
        return sq;
    }

    /*returns smallest no. less greater than x*/
    long floor(Long[] a, int start, int end, int x) {
        if (start <= end) {
            int mid = (start + end) / 2;
            if (a[mid] == x) {
                return mid;
            } else if (a[mid] < x) {
                return floor(a, mid + 1, end, x);
            } else {
                long currentAns = floor(a, start, mid - 1, x);
                return currentAns == -1 ? a[mid] : currentAns;
            }
        }
        return -1;
    }

    /*returns biggest no. less than x*/
    long ceil(Long[] a, int start, int end, int x) {
        if (start <= end) {
            int mid = (start + end) / 2;
            if (a[mid] == x) {
                return mid;
            } else if (a[mid] < x) {
                long currentAns = floor(a, mid + 1, end, x);
                return currentAns == -1 ? a[mid] : currentAns;
            } else {
                return floor(a, start, mid - 1, x);
            }
        }
        return -1;
    }

    public int solution(int a, int b) {
        int actualStart = (int) floor(squareSet, 0, squareSet.length - 1, a);
        int actualEnd = (int) ceil(squareSet, 0, squareSet.length - 1, b);

        if (actualStart == -1 || actualEnd == -1) return 0;

        int result = 0;
        for (int i = actualStart; i <= actualEnd; i++) {
            result = max(result, calOperations(squareSet[i]));
        }
        return result;
    }

    private int calOperations(long x) {
        double sqrt = x;
        int count = 0;
        while (true) {
            if (isPerfectSquare(sqrt)) {
                sqrt = Math.sqrt(sqrt);
                count++;
            } else break;

        }
        return count;
    }

    static boolean isPerfectSquare(double x) {
        double sr = Math.sqrt(x);
        return ((sr - Math.floor(sr)) == 0);
    }
}
