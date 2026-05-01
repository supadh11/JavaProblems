package org.example.java.problems.bst;
/*
108. Convert Sorted Array to Binary Search Tree
Take mid node and recursively call on left and right sortedArray

 */
import com.sun.source.tree.Tree;

import java.util.Arrays;

public class HeightedBinarySearch {

    public static void main(String args[]){
        System.out.print(sortedArrayToBST(new int[]{-10,-3,0,5,9}));
    }

    public static  TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) return null;

        int mid = nums.length/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(Arrays.copyOfRange(nums,0, mid));
        node.right = sortedArrayToBST(Arrays.copyOfRange(nums,mid+1, nums.length));


        return node;
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
