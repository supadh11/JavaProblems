package org.example.java.problems.arrays;
/*
55. Jump Game
You are given an integer array nums.
You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

Solution :
1) Start from the end
2) Consider the last element as goal
3) start the loop from last element -2 and go towards start
4) see if i+nums[i] >= goal, if it is replace the goal with i, basically the goal is reachable from i,
so move the goal pointer to i
5) in the end if the goal pointer is at 0, it means that it is reachable.
 */
public class JumpGame {

    public static void main(String argsp[]){
    int[] array = new int[]{3,2,1,0,4};
    System.out.println(canJump(array));
    }

    public static boolean canJump(int[] nums) {
        int goal = nums.length-1;
        for(int i=  nums.length-2;i>=0;i--){
            if(i+nums[i] >= goal){
                goal = i;
            }
        }
        if(goal == 0){
            return true;
        }
        return false;
    }
}
