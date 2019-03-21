package com.opensource.dada.problems.hackerrank;

import java.util.Arrays;

/** Problem:
 * https://www.hackerrank.com/challenges/jumping-on-the-clouds
 */
public class JumpingOnClouds {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }
    static void test1() {
        int[] c = {0, 1, 0, 0, 0, 1, 0};
        System.out.println("Array:"+ Arrays.toString(c)+" result:"+jumpingOnClouds(c));//3
    }
    static void test2() {
        int[] c = {0, 0, 1, 0, 0, 1, 0};
        System.out.println("Array:"+ Arrays.toString(c)+" result:"+jumpingOnClouds(c));//4
    }
    static void test3() {
        int[] c = {0, 0, 0, 0, 1, 0};
        System.out.println("Array:"+ Arrays.toString(c)+" result:"+jumpingOnClouds(c));//3
    }
    static void test4() {
        int[] c = {0, 0, 0, 1, 0, 0};
        System.out.println("Array:"+ Arrays.toString(c)+" result:"+jumpingOnClouds(c));//3
    }

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int jumps = 0;
        int index = 0;
        while(index <=c.length-1) {
            if (index==c.length-1) {
                break;
            }
            if (index+2>c.length-1) {
                jumps++;
                break;
            }
            int y = c[index+2];
            if(y==0) {
                index +=2;
            } else {
                index +=1;
            }
            jumps++;
        }
        return jumps;
    }
}
