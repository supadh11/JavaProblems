package org.example.java.problems.linkedlist;
/*
21. Merge Two Sorted Lists
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list.
The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

Solution :
1) Return list1 if list2 is empty
2) Return list2 if list1 is empty
3) Move the loop while(list1 != null && list2 != null) i.e break if any of the list is null
4) Assign list1 to node if list1 is smaller
5) Assign list2 to node if list2.val is smaller
6) After loop check if any of the list is not null and assign that list to node.next
7) Return the list;
 */
public class MergeSortedList {

    public static void main(String args[]){
        ListNode n3 = new ListNode(3);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);

      //  ListNode a4 = new ListNode(3);
        ListNode a3 = new ListNode(4);
        ListNode a2 = new ListNode(2, a3);
        ListNode a1 = new ListNode(1, a2);

        ListNode listNode = mergeTwoLists(a1, n1);
        while(listNode != null){
            System.out.print(listNode.val+ " ,");
            listNode = listNode.next;
        }

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1 == null)return list2;
        if(list2 == null)return list1;

        ListNode returnNode = new ListNode(-1);
        ListNode node = returnNode;
    while(list1 != null && list2 != null){

    if (list1.val <= list2.val) {
                node.next = list1;
                node = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
               node = list2;
                list2 = list2.next;
            }

        }
        if(list1 == null){
            node.next = list2;
        }else{
            node.next = list1;
        }

    return returnNode.next;
    }

     private static class ListNode {
      int val;
     ListNode next;
    ListNode() {}
   ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
