//Given two strings s and t , write a function to determine if t is an anagram of s.
//
//        Example 1:
//
//        Input: s = "anagram", t = "nagaram"
//        Output: true
//        Example 2:
//
//        Input: s = "rat", t = "car"
//        Output: false
//        Note:
//        You may assume the string contains only lowercase alphabets.
//
//        Follow up:
//        What if the inputs contain unicode characters? How would you adapt your solution to such case?

package com.java.easy.strings;

import java.util.HashMap;

public class ValidAnagram {
    public ValidAnagram(){}

    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> hashMap = new HashMap<>();

        if(s.length() != t.length()){
            return false;
        }
        else {
            for (int i = 0; i < s.length(); i++){
                hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i), 0) + 1);
                hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i), 0) - 1);
            }

            for(char c: hashMap.keySet()){
                if(hashMap.get(c) != 0){
                    return false;
                }
            }

            return true;
        }
    }

}
