//Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
//
//        Example:
//
//        Input: [-2,1,-3,4,-1,2,1,-5,4],
//        Output: 6
//        Explanation: [4,-1,2,1] has the largest sum = 6.
//        Follow up:
//
//        If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

package com.java.easy.dynamicprogramming;

import static java.lang.Math.max;

public class MaximumSubarray {

    public MaximumSubarray(){}

    public int maxSubArray_dp_1(int[] nums) {
        int currentMax = nums[0];
        for(int i = 1; i <= nums.length; i++){
            if(nums[i - 1] > 0){
                nums[i] = nums[i -1] + nums[i];
            }
            currentMax = max(currentMax, nums[i]);
        }
        return currentMax;
    }

    public int maxSubArray_dp_2(int[] nums) {
        int max = Integer.MIN_VALUE, sum = 0;
        for (int n : nums) {
            sum += n;
            max = Math.max(sum, max);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }

}
