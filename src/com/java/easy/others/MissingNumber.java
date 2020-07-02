package com.java.easy.others;

import java.util.HashSet;

public class MissingNumber {
    public MissingNumber(){}

    public int missingNumber(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for(int num : nums){
            hashSet.add(num);
        }

        for(int i =0; i <= nums.length; i++){
            if(!hashSet.contains(i)){
                return i;
            }
        }

        return -1;
    }
}
