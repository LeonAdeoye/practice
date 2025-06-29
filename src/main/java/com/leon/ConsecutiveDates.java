package com.leon;

import java.time.LocalDate;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class ConsecutiveDates {
    private static void main(String... args)
    {
        record User(String userId, LocalDate loginDate) {};
        List<User> users = Arrays.asList(new User("harper", LocalDate.now()), new User("horatio", LocalDate.now()), new User("Horatio", LocalDate.now().plusDays(1)));

        users.sort(Comparator
                .comparing(User::userId, String.CASE_INSENSITIVE_ORDER)
                .thenComparing(User::loginDate));

        Map<String, List<LocalDate>> map = users.stream()
                .collect(Collectors.groupingBy(
                        User::userId,
                        Collectors.mapping(User::loginDate, Collectors.toList())
                ));
    }
}
