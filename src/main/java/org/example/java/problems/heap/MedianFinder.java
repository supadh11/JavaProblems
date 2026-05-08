package org.example.java.problems.heap;
/*
295. Find Median from Data Stream

Solution :
The idea is to divide numbers into 2 balanced halves, one half low stores low numbers, the other half high stores high numbers. To access the median in O(1), we need a data structure that give us the maximum of low half and the minimum of high half in O(1).
 That's where maxHeap and minHeap come into play.

 When adding a new number num into our MedianFinder:
Firstly, add num to the maxHeap, now maxHeap may contain the big element (which should belong to minHeap). So we need to balance, by removing the highest element from maxHeap, and offer it to minHeap.
Now, the minHeap might hold more elements than maxHeap, in that case, we need to balance the size, by removing the lowest element from minHeap and offer it back to maxHeap.

When doing findMedian():
If maxHeap.size > minHeap.size return top of the maxHeap, which is the highest number amongs low numbers.
Else if maxHeap.size == minHeap return the (maxHeap.top() + minHeap.top()) / 2.
 */
import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> {return b-a;});
    public MedianFinder() {

    }

    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if(minHeap.size() > maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if(maxHeap.size() >minHeap.size()) return maxHeap.peek();
        else return (maxHeap.peek() + minHeap.peek())/2.0d;
    }
}
