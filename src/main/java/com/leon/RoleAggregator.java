package com.leon;

// Given a list of (userId, role) pairs, build a Map<String, List<String>> mapping each user to their roles.

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RoleAggregator {
    private record User(String userId, String role) {}
    public static void main(String... args)
    {
        List<User> users = Arrays.asList(new User("Leon", "dad"), new User("Horatio", "son"), new User("Horatio", "brother"));
        Map<String, List<String>> userRoles = users.stream().collect(Collectors.groupingBy(User::userId, Collectors.mapping(User::role, Collectors.toList())));
        userRoles.forEach((key, val) -> System.out.println(key + ":  " + val));
    }
}
