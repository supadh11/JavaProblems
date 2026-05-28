package org.example.java.problems.linkedlist;
/*

61. Rotate List
Given the head of a linked list, rotate the list to the right by k places.
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
Input: head = [0,1,2], k = 4
Output: [2,0,1]

Solution :
1) Calculate the lists length by creating a tailNode = head and moving it tll it becomes null;
2) Calculate the number of steps it needs to move by len - k
3) Make the list circular by assigning tailNode.next = head
4) move steps and assign the last node as newTailNode
5) newHeadNode will be assigned as newTailNode.next
6) assign newTailNode.next = null to break the circular list

 */
public class ReverseLinkedList {

    public static void main(String args[]){
        ListNode a3 = new ListNode(6);
        ListNode a2 = new ListNode(5, a3);
        ListNode a1 = new ListNode(4, a2);
        ListNode n3 = new ListNode(3,a1);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        n1 = rotateRight(n1,2);
        while(n1.next != null){

            System.out.print(n1.val + " ->");
            n1 = n1.next;
        }
        System.out.print(n1.val + " ->");
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null||k==0) return head;
        int len = 1;
        ListNode tail = head;
        while( tail.next != null){
            tail = tail.next;
            len++;
        }
        k = k%len;
        int step = len-k; // for a len of 6 and k of 2, step will become 4
        if(step == 0) return head;


        tail.next = head;  // making the linked list circular

        ListNode newTail = head; // taking the newtail and assigning it to the start of linkedList
        for(int i =1;i< step;i++){

            newTail=newTail.next;  // moving the newTail to the last
        }

        ListNode newhead=newTail.next; // the next element of list will become the newHead
        newTail.next=null; // breaking the circular linkedlist and assigning the newTails next element as null

        return newhead;


    }

    private static  class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
