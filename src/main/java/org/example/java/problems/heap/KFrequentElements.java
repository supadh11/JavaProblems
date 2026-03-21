package org.example.java.problems.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/*
347. Top K Frequent Elements
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]

Example 3:
Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2
Output: [1,2]


 */
public class KFrequentElements {

    public static void main(String args[]){
         int[] p = {1,2,1,2,1,2,3,1,3,2,4,5,5,5,5,5,3,3,3};
        Arrays.stream(topKFrequent(p,2)).forEach(n -> System.out.print(n+"," ));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] retArray = new int[k];
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for(int i =0;i<nums.length;i++){
            if(frequencyMap.get(nums[i]) == null){
                frequencyMap.put(nums[i], 1);
            }else{
                int frequncy = frequencyMap.get(nums[i]);
                frequencyMap.put(nums[i], ++frequncy);
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((num1, num2) ->{
            return frequencyMap.get(num2) - frequencyMap.get(num1);
        });

        for(Integer key : frequencyMap.keySet()){
            pq.add(key);
        }
        for(int i =0;i<k;i++){
            retArray[i]= pq.poll();
        }
        return retArray;



    }
}
