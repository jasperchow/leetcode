package com.java.easy.sortingandsearching;

public class FirstBadVersion {
    public FirstBadVersion(){}

    public int firstBadVersion(int n) {
        int left = 0;
        int right = n - 1;
        while (left < right){
            int middle = left + (right - left) / 2;
            if (isBadVersion(middle)) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }
}
