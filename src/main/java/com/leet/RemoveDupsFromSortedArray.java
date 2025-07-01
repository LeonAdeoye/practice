package com.leet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDupsFromSortedArray {
    public static void main(String... args)
    {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        //int[] nums = {1,1,2};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums)
    {
        Set<Integer> set = new HashSet<>();
        int j = 0;
        for(int i = 0; i < nums.length; i++)
        {
            int value = nums[i];
            if(!set.contains(value))
            {
                set.add(value);
                nums[j++] = value;
            }
        }
        System.out.println(Arrays.toString(nums));
        return set.size();
    }
}
