//Write a function to find the longest common prefix string amongst an array of strings.
//
//        If there is no common prefix, return an empty string "".
//
//        Example 1:
//
//        Input: ["flower","flow","flight"]
//        Output: "fl"
//        Example 2:
//
//        Input: ["dog","racecar","car"]
//        Output: ""
//        Explanation: There is no common prefix among the input strings.
//        Note:
//
//        All given inputs are in lowercase letters a-z.

package com.java.easy.strings;

public class LongestCommonPrefix {
    public LongestCommonPrefix(){}

    public String longestCommonPrefixVerticalScan(String[] strs) {

        if (strs.length == 0){
            return "";
        }
        else {
            String prefix = strs[0];
            for (int i = 0; i < strs[0].length(); i++) {
                char c = strs[0].charAt(i);
                for (int j = 1; j < strs.length; j++) {
                    if (i == strs[j].length() || c != strs[j].charAt(i)) {
                        return prefix.substring(0, i);
                    }
                }
            }
            return prefix;
        }
    }

    public String longestCommonPrefixDivideAndConquer(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        else{
            return longestCommonPrefixDivideAndConquer(strs, 0 , strs.length - 1);
        }
    }

    private String longestCommonPrefixDivideAndConquer(String[] strs, int l, int r){
        if (l == r) {
            return strs[l];
        }
        else {
            int mid = (l + r)/2;
            String lcpLeft =   longestCommonPrefixDivideAndConquer(strs, l , mid);
            String lcpRight =  longestCommonPrefixDivideAndConquer(strs, mid + 1,r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    private String commonPrefix(String left,String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if ( left.charAt(i) != right.charAt(i) )
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }
}
