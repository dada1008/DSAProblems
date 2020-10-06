package com.opensource.dada.problems;

import java.util.ArrayList;
import java.util.List;

public class UnderscorifySubString {
    public static void main(String[] args) {
        String str = "testthis is a testtest to see if testestest it works";
        String subStr = "test";
        //Result: _test_this is a _testtest_ to see if _testestest_ it works
        System.out.println("Result:"+underscorifySubString(str, subStr));
    }

    //Complexity time:O(n+m), space: O(n)
    static String underscorifySubString(String str, String subStr) {
        List<int[]> locations = getLocations(str, subStr);
        locations =collapse(locations);
        String modifiedStr = underscorify(str, locations);
        return modifiedStr;
    }

    private static List<int[]> getLocations(String str, String subStr) {
        List<int[]> locations = new ArrayList<>();
        int startIndex = 0;
        while (startIndex < str.length()) {
            int nextIndex = str.indexOf(subStr, startIndex);
            if (nextIndex!= -1) {
                locations.add(new int[]{nextIndex, nextIndex + subStr.length()});
                startIndex = nextIndex + 1;
            } else {
                break;
            }
        }
        return locations;
    }

    private static List<int[]> collapse(List<int[]> locations) {
        if (locations==null || locations.isEmpty()) {
            return locations;
        }
        List<int[]> newLocations = new ArrayList<>();
        newLocations.add(locations.get(0));
        int[] previous = newLocations.get(0);
        for (int i = 1; i < locations.size(); i++) {
            int[] current = locations.get(i);
            if (current[0] <= previous[1]) {
                previous[1] = current[1];
            } else {
                newLocations.add(current);
                previous = current;
            }
        }
        return newLocations;
    }
    private static String underscorify(String str, List<int[]> locations) {
        int locationsIndex = 0;
        int strIndex = 0;
        boolean inBetweenUnderscores = false;
        StringBuilder finalChars = new StringBuilder();
        int i = 0;
        while (strIndex < str.length() && locationsIndex < locations.size()) {
            if (strIndex==locations.get(locationsIndex)[i]) {
                finalChars.append('_');
                inBetweenUnderscores = !inBetweenUnderscores;
                if (!inBetweenUnderscores) {
                    locationsIndex++;
                }
                i = i == 1 ? 0 : 1;
            }
            finalChars.append(str.charAt(strIndex));
            strIndex++;
        }
        if (locationsIndex < locations.size()) {
            finalChars.append('_');
        } else if (strIndex < str.length()) {
            finalChars.append(str.substring(strIndex));
        }
        return finalChars.toString();
    }
}
