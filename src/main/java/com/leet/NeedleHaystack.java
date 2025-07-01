package com.leet;

public class NeedleHaystack {
    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad"));
    }
    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
