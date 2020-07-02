//
//Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
//
//        Note:
//
//        The number of elements initialized in nums1 and nums2 are m and n respectively.
//        You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
//        Example:
//
//        Input:
//        nums1 = [1,2,3,0,0,0], m = 3
//        nums2 = [2,5,6],       n = 3
//
//        Output: [1,2,2,3,5,6]
package com.java.easy.sortingandsearching;

public class MergeSortedArray {
    public MergeSortedArray(){}

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // two get pointers for nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;
        // set pointer for nums1
        int p = nums1.length - 1;
        while (p > -1) {
            int cand1 = p1 > -1 ? nums1[p1] : Integer.MIN_VALUE;
            int cand2 = p2 > -1 ? nums2[p2] : Integer.MIN_VALUE;
            if (cand1 > cand2) {
                nums1[p] = cand1;
                p1--;
            } else {
                nums1[p] = cand2;
                p2--;
            }
            p--;
        }
    }
}
