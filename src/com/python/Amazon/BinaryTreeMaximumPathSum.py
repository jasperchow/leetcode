# Given a non-empty binary tree, find the maximum path sum.

# For this problem, a path is defined as any node sequence from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.


# https://leetcode.com/explore/interview/card/amazon/78/trees-and-graphs/2981/

# Definition for a binary tree node.
import math
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def maxPathSum(self, root: TreeNode) -> int:
        max_sum = [float('-inf')]
        self.maxGain(root, max_sum)
        return max_sum[0]

    def maxGain(self, node: TreeNode, max_sum):
        if not node:
            return 0
        else:
            left_gain = max(self.maxGain(node.left, max_sum), 0)
            right_gain = max(self.maxGain(node.right, max_sum), 0)
            max_sum[0] = max(max_sum[0], node.val + left_gain + right_gain)
            return node.val + max(left_gain, right_gain)