package com.opensource.dada.problems;

public class PowerSetOfGivenSet {
    public static void main(String[] args) {
        char[] set = {'a', 'b', 'c'};

        printPowerSet(set);
    }

    private static void printPowerSet(char[] set) {
        int setSize = set.length;
        long powerSetSize = (long) Math.pow(2, setSize);

        for (long i = 0; i < powerSetSize; i++) {
            for (int j = 0; j < setSize; j++) {
                if ((i & (1 << j)) > 0) {
                    System.out.print(set[j]);
                }
            }
            System.out.println();
        }
    }

}
