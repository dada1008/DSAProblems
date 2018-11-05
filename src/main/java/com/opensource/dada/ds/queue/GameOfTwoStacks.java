package com.opensource.dada.ds.queue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Problem:
 * url: https://www.hackerrank.com/challenges/game-of-two-stacks/problem
 *
 * Alexa has two stacks of non-negative integers, stack A=[a0,a1,...an-1] and stack B=[b0,b1,...bn-1]
 * where index denotes the top of the stack. Alexa challenges Nick to play the following game:
 *
 * In each move, Nick can remove one integer from the top of either stack A or stack B.
 * Nick keeps a running sum of the integers he removes from the two stacks.
 * Nick is disqualified from the game if, at any point, his running sum becomes greater than some integer
 * x given at the beginning of the game.
 * Nick's final score is the total number of integers he has removed from the two stacks.
 * Given A, B and x for g games, find the maximum possible score Nick can achieve
 * (i.e., the maximum number of integers he can remove without being disqualified)
 * during each game and print it on a new line.
 *
 * Input Format
 *
 * The first line contains an integer, g (the number of games). The  subsequent lines describe each game
 * in the following format:
 *
 * The first line contains three space-separated integers describing the respective values of
 * n (the number of integers in stack A), m (the number of integers in stack B), and
 * x (the number that the sum of the integers removed from the two stacks cannot exceed).
 * The second line contains n space-separated integers describing the respective values of a0,a1...an-1.
 * The third line contains  space-separated integers describing the respective values of b0,b1...bn-1.
 * Constraints
 * 1 <= g <= 50
 * 1 <= n,m <= 10^5
 * 0 <= ai,bj <= 10^6
 * 1 <= x <= 10^9
 *
 * Subtasks
 *
 * 1 <= n,m <= 100 for 50% of the maximum score.
 *
 * Output Format
 *
 * For each of the g games, print an integer on a new line denoting the maximum possible score
 * Nick can achieve without being disqualified.
 *
 * Sample Input 0
 *
 * 1
 * 5 4 10
 * 4 2 4 6 1
 * 2 1 8 5
 * Sample Output 0
 *
 * 4
 * Explanation 0
 *
 * The two stacks initially look like this:
 *
 * image
 *
 * The image below depicts the integers Nick should choose to remove from the stacks.
 * We print  as our answer, because that is the maximum number of integers that can be removed
 * from the two stacks without the sum exceeding .
 *
 * image
 *
 * (There can be multiple ways to remove the integers from the stack, the image shows just one of them.)
 */
public class GameOfTwoStacks {

    public static void main(String[] args) {
        int[] a = {4,2,4,6,1};
        int[] b = {2,1,8,5};
        int x = 10;

        int totalMoves = twoStacks(x, a, b);
        System.out.println("totalMoves: " + totalMoves);
    }

    public static int twoStacks(int x, int[] a, int[] b) {
        int indexB = 0;
        int sum = 0;
        while (indexB < b.length && (sum + b[indexB]) <= x) {
            sum += b[indexB];
            indexB++;
        }

        int maxScore = indexB;
        for (int indexA = 1; indexA <= a.length; indexA++) {
            sum += a[indexA - 1];

            while (sum > x && indexB > 0) {
                indexB--;
                sum -= b[indexB];
            }

            if (sum > x) {
                break;
            }

            maxScore = Math.max(maxScore, indexA + indexB);
        }
        return maxScore;
    }
}
