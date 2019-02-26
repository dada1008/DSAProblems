package com.opensource.dada.knapsack;

import java.util.HashMap;
import java.util.Map;

/** Problem:
 * Queen Elizabeth has a limited number of types of cake,
 * she has an unlimited supply of each type.
 *
 * Each type of cake has a weight and a value,
 * stored in a tuple with two indices:
 *
 * An integer representing the weight of the cake in kilograms
 * An integer representing the monetary value of the cake in British shillings
 * For example:
 *
 *   # Weighs 7 kilograms and has a value of 160 shillings
 * (7, 160)
 *
 * # Weighs 3 kilograms and has a value of 90 shillings
 * (3, 90)
 *
 * You brought a duffel bag that can hold limited weight,
 * and you want to make off with the most valuable haul possible.
 *
 * Write a function max_duffel_bag_value() that takes a list of cake type tuples
 * and a weight capacity, and returns the maximum monetary value the duffel bag can hold.
 *
 * For example:
 *
 *   cake_tuples = [(7, 160), (3, 90), (2, 15)]
 * capacity    = 20
 *
 * # Returns 555 (6 of the middle type of cake and 1 of the last type of cake)
 * max_duffel_bag_value(cake_tuples, capacity)
 *
 * Weights and values may be any non-negative integer.
 * Yes, it's weird to think about cakes that weigh nothing
 * or duffel bags that can't hold anything.
 * But we're not just super mastermind criminals—we're
 * also meticulous about keeping our algorithms flexible and comprehensive.
 */
public class CakeThiefProblem {

    /**
     * Solution:
     * This is a classic computer science puzzle called "the unbounded knapsack problem."
     *
     * We use a bottom-up ↴ approach to find the max value at our duffel bag's weightCapacity
     * by finding the max value at every capacity from 0 to weightCapacity.
     *
     * We allocate an array maxValuesAtCapacities where the indices are capacities
     * and each value is the max value at that capacity.
     *
     * For each capacity, we want to know the max monetary value we can carry.
     * To figure that out, we go through each cake, checking to see if we should take that cake.
     *
     * The best monetary value we can get if we take a given cake is simply:
     *
     * that cake's value, plus
     * the best monetary value we can carry in our remaining duffel bag capacity
     * after taking the cake—which we'll already have stored in maxValuesAtCapacities
     * To handle weights and values of zero, we throw an infinity error
     * only if a cake weighs nothing and has a positive value.
     */
    public static long maxDuffelBagValue(CakeType[] cakeTypes, int weightCapacity) {

        // we make an array to hold the maximum possible value at every
        // duffel bag weight capacity from 0 to weightCapacity
        // starting each index with value 0
        long[] maxValuesAtCapacities = new long[weightCapacity + 1];

        for (int currentCapacity = 0; currentCapacity <= weightCapacity; currentCapacity++) {

            // set a variable to hold the max monetary value so far for currentCapacity
            long currentMaxValue = 0;

            for (CakeType cakeType : cakeTypes) {

                // if a cake weighs 0 and has a positive value the value of our duffel bag is infinite!
                if (cakeType.weight == 0 && cakeType.value != 0) {
                    throw new InfinityException();
                }

                // if the current cake weighs as much or less than the current weight capacity
                // it's possible taking the cake would get a better value
                if (cakeType.weight <= currentCapacity) {

                    // so we check: should we use the cake or not?
                    // if we use the cake, the most kilograms we can include in addition to the cake
                    // we're adding is the current capacity minus the cake's weight. we find the max
                    // value at that integer capacity in our array maxValuesAtCapacities
                    long maxValueUsingCake = cakeType.value
                            + maxValuesAtCapacities[currentCapacity - cakeType.weight];

                    // now we see if it's worth taking the cake. how does the
                    // value with the cake compare to the currentMaxValue?
                    currentMaxValue = Math.max(maxValueUsingCake, currentMaxValue);
                }
            }

            // add each capacity's max value to our array so we can use them
            // when calculating all the remaining capacities
            maxValuesAtCapacities[currentCapacity] = currentMaxValue;
        }

        return maxValuesAtCapacities[weightCapacity];
    }
}

class CakeType {

    final int weight;
    final int value;

    public CakeType(int weight, int value) {
        this.weight = weight;
        this.value  = value;
    }
}
class InfinityException extends RuntimeException {
    public InfinityException() {
        super("Max value is infinity!");
    }
}