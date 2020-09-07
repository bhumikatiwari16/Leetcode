package leetcode.List;

import leetcode.util.ListNode;

public class mergeSortedList {

	public static void main(String[] args) {

		ListNode head1 = new ListNode(-9);
		ListNode a1 = head1;
		a1.next = new ListNode(3);
		a1 = a1.next;
		// a1.next = new ListNode(4);
		// a1 = a1.next;

		ListNode head2 = new ListNode(5);
		ListNode a2 = head2;
		a2.next = new ListNode(7);
		a2 = a2.next;
		// a2.next = new ListNode(4);
		// a2 = a2.next;

		ListNode a3 = mergeTwoLists(head1, head2);
		// ListNode head3 = a3;

		printList(a3);

	}

	public static void printList(ListNode head1) {
		while (head1 != null) {
			System.out.println(head1.val);
			head1 = head1.next;
		}
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		ListNode p3 = new ListNode(-1);
		ListNode head = p3;

		if (l1 == null && l2 == null)
			return null;
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		while(l1 !=null && l2!=null) {
			
			if(l1.val < l2.val) {
				p3.next=l1;
				l1 =l1.next;
			}
			else {
				p3.next=l2;
				l2=l2.next;
			}
			p3 = p3.next;
		}
		if(l1!=null)
			p3.next=l1;
		if(l2!=null)
			p3.next=l2;
		
		return head.next;
	}

}
