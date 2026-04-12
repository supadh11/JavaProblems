package org.example.java.problems.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*
114. Flatten Binary Tree to Linked List

Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class
where the right child pointer points to the next node in the list and the left child pointer is always null.
Take a linkedlist to add the nodes, traverse in a preorder nodes using recursion .

 */
public class FlattenBinaryTree {
    static List<TreeNode> listNode;
    public static void main(String args[]){
        TreeNode l3 = new TreeNode(9);
        TreeNode l2 = new TreeNode(15);
        TreeNode r2 = new TreeNode(7);
        TreeNode r3 = new TreeNode(20, l2,r2);
        TreeNode root = new TreeNode(3,l3,r3);
        flatten(root);
    }

    public static void flatten(TreeNode root) {

        listNode = new LinkedList<TreeNode>();

        recursionPreOrder(root, listNode);
        for(int i =0;i< listNode.size()-1;i++){
            listNode.get(i).left = null;
            listNode.get(i).right = listNode.get(i+1);
        }
    }

    private static void recursionPreOrder(TreeNode root, List<TreeNode> listNode) {
        if(root == null){
            return ;
        }
        listNode.add(root);
        recursionPreOrder(root.left,listNode);
        recursionPreOrder(root.right,listNode);
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
