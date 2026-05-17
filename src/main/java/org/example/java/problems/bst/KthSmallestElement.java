package org.example.java.problems.bst;

/*
230. Kth Smallest Element in a BST
Inorder traversal of a Binary Search Tree (BST) yields elements in sorted ascending order.
So, the k-th element in this traversal is the k-th smallest element.

Use recursive inorder traversal.
Maintain a counter to track visited nodes.
Return the node when the counter reaches k.
 */

public class KthSmallestElement {
    static int count = 0;
    static TreeNode result ;
    public static void main(String args[]){

    }

    public static int kthSmallest(TreeNode root, int k) {

        recursion(root,k);

        return result.val;

    }

    private static void recursion(TreeNode root, int k) {
        if(root == null) return;
        if(root.left != null) recursion(root.left,k);
        count++;
        if(count == k){
            result = root;
            return;
        }
        if(root.right != null) recursion(root.right,k);


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
