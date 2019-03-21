package com.opensource.dada.problems;

public class CountSetBits {
    public static void main(String[] args) {
        int i = 18;
        System.out.println(countSetBits(i));
    }

    /* Function to get no of set
    bits in binary representation
    of positive integer n */
    static int countSetBits(int n)
    {
        int count = 0;
        while (n > 0)
        {
            System.out.println("n: "+n+" (n & 1): "+(n & 1));
            count += n & 1;
            n >>= 1;
            System.out.println("n:"+n);
        }
        return count;
    }
}
