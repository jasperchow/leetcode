//Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
//
//        Example 1:
//
//        Input: [3,2,1,5,6,4] and k = 2
//        Output: 5
//        Example 2:
//
//        Input: [3,2,3,1,2,4,5,5,6] and k = 4
//        Output: 4
//        Note:
//        You may assume k is always valid, 1 ≤ k ≤ array's length.
package com.java.medium.SortingAndSearching;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class KthLargestElementInAnArray {
    public KthLargestElementInAnArray(){}

    public int findKthLargest_heap(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(n -> n));

        for (int num : nums){
            heap.add(num);
            if(heap.size() > k) {
                heap.poll();
            }
        }
        return heap.poll();
    }

//    1. 先建出一个map(数字： 对应出现的次数)
//    2. 随意选出一个数字， 放在对应正确的位置， 左边比他小， 右边大于或等于其出现次数（左右两边都不一定要sorted）
//    3. 小了就往右边找， 大了就往左边找， 重复以上步骤
    int [] nums;

    public void swap(int a, int b) {
        int tmp = this.nums[a];
        this.nums[a] = this.nums[b];
        this.nums[b] = tmp;
    }


    public int partition(int left, int right, int pivot_index) {
        int pivot = this.nums[pivot_index];
        // 1. move pivot to end
        swap(pivot_index, right);
        int store_index = left;

        // 2. move all smaller elements to the left
        for (int i = left; i <= right; i++) {
            if (this.nums[i] < pivot) {
                swap(store_index, i);
                store_index++;
            }
        }

        // 3. move pivot to its final place
        swap(store_index, right);

        return store_index;
    }

    public int quickselect(int left, int right, int k_smallest) {
    /*
    Returns the k-th smallest element of list within left..right.
    */

        if (left == right) // If the list contains only one element,
            return this.nums[left];  // return that element

        // select a random pivot_index
        Random random_num = new Random();
        int pivot_index = left + random_num.nextInt(right - left);

        pivot_index = partition(left, right, pivot_index);

        // the pivot is on (N - k)th smallest position
        if (k_smallest == pivot_index)
            return this.nums[k_smallest];
            // go left side
        else if (k_smallest < pivot_index)
            return quickselect(left, pivot_index - 1, k_smallest);
        // go right side
        return quickselect(pivot_index + 1, right, k_smallest);
    }

    public int findKthLargest_selection(int[] nums, int k) {
        this.nums = nums;
        int size = nums.length;
        // kth largest is (N - k)th smallest
        return quickselect(0, size - 1, size - k);
    }
}
