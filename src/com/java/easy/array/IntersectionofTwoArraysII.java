//Given two arrays, write a function to compute their intersection.
//
//        Example 1:
//
//        Input: nums1 = [1,2,2,1], nums2 = [2,2]
//        Output: [2,2]
//        Example 2:
//
//        Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//        Output: [4,9]

package com.java.easy.array;

import java.util.Arrays;
import java.util.HashMap;

public class IntersectionofTwoArraysII {
    public IntersectionofTwoArraysII(){}

    public int[] intersect(int[] nums1, int[] nums2) {

        if(nums1.length > nums2.length){
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int number: nums1){
            map.put(number, map.getOrDefault(number, 0 ) + 1);
        }
        int k = 0;
        for (int number: nums2){
            if(map.getOrDefault(number, 0) != 0){
                nums1[k++] = number;
                map.put(number, map.getOrDefault(number, 0) - 1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}
