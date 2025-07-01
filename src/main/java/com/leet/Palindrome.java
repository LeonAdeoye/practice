package com.leet;

import java.util.Stack;

public class Palindrome {
    public static boolean isPalindrome(int x)
    {
        String str = Integer.toString(x);
        int left = 0, right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static boolean isPalindromeNumber(int x) {
        if (x < 0) return false;

        String str = Integer.toString(x);
        Stack<Character> stack = new Stack<>();

        // Push all characters onto the stack
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        // Compare characters popped from stack with the original string
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int number = 1542451;
        System.out.println(number + " is palindrome? " + isPalindrome(number));
    }
}
