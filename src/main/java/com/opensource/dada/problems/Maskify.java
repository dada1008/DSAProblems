package com.opensource.dada.problems;

public class Maskify {
    public static String maskify(String str) {
        if(str==null || str.length()<4) {
            return str;
        }
        char[] chars = str.toCharArray();
        for (int i=0; i<chars.length-4;i++) {
            chars[i]='#';
        }
        return new String(chars);
    }
}
