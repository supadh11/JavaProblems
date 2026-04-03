package org.example.java.problems.binarytree;
/*
104. Maximum Depth of Binary Tree
Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the
 longest path from the root node down to the farthest leaf node.

 Solution :
 1) Edge case : if root node is empty return 0;
 2) call the recursive method on both left and right side;
 3) return the max of left and right side
 */
public class MaximumDepth {

    public static void main(String args[]){
        TreeNode l3 = new TreeNode(9);
        TreeNode l2 = new TreeNode(15);
        TreeNode r2 = new TreeNode(7);
        TreeNode r3 = new TreeNode(20, l2,r2);
        TreeNode root = new TreeNode(3,l3,r3);
        System.out.println(maxDepth(root));
    }
    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;
         return (recursion(root,1));
    }

    private static int recursion(TreeNode root, int i) {
        if(root.right == null && root.left == null) return i;
        if(root.right == null) return Math.max(recursion(root.left, i+1), i);
        if(root.left == null) return Math.max(recursion(root.right, i+1), i);
        return Math.max(recursion(root.left, i+1), recursion(root.right, i+1));
    }

    private static class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
        this.right = right;
     }
 }
}
