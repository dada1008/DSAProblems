package com.opensource.dada.problems.codility.glove;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class BinomialCoefficient {
    public static void main(String[] args) {
        int result = 0;
        long startTime = System.nanoTime();
        result = solution(5, 3);
        System.out.println("Result:" + result+" in ns:"+(System.nanoTime()-startTime));//-1

        startTime = System.nanoTime();
        result = solution(40, 20);
        System.out.println("Result:" + result+" in ns:"+(System.nanoTime()-startTime));//-1

        startTime = System.nanoTime();
        result = solution(3, 5);
        System.out.println("Result:" + result+" in ns:"+(System.nanoTime()-startTime));//-1

        startTime = System.nanoTime();
        result = solution(3, -5);
        System.out.println("Result:" + result+" in ns:"+(System.nanoTime()-startTime));//-1
    }

    public static int solution(int N, int K) {
        if (N<0 || K<0 || (N - K) < 0) {
            return -1;
        }
        BigInteger facto1 = factorial(BigInteger.valueOf(N));

        BigInteger facto2 = factorial(BigInteger.valueOf(K));
        BigInteger facto3 = factorial(BigInteger.valueOf(N - K));

        BigInteger result = facto1.divide(facto2.multiply(facto3));

        if (result.compareTo(BigInteger.valueOf(1000000000)) >= 1) {
            return -1;
        }
        return result.intValue();
    }

    /**
     * Without cache===
     *
     * Result:10 in ns:1299992
     * Result:-1 in ns:380168
     * Result:-1 in ns:536
     *
     * Result:10 in ns:1999607
     * Result:-1 in ns:247631
     * Result:-1 in ns:424
     *
     * Result:10 in ns:2151828
     * Result:-1 in ns:318316
     * Result:-1 in ns:548
     *
     * Result:10 in ns:1614831
     * Result:-1 in ns:238001
     * Result:-1 in ns:443
     *
     * Result:10 in ns:1676334
     * Result:-1 in ns:254889
     * Result:-1 in ns:429
     *
     * With cache===
     *
     * Result:10 in ns:1846509
     * Result:-1 in ns:167331
     * Result:-1 in ns:438
     *
     * Result:10 in ns:1734067
     * Result:-1 in ns:275437
     * Result:-1 in ns:622
     *
     * Result:10 in ns:1609772
     * Result:-1 in ns:176677
     * Result:-1 in ns:437
     *
     * Result:10 in ns:1422193
     * Result:-1 in ns:254007
     * Result:-1 in ns:683
     *
     * Result:10 in ns:1606951
     * Result:-1 in ns:176068
     * Result:-1 in ns:499
     */
    static Map<BigInteger, BigInteger> numberToFactorialCache = new HashMap<>();
    static BigInteger factorial(BigInteger n) {
        if (n.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        }
        BigInteger nextNumber = n.subtract(BigInteger.ONE);
        BigInteger fact = numberToFactorialCache.get(nextNumber);
        if (fact==null) {
            fact = factorial(nextNumber);
            numberToFactorialCache.put(nextNumber, fact);
        }

        return n.multiply(fact);
    }
}
