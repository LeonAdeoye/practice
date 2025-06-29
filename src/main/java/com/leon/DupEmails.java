package com.leon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Given a list of users with emails, return a list of emails that appear more than once using a Map<String, Integer>.
public class DupEmails {
    public static void main(String... args)
    {
        Map<String, Integer> map = new HashMap<>();
        List<String> emails = Arrays.asList("leon@gmail.com", "saori@ghotmail.com", "hoartio@yahoo.co.uk", "leon@gmail.com");
        for(String email : emails)
            map.merge(email, 1, Integer::sum);
        map.forEach((key, value) -> System.out.println("email: " + key + " has count: " + value));
    }
}
