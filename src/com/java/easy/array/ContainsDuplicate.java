package com.java.easy.array;

import java.util.HashMap;

public class ContainsDuplicate {
    public ContainsDuplicate(){}

    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int num: nums){
            if(hashMap.containsKey(num)){
                return true;

            }
            hashMap.put(num, 1);
        }

        return false;
    }
}
