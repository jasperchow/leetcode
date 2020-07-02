package com.java;

import java.util.List;

class Main {
    public static void main(String[] args) {
        // write your code here
        TopKFrequent solution = new TopKFrequent();
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        List<String> ans = solution.topKFrequent( words,2);
        System.out.print(ans);
    }
}
