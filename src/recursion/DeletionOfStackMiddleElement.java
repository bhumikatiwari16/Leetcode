package recursion;

import java.util.Stack;

public class DeletionOfStackMiddleElement {

	public static void main(String[] args) {
		
		Stack<Integer> s = new Stack<>();
		s.add(1);
		s.add(2);
		s.add(3);
		s.add(4);
		s.add(5);
		s.add(6);
		
		int k = (s.size()/2) + 1;
		deleteMidElem(s, k);
		
		while (!s.isEmpty()) {
			System.out.println(s.pop());
		}

	}

	private static void deleteMidElem(Stack<Integer> s, int k) {
		
		if (k == 1) {
			s.pop();
			return;
		}

		int temp = s.pop();
		deleteMidElem(s, --k);
		s.push(temp);
		
		
	}
	
	

}
