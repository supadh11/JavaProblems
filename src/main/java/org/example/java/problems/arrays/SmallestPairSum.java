package org.example.java.problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
373. Find K Pairs with Smallest Sums
Medium
Topics
premium lock icon
Companies
You are given two integer arrays nums1 and nums2 sorted in non-decreasing order and an integer k.

Define a pair (u, v) which consists of one element from the first array and one element from the second array.

Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.
Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
Output: [[1,2],[1,4],[1,6]]
Explanation: The first 3 pairs are returned from the sequence:
[1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]


Solution : One solution is to Sort the array and find the first k elements from the array, but that will take a long time if let's say there are 10000 number in arrays
and we want only first 10 elements.
To avoid this situation we will use the minHeap concept which will store  k elements at a time. We will initialize the array with one array and 0th column of other array.
MinHeap is implemented by priorityQueue in java and insertion will take log n time
offer method will return the smallest number available in the min heap
We will also store the position of nums index in the PQ, so each element of PQ will contain one number from num1 array, one num of num2 array and position of num2 array
index. This position will be required to fetch the next element.
It is like we have stored all the values from num1 array in the PQ already and now we are taking the minimum value from PQ and inserting the next element in PQ.
This element can go anywhere in PQ depending on the sum ( not necessarily the smallest number present in the PQ at this time). At a time PQ will contain max k records


 */
public class SmallestPairSum {
    public static void main(String args[]){
        int[] nums1 = {1,5,11};
        int[] nums2 = {2,4,6};
        kSmallestPairs(nums1,nums2,4).stream().forEach((list) -> {

            list.stream().forEach((val) -> {
                System.out.print(val + ",");
            });
            System.out.println("");
        });
    }
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> smallestList = new ArrayList<>();
        if(nums1.length == 0 || nums2.length == 0 || k == 0) return smallestList;

        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a,b) -> {return ((a[0]+a[1]) - (b[0]+b[1]));}); // inserting records based on their sum
        int n = nums1.length;
        for(int i =0;i<n;i++){
            pq.offer(new Integer[]{nums1[i],nums2[0],0}); // initializing PQ will all nums1 record paired with nums[0] record, that'swhy position is also 0
        }
        while(k-- >  0 && pq.size() != 0){
            Integer[] arr = pq.poll();
            smallestList.add(Arrays.asList(arr[0], arr[1]));
            int nums2NextIndex = arr[2];

            if(nums2NextIndex < nums2.length-1){
                pq.offer(new Integer[] {arr[0], nums2[nums2NextIndex+1], nums2NextIndex+1}); // increasing the index of nums2 array , we dont need to increase nums1 index as that is already stored in PQ
            }
        }

        return smallestList;
    }
}
