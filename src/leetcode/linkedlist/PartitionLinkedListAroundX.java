package leetcode.linkedlist;
import leetcode.util.ListNode;

public class PartitionLinkedListAroundX {

    public static void main(String[] args) {

        ListNode a1 = new ListNode(3);
        ListNode a2 = new ListNode(5);
        ListNode a3 = new ListNode(8);
        ListNode a4 = new ListNode(5);
        ListNode a5 = new ListNode(10);
        ListNode a6 = new ListNode(2);
        ListNode a7 = new ListNode(1);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;
        a6.next = a7;
        a7.next = null;
        ListNode newHead = partitionAroundX(a1, 5);
        printLinkedList(newHead);

    }

    public static ListNode partitionAroundX (ListNode head, int x) {

        ListNode cur = head;

        while (cur.next != null) {
            if (cur.next.val < x) {
                ListNode temp = cur.next.next;
                //  cur.next.next = temp;
                cur.next.next = head;
                head = cur.next;
                cur.next = temp;

            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void printLinkedList(ListNode head) {

        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + "  ");
            cur = cur.next;
        }

        System.out.println();
    }
}
