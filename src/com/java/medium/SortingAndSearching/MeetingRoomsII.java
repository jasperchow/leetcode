//Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
//
//        Example 1:
//
//        Input: [[0, 30],[5, 10],[15, 20]]
//        Output: 2
//        Example 2:
//
//        Input: [[7,10],[2,4]]
//        Output: 1
//        NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.


package com.java.medium.SortingAndSearching;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public MeetingRoomsII(){

    }

    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(final int[] o1, final int[] o2) {
                return o1[0] - o2[0];
            }
        });

        PriorityQueue<Integer> allocator = new PriorityQueue<>(intervals.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        allocator.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++){
            if(intervals[i][0] >= allocator.peek()){
                allocator.poll();
            }

            allocator.add(intervals[i][1]);
        }

        return allocator.size();
    }
}
