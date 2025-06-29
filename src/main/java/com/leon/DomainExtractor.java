package com.leon;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


// Given an array of email addresses, extract and return a list of unique domains.

public class DomainExtractor
{
    public static void main(String args[])
    {
        Set<String> uniqueDomain1 = new HashSet<>();
        Set<String> uniqueDomain2 = new HashSet<>();

        String[] emails = {"leon.adeoye@gmail.com", "ysaori@hotmail.com", "horatio@gmail.com", "mike@hotmail.com", "harper@yahoo.co.uk"};
        for(int i = 0; i < emails.length; i++)
        {
            int startOfDomain = emails[i].indexOf("@") + 1;
            if(startOfDomain  != -1)
                uniqueDomain1.add(emails[i].substring(startOfDomain));
        }

        for (String email : emails) {
            String[] parts = email.split("@");
            if (parts.length == 2) {
                uniqueDomain2.add(parts[1]);
            }
        }

        Set<String> uniqueDomain3 = Stream.of("leon.adeoye@gmail.com", "ysaori@hotmail.com", "horatio@gmail.com", "mike@hotmail.com", "harper@yahoo.co.uk")
                .map(e -> e.split("@"))
                .filter(parts -> parts.length == 2)
                .map(parts -> parts[1])
                .collect(Collectors.toSet());

        System.out.println(uniqueDomain1);
        System.out.println(uniqueDomain2);
        System.out.println(uniqueDomain3);

    }
}
