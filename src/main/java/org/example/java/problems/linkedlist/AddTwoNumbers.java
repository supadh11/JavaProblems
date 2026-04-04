package org.example.java.problems.linkedlist;
/*
2. Add Two Numbers
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Solution :
1) The numbers are already reversed, so no need to reverse the linked lists
2) take a sum list and a dummy list to be returned
3) start a loop that runs till any of the lists has nodes (use OR).
 As we are using OR one node can be empty, so we have to do null checks.
4) take a variable carry which can be assigned as 1 in case if sum + carry is greater than 9 and 0 in case if it less than n.
5) val of node should be sum+carry and assign new node to header.next;
6) Move header, l1 and l2 to the next element
7) An edge case is if there is a value in carry even after both the lists are finished.
 In that case create a new node and assign it to be header.next

 */
public class AddTwoNumbers {

    public static void main(String args[]) {
        ListNode n3 = new ListNode(3);
        ListNode n2 = new ListNode(4, n3);
        ListNode n1 = new ListNode(2, n2);

        ListNode a4 = new ListNode(3);
        ListNode a3 = new ListNode(4, a4);
        ListNode a2 = new ListNode(6, a3);
        ListNode a1 = new ListNode(5, a2);
        ListNode listNode = addTwoNumbers(a1, n1);
        while(listNode != null){
            System.out.print(listNode.val+ " ,");
            listNode = listNode.next;
        }


    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode header = new ListNode();
        ListNode dummy = header;
        int carry = 0;
        while(l1 != null || l2 != null){

            int t = (l1 != null? l1.val : 0) + (l2!= null? l2.val:0);
            t = t+carry;
            if(t > 9){
               t = t%10;
               carry = 1;
            }else{
                carry = 0;
            }
            ListNode node = new ListNode(t);
            header.next = node;
            header = header.next;
            l1 = l1 != null? l1.next: l1;
            l2 = l2 != null? l2.next:l2;
        }
    if(carry != 0){
        ListNode node = new ListNode(carry);
        header.next = node;
    }


        return dummy.next;

    }

    private static class ListNode {
    int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
