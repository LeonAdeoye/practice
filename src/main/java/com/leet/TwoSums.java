package com.leet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSums {
    public static void main(String... args)
    {
        int[] numbers = {2,11,15,7};
        int[] result = calculate(numbers, 9);
        Arrays.stream(result).forEach(System.out::println);
    }

    private static int[] calculate(int[] numbers, int target)
    {
        boolean found = false;
        int[] result = new int[2];
        for(int i = 0; i < numbers.length && !found; i++) {
            for(int j = i+1; j < numbers.length && !found; j++) {
                if (numbers[i] + numbers[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    found = true;
                }
            }
        }
        return result;
    }

    private static int[] calc(int[] numbers, int target)
    {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(numbers[i], i);
        }

        return new int[] {}; // Or throw exception if no solution found
    }

}



