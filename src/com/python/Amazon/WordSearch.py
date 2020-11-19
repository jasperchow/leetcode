# Given an m x n board and a word, find if the word exists in the grid.
# The word can be constructed from letters of sequentially adjacent cells, where "adjacent" cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

# https://leetcode.com/explore/interview/card/amazon/84/recursion/2989/
from typing import List

class Solution:
    
    def exist(self, board: List[List[str]], word: str) -> bool:
        self.ROWS = len(board)
        self.COLS = len(board[0])
        self.board = board
        for row in range(self.ROWS):
            for col in range(self.COLS):
                if self.backtrack(row, col, word):
                    return True

    def backtrack(self, row, col, suffix):
        if len(suffix) == 0:
            return True
        else:
            if row < 0 or row == self.ROWS or col < 0 or col == self.COLS or \
            self.board[row][col] != suffix[0]:
                return False
            else:
                result = False
                self.board[row][col] = '#'
                for rowOffSet, colOffSet in [(0, 1), (1, 0), (0, -1), (-1, 0)]:
                    result = self.backtrack(row + rowOffSet, col + colOffSet, suffix[1:])
                    if result:
                        break
                self.board[row][col] = suffix[0]

                return result