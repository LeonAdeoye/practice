package com.leon;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Given a list of articles with tags, build a Map<String, List<Article>> mapping each tag to the articles it appears in.
public class Articles {
    private record Article(String name, String tag) {};
    public static void main(String... args)
    {
        List<Article> articles = Arrays.asList(new Article("Rubik cube", "toys"), new Article("Bike", "toys"), new Article("Air rifle", "guns"));
        Map<String, List<Article>> map = articles.stream().collect(Collectors.groupingBy(Article::tag));
        map.forEach((key, value) -> System.out.println("tag: " + key + " has articles: " + value));

    }
}
