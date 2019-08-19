package leetcode.linkedlist;

import leetcode.util.ListNode;

public class SumLists {

    public static void main(String[] args) {

        ListNode a1 = new ListNode(7);
        ListNode a2 = new ListNode(1);
        ListNode a3 = new ListNode(9);
        ListNode a4= new ListNode(9);

        ListNode b1 = new ListNode(9);
        ListNode b2 = new ListNode(9);
        ListNode b3 = new ListNode(2);

        //9917
        // 299
        //10212


        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next=null;

        b1.next = b2;
        b2.next = b3;
        b3.next = null;

        sumLists(a1, b1);

    }

    public static void sumLists (ListNode head1, ListNode head2) {

        ListNode cur1 = head1, cur2 = head2;
        ListNode head3=null;
        ListNode current=null;
        int carry = 0;

        while(cur1 != null && cur2 != null) {

            ListNode temp=null;

            if(current!=null)
             temp= current;

            current = new ListNode((cur1.val + cur2.val + carry) % 10);

            carry = (cur1.val + cur2.val + carry) / 10;

            if (head3 == null) {
                head3= current;
            }
            if(temp!=null)
                temp.next = current;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        while (cur1 != null) {
            ListNode temp = new ListNode((cur1.val + carry) % 10);
            carry = (cur1.val + carry) / 10;
            current.next=temp;
            current = current.next;
            cur1 = cur1.next;

        }

        while (cur2 != null) {
            ListNode temp = new ListNode((cur2.val + carry) % 10);
            carry = (cur2.val + carry) / 10;
            current.next=temp;
            current = current.next;
            cur2=cur2.next;
        }

        //Printing the list

       // ListNode cur = head3;
        if(carry!=0){
            current.next = new ListNode(carry);
        }

        while (head3 != null) {
            System.out.print(head3.val + "  ");
            head3 = head3.next;
        }

        System.out.println();
    }


}
