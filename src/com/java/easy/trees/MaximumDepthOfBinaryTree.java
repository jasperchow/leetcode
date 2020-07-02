//
//Given a binary tree, find its maximum depth.
//
//        The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
//
//        Note: A leaf is a node with no children.
//
//        Example:
//
//        Given binary tree [3,9,20,null,null,15,7],
//
//        3
//        / \
//        9  20
//        /  \
//        15   7
//        return its depth = 3.

package com.java.easy.trees;


public class MaximumDepthOfBinaryTree {
    public MaximumDepthOfBinaryTree(){}

    public int maxDepth_recursion(TreeNode root) {
        if (root == null){
            return 0;
        }
        else{
            int left_height = maxDepth_recursion(root.left);
            int right_height = maxDepth_recursion(root.right);
            return Math.max(left_height,right_height) + 1;
        }
    }
}
