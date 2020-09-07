package leetcode.List;

import java.util.ArrayList;
import java.util.List;

public class VeritasRollingString {

	public static void main(String[] args) {
		
		List<String> l = new ArrayList<String>();
		String s = "zbd";
		l.add("02R");  
		findRolling(s, l);

	}
	
	public static void findRolling(String s, List<String> operations) {
		
		String str = s;
		
		int m = 0;
		
		while (m < operations.size()) {
			
			String pres = operations.get(m);
			
			str = helperRoll(str, pres);
		
			m++;
		
		}
		
		System.out.println(str);
		
	}
	
	public static String helperRoll (String str, String operations) {
		
		int start = Integer.parseInt(operations.charAt(0)+"");
		int end = Integer.parseInt(operations.charAt(1)+"");
		char op = operations.charAt(2);
		char newCur;
		
		StringBuilder st = new StringBuilder();
		
		for (int i = 0; i < str.length(); i++) {
			
			int x  = 0;
			
			char cur = str.charAt(i);
			
			if (i < start || i > end) {
				st.append(cur);
			} else {
		
			if (cur == 'a' && op == 'L') {
				newCur = 'z';
			} else if (cur == 'z' && op == 'R') {
				newCur = 'a';
			} else {
				if (op == 'R') {
						x = (int)cur + 1;
					} else if (op == 'L'){
						x = (int)cur - 1;
					}
			newCur = (char)x;
			
			}
			st.append(newCur);
		
			}
		}
		
		return st.toString();

	}
}
