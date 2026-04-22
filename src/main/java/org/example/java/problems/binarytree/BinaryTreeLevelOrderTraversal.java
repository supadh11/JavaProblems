package org.example.java.problems.binarytree;

import java.util.ArrayList;
import java.util.List;

/*
102. Binary Tree Level Order Traversal
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []

Solution : Use recursion to traverse the BT. Pass the level value so as to keep track of each level in the recursive method.
in case if returnList size is at level that means a list is not yet added, so create a new inner list and add the list to it.
if the list is greater than level size that means that the list is already added, so in this case get the inner list first from returnList and add the value to innerlist

call recursion on both left and right nodes.

 */
public class BinaryTreeLevelOrderTraversal {
    
    public static void main(String args[]){
        TreeNode l3 = new TreeNode(9);
        TreeNode l2 = new TreeNode(15);
        TreeNode l4 = new TreeNode(15);
        TreeNode r2 = new TreeNode(7, l4, null);
        // TreeNode r2 = new TreeNode(15);
        TreeNode r3 = new TreeNode(20, l2, r2);
        TreeNode root = new TreeNode(3, l3, r3);
        TreeNode root1 = new TreeNode(3, l3, r3);
        System.out.println(levelOrder(root ));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> returnList = new ArrayList<>();

        levelOrderRecursion(root, 0, returnList);
        return returnList;
    }

    private static void levelOrderRecursion(TreeNode root, int level, List<List<Integer>> returnList) {

        if(root == null){
            return;
        }
        if(returnList.size() == level){ // This checks if the list is already added to the returnList or not, if it is added then go to else and fetch he list and then add element
            List<Integer>li=new ArrayList<>();
            li.add(root.val);
            returnList.add(li);
        }else{
            returnList.get(level).add(root.val);
        }

        levelOrderRecursion(root.left,level+1, returnList);
        levelOrderRecursion(root.right,level+1, returnList);

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
