package org.example.java.problems.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

Given the root of a binary tree and an integer targetSum,
return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.

A root-to-leaf path is a path starting from the root and ending at any leaf node.
A leaf is a node with no children.

Solution :
1) Add the sumlist in to the return list only when there is no node in left or right and the target is 0
2) Add the node value to the sumlist and deduct the node value from target
3) call the backtrack method on both left and right node
4) Remove the number from the list
 */
public class PathSum {
    public static void main(String args[]){
        TreeNode thirdLeft = new TreeNode(7);
        TreeNode thirdRight = new TreeNode(2);
        TreeNode secondLeft = new TreeNode(11,thirdLeft, thirdRight);

        TreeNode firstLeft = new TreeNode(4,secondLeft, null);


        TreeNode seventhLeft = new TreeNode(5);
        TreeNode seventhRight = new TreeNode(1);

        TreeNode fifthLeft = new TreeNode(13,null, null);
        TreeNode fifthRight = new TreeNode(4,seventhLeft, seventhRight);

        TreeNode firstRight = new TreeNode(8,fifthLeft, fifthRight);



        TreeNode node = new TreeNode(5,firstLeft, firstRight);

        pathSum(node, 22).stream().forEach((list) ->{
            System.out.print("{");
            list.stream().forEach((val) ->{
                System.out.print(val+",");
            });
            System.out.print("}");
        });

    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> returnList = new ArrayList<>();
        backTrack(root, returnList,new ArrayList<>() ,targetSum);
        return returnList;
    }

    private static void backTrack(TreeNode node, List<List<Integer>> returnList, ArrayList<Integer> sumList, int targetSum) {
        if(node == null ) return;
        sumList.add(node.val);
        targetSum= targetSum-node.val;
        if(targetSum == 0 && node.left == null && node.right == null){
            returnList.add(new ArrayList<>(sumList));
        }
        backTrack(node.left, returnList,sumList, targetSum);
        backTrack(node.right, returnList,sumList, targetSum);
        sumList.remove(sumList.size()-1);

    }
}

 class TreeNode {
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
