package com.leon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Given a list of log entries, count how many times each log level (INFO, WARN, ERROR) appears.
public class LogCounter {
    public static void main(String... args)
    {
        Map<String, Integer> map = new HashMap<>();
        List<String> logs = Arrays.asList("INFO leon@gmail.com", "WARN saori@ghotmail.com", "DEBUG horatio@yahoo.co.uk", "WARN leon@gmail.com");

        List<String> levels = Arrays.asList("INFO", "WARN", "ERROR");

        for (String log : logs) {
            for (String level : levels) {
                if (log.contains(level)) {
                    map.merge(level, 1, Integer::sum);
                }
            }
        }

        map.forEach((key, value) -> System.out.println("Log level: " + key + " appears: " + value + " times."));

    }
}
