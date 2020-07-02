package com.java.easy.array;

import java.util.HashMap;

public class SingleNumber {
    public SingleNumber(){}

    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int num : nums){
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            if (hashMap.get(num) == 1) {
                return num;
            }
        }
        return 0;
    }
}
