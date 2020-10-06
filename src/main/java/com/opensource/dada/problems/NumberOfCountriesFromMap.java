package com.opensource.dada.problems;

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
 */
public class NumberOfCountriesFromMap {
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
        System.out.println("map1 countries:"+countCountries(map1));
        System.out.println("map2 countries:"+countCountries(map2));
        System.out.println("A countries:"+countCountries(A));
    }
    static int countCountries(int[][] map) {
        int numberOfCountries = 0;
        for (int x = 0; x < map.length; ++x) {
            for (int y = 0; y < map[0].length; ++y) {
                int countryColor = map[x] [y];
                // only floodfill a country if it hasn't yet been visited
                if (countryColor != 0) {
                    numberOfCountries++;
                    floodfill(map, x, y, countryColor, 0);
                }
            }
        }
        // update our display of the country count:
        return numberOfCountries;
    }

    static void floodfill(int[][] map, int x, int y, int colorToReplace, int colorToUse) {
        if (x < 0 || x >= map.length) {
            return;
        }
        if (y < 0 || y >= map[0].length) {
            return;
        }
        var tileColor = map[x] [y];
        if (tileColor == colorToUse) {
            return;
        }
        if (tileColor != colorToReplace) {
            return;
        }
        map[x] [y] = colorToUse;
        floodfill(map, x, y - 1, colorToReplace, colorToUse); //floodfill tile to North
        floodfill(map, x - 1, y, colorToReplace, colorToUse); //floodfill tile to the West
        floodfill(map, x + 1, y, colorToReplace, colorToUse); //floodfill tile to the East
        floodfill(map, x, y + 1, colorToReplace, colorToUse); //floodfill tile to the South
    }
}
