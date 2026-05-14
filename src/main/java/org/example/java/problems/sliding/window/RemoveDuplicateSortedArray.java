package org.example.java.problems.sliding.window;
/*
80. Remove Duplicates from Sorted Array II

Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

Solution :

Use two pointers one to keep on moving, second to keep track of the index where to put the compared value.
Also use a boolean to keep the toggle, just to keep track of the second element.

Another simple solution :

start the loop with 2 if value is not same as 2nd prev then move nums[j] to nums[i] and increment;
int n = nums.length;
        if(n<=2){
            return n;
        }

        int j = 2;
        for(int i=2; i<n; i++){
            if(nums[i] != nums[j-2]){
                nums[j] = nums[i];
                j++;
            }
        }
        return j;


 */
public class RemoveDuplicateSortedArray {

    public static void main(String args[]){

        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));

    }

    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int prevNum = nums[0];
        boolean sec = true;
        int index = 1;
        for(int i =1;i< nums.length;i++){
            while(i < nums.length && nums[i] == prevNum ){
                if(sec) {
                   sec = false;
                   nums[index] = nums[i];
                   index++;
                }else{
                    prevNum = nums[i];

                }
                i++;
            }
            sec = true;
            if(i < nums.length && nums[i] != prevNum){
                nums[index] = nums[i];
                prevNum = nums[i];
                index++;

            }


        }
        return index;
    }
}
