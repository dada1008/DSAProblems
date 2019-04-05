package com.opensource.dada.problems.hackerrank;

public class TaumBday {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();

        test6();
        test7();
        test8();
        test9();
        test10();
    }

    static void test1() {
        System.out.println("result: " + taumBday(10,10,1,1,1));//20
    }
    static void test2() {
        System.out.println("result: " + taumBday(5,9,2,3,4));//37
    }
    static void test3() {
        System.out.println("result: " + taumBday(3,6,9,1,1));//12
    }
    static void test4() {
        System.out.println("result: " + taumBday(7,7,4,2,1));//35
    }
    static void test5() {
        System.out.println("result: " + taumBday(3,3,1,9,2));//12
    }

    /**
     * 27984 1402
     * 619246 615589 247954
     *18192035842
     *
     * 95677 39394
     * 86983 311224 588538
     *20582630747
     *
     * 68406 12718
     * 532909 315341 201009
     *39331944938
     *
     * 15242 95521
     * 712721 628729 396706
     *70920116291
     *
     * 21988 67781
     * 645748 353796 333199
     *38179353700
     *
     * 22952 80129
     * 502975 175136 340236
     *25577754744
     *
     * 38577 3120
     * 541637 657823 735060
     *22947138309
     *
     * 5943 69851
     * 674453 392925 381074
     *31454478354
     *
     * 62990 61330
     * 310144 312251 93023
     *38686324390
     *
     * 11152 43844
     * 788543 223872 972572
     *18609275504
     */

    static void test6() {
        System.out.println("result: " + taumBday(27984,1402,619246,615589,247954));//18192035842
    }
    static void test7() {
        System.out.println("result: " + taumBday(95677,39394,86983, 311224, 588538));//20582630747
    }
    static void test8() {
        System.out.println("result: " + taumBday(68406, 12718,532909, 315341, 201009));//39331944938
    }
    static void test9() {
        System.out.println("result: " + taumBday(62990,61330,310144,312251,93023));//38686324390
    }
    static void test10() {
        System.out.println("result: " + taumBday(11152,43844,788543,223872,972572));//18609275504
    }

    // Complete the taumBday function below.
    static long taumBday(int b, int w, int bc, int wc, int z) {
        return taumBday1(b, w, bc, wc, z);
    }

    // this solution works for 1 to 5 test cases, but for test 6 to 10 it fails as it would comvert in in long and multiplication stays in int
    // If we convert all the input parameters from int to long this will work for all tests.
    static long taumBday1(int b, int w, int bc, int wc, int z) {
        if((b+w <=0) ||(bc+wc) <= 0){
            return 0;
        }
        long minCost = Long.MAX_VALUE;
        long bc_wc_diff = Math.abs(bc-wc);
        boolean needConversion = z < bc_wc_diff;

        if (needConversion) {
            if(bc > wc) {
                minCost = (b+w)*wc + (b*z);
            } else {
                minCost = (b+w)*bc + (w*z);
            }
        } else {
            minCost = (b*bc) + (w*wc);
        }

        return minCost;
    }

    // better than 1.
    static long taumBday2(int b, int w, int bc, int wc, int z) {
        //Calculate white->black and choose max between it and black
        long minBlackPrice = Math.min(bc, wc + z);

        //Calculate black->white and choose max between it and white
        long minWhitePrice = Math.min(wc, bc + z);

        //Multiple the price for each one by the number of gifts we need
        return ((minBlackPrice * b) + (minWhitePrice * w));
    }
}
