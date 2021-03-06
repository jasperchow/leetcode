# Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

# Example:
# Given a binary tree
#           1
#          / \
#         2   3
#        / \     
#       4   5    
# Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

# Note: The length of path between two nodes is represented by the number of edges between them.

# https://leetcode.com/problems/diameter-of-binary-tree/solution/

# Definition for a binary tree node.

# 思路： recursive max of any given node = max left + max right + 1
# use a list for reference to return 
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution(object):
    def diameterOfBinaryTree(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        diameter = [0]
        self.depth(root, diameter)
        return diameter[0]
        
    
    def depth(self, root, diameter):
        if not root:
            return 0
        else:
            left = self.depth(root.left, diameter)
            right = self.depth(root.right, diameter)
            diameter[0] = max(diameter[0], left + right)
            return 1 + max(left, right)

