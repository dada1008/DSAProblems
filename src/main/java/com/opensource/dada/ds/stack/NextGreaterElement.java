package com.opensource.dada.ds.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Problem: https://www.interviewbit.com/problems/nextgreater/
 *
 * Given an array, find the next greater element G[i] for every element A[i] in the array.
 * The Next greater Element for an element A[i] is the first greater element on the right side of
 * A[i] in array.
 * More formally,
 *
 * G[i] for an element A[i] = an element A[j] such that
 *     j is minimum possible AND
 *     j > i AND
 *     A[j] > A[i]
 * Elements for which no greater element exist, consider next greater element as -1.
 *
 * Example:
 *
 * Input : A : [4, 5, 2, 10]
 * Output : [5, 10, 10, -1]
 *
 * Example 2:
 *
 * Input : A : [3, 2, 1]
 * Output : [-1, -1, -1]
 *
 */
public class NextGreaterElement {

    public static void main(String[] args) {
        System.out.println("nextGreater:"+nextGreater(List.of(1, 4, 5, 2, 10)));
        System.out.println("nextGreater:"+nextGreater(List.of(3, 2, 1)));
        System.out.println("nextGreater:"+nextGreater(List.of(1,5,2,70,5,10, 14)));
    }

    private static List<Integer> nextGreater(List<Integer> A) {
        //return nextGreaterBrutForce(A);
        return nextGreaterUsingStack(A);
    }

    //This is optimum solution with Time Complexity: O(n)
    public static List<Integer> nextGreaterUsingStack(List<Integer> A) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            result.add(-1);
        }
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < A.size(); i++) {
            int num = A.get(i);
            while (!stack.isEmpty() && num > A.get(stack.peek())) {
                result.set(stack.pop(), num);
            }
            stack.push(i);
        }
        return result;
    }

    //Time Complexity: O(n*n), i.e. O(n2)
    public static List<Integer> nextGreaterBrutForce(List<Integer> A) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < A.size() -1; i++) {
            int nextG = -1;
            for (int j = i+1; j < A.size(); j++) {
                if (A.get(i) < A.get(j) && (nextG ==-1 || nextG > A.get(j))) {
                    nextG = A.get(j);
                }
            }
            result.add(nextG);
        }
        return result;
    }
}
