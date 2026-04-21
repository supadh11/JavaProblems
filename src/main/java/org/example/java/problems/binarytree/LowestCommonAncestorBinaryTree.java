package org.example.java.problems.binarytree;
/*
236. Lowest Common Ancestor of a Binary Tree
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.

Solution : Use DFS call recursive method on left and right method.
Base case if you have reached p or q or null -> return the node.
Call recursive method on left and right node

if left & right both are not null that means it is the lowest common ancestor and return the node
if one of them is not null then return that node.

 */
public class LowestCommonAncestorBinaryTree {

    public static void main(String args[]){
        TreeNode l3 = new TreeNode(9);
        TreeNode l2 = new TreeNode(15);
        TreeNode r2 = new TreeNode(7);
        TreeNode r3 = new TreeNode(20, l2,r2);
        TreeNode root = new TreeNode(3,l3,r3);
        System.out.println(lowestCommonAncestor(root, r2,l3));
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null || p == root || q == root) return root;

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left != null && right != null) {
        return root;
        }

        if(left != null) return left;
        return right;
    }

    private static  class TreeNode {
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


