package org.example.java.problems.binarytree;
/*
222. Count Complete Tree Nodes
Given the root of a complete binary tree, return the number of the nodes in the tree.

According to Wikipedia, every level,
except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Design an algorithm that runs in less than O(n) time complexity.


Solution :
1) if root is null return 0
2) else do a count++ and call recursion on root.left and root.right;
3) return count;
 */
public class CountTreeNodes {
     static int count = 0;
    public static void main(String args[]){
        TreeNode l3 = new TreeNode(9);
        TreeNode l2 = new TreeNode(15);
        TreeNode l4 = new TreeNode(15);
        TreeNode r2 = new TreeNode(7,l4,null);
       // TreeNode r2 = new TreeNode(15);
        TreeNode r3 = new TreeNode(20, l2,r2);
        TreeNode root = new TreeNode(3,l3,r3);
        System.out.println(countNodes(root));


    }

    public static int countNodes(TreeNode root) {
        if(root == null){ return 0;}
        else {
            count++;
            countNodes(root.left);
            countNodes(root.right);
        }
        return count;
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
