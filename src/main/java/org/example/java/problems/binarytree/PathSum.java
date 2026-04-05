package org.example.java.problems.binarytree;
/*
112. Path Sum

Given the root of a binary tree and an integer targetSum, return true
if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

Solution : Try the recursion with same method by reducing the targetSum - root.val
1) return null in case if the root == null
2) if leaf node is returned for any branch then return whether targetSum - root.val == 0
3) use recursion on both side of the branched in an OR condition as

 */
public class PathSum {

    public static void main(String args[]){
        TreeNode l3 = new TreeNode(9);
        TreeNode l2 = new TreeNode(15);
        TreeNode r2 = new TreeNode(7);
        TreeNode r3 = new TreeNode(20, l2,r2);
        TreeNode root = new TreeNode(3,l3,r3);
        System.out.println(hasPathSum(root, 30));

    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {

        if(root == null) return false;
        if(root.right == null && root.left == null) return targetSum - root.val == 0;

        return hasPathSum(root.right, targetSum - root.val)
                || hasPathSum(root.left, targetSum-root.val);

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
