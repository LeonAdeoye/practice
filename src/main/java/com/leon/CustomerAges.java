package com.leon;

import java.util.HashMap;
import java.util.Map;

// Given an array of customer ages, group them into brackets (e.g. 18–25, 26–35, etc.) and count how many fall into each.
public class CustomerAges {
    private int[] ages = {18, 18, 45, 23, 19, 48, 69, 72, 18, 24, 52, 42, 38, 36, 19, 20, 29};
    private Map<String, Integer> ageRanges = new HashMap<>();

    public void setup()
    {
        for(int age : ages)
        {
            if (!determineRange(age, 16, 25) &&
                !determineRange(age, 26, 35) &&
                !determineRange(age, 36, 45) &&
                !determineRange(age, 46, 55) &&
                !determineRange(age, 56, 65) &&
                !determineRange(age, 66, 75))
            {
                ageRanges.merge("Other", 1, Integer::sum);
            }
        }
        System.out.print(ageRanges);
    }

    private boolean determineRange(int age, int start, int end)
    {
        if(age >= start && age <= end)
        {
            String key = String.format("%d-%d", start, end);
            ageRanges.merge(key, 1, Integer::sum);
            return true;
        }
        return false;
    }

    public static void main(String... args)
    {
        CustomerAges customerAges = new CustomerAges();
        customerAges.setup();
    }
}
