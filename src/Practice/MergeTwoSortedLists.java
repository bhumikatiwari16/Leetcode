package Practice;

import leetcode.util.ListNode;

public class MergeTwoSortedLists {

	public static void main(String[] args) {
		
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		
		ListNode l3 = mergeTwoLists(l1,l2);
		
		printList(l3);
		
	}
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
		ListNode cur1 = l1;
		ListNode cur2 = l2;
		
		ListNode res = new ListNode(-1);
		
		ListNode r = res;
		
		while (cur1 != null && cur2 != null) {
			
			if(cur1.val <= cur2.val) {
				
				r.next = cur1;
				cur1 = cur1.next;
				
			} else {
				
				r.next = cur2;
				cur2 = cur2.next;
				
			}
			
			r = r.next;
			
		}
		
		if (cur1 != null) {
			r.next = cur1;
		} else {
			r.next = cur2;
		}
		
		return res.next;
		
		
    }
	
	public static void printList(ListNode l3) {
		 
		ListNode temp = l3;
		
		while (l3 != null) {
			System.out.println(l3.val);
			l3 = l3.next;
		}
	}

	public static class ListNode {
		
		int val;
		ListNode next;
		
		public ListNode(int val) {
			this.val = val;
			this.next =  null;
		}
		
	}
	
}
