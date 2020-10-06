package com.opensource.dada.alg.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DiskStacking {
    public static void main(String[] args) {
        int[][] array = {
                {2, 2, 1},
                {2, 1, 2},//
                {3, 2, 3},//
                {2, 3, 4},
                {4, 4, 5},//
                {2, 2, 8}
        }; //2+3+5 = 10
        List<int[]> result = diskStacking(array);
        for (int[] disk: result) {
            System.out.printf(Arrays.toString(disk));
            System.out.printf(",");
        }
        System.out.println("");
    }
    //Complexity Time:O(n^2), Space: O(n)
    static List<int[]> diskStacking(int[][] disks) {
        Arrays.sort(disks, (o1, o2) -> o1[2] - o2[2]);
        int[] heights = Arrays.stream(disks).mapToInt(value -> value[2]).toArray();
        int[] sequences = new int[disks.length];
        Arrays.fill(sequences, -1);
        int maxHeightIndex = 0;
        for (int i = 1; i < disks.length; i++) {
            int[] currentDisk = disks[i];
            for (int j = 0; j < i; j++) {
                int[] otherDisk = disks[j];
                if (areValidDimensions(currentDisk, otherDisk)) {
                    if (heights[i] <= currentDisk[2] + heights[j]) {
                        heights[i] = currentDisk[2] + heights[j];
                        sequences[i] = j;
                    }
                }
            }
            if (heights[i] >= heights[maxHeightIndex]) {
                maxHeightIndex = i;
            }
        }
        return buildSequence(disks, sequences, maxHeightIndex);
    }

    private static List<int[]> buildSequence(int[][] disks, int[] sequences, int maxHeightIndex) {
        List<int[]> sequence = new ArrayList<>();
        while (maxHeightIndex != -1) {
            sequence.add(disks[maxHeightIndex]);
            maxHeightIndex = sequences[maxHeightIndex];
        }
        Collections.reverse(sequence);
        return sequence;
    }

    private static boolean areValidDimensions(int[] currentDisk, int[] otherDisk) {
        return otherDisk[0] < currentDisk[0]
                && otherDisk[1] < currentDisk[1]
                && otherDisk[2] < currentDisk[2];
    }
}
