//Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//        An input string is valid if:
//
//        Open brackets must be closed by the same type of brackets.
//        Open brackets must be closed in the correct order.
//        Note that an empty string is also considered valid.

package com.java.easy.others;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public ValidParentheses(){}

    public boolean isValid(String s) {
        HashMap<Character, Character> hashMap = new HashMap<Character, Character>(){
            {
                put('(', ')');
                put('{', '}');
                put('[',']');
            }
        };
        Stack<Character> parenthesis = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hashMap.containsKey(c)) {
                parenthesis.push(hashMap.get(c));
            } else if (hashMap.containsValue(c)) {
                if (parenthesis.isEmpty() || parenthesis.pop() != c) {
                    return false;
                }
            }
        }
        return parenthesis.isEmpty();
    }

}
