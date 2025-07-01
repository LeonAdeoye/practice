package com.leet;

import java.util.HashMap;
import java.util.Map;

public class Roman {
    public static int romanToInt(String s) {
        Map<Character, Integer> values = new HashMap<>();
        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);

        int total = 0, prev = 0;
        for(int i = s.length() - 1; i >= 0; i--)
        {
            int current = values.get(s.charAt(i));
            if(current < prev)
            {
                total -= current;
            }
            else
            {
                total += current;
                prev = current;
            }
        }

        return total;
    }

    // Example usage
    public static void main(String[] args) {
        String roman = "MCMXCIV";
        System.out.println("Integer value: " + romanToInt(roman)); // Output: 1994
    }
}
