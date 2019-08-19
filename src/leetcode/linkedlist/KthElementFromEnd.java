package leetcode.linkedlist;
import leetcode.util.ListNode;

import javax.swing.event.ListDataEvent;

public class KthElementFromEnd {

    public static void main(String[] args) {

        ListNode a1 = new ListNode(5);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(9);
        ListNode a4 = new ListNode(1);
        ListNode a5 = new ListNode(2);
        ListNode a6 = new ListNode(5);
        ListNode a7 = new ListNode(7);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;
        a6.next = a7;
        a7.next = null;


        System.out.println(findKthElement(a1, 6));
    }

    public static int findKthElement (ListNode head, int k) {

        int count = 0;
        ListNode fast = head;
        ListNode slow = head;


        while(fast != null) {
            fast = fast.next;
            count++;
            if (count > k){
                slow = slow.next;
            }
        }
/*
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
*/
        return slow.val;
    }
}
