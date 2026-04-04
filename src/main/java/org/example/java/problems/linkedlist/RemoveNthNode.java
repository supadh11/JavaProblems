package org.example.java.problems.linkedlist;

/*.

19. Remove Nth Node From End of List
Given the head of a linked list, remove the nth node from the end of the list and return its head.
Solution : Fast Pointer and Slow pointer initialize on head node
1) Take a fast pointer move it till nth position in a loop
2) if fast pointer reached the end, it means we have to remove the first node, so return head.next
3) Now run the loop on fast pointer till end and move both fast and slow pointer.
4) Now by the tile loop ends, fast pointer will be on end pointer and slow pointer will be on nth pointer
5) assign the slow.next = slow.next.next

 */
public class RemoveNthNode {

    public static void main(String args[]){
        ListNode a3 = new ListNode(4);
        ListNode a2 = new ListNode(2, a3);
        ListNode a1 = new ListNode(1, a2);

        ListNode n3 = new ListNode(3,a1);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);

        ListNode listNode = removeNthFromEnd(n1,3);
        while(listNode != null){
            System.out.print(listNode.val+ " ,");
            listNode = listNode.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        for(int i = 0;i< n;i++){
            fast = fast.next;
        }
        if(fast == null) return head.next;
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return head;

    }

    private static  class ListNode {
  int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}

