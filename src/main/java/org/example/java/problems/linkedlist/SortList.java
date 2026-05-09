package org.example.java.problems.linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*

148. Sort List
Given the head of a linked list, return the list after sorting it in ascending order.

Solution : Turn it to an arraylist and sort and then put the values back.
alternate solution would be to use merge sort.

 */
public class SortList {

    public static class ListNode {
     int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public static void main(String args[]){
       ListNode n3 = new ListNode(3);
      ListNode n2 = new ListNode(4, n3);
      ListNode n1 = new ListNode(2, n2);

      ListNode a4 = new ListNode(3);
      ListNode a3 = new ListNode(4, a4);
      ListNode a2 = new ListNode(6, a3);
      ListNode a1 = new ListNode(5, a2);
      ListNode listNode = sortList(a1);
      while(listNode != null){
          System.out.print(listNode.val+ " ,");
          listNode = listNode.next;
      }


  }

    public static ListNode sortList(ListNode head) {

        ListNode temp = head;
        List<Integer> arrayList = new ArrayList<>();
        while(temp!= null){
            arrayList.add(temp.val);
            temp = temp.next;
        }
        ListNode tempNode = head;
        Collections.sort(arrayList);
        for(Integer val : arrayList){
            tempNode.val = val;
            tempNode = tempNode.next;
        }
        return head;

    }
}
