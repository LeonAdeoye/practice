package com.leon;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.List;
import java.util.ArrayList;

public class TagExtractor {
    public static List<String> extractTagFromList(List<String> xmlList, String tagName) {
        List<String> tagValues = new ArrayList<>();
        String regex = String.format("<%s>(.*?)</%s>", tagName, tagName);
        Pattern pattern = Pattern.compile(regex);

        for (String xml : xmlList)
        {
            Matcher matcher = pattern.matcher(xml);
            tagValues.add(matcher.find() ? matcher.group(1) : null);
        }
        return tagValues;
    }

    public static List<String> extractTagFromString(String xml, String tagName) {
        List<String> tagValues = new ArrayList<>();
        String regex = String.format("<%s>(.*?)</%s>", tagName, tagName);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(xml);

        while (matcher.find()) {
            tagValues.add(matcher.group(1));
        }

        return tagValues;
    }


    public static void main(String[] args) {
        List<String> xmls = List.of(
                "<StrategyName>Alpha</StrategyName>",
                "<StrategyName>Beta</StrategyName>",
                "<StrategyName>Gamma</StrategyName>"
        );
        System.out.println(extractTagFromList(xmls, "StrategyName"));

        String xml =  "<StrategyName>Alpha</StrategyName><StrategyName>Beta</StrategyName><StrategyName>Gamma</StrategyName>";
        System.out.println(extractTagFromString(xml, "StrategyName"));
    }
}
