//The count-and-say sequence is the sequence of integers with the first five terms as following:
//
//        1.     1
//        2.     11
//        3.     21
//        4.     1211
//        5.     111221
//        1 is read off as "one 1" or 11.
//        11 is read off as "two 1s" or 21.
//        21 is read off as "one 2, then one 1" or 1211.
//
//        Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence. You can do so recursively, in other words from the previous member read off the digits, counting the number of digits in groups of the same digit.
//
//        Note: Each term of the sequence of integers will be represented as a string.

package com.java.easy.strings;

import java.util.LinkedList;

public class CountAndSay {
    public CountAndSay(){}

    public String countAndSay(int n) {
        LinkedList<Integer> prevSeq = new LinkedList<>();
        prevSeq.add(1);

        prevSeq.add(-1);

        LinkedList<Integer> finalSeq = this.nextSequence(n, prevSeq);
        StringBuilder seqStr = new StringBuilder();
        for (Integer digit : finalSeq) {
            seqStr.append(digit);
        }
        return seqStr.toString();
    }

    private LinkedList<Integer> nextSequence(int n, LinkedList<Integer> prevSeq) {
        if (n <= 1) {
            // remove the delimiter before return
            prevSeq.pollLast();
            return prevSeq;
        }

        LinkedList<Integer> nextSeq = new LinkedList<Integer>();
        Integer prevDigit = null;
        Integer digitCnt = 0;
        for (Integer digit : prevSeq) {
            if (prevDigit == null) {
                prevDigit = digit;
                digitCnt += 1;
            } else if (digit == prevDigit) {
                // in the middle of the sub-sequence
                digitCnt += 1;
            } else {
                // end of a sub-sequence
                nextSeq.add(digitCnt);
                nextSeq.add(prevDigit);
                // reset for the next sub-sequence
                prevDigit = digit;
                digitCnt = 1;
            }
        }
        // add the delimiter for the next recursion
        nextSeq.add(-1);
        return this.nextSequence(n - 1, nextSeq);
    }
}
