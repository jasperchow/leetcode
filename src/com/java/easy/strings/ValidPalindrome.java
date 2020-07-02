//Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
//
//        Note: For the purpose of this problem, we define empty string as valid palindrome.
//
//        Example 1:
//
//        Input: "A man, a plan, a canal: Panama"
//        Output: true
//        Example 2:
//
//        Input: "race a car"
//        Output: false

package com.java.easy.strings;

public class ValidPalindrome {

    public ValidPalindrome(){

    }


    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right){
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left += 1;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right -= 1;
            }

            if (left < right && Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }

            left += 1;
            right -= 1;
        }
        return true;
    }


}
