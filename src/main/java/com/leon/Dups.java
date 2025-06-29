package com.leon;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dups {
    public static <T> Set<T> findDuplicates(Stream<T> stream) {
        Set<T> seen = new HashSet<>();
        return stream.filter(id -> !seen.add(id)) // add() returns false if already present
                .collect(Collectors.toSet()); // collect only the duplicates
    }

    public static void main(String[] args) {
        Stream<String> tradeIds = Stream.of("T1", "T2", "T3", "T2", "T4", "T1", "T5", "T1", "T5");
        Set<String> duplicates = findDuplicates(tradeIds);
        System.out.println("Duplicates: " + duplicates); // Output: [T1, T2]
    }
}
