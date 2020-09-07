package recursion;

import java.util.Stack;

public class SortingOfStack {

	public static void main(String[] args) {
		
		Stack<Integer> s = new Stack<>();
		s.add(15);
		s.add(3);
		s.add(3);
		s.add(16);
		s.add(4);
		s.add(4);
		
		sortStack(s);
		
		while (!s.isEmpty()) {
			System.out.println(s.pop());
		}

	}
	
	public static void sortStack(Stack<Integer> s) {
		
		if (s.size() == 1) {
			return;
		}
		
		Stack<Integer> r = new Stack<>();
		int last = (int) s.pop();
		
		sortStack(s);
		
		while (!s.isEmpty()) {
			if ((int) s.peek() < last) {
				int cur = (int) s.pop();
				r.push(cur);
			} else {
				s.push(last);
				break;
			}
		}
		
		if (s.isEmpty()) {
			s.push(last);
		}
		
		while (!r.isEmpty()) {
			
			int shift = r.pop();
			s.push(shift);
			
		}
		
	}

}
