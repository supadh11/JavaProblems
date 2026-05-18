package org.example.java.problems.linkedlist;
/*

92. Reverse Linked List II
Given the head of a singly linked list and two integers left and right where left <= right,
 reverse the nodes of the list from position left to position right, and return the reversed list.
Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]
Example 2:

Input: head = [5], left = 1, right = 1
Output: [5]

Solution :


Core Idea

Instead of reversing the whole list, the algorithm:

Finds the node before the reversal starts
Repeatedly takes the next node
Moves it to the front of the reversing section
Inside Loop :
ListNode next = start.next; //Take next node.
start.next = next.next; //Detach it.
next.next = temp.next; //Point detached node to front.
temp.next = next; //Insert at front.

temp -> A -> B -> C -> D
         start

 */
public class ReverseLinkedListBetween {

    public static void main(String args[]){
        ListNode a3 = new ListNode(4);
        ListNode a2 = new ListNode(2, a3);
        ListNode a1 = new ListNode(1, a2);

        ListNode n3 = new ListNode(3,a1);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);

        ListNode listNode = reverseBetween(n1,2,4);
        while(listNode != null){
            System.out.print(listNode.val+ " ,");
            listNode = listNode.next;
        }

    }



    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode temp = dummy;
        ListNode start  ;
        for(int i = 1;i<left;i++){
            temp = temp.next;
        }
        start = temp.next;
        for(int i = 0;i<right-left;i++){
            ListNode next = start.next;
            start.next = next.next;
            next.next = temp.next;
            temp.next = next;

        }

        return dummy.next;
    }

    public static class ListNode {
      int val;
      ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }


}
