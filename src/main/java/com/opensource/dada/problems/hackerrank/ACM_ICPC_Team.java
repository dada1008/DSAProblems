package com.opensource.dada.problems.hackerrank;

import java.util.Arrays;

public class ACM_ICPC_Team {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    static void test1() {
        String[] topic = {"10101", "11100", "11010", "00101"};
        System.out.println("Result:"+ Arrays.toString(acmTeam(topic)));// 5 2
    }
    static void test2() {
        String[] topic = {"10101", "11110", "00010"};
        System.out.println("Result:"+ Arrays.toString(acmTeam(topic)));// 5 1
    }
    static void test3() {

    }
    static int[] acmTeam(String[] topic) {
        int maxTopics=0, maxTeams=0;
        for (int i=0; i< topic.length; i++) {
            char[] chars1 = topic[i].toCharArray();
            for (int j=i+1; j< topic.length; j++) {
                char[] chars2 = topic[j].toCharArray();
                int topics = countTopics(chars1, chars2);
                if(topics>maxTopics) {
                    maxTopics = topics;
                    maxTeams = 1;
                } else if(topics == maxTopics) {
                    maxTeams++;
                }
            }
        }

        return new int[]{maxTopics, maxTeams};
    }

    static int countTopics(char[] chars1, char[] chars2) {
        int topics = 0;
        for (int i=0; i< chars1.length; i++) {
            if (chars1[i]=='1' || chars2[i]=='1') {
                topics++;
            }
        }
        return topics;
    }
}
