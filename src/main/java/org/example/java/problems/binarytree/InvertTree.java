package org.example.java.problems.binarytree;
/*
226. Invert Binary Tree
Given the root of a binary tree, invert the tree, and return its root.
Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]

Solution : use recursion and swap the left and right nodes to invert tree
 */
public class InvertTree {

    public static void main(String args[]){
        TreeNode l3 = new TreeNode(9);
        TreeNode l2 = new TreeNode(15);
        TreeNode r2 = new TreeNode(7);
        TreeNode r3 = new TreeNode(20, l2,r2);
        TreeNode root = new TreeNode(3,l3,r3);
        invertTree(root);
    }

    public static void invertTree(TreeNode root) {
        if(root == null) return;
         recursion(root);
        return;
    }

    private static void recursion(TreeNode root) {
       if(root.left == null && root.right == null) return;
       TreeNode temp = null;
       temp = root.left;
       root.left = root.right;
       root.right = temp;
       if(root.left != null) {
           recursion(root.left);
       }
       if(root.right != null) {
            recursion(root.right);
       }
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
