package com.opensource.dada.problems.geeksforgeeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RotatingAnArray {
    public static void main (String[] args) throws IOException {
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
            int rotatingCount = Integer.parseInt(br.readLine());
            RotatingAnArray(array, rotatingCount);
        }
        br.close();
    }

    public static void RotatingAnArray(int[] array, int rotatingCount) {
        StringBuilder sb = new StringBuilder();
        for (int i=rotatingCount;i<array.length;i++) {
            sb.append(array[i]);
            sb.append(" ");
        }
        for (int i=0;i<rotatingCount;i++) {
            sb.append(array[i]);
            sb.append(" ");
        }
        System.out.println(sb);
    }
}
