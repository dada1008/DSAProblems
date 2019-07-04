package com.opensource.dada.problems.geeksforgeeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ImmediateSmallerElement {
    public static void main (String[] args) throws IOException {
        /*Scanner scanner = new Scanner(System.in);
        int noOfInputs = scanner.nextInt();
        int[][] inputArrays = new int[noOfInputs][];
        for (int i =0; i<noOfInputs; i++) {
            int arraySize = scanner.nextInt();
            int[] array = new int[arraySize];
            for (int j =0; j<arraySize; j++) {
                array[j] = scanner.nextInt();
            }
            inputArrays[i] = array;
        }*/
        // Using BufferedReader class to take input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // taking input of number of testcase
        int noOfInputs = Integer.parseInt(br.readLine());
        for (int i =0; i<noOfInputs; i++) {
            // n : size of array
            int arraySize = Integer.parseInt(br.readLine());
            int[] array = new int[arraySize];

            // to read multiple integers line
            String line = br.readLine();
            String[] strs = line.trim().split("\\s+");

            for (int j =0; j<arraySize; j++) {
                array[j] = Integer.parseInt(strs[j]);
            }
            printImmediateSmaller(array);
        }
        br.close();
        /*for (int i =0; i<noOfInputs; i++) {
            printImmediateSmaller(inputArrays[i]);
        }*/


        //code
        /*int[] array = {4, 2, 1, 5, 3};
        printImmediateSmaller(array);

        int[] array2 = {5, 6, 2, 3, 1, 7};
        printImmediateSmaller(array2);*/
    }

    public static void printImmediateSmaller(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<array.length-1;i++) {
            int smaller = array[i]>array[i+1]? array[i+1]: -1;
            sb.append(smaller);
            sb.append(" ");
        }
        sb.append(-1);
        System.out.println(sb);

    }
}
