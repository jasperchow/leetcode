//Given a non-empty array of integers, return the k most frequent elements.
//
//        Example 1:
//
//        Input: nums = [1,1,1,2,2,3], k = 2
//        Output: [1,2]
//        Example 2:
//
//        Input: nums = [1], k = 1
//        Output: [1]
//        Note:
//
//        You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
//        Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
//        It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
//        You can return the answer in any order.

package com.java;

import java.util.*;

class TopKFrequent {
    public List<String> topKFrequent_heap(int[] nums, int k) {

        if(k == nums.length){
            return nums;
        }

        Map<Integer, Integer> count = new HashMap();
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(
                (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                        w1.compareTo(w2) : count.get(w1) - count.get(w2) );

        for (int n: count.keySet()) {
            heap.add(n);
            if (heap.size() > k) heap.poll();
        }

        int[] top = new int[k];
        for(int i = k - 1; i >= 0; i--) {
            top[i] = heap.poll();
        }
        return top;
    }


    int[] unique;
    Map<Integer, Integer> count_quickselect;
    public List<String> topKFrequent_quickselect(int[] nums, int k){
        count_quickselect = new HashMap();
        for (int num: nums) {
            count_quickselect.put(num, count_quickselect.getOrDefault(num, 0) + 1);
        }

        int n = count_quickselect.size();
        unique = new int[n];
        int i = 0;
        for (int num : count_quickselect.keySet()){
            unique[i] = num;
            i += 1;
        }

        quickselect(0, n - 1, n - k);
        return Arrays.copyOfRange(unique, n - k, n);
    }

    private void quickselect(int left, int right, int k_smallest){
        if(left == right) return;

        Random random_num = new Random();
        int pivot_index = left + random_num.nextInt(right - left);

        pivot_index = partition(left, right, pivot_index);

        if(k_smallest == pivot_index){
            return;
        }
        else if(k_smallest < pivot_index){
            quickselect(left, pivot_index - 1, k_smallest);
        }
        else{
            quickselect(pivot_index + 1, right,k_smallest);
        }
    }

    private int partition(int left, int right, int pivor_index){
        int pivot_frequency = count_quickselect.get(unique[pivor_index]);

        swap(pivor_index, right);
        int store_index = left;

        for(int i = left; i<= right; i++){
            if(count_quickselect.get(unique[i]) < pivot_frequency){
                swap(store_index, i);
                store_index += 1;
            }
        }

        swap(store_index, right);
        return  store_index;
    }

    private void swap(int a, int b) {
        int tmp = unique[a];
        unique[a] = unique[b];
        unique[b] = tmp;
    }

}


