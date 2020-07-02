package com.java.easy.others;

public class NumberOfOneBits {
    public NumberOfOneBits(){

    }

    // n & (n-1) flips the least significant 1-bit
    public int hammingWeight_smart(int n) {
        int sum = 0;

        while(n != 0){
            sum += 1;
            n = n & (n-1);
        }

        return sum;
    }

    public int hammingWeight(int n) {
        int sum = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++){
            if((n & mask) != 0){
                sum += 1;
            }

            mask <<= 1;
        }

        return sum;
    }
}
