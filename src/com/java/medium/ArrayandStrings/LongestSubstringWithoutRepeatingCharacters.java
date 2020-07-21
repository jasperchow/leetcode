//Given a string, find the length of the longest substring without repeating characters.
//
//        Example 1:
//
//        Input: "abcabcbb"
//        Output: 3
//        Explanation: The answer is "abc", with the length of 3.
//        Example 2:
//
//        Input: "bbbbb"
//        Output: 1
//        Explanation: The answer is "b", with the length of 1.
//        Example 3:
//
//        Input: "pwwkew"
//        Output: 3
//        Explanation: The answer is "wke", with the length of 3.
//        Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
package com.java.medium.ArrayandStrings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public LongestSubstringWithoutRepeatingCharacters(){}

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int result = 0, i = 0, j = 0;
        while (i < s.length() && j < s.length()) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                result = Math.max(result, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return result;
    }

    public int lengthOfLongestSubstring_optimized(String s) {
        int result = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for(int i = 0, j = 0; j < s.length(); j++){
            if (hashMap.containsKey(s.charAt(j))){
                i = Math.max(hashMap.get(s.charAt(j)), i);
            }
            result = Math.max(result, j - i + 1);
            hashMap.put(s.charAt(j), j + 1);
        }

        return  result;
    }
}
