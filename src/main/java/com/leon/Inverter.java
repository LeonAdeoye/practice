package com.leon;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

// Given a Map<String, List<String>> where keys are topics and values are people interested in them,
// invert the map into a Map<String, List<String>> where the key is a person and the value is topics they're interested in.
public class Inverter {
    public static void main(String... args)
    {
        Map<String, List<String>> map = new HashMap<>();
        map.put("fruit", Arrays.asList("horatio", "harper"));
        map.put("vegetables", Arrays.asList("saori", "leon"));

        Map<String, List<String>> inverted = map.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream()
                        .map(person -> new AbstractMap.SimpleEntry<>(person, entry.getKey())))
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue, Collectors.toList())
                ));

        System.out.println(inverted);

    }
}
