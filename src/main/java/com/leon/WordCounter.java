package com.leon;

import java.util.HashMap;
import java.util.Map;

public class WordCounter
{
    // Given a paragraph, return a Map<String, Integer> of word frequencies, ignoring case and punctuation.
    public static void main(String... args)
    {
        Map<String, Integer> counts = new HashMap<>();
        String paragraph = "The beginning of the end is not end of the beginning.";
        String[] words = paragraph.replaceAll("[^a-zA-Z ]", "").split("\\s+");

        for(String word : words)
            counts.merge(word.toLowerCase(), 1, Integer::sum);

        System.out.println(counts);
    }
}
