# Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
#
# Only one letter can be changed at a time.
# Each transformed word must exist in the word list.
# Note:
#
# Return 0 if there is no such transformation sequence.
# All words have the same length.
# All words contain only lowercase alphabetic characters.
# You may assume no duplicates in the word list.
# You may assume beginWord and endWord are non-empty and are not the same.

# Input:
# beginWord = "hit",
# endWord = "cog",
# wordList = ["hot" ,"dot" ,"dog" ,"lot" ,"log" ,"cog"]
#
# Output: 5
#
# Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
# return its length 5.

import collections
import string

class Solution(object):
    def ladderLength_breadth_first_search(self, beginWord, endWord, wordList):
        if endWord not in wordList or not beginWord  or not wordList:
            return 0
        
        # create the middle layer dictionary
        L = len(beginWord)
        middle_dict = {}
        for word in wordList:
            for i in range(L):
                middle_dict.setdefault(word[:i] + '*' + word[i+1:], []).append(word)
        
        queue = collections.deque([(beginWord, 1)])
        
        visited = {beginWord : True}

        # using queue for BFS, use a dictionary to record the visited words
        while queue:
            current_word, level = queue.popleft()
            for i in range(L):
                intermediate_word = current_word[:i] + "*" + current_word[i+1:]

                for word in middle_dict[intermediate_word]:
                    if word == endWord:
                        return level + 1
                    else:
                        if word not in visited:
                            visited[word] = True
                            queue.append((word, level + 1))
                middle_dict[intermediate_word] = []
        
        return 0

    def ladderLength_smarter(self, beginWord, endWord, wordList):
        wordList = set(wordList)
        queue = collections.deque([(beginWord, 1)])
        visited = set()
        chars = string.ascii_lowercase
        while queue:
            current_word, level = queue.popleft()
            if current_word == endWord:
                return level
            else:
                for i in range(len(current_word)):
                    for ch in chars:
                        new_word = current_word[:i] + ch + current_word[i+1:]
                        if new_word in wordList and new_word not in visited:
                            queue.append((new_word, level + 1))
                            visited.add(new_word)
        
        return 0
