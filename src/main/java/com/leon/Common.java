package com.leon;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


// Top N Words by Frequency
// Given a long List<String> of words and an integer N, return the top N most frequent words as a List<String>.
// You’ll need grouping, sorting, and limiting.

public class Common {
    public static void main(String... args) {
        int n = 2;
        List<String> words = Arrays.asList("the", "end", "bye", "the", "the", "bye");

        // Count frequency
        Map<String, Long> frequencyMap = words.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        // Get top N words sorted by frequency (descending)
        List<String> topNWords = frequencyMap.entrySet().stream()
                .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                .limit(n)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("Top " + n + " words: " + topNWords);
    }
}

