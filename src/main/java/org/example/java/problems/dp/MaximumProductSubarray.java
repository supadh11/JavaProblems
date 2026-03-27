package org.example.java.problems.dp;
/*
152. Maximum Product Subarray
Given an integer array nums, find a subarray that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

Note that the product of an array with a single element is the value of that element.

Solution :
1) it's a simple trick to keep two vars, one for min and another for max product.
2) in case if a -ve number is found, swap these variables
3) minProduct will be min of num[i] and minProduct * num[i]
4) maxProduct will be max of num[i] and maxProduct[i] * num[i]
5) return the result which is max of result and maxProduct for that index

 */
public class MaximumProductSubarray {

    public static void main(String args[]){
    int[] nums = {1,-2,-3,6,-4,3};
      System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
       int maxProduct = nums[0];
       int minProduct = nums[0];
       int result = nums[0];
       int temp;
       for(int i =1;i<nums.length;i++){
           if(nums[i] < 0){
               temp = maxProduct;
               maxProduct = minProduct ;
               minProduct = temp ;

           }
           maxProduct = Math.max(nums[i], maxProduct * nums[i]);
           minProduct = Math.min(nums[i],minProduct * nums[i]);

           result = Math.max(result, maxProduct);
       }
        return result;
    }




}
