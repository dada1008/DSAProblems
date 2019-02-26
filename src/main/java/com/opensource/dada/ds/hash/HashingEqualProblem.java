package com.opensource.dada.ds.hash;

import java.util.*;

/** Problem:
 * Given an array A of integers,
 * find the index of values that satisfy A + B = C + D,
 * where A,B,C & D are integers values in the array
 *
 * Note:
 *
 * 1) Return the indices `A1 B1 C1 D1`, so that
 *   A[A1] + A[B1] = A[C1] + A[D1]
 *   A1 < B1, C1 < D1
 *   A1 < C1, B1 != D1, B1 != C1
 *
 * 2) If there are more than one solutions,
 *    then return the tuple of values which are lexicographical smallest.
 *
 * Assume we have two solutions
 * S1 : A1 B1 C1 D1 ( these are values of indices int the array )
 * S2 : A2 B2 C2 D2
 *
 * S1 is lexicographically smaller than S2 iff
 *   A1 < A2 OR
 *   A1 = A2 AND B1 < B2 OR
 *   A1 = A2 AND B1 = B2 AND C1 < C2 OR
 *   A1 = A2 AND B1 = B2 AND C1 = C2 AND D1 < D2
 * Example:
 *
 * Input: [3, 4, 7, 1, 2, 9, 8]
 * Output: [0, 2, 3, 5] (O index)
 * If no solution is possible, return an empty list.
 */
public class HashingEqualProblem {

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(3, 4, 7, 1, 2, 9, 8);
        List<Integer> res = equal(A);
        System.out.println(A+", Result: "+res);

        A = Arrays.asList(3, 4, 7, 0, 2, 9, 8);
        res = equal(A);
        System.out.println(A+", Result: "+res);

        A = Arrays.asList(3, 2, 5, 1, 2, 9, 8);
        res = equal(A);
        System.out.println(A+", Result: "+res);

        A = Arrays.asList(3, 4, 7, 1, 2, 9, 8);
        res = equal(A);
        System.out.println(A+", Result: "+res);
    }

    public static List<Integer> equal(List<Integer> A) {
        List<Integer> res = new ArrayList<>();
        if(A.size()<4) {
            return res;
        }
        Map<Integer, Integer[]> sum2InciesMap = new HashMap<>();
        boolean found = false;
        for (int i=0; i<A.size(); i++) {
            for (int j=i+1; j<A.size(); j++) {
                int sum = A.get(i) + A.get(j);
                Integer[] indices = sum2InciesMap.get(sum);
                if (indices==null) {
                    indices = new Integer[2];
                    indices[0]=i;
                    indices[1]=j;
                    sum2InciesMap.put(sum,indices);
                } else if (indices[0] < i && indices[1] != i && indices[1] != j) {

                    if(res.isEmpty()) {
                        res.add(indices[0]);
                        res.add(indices[1]);
                        res.add(i);
                        res.add(j);
                    } else {

                        int a2 = res.get(0);
                        int b2 = res.get(1);
                        int c2 = res.get(2);
                        int d2 = res.get(3);

                        int a1 = indices[0];
                        int b1 = indices[1];
                        int c1 = i;
                        int d1 = j;

                        if((a1 < a2) ||
                                (( a1 == a2) &&( b1 < b2)) ||
                                ((a1 == a2) && (b1 == b2) && (c1 < c2)) ||
                                ((a1 == a2) && (b1 == b2) && (c1 == c2) &&( d1 < d2))) {
                            res.clear();
                            res.add(a1);
                            res.add(b1);
                            res.add(c1);
                            res.add(d1);
                        }

                    }
                }
            }
        }

        return res;
    }
}
