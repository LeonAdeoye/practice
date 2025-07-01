package com.leet;

import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid2(String s)
    {
        String[] brackets = {"()", "[]", "{}"};

        while(s.length() != 0)
        {
            boolean found = false;
            for(int i = 0; i < brackets.length; i++)
            {
                int index = s.indexOf(brackets[i]);
                if(index != -1)
                {
                    s = s.substring(0, index) + s.substring(index + 2);
                    found = true;
                }

                if(i == brackets.length-1 && found == false)
                {
                    return false;
                }
            }
        }

        return s.isEmpty();
    }

    public static boolean isValid(String s)
    {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray())
        {
            if(c == '{' || c == '[' || c == '(')
                stack.push(c);
            else
            {
                if(!stack.isEmpty())
                {
                    char t = stack.pop();
                    if((c == ']' && t != '[') || (c == ')' && t != '(') || (c == '}' && t != '{'))
                        return false;
                }
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String... args)
    {
        System.out.println(isValid("[()]"));
        System.out.println(isValid("[(]"));
        System.out.println(isValid("()]"));
        System.out.println(isValid("[([])]{}"));
        System.out.println(isValid("[][([])]{}"));
        System.out.println(isValid("[{"));
        System.out.println(isValid("}{"));
        System.out.println(isValid("}"));
    }
}
