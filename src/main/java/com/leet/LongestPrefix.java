package com.leet;

import java.util.Arrays;

public class LongestPrefix {

    public static String longestCommonPrefix1(String[] strs)
    {
        int count = 0;
        boolean allMatch = true;

        int minLength = Arrays.stream(strs)
                .map(String::length)
                .min(Integer::compare)
                .orElse(0);

        for(int i = 0; i < minLength; i++)
        {
            char current = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++)
            {
                char currentChar = strs[j].charAt(i);
                if (currentChar != current)
                {
                    allMatch = false;
                    break;
                }
            }
            if(allMatch)
                count++;
            else
                break;
        }
        return strs[0].substring(0,count);
    }

    public static String longestCommonPrefix2(String[] strs) {
        int count = 0;
        boolean allMatch = true;

        int minLength = Arrays.stream(strs)
                .map(String::length)
                .min(Integer::compare)
                .orElse(0);

        for(int i = 0; i < minLength; i++)
        {
            String prefix = strs[0].substring(0, i + 1);
            for(int j = 1; j < strs.length; j++)
            {
                if(!strs[j].startsWith(prefix))
                    return strs[0].substring(0,count);
            }
            if(allMatch)
                count++;
        }
        return strs[0].substring(0,count);
    }

    public static String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != ch) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }

    public static void main(String... args)
    {
        String[] words = {"fred", "free", "freedom", "freight"};
        System.out.println(longestCommonPrefix3(words));
    }
}
