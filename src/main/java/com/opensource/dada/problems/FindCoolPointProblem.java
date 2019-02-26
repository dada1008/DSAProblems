package com.opensource.dada.problems;

/** Problem:
 * int a[] = [40,30,50,60,70,10,40]
 * find any 1 cool point = temp less than its neighbours like 30 or 10
 *
 * constraints :
 * a[0] > a[1]
 * a[n] > a[n-1]
 *
 * }
 */
public class FindCoolPointProblem {
    public static void main(String[] args) {
        int[] a = {40,30,50,60,70,10,40};
        int coolPoint = findCoolPoint(a);
        System.out.println("CoolPoint: "+coolPoint);
    }

    static int findCoolPoint(int[] a) {

        int low = 0, high = a.length - 1;
        int mid = high / 2;

        while (high > low) {
            if ((mid == 0 || a[mid] < a[mid-1] ) && (mid == a.length-1 || a[mid] < a[mid+1])) {
                return a[mid];
            }
            if (mid > 0 && a[mid] > a[mid-1]) {
                high = mid -1;
            } else {
                low = mid + 1;
            }
            mid = low + (high - low) / 2;
        }
        return 0;
    }
}
