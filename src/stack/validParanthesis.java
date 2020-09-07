package stack;

import java.util.Stack;

public class validParanthesis {

	public static void main(String[] args) {
		System.out.println(checkParanthesis("()"));
		System.out.println(checkParanthesis("()[]{}"));
		System.out.println(checkParanthesis("(]"));
		System.out.println(checkParanthesis("([)]"));
		System.out.println(checkParanthesis("{[]}"));
		System.out.println(checkParanthesis("]"));

		
	}	
	
	public static boolean checkParanthesis (String s) {
		
		Stack<Character> st = new Stack<Character>(); 
		for (int i = 0; i < s.length(); i++) {
			
			if ((s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') && st.isEmpty()) 
				return false;
			
			if (s.charAt(i) =='(' || s.charAt(i) == '[' || s.charAt(i) == '{') 
				st.push(s.charAt(i));
			else if (s.charAt(i) ==')' && st.peek() == '(' && st.isEmpty() == false)
				st.pop();
			else if (s.charAt(i) =='}' && st.peek() == '{' && st.isEmpty() == false)
				st.pop();
			else if (s.charAt(i) ==']' && st.peek() == '[' && st.isEmpty() == false) 
				st.pop();
			else 
				return false;
		}
		if (st.isEmpty())
			return true;
		else 
			return false;
	}
	
	
}
