//Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//
//        You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//        Example:
//
//        Given nums = [2, 7, 11, 15], target = 9,
//
//        Because nums[0] + nums[1] = 2 + 7 = 9,
//        return [0, 1].

package com.java.easy.array;

import java.util.HashMap;

public class TwoSum {

    public TwoSum(){}

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap();
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(hashMap.containsKey(complement)){
                return new int[]{i, hashMap.get(complement)};
            }
            hashMap.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
