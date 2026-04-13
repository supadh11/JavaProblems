package org.example.java.problems.binarytree;


/*
637. Average of Levels in Binary Tree
Given the root of a binary tree, return the average value of the nodes on each level in the form of an array.
Answers within 10-5 of the actual answer will be accepted.

Input: root = [3,9,20,null,null,15,7]
Output: [3.00000,14.50000,11.00000]
Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
Hence return [3, 14.5, 11].

Solution : This is a simple BFS solution. Take a queue to maintain all the nodes in a level.
 In this solution we are not maintaining the nodes at a level in the queue. Queue will contain more nodes just we are going to use the level as the counter.

1) We start the while loop till the queue becomes empty.
2) assign size of the queue at each level, initially the queue will contain all the nodes at that level
3) we initialize the sum at 0
4) we start a for loop from 0 till size of the queue, at this time queue still contains nodes at a particular level
5) one by one poll the nodes till size, sum their value in a varaible
6) for each node , add their left and right children in the queue, this will serve as the next level.
7) add sum/size in the resultList.

 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelsAverage {

    public static void main(String args[]){
        TreeNode l3 = new TreeNode(9);
       TreeNode l2 = new TreeNode(15);
       TreeNode r2 = new TreeNode(7);
       TreeNode r3 = new TreeNode(20, l2,r2);
       TreeNode root = new TreeNode(3,l3,r3);
        averageOfLevels(root);

    }

    public static List<Double> averageOfLevels(TreeNode root) {

        List<Double> averageList = new ArrayList<>();
        Queue<TreeNode> averageQueue = new LinkedList<>();
        averageQueue.add(root);



        while(!averageQueue.isEmpty()) {
            int level = averageQueue.size();
            double sum = 0;
            for (int i = 0; i < level; i++) {
                TreeNode node = averageQueue.poll();
                sum += node.val;
                if(node.left != null) averageQueue.offer(node.left);
                if(node.right != null) averageQueue.offer(node.right);

            }
            averageList.add(sum/level);
        }
        return averageList;
    }


    private static class TreeNode {
        int val;
       TreeNode left;
       TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val,TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    
}
