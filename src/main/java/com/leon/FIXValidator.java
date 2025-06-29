package com.leon;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

// FIX Message Field Validator
// Parse a list of FIX fields and validate required tags based on message type. Return missing or malformed fields.

public class FIXValidator
{
    private static Map<Integer, String> messageMap = new HashMap<>() {{
        put(8, "String");
        put(35, "Char");
        put(44, "Double");
        put(38, "Integer");
        put(60, "LocalDateTime");
        put(55, "String");
        put(11, "String");
        put(54, "Integer");
    }};

    public static void main(String[] args)
    {
        String message = "8=FIX.4.2|35=D|55=0001.HK|54=GG|38=100";
        String result = parse(message);
        if (result.isEmpty()) {
            System.out.println("All fields are valid!");
        } else {
            System.out.println(result);
        }
    }

    private static boolean isValid(String tagType, String tagValue)
    {
        try
        {
            switch(tagType)
            {
                case "String":
                    return true;
                case "Integer":
                    Integer.parseInt(tagValue);
                    return true;
                case "Double":
                    Double.parseDouble(tagValue);
                    return true;
                case "LocalDateTime":
                    LocalDateTime.parse(tagValue);
                    return true;
                case "Char":
                    return tagValue.length() == 1;
                default:
                    return false;
            }
        }
        catch(Exception exception)
        {
            return false;
        }
    }

    private static String parse(String message)
    {
        Map<Integer, String> tagMap = new HashMap<>();
        Stream.of(message.split("\\|")).forEach(pair -> {
            String parts[] = pair.split("=");
            if(parts.length == 2)
                tagMap.put(Integer.parseInt(parts[0]), parts[1]);
        });
        StringBuilder result = new StringBuilder();
        for(Map.Entry<Integer, String> messageMapEntry : messageMap.entrySet())
        {
            if(!tagMap.containsKey(messageMapEntry.getKey()))
            {
                result.append("Tag: " + messageMapEntry.getKey() + " not found in message\n");
            }
            else
            {
                if(!isValid(messageMapEntry.getValue(), tagMap.get(messageMapEntry.getKey())))
                {
                    result.append(messageMapEntry.getKey() + " value type incorrect. Type should be: " + messageMapEntry.getValue() + "\n");
                }
            }
        }
        return result.toString();
    }
}
