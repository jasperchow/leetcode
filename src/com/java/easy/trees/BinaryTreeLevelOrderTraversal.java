//Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
//
//        For example:
//        Given binary tree [3,9,20,null,null,15,7],
//        3
//        / \
//        9  20
//        /  \
//        15   7
//        return its level order traversal as:
//        [
//        [3],
//        [9,20],
//        [15,7]
//        ]

package com.java.easy.trees;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public BinaryTreeLevelOrderTraversal(){}

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        if (root == null) return levels;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()){
            levels.add(new ArrayList<Integer>());

            int level_length = queue.size();
            for(int i = 0; i < level_length; i++){
                TreeNode node = queue.remove();

                levels.get(level).add(node.val);

                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            level += 1;
        }
        return levels;
    }

}
