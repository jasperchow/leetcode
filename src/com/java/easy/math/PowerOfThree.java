//Given an integer, write a function to determine if it is a power of three.
//
//        Example 1:
//
//        Input: 27
//        Output: true
//        Example 2:
//
//        Input: 0
//        Output: false
//        Example 3:
//
//        Input: 9
//        Output: true
//        Example 4:
//
//        Input: 45
//        Output: false
//        Follow up:
//        Could you do it without using any loop / recursion?

package com.java.easy.math;

public class PowerOfThree {
    public PowerOfThree(){}

    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }


    public boolean isPowerOfThree_V2(int n) {

        //1162261467 = 3 ^ 19
        return n > 0 && 1162261467 % n == 0;
    }
}
