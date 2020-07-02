package com.java.easy.dynamicprogramming;

public class ClimbingStairs {

    public ClimbingStairs(){}

    public int climbStairs(int n) {
        if (n == 1){
            return 1;
        }
        else{
            int[] array = new int[n];
            array[1] = 2;
            array[0] = 1;
            for (int i = 2; i <= n-1; i++){
                array[i] = array[i-1] + array[i-2];
            }
            return array[n-1];
        }
    }

}
