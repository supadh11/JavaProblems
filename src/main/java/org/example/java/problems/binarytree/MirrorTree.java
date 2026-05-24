package org.example.java.problems.binarytree;
/*
101. Symmetric Tree

Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
Input: root = [1,2,2,3,4,4,3]
Output: true

Input: root = [1,2,2,null,3,null,3]
Output: false

Solution : Use recursion, we just cant do it by calling the isSymmetric method, we need to call isMirror method as we need to traverse, left and right
and the comparison in the next call will be between left.right, right.left and right.right and left.left

 */
public class MirrorTree {

    public static void main(String args[]){


    }

    public static boolean isSymmetric(TreeNode root) {

        if(root == null) return true;
       return isMirror(root.left, root.right);

    }

    public static boolean isMirror(TreeNode left, TreeNode right){
        if(left == null && right == null ) return true;
        if(left == null || right == null) return false;

        return (left.val == right.val) && isMirror(left.left, right.right) && isMirror(left.right, right.left);


    }

    public static class TreeNode {
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
