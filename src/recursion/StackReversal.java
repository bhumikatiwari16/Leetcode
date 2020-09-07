package recursion;

import java.util.Stack;

public class StackReversal {

	public static void main(String[] args) {
		
		Stack<Integer> s = new Stack<>();
		s.add(7);
		s.add(2);
		s.add(1);
		
		s.add(9); s.add(5); s.add(5);
		
		
		
		reverseStack(s);
		
		while (!s.isEmpty()) {
			System.out.println(s.pop());
		}

	}

	private static void reverseStack(Stack<Integer> s) {
		
		if (s.size() == 1) {
			return;
		}
		
		int last = s.pop();
		
		reverseStack(s);
		
		insertLast(s, last);
		
	}

	private static void insertLast(Stack<Integer> s, int last) {
		
		if (s.size() == 0) {
			s.push(last);
			return;
		}
		
		int temp = s.pop();
		insertLast(s, last);
		s.push(temp);
		
		
	}
	
	
	
	

}
