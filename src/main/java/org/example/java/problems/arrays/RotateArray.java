package org.example.java.problems.arrays;
/*
189. Rotate Array
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

Solution :
Reverse the whole array
reverse the ist half - till k
reverse the second half from k till n

Better way of doing it in place :
public void rotate(int[] nums, int k) {
    int n = nums.length;
    k = k % n;

    reverse(nums, 0, n - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, n - 1);
}

private void reverse(int[] nums, int l, int r) {
    while (l < r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
        l++;
        r--;
    }
}
 */
public class RotateArray {

    public static void main(String args[]){
        rotate(new int[]{1,2,3,4,5,6,7},3);
        rotate(new int[]{-1,-100,3,99},2);
    }

    public static void rotate(int[] nums, int k) {
        if(k == nums.length){
            return;
        }
        if(k > nums.length){
            k = k% nums.length;
        }
        int[] numMod = new int[nums.length];
        int j =0;
        for(int i =nums.length-k;i<nums.length;i++){
            numMod[j] = nums[i];
            j++;
        }
        for(int i =0;i<nums.length-k;i++){
            numMod[j] = nums[i];
            j++;
        }

        for(int i = 0;i<nums.length;i++){
            nums[i] = numMod[i];
        }
    }

}
