package leetcode.linkedlist;

import leetcode.util.ListNode;

public class ReverseLinkListIterative {

	public static void main(String[] args) {
		
		ListNode head = new ListNode(1);
		ListNode n1 = head;
		n1.next = new ListNode(2);
		n1 = n1.next;
		n1.next = new ListNode(3);
		n1 = n1.next;
		n1.next = new ListNode(4);
		n1 = n1.next;
		n1.next = new ListNode(5);
		//n1 = n1.next;
		
		
		ListNode op = reverseList(head);
		
		while (op != null) {
			
			System.out.println(op.val);
			op = op.next;
			
		}
		
		
		
	}
	
	public static ListNode reverseList(ListNode head) {
	
		ListNode cur = head;
		ListNode prev = null;
		
		while (cur != null) {
			ListNode temp = cur.next;
			cur.next = prev;
			prev = cur;
			cur = temp;
		}
		
		return prev;
	}

}
