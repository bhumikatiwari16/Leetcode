package linkedList;

// https://www.educative.io/courses/grokking-the-coding-interview/m2YYJJRP9KG

/*
 * Given the head of a LinkedList and a number ‘k’, reverse every alternating ‘k’ sized sub-list starting from the head.

If, in the end, you are left with a sub-list with less than ‘k’ elements, reverse it too.

 
 */
import java.util.*;

class ListNode {
  int value = 0;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }
}

public class RevAlternateKElemSublist {

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(6);
    head.next.next.next.next.next.next = new ListNode(7);
    head.next.next.next.next.next.next.next = new ListNode(8);

    ListNode result = RevAlternateKElemSublist.reverse(head, 2);
    System.out.print("Nodes of the reversed LinkedList are: ");
    while (result != null) {
      System.out.print(result.value + " ");
      result = result.next;
    }
  }
  
  public static ListNode reverse(ListNode head, int k) {
	    
	    ListNode root = new ListNode(-1);
	    root.next = head;
	    
	    ListNode prev = root;
	    ListNode cur = head;
	    
	    ListNode tail = null;
	    
	   
	    boolean revFlag = true;
	    
	    // iterate through whole list
	    while (cur != null) {
	    	
	    	 int count = 0;
	    	 
	    	 tail = cur;
	    	 
	    	// count k nodes using count pointer 
	    	while (count < k & cur != null) {
	    		cur = cur.next;
	    		count++;	
	    	}
	    
	     // check if count < k but end of list reached and revFlag is set to true
	    // add the remaining elements after reversing
	    	if (count < k && cur == null && revFlag == true) {
	    		prev.next = reverseList(tail, count);
	    		//prev = tail;
	    	} 
	    
	    // check if count < k but end of list reached and revFlag is set to false
	    // add the remaining elements as is without reversing
	    	else if (count < k && cur == null && revFlag == false) {
	    		prev.next = tail;
	    		//prev = tail;	
	    	}
	    	
	    // check if revFlag is true/false.
	    // if revFlag is true, reverse. 
	    	if (revFlag == true) {
	    		prev.next = reverseList(tail, k);
	    		prev = tail;
	    	}
	    // if revFlag is false, add the sublist as is.
	    	else if (revFlag == false) {
	    		
	    	// add all nodes of sublist starting from node at tail ptr to the node at cur ptr 
	    		
	    		while (tail != cur) {
	    			prev.next = tail;
	    			tail = tail.next;
	    			prev = prev.next;
	    		}
	    		
	    	}
	    
	    // toggle the reverseFlag for alternating
	    	
	    	revFlag = !revFlag;
	    
	    }
	    
	    
	    return root.next;
  }

  
 // function to reverse a list till k nodes
 public static ListNode reverseList(ListNode tail, int k) {
	
	 ListNode previous = null;
	 ListNode current = tail;
	 
	 while (current != null && k > 0) {
		 
		 ListNode temp = current.next;
		 current.next =  previous;
		 previous = current;
		 current = temp;
		 k--;
		 
	 }
	 
	return previous;
}
  
  
}
