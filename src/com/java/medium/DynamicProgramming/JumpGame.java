package com.java.medium.DynamicProgramming;//
//Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
//        Each element in the array represents your maximum jump length at that position.
//
//        Determine if you are able to reach the last index.
//
//
//
//        Example 1:
//
//        Input: nums = [2,3,1,1,4]
//        Output: true
//        Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
//        Example 2:
//
//        Input: nums = [3,2,1,0,4]
//        Output: false
//        Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
//
//
//        Constraints:
//
//        1 <= nums.length <= 3 * 10^4
//        0 <= nums[i][j] <= 10^5

enum Index{
    Good, Bad, Unknown
}

public class JumpGame {

    public JumpGame(){}

    public boolean canJump_dp(int[] nums) {
        Index[] table = new Index[nums.length];
        for(int i = 0; i < nums.length; i++){
            table[i] = Index.Unknown;
        }
        table[nums.length - 1] = Index.Good;

        for(int i = nums.length - 2; i >= 0; i--){
            int furthestJump = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j < furthestJump; j++){
                if (table[j] == Index.Good){
                    table[i] = Index.Good;
                    break;
                }
            }
        }

        return table[0] == Index.Good;
    }

    public boolean canJump_greedy(int[] nums) {
        int lastPos = nums.length - 1;
        for(int i = nums.length - 1; i >=0 ; i--){
            if(i + nums[i] >= lastPos){
                lastPos = i;
            }
        }

        return lastPos == 0;
    }
}