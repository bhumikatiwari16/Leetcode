package stack;

import java.util.Stack;

public class minStack {
	
	Stack<Integer> s1;
	Stack<Integer> s2;
	

	 public minStack() {
	        
		 	s1 = new Stack<Integer>();
		 	s2 = new Stack<Integer>();
		 
	    }
	    
	    public void push(int x) {
	        
	    	s1.push(x);
	    	
	    	if (s2.isEmpty()) {
	    		s2.push(x);
	    	}
	    	else if (s2.peek() > x) {
	    		s2.push(x);
	    	}
	    	
	    }
	    
	    public void pop() {
	    	
	    	
	    	if(s1.peek() == s2.peek()) {
	    		s2.pop();
	    	}
	    	s1.pop();
	    }
	    
	    public int top() {
	        
	    	return s1.peek();
	    	
	    }
	    
	    public int getMin() {
	        
	    	return s2.peek();
	    	
	    }

}
