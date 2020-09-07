package Practice;

public class ReverseLinkedList {

	public static void main(String[] args) {
		
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		
		printList(l1);
		
		ListNode res = reverseList(l1);
		
		printList(res);
	
	}
	
	public static ListNode reverseList(ListNode head) {
	        
	    ListNode cur = head;
	    ListNode prev = null;
	    ListNode t = null;
	    
	    while (cur != null) {
	  
	    	t = cur.next;
	    	cur.next = prev;
	    	prev = cur;	
	    	cur = t; 	
	    }
	    
	    return prev;
	   
	}
	
	public static void printList(ListNode res) {
		
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

	public static class ListNode {
		
		  int val;
		  ListNode next;
		  
		  ListNode(int x) { 
			  val = x; 
		  }
		  
	}
	
}
