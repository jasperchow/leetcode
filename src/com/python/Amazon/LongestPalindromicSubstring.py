# Given a string s, return the longest palindromic substring in s.

#https://leetcode.com/explore/interview/card/amazon/80/dynamic-programming/489/

# 1. reverse the string, find the same substring and check the index
# 2. check every substring, and see if it is palindrome
# 3. dynamic programming., avoid checking the same string, P(i + 1, j + 1) is palindrome if P(i, j) is palindrome and i == j
# 4. try to expand the potential palindrome from its middle to the both end, there are 2n-1 middles to loop, "aba" and "abba" two kind of cases
class Solution:
    def longestPalindrome(self, s: str) -> str:
        res = ""
        for i in range(len(s)):
            temp = self.checkPalindrome(s, i, i)
            if len(temp) > len(res):
                res = temp
            temp = self.checkPalindrome(s, i, i + 1)
            if len(temp) > len(res):
                res = temp

        return res

    def checkPalindrome(self, s, i, j):
        while i >= 0 and j < len(s) and s[i] == s[j]:
            i = i - 1
            j = j + 1
        return s[i + 1 : j]
