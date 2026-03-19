package org.example.java.problems.arrays;


import java.util.Arrays;

/*
88. Merge Sorted Array
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

Example 1:
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

Solution :
Ideal solution should be to start from the end of the arrays, take 3 pointers and compare the values
i = m-1;
j= n-1;
k = m+n-1;
while(j>=0){
if(val1[i] > val2[j]){
val1[k] = val1[i]
k--;
i--;
}else{
val1[k] = val2[j]
k--;
j--;
}
}
 */
public class MergeSortedArrays{

    public static void main(String args[]){
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;

       Arrays.stream(solution(nums1, m, nums2,n)).forEach((num) -> System.out.println(num));

    }

    private static int[] solution(int[] nums1, int m, int[] nums2, int n) {
        int pt1 = 0;
        int pt2 = 0;
        int[] returnArray = new int[m+n];
        for(int i = 0;i<m+n;i++){
            if((pt1 < m && pt2 >= n) || (nums1[pt1] < nums2[pt2] && pt1 < m)){
                returnArray[i] = nums1[pt1];
                pt1++;
            }else if((pt1 >= m && pt2 < n) || (nums1[pt1] >= nums2[pt2 ])){
                returnArray[i] = nums2[pt2];
                pt2++;
            }
        }

        for(int i = 0;i< returnArray.length;i++){
            nums1[i] = returnArray[i];
        }
        return returnArray;
    }

}
