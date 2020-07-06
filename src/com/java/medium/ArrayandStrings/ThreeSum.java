//Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
//
//        Note:
//
//        The solution set must not contain duplicate triplets.
//
//        Example:
//
//        Given array nums = [-1, 0, 1, 2, -1, -4],
//
//        A solution set is:
//        [
//        [-1, 0, 1],
//        [-1, -1, 2]
//        ]

package com.java.medium;

import javafx.util.Pair;

import java.util.*;

public class ThreeSum {
    public ThreeSum(){}

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Pair> found = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            Set<Integer> seen = new HashSet<>();
            for(int j = i + 1; j < nums.length; j++){
                int complement = -nums[i] - nums[j];

                if (seen.contains(complement)){
                    int smaller = Math.min(nums[i], Math.min(complement, nums[j]));
                    int larger = Math.max(nums[i], Math.max(complement, nums[j]));
                    if (found.add(new Pair(smaller, larger))) {
                        result.add(Arrays.asList(nums[i], complement, nums[j]));
                    }
                }

                seen.add(nums[j]);
            }
        }
        return result;
    }
}
