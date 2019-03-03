package com.opensource.dada.problems;


public class ZalandoProblem {
    public static void main(String[] agrs) {
        System.out.println("Welcome to Zalando codility tasks of 90 minutes");
        //testSmallnum();
        testSqrtOp();
    }

    static void testSmallnum() {
        int num = 125;
        System.out.println("smallNumberWithSameNumOfDigits of :"+num+" is: "+smallNumberWithSameNumOfDigits(num));
    }

    static void testSqrtOp() {
        int A = 6000;
        int B = 7000;
        System.out.println("smallNumberWithSameNumOfDigits of A:"+A+" and B: "+B +" is: "+maxNumOfRepeatedSquareRootOperations(A,B));
    }
    /**
     Write a function that, given an integer N,
     returns the smallest number with the same number of digits.
     You can assume N is between 1 and 10^9(a billion).
     For example, given N = 125, the function should return 100.
     Given N = 10, the function should return 10.
     Given N = 1, the function should return 0.
     *
     */
    public static int smallNumberWithSameNumOfDigits(int N) {
        /**String numStr = String.valueOf(N);
         int digitCount = numStr.length();**/
        int digitCount = countOfDigit(N);
        if(digitCount==1) {
            return 0;
        }
        int smallestNum = (int)Math.pow(10, digitCount-1);
        return smallestNum;
    }

    static int countOfDigit(int N) {
        int count =0;
        while(N!=0) {
            N /=10;
            count++;
        }
        return count;
    }

    /**
     Write a function solution that, given two integers A and B,
     returns the maximum number of repeated square root operations
     that can be performed using the numbers from the interval [A..B] (both ends included)
     as starting points. Square root operations can be performed
     as long as the result is still an integer.
     For example, given A = 10, B = 20,
     the function should return 2.
     Starting with the integer 16, t
     wo square root operations can be performed: sqrt(16) = 4 and then sqrt(4) = 2.
     Given A = 6000 and B = 7000,
     the function should return 3.
     Starting with integer 6561, three square root operations can be performed:
     sqrt(6561) = 81, sqrt(81) = 9 and sqrt(9) = 3.
     Write an efficient algorithm for the following assumptions:
     A and B are integers within the range 2..1,000,000,000;
     A ≤ B.
     *
     */
    public static int maxNumOfRepeatedSquareRootOperations(int A, int B) {
        int finalResult = 0;
        int finalNum = 0;
        for (int i=A; i<=B; i++) {
            if(isNumSqrtable(i)) {
                int result = checkSqureRoots(i);
                if (finalResult < result) {
                    finalResult = result;
                    finalNum = i;
                }
            }
        }
        if(finalResult>0) {
            System.out.println("Number is: "+finalNum);
        }
        return finalResult;
    }

    static boolean isNumSqrtable(int num) {
        //Perfect square has number ends with 1, 4, 6, 9, 00, 25.
        int reminder = num%10;
        //check number's last digit is 1, 4, 6 or 9
        if(reminder==1|| reminder==4|| reminder==6 || reminder==9) {
            return true;

            //check number's last 2 digits are 00
        } else if (reminder==0) {
            int reminder2 = (num/10)%10;
            if (reminder2==0) {
                return true;
            }
            //check number's last 2 digits are 25
        } else if (reminder==5) {
            int reminder2 = (num/10)%10;
            if (reminder2==2) {
                return true;
            }
        }

        return false;
    }

    private static int checkSqureRoots(int squareNum) {
        int sqaureRootCount = 0;
        double newSquareNum = Math.sqrt(squareNum);
        while(isCompleteSquare(newSquareNum)) {
            sqaureRootCount++;
            newSquareNum = Math.sqrt(newSquareNum);
        }

        return sqaureRootCount;
    }

    static boolean isCompleteSquare(double sqrt) {
        return ((sqrt - Math.floor(sqrt)) == 0);
    }
}
