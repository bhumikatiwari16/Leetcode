package leetcode.linkedlist;

import leetcode.util.ListNode;

import java.util.List;

public class DeleteInnerNode {

    public static void main(String[] args) {

        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(9);
        ListNode a4 = new ListNode(3);
        ListNode a5 = new ListNode(4);
        ListNode a6 = new ListNode(5);
        ListNode a7 = new ListNode(7);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;
        a6.next = a7;
        a7.next = null;

        deleteGivenNode(a1, a4);
    }

    public static void deleteGivenNode (ListNode head, ListNode gn) {

        ListNode cur = head;

        while(cur.next != gn) {
            cur= cur.next;
        }

        cur.next = gn.next;

        cur = head;

        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
