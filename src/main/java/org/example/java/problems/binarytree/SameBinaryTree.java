package org.example.java.problems.binarytree;


/*
100. Same Tree
Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

Solution :
Return false if one of the two nodes passed is null
Return True is both of them are null
Return null if their value are not equal
Else call recursion on both sides of node
 */
public class SameBinaryTree {

    public static void main(String args[]) {
        TreeNode l3 = new TreeNode(9);
        TreeNode l2 = new TreeNode(15);
        TreeNode l4 = new TreeNode(15);
        TreeNode r2 = new TreeNode(7, l4, null);
        // TreeNode r2 = new TreeNode(15);
        TreeNode r3 = new TreeNode(20, l2, r2);
        TreeNode root = new TreeNode(3, l3, r3);
        TreeNode root1 = new TreeNode(3, l3, r3);
        System.out.println(isSameTree(root, root1));

    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if ((p != null && q == null) || (q != null && p == null)) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
