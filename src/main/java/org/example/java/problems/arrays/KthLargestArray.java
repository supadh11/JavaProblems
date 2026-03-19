package org.example.java.problems.arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

/*

215. Kth Largest Element in an Array
Given an integer array nums and an integer k, return the kth largest element in the array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.
Can you solve it without sorting?
 */
public class KthLargestArray {

    public static void main(String args[]){
        int[] p = {4,5,6,2,1,2,4,9,10,3,3,11};
        System.out.println(solution(p,4));
    }

    private static int solution(int[] p, int k) {
        int returnVal = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i =0;i<p.length;i++){
            queue.add(p[i]);
        }
        int i =1;
        while(i<k){
            queue.poll();
            i++;
        }
        if(queue.size() >= 1){
            returnVal = queue.peek();
        }
        return returnVal;

    }
}
