//Given a sorted integer array nums, where the range of elements are in the inclusive range [lower, upper], return its missing ranges.
//
//        Example:
//
//        Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
//        Output: ["2", "4->49", "51->74", "76->99"]

package com.java.medium;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
    public MissingRanges(){}

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        long next = lower;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] < next){
                continue;
            }

            if(nums[i] == next){
                next++;
                continue;
            }

            result.add(getRange(next, (long) nums[i] - 1));

            next = ((long) nums[i] + 1);
        }

        if (next <= upper) {
            result.add(getRange(next, (long) upper));
        }

        return result;
    }

    private String getRange(long down, long up) {
        return up == down ? String.valueOf(up) : String.format("%d->%d", down, up);
    }
}
