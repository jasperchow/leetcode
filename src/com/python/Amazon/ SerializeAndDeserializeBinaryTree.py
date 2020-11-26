
#Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

# Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

# Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

# #https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        return self.rserialize(root, '')
        
    def rserialize(self, root, string):
        if root is None:
            string += 'None,'
        else:
            string += str(root.val) + ','
            string = self.rserialize(root.left, string)
            string = self.rserialize(root.right, string)
        return string

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        data_list = data.split(',')
        root = self.rdeseriablize(data_list)
        return root
    
    def rdeseriablize(self, lst):
        if lst[0] == 'None':
            lst.pop(0)
            return None
        else:
            root = TreeNode(lst[0])
            lst.pop(0)
            root.left = self.rdeseriablize(lst)
            root.right = self.rdeseriablize(lst)
            return root

        

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))