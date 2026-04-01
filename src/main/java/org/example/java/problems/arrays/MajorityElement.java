package org.example.java.problems.arrays;

import java.util.HashMap;

/*.

169. Majority Element
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 */
public class MajorityElement {


    public static void main(String args[]){
        int[] nums = new int[]{3,3,4};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        int num = 0;
        if(nums.length == 1) return nums[0];
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int i = 0;i< nums.length;i++){
            if(freqMap.get( (nums[i])) != null){
                Integer val = freqMap.get(nums[i]);
                freqMap.replace(nums[i],val.intValue()+1);
            }else{
                freqMap.put(nums[i],1);
            }
        }
        for(Integer key : freqMap.keySet()){
            if(nums.length %2 == 0) {
                if (freqMap.get(key).intValue() >= (nums.length / 2)) {
                    num = key;
                }
            }else{
                if (freqMap.get(key).intValue() >= ((nums.length+1) / 2)) {
                    num = key;
                }
            }
        }
        return num;

    }
}

