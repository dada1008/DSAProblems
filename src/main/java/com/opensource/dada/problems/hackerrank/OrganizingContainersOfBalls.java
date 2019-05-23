package com.opensource.dada.problems.hackerrank;

import java.util.Arrays;

/** Problem:
 * https://www.hackerrank.com/challenges/organizing-containers-of-balls/problem
 */
public class OrganizingContainersOfBalls {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }
    static void test1() {
        int[][] container = new int[2][2];
        container[0][0]=1;
        container[0][1]=1;

        container[1][0]=1;
        container[1][0]=1;

        System.out.println("Result: "+organizingContainers(container));//Possible
    }

    static void test2() {
        int[][] container = new int[2][2];
        container[0][0]=0;
        container[0][1]=2;

        container[1][0]=1;
        container[1][1]=1;

        System.out.println("Result: "+organizingContainers(container));//Impossible
    }

    static void test3() {
        int[][] container = new int[3][3];
        container[0][0]=1;
        container[0][1]=3;
        container[0][2]=1;

        container[1][0]=2;
        container[1][0]=1;
        container[1][2]=2;

        container[2][0]=3;
        container[2][1]=3;
        container[2][2]=3;
        System.out.println("Result: "+organizingContainers(container));//Impossible
    }
    static void test4() {
        int[][] container = new int[3][3];
        container[0][0]=0;
        container[0][1]=2;
        container[0][2]=1;

        container[1][0]=1;
        container[1][0]=1;
        container[1][2]=1;

        container[2][0]=2;
        container[2][1]=0;
        container[2][2]=0;
        System.out.println("Result: "+organizingContainers(container));//Possible
    }
    static String organizingContainers(int[][] container) {
        int n = container.length;
        int[] containers = new int[n];
        int[] colors = new int[n];
        for(int i = 0; i < n; i++) {
            int containerSum = 0;
            int colorSum = 0;
            for(int j = 0; j < n; j++){
                containerSum += container[i][j];
                colorSum += container[j][i];
            }
            colors[i] = colorSum;
            containers[i] = containerSum;
        }

        Arrays.sort(containers);
        Arrays.sort(colors);

        return Arrays.equals(containers, colors) ? "Possible" : "Impossible";
    }

}
