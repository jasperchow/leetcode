//Given a 32-bit signed integer, reverse digits of an integer.
//
//        Example 1:
//
//        Input: 123
//        Output: 321
//        Example 2:
//
//        Input: -123
//        Output: -321
//        Example 3:
//
//        Input: 120
//        Output: 21

package com.java.easy.strings;

public class ReverseInteger {
    public ReverseInteger(){}

    public int reverse(int x) {
        int result = 0;
        while (x != 0){
            int pop = x % 10;
            x = x / 10;
            if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            result = result * 10 + pop;
        }

        return result;
    }
}
