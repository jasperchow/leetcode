package com.java.easy.array;
class RemoveDuplicatesfromSortedArray {

    public RemoveDuplicatesfromSortedArray(){};

    public int removeDuplicates(int[] nums) {
        int i = 0;
        if (nums.length == 0){
            return 0;
        }
        else {
            for (int j = 1; j < nums.length; j++) {
                if (nums[i] != nums[j]) {
                    i ++;
                    nums[i] = nums[j];
                }
            }
        }
        return i + 1;
    }
}
