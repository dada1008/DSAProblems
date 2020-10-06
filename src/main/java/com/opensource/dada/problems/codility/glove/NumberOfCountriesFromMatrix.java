package com.opensource.dada.problems.codility.glove;

/**
 * Problem:
 * What if we know the country map after being colored with no more than 4 colors,
 * and the same color as the adjacent grid indicates the same country;
 * only for the up, down, left, right directions, not for oblique direction.
 * How can we find the number of countries from the map?
 *
 * For example, given the map:
 *
 * 1, 3, 3, 3
 * 1, 2, 4, 3
 * 2, 3, 4, 4
 * The number of countries is 6.
 *
 * [
 *   [1, 3, 3, 3, 4, 4, 1],
 *   [1, 2, 2, 2, 1, 1, 1],
 *   [1, 2, 2, 3, 3, 1, 1],
 *   [1, 3, 2, 4, 3, 1, 4],
 *   [4, 3, 2, 2, 3, 4, 4],
 *   [2, 1, 4, 4, 2, 2, 2],
 *   [2, 1, 4, 4, 3, 3, 1],
 *   [2, 2, 1, 1, 2, 2, 1]
 * ]
 * The number of countries is 18.
 *
 * 7*3 matrix
 *
 * A[0][0] = 5    A[0][1] = 4    A[0][2] = 4
 * A[1][0] = 4    A[1][1] = 3    A[1][2] = 4
 * A[2][0] = 3    A[2][1] = 2    A[2][2] = 4
 * A[3][0] = 2    A[3][1] = 2    A[3][2] = 2
 * A[4][0] = 3    A[4][1] = 3    A[4][2] = 4
 * A[5][0] = 1    A[5][1] = 4    A[5][2] = 4
 * A[6][0] = 4    A[6][1] = 1    A[6][2] = 1
 *
 * The number of countries is 11.
 */
public class NumberOfCountriesFromMatrix {
    public static void main(String[] args) {
        int[][] map1 = {
                {1, 3, 3, 3},
                {1, 2, 4, 3},
                {2, 3, 4, 4},
        };
        int[][] map2 = {
                {1, 3, 3, 3, 4, 4, 1},
                {1, 2, 2, 2, 1, 1, 1},
                {1, 2, 2, 3, 3, 1, 1},
                {1, 3, 2, 4, 3, 1, 4},
                {4, 3, 2, 2, 3, 4, 4},
                {2, 1, 4, 4, 2, 2, 2},
                {2, 1, 4, 4, 3, 3, 1},
                {2, 2, 1, 1, 2, 2, 1}
        };
        int [][] A = new int[7][3];
        A[0][0] = 5; A[0][1] = 4; A[0][2] = 4;
        A[1][0] = 4; A[1][1] = 3; A[1][2] = 4;
        A[2][0] = 3; A[2][1] = 2; A[2][2] = 4;
        A[3][0] = 2; A[3][1] = 2; A[3][2] = 2;
        A[4][0] = 3; A[4][1] = 3; A[4][2] = 4;
        A[5][0] = 1;    A[5][1] = 4;    A[5][2] = 4;
        A[6][0] = 4;    A[6][1] = 1;    A[6][2] = 1;
        System.out.println("map1 countries:"+solution(map1));
        System.out.println("map2 countries:"+solution(map2));
        System.out.println("A countries:"+solution(A));
    }
    static int solution(int[][] A) {
        int numberOfCountries = 0;
        for (int x = 0; x < A.length; ++x) {
            for (int y = 0; y < A[0].length; ++y) {
                int countryColor = A[x] [y];
                // only replaceColor a country if it hasn't yet been visited
                if (countryColor != 0) {
                    numberOfCountries++;
                    replaceColor(A, x, y, countryColor, 0);
                }
            }
        }
        return numberOfCountries;
    }

    static void replaceColor(int[][] A, int x, int y, int colorToReplace, int colorToUse) {
        if (x < 0 || x >= A.length) {
            return;
        }
        if (y < 0 || y >= A[0].length) {
            return;
        }
        int color = A[x] [y];
        if (color == colorToUse) {
            return;
        }
        if (color != colorToReplace) {
            return;
        }
        A[x] [y] = colorToUse;
        replaceColor(A, x, y - 1, colorToReplace, colorToUse); //replaceColor to North
        replaceColor(A, x, y + 1, colorToReplace, colorToUse); //replaceColor to South
        replaceColor(A, x - 1, y, colorToReplace, colorToUse); //replaceColor to West
        replaceColor(A, x + 1, y, colorToReplace, colorToUse); //replaceColor to East
    }
}
