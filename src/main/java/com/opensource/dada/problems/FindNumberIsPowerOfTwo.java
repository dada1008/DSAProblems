package com.opensource.dada.problems;

public class FindNumberIsPowerOfTwo {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }
    static void test1() {
        System.out.println(isPowerOfTwo1(31) ? "Yes" : "No");
        System.out.println(isPowerOfTwo1(64) ? "Yes" : "No");
    }
    static void test2() {
        System.out.println(isPowerOfTwo2(31) ? "Yes" : "No");
        System.out.println(isPowerOfTwo2(64) ? "Yes" : "No");
    }
    static void test3() {
        System.out.println(isPowerOfTwo3(31) ? "Yes" : "No");
        System.out.println(isPowerOfTwo3(64) ? "Yes" : "No");
    }
    /* Function to check if x is power of 2*/
    static boolean isPowerOfTwo1(int n)
    {
        return (int)(Math.ceil((Math.log(n) / Math.log(2)))) ==
                (int)(Math.floor(((Math.log(n) / Math.log(2)))));
    }

    // Function to check if
    // x is power of 2
    static boolean isPowerOfTwo2(int n)
    {
        if (n == 0)
            return false;

        while (n != 1)
        {
            if (n % 2 != 0)
                return false;
            n = n / 2;
        }
        return true;
    }

    /* Method to check if x is power of 2*/
    static boolean isPowerOfTwo3(int x)
    {
      /* First x in the below expression is
        for the case when x is 0 */
        return x!=0 && ((x&(x-1)) == 0);

    }
}
