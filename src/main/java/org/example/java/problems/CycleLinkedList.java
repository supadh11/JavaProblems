package org.example.java.problems;



/*
Given head, the head of a linked list, determine if the linked list has a cycle in it.

        There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

        Return true if there is a cycle in the linked list. Otherwise, return false.

*/

import java.util.HashSet;
import java.util.Set;

public class CycleLinkedList {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();
        boolean cycle = false;
        while(head != null){

            if(!nodeSet.add(head) ){
                cycle = true;
                break;
            }

            head = head.next;
            if(cycle)
                break;
        }
        return cycle;
    }


    }
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
    ListNode(int x, ListNode value) {
        val = x;
        next = value;
    }


}
