package com.leon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrList
{
    public static void main(String[] args)
    {
        List<String> friends = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie", "Diana", "Eve"));
        friends.size();
        friends.add("Frank");
        friends.remove("Charlie");
        friends.set(1, "Bob Jr.");
        System.out.println("Get the first friend: " + friends.get(0));
        System.out.println("Friends list: " + friends);
        friends.forEach(friend ->
            System.out.println("Friend: " + friend)
        );
    }
}
