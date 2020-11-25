# Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

# For example:
# Given binary tree [3,9,20,null,null,15,7],

# https://leetcode.com/explore/interview/card/amazon/78/trees-and-graphs/2980/

# Definition for a binary tree node.

from typing import List
from collections import deque
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def zigzagLevelOrder(self, root: TreeNode) -> List[List[int]]:
        result = []
        level_list = deque()
        if root is None:
            return []
        
        node_queue = deque([root, None])
        is_order_left = True

        while (len(node_queue)) > 0:
            current_node = node_queue.popleft()

            if current_node:
                if is_order_left:
                    level_list.append(current_node.val)
                else:
                    level_list.appendleft(current_node.val)
            
                if current_node.left:
                    node_queue.append(current_node.left)
                if current_node.right:
                    node_queue.append(current_node.right)
            else:
                result.append(level_list)
                level_list = deque()
                is_order_left =  not is_order_left

                if len(node_queue) > 0:
                    # None 来判断一层的结束， popleft() currentNode 会跳到else
                    node_queue.append(None)
        return result
                
                
