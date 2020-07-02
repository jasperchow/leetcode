//// Init an array with set 1, 2, and 3.
//int[] nums = {1,2,3};
//        Solution solution = new Solution(nums);
//
//// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
//        solution.shuffle();
//
//// Resets the array back to its original configuration [1,2,3].
//        solution.reset();
//
//// Returns the random shuffling of array [1,2,3].
//        solution.shuffle();

package com.java.easy.design;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShuffleAnArray {

    private final int[] original;
    private int[] result;

    public ShuffleAnArray(int[] nums){
        this.result = nums;
        this.original = nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        result = original.clone();
        return result;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        List<Integer> aux = getArrayCopy();
        Random rand = new Random();
        for (int i = 0; i < this.result.length; i++) {
            int ranIndex = rand.nextInt(aux.size());
            result[i] = aux.get(ranIndex);
            aux.remove(ranIndex);
        }

        return result;
    }

    private List<Integer> getArrayCopy() {
        List<Integer> lst = new ArrayList<>();
        for (int value : this.original) {
            lst.add(value);
        }
        return lst;
    }
}
