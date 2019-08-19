package leetcode.linkedlist;
import leetcode.util.ListNode;

public class RemoveDuplicates {

    public static void main(String[] args) {

        //create a linked list
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

        removeDup(a1);

    }

    public static void removeDup(ListNode head) {

        ListNode curr = head;

        while(curr != null) {

            int value = curr.val;
            ListNode pre = curr;
            ListNode temp = curr.next;

            while (temp != null) {
                if (temp.val == value) {
                    ListNode n1 = temp.next;
                    pre.next = temp.next;
                    temp = n1;
                }
                else {
                    pre = pre.next;
                    temp = temp.next;
                }
            }
            curr = curr.next;
        }

        //printing the listnode
        ListNode first = head;
        while (first != null) {
            System.out.println(first.val);
            first = first.next;
        }

    }
}
