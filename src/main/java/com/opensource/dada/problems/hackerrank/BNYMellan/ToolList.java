package com.opensource.dada.problems.hackerrank.BNYMellan;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class ToolList {

    public static void main(String[] args) {
        List<String> list2 = Arrays.asList("ballendmill", "facemill", "keywaycutter", "slotdrill");
        System.out.println("1. "+toolchanger(list2,1,"slotdrill"));//2

        List<String> list1 = Arrays.asList("facemill", "slotdrill", "ballendmill", "ballendmill");
        System.out.println("2. "+toolchanger(list1,0,"ballendmill"));//1
    }
    public static int toolchanger(List<String> tools, int k, String q) {
        // Write your code here
        int size = tools.size();
        int forwardCount = 0;
        boolean forwardFound = false;
        for (int i=k+1;i<size; i++) {
            forwardCount++;
            String tool = tools.get(i);
            if (tool.equals(q)) {
                forwardFound = true;
                break;
            }
        }
        if (!forwardFound) {
            for (int i=0;i<k; i++) {
                forwardCount++;
                String tool = tools.get(i);
                if (tool.equals(q)) {
                    forwardFound = true;
                    break;
                }
            }
        }

        int backwardCount = 0;
        boolean backwardFound = false;
        for (int i=k-1;i>=0; i--) {
            backwardCount++;
            String tool = tools.get(i);
            if (tool.equals(q)) {
                backwardFound = true;
                break;
            }
        }
        if (!backwardFound) {
            for (int i=size-1;i>k; i--) {
                backwardCount++;
                String tool = tools.get(i);
                if (tool.equals(q)) {
                    backwardFound = true;
                    break;
                }
            }
        }
        System.out.println("forwardCount:"+forwardCount+" backwardCount:"+backwardCount);
        return Math.min(forwardCount, backwardCount);
    }
}
