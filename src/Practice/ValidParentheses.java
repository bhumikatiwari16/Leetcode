package Practice;

import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		
		String i = "{[]}";
		System.out.println(isValid(i));

	}
	
	public static boolean isValid(String s) {
		
		Stack<Character> st = new Stack<Character>();
		int i = 0;
		
		while (i < s.length()) {
			
			if (st.isEmpty()) {
				st.push(s.charAt(i));
			}
			else if (s.charAt(i) == '}' && st.peek().equals('{')) {
				st.pop();
			}
			else if (s.charAt(i) == ')' && st.peek().equals('(')) {
				st.pop();
			}
			else if (s.charAt(i) == ']' && st.peek().equals('[')) {
				st.pop();
			} 
			else {
				st.push(s.charAt(i));
			}
			
			i++;
		}
		
		if (st.size() == 0) {
			return true;
		}
		
		return false;
        
    }

}
