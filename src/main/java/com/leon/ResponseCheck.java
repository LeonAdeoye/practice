package com.leon;

import java.util.HashMap;
import java.util.Map;

// Given an array of survey answers (e.g. "Yes", "No", "Maybe"), count the frequency of each response.
public class ResponseCheck {
    public static void main(String[] args)
    {
        String[] responses = {"Yes", "No", "Maybe", "No", "Yes", "Yes"};
        Map<String, Integer> counts = new HashMap<>();
        Map<String, Integer> counts2 = new HashMap<>();

        for(int i = 0; i < responses.length; i++)
        {
            if(counts.containsKey(responses[i]))
            {
                int count = counts.get(responses[i]);
                counts.replace(responses[i], ++count);
            }
            else
                counts.put(responses[i], 1);
        }
        System.out.println(counts);

        for (String response : responses)
            counts2.merge(response, 1, Integer::sum);

        System.out.println(counts2);
    }
}
