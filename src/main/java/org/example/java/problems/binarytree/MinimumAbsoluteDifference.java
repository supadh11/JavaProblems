package org.example.java.problems.binarytree;
/*
530. Minimum Absolute Difference in BST
Core concept
In inorder traversal, you always follow this order:

Left → Root → Right

During inorder traversal:

Keep track of prev (previous visited node)
For each node:
Compute: current - prev
Update minimum

 */
public class MinimumAbsoluteDifference {
    static Integer prev;
    static int minAbsDiff = Integer.MAX_VALUE;
    public static void main(String args[]){

        TreeNode l3 = new TreeNode(9);
        TreeNode l2 = new TreeNode(15);
        TreeNode r2 = new TreeNode(7);
        TreeNode r3 = new TreeNode(20, l2,r2);
        TreeNode root = new TreeNode(3,l3,r3);
        System.out.println(getMinimumDifference(root));
    }

    public static int getMinimumDifference(TreeNode root) {

        recursion(root);
        return minAbsDiff;
    }

    public static void recursion(TreeNode node){
        if(node == null) return;

        recursion(node.left);
        if(prev!= null) {
            minAbsDiff = Math.min(minAbsDiff, Math.abs(prev - node.val));
        }
        prev = node.val;
        recursion(node.right);

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
