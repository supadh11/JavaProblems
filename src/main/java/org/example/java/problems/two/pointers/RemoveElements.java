package org.example.java.problems.two.pointers;

import java.util.Arrays;

/*
27. Remove Element
Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
Example 1:

Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2,_,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 2.
It does not matter what you leave beyond the returned k (hence they are underscores).

[3,3] --> []
Solution : Adopt two pointers maintaining initial and ending position.
To maintain position of last index where position is not null, we need to use another loop.
As we are traversing each element once, time will always be O(N).
Consider the edge cases where length is 1 and the elemnt is = to value and vice versa
Also as we have to return the number of elements that are not equal we are maintaining temp variable
to keep the count
We have to increase it when i or j is not equal to val

 */
public class RemoveElements {

public static void main(String args[]){

    int[] p = new int[]{3,2,2,3};
    System.out.println(removeElement(p,3));
    Arrays.stream(p).forEach(( a -> {System.out.print(a+ ",");}));

}

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length-1;
        int temp = 0;
        if(nums.length == 1){
            if(nums[0] == val) return 0;
            else return 1;
        }
        while(i<=j){
            if(nums[i] == val){
                while(j >= 0 && nums[j] == val ){
                    if(j <= i) return temp; // consider the case of [3,3] or [3,3,3,4]
                    j--;
                }
                nums[i] = nums[j];
                nums[j] = val;
                j--;
                temp++;
            }else{
                temp++;
            }
            i++;
        }

        return temp;
    }
}
