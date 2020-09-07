package sambaTv;

import java.util.HashMap;

public class q1 {

	public static void main(String[] args) {
		
		String i = "codility";
		System.out.println(solution(i));
	}
	
	public static String solution(String S) {
		
		  if (S.length() == 0) {
	           return "";
	       } else if (S.length() == 1) {
	           return S;
	       }

		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
       
		for (int i = 0; i < S.length(); i++) {
			
			char cur = S.charAt(i);
			
			if (hm.containsKey(cur)) {
				String sol = ((Character)cur).toString();
				return sol;
			} else {
				hm.put(cur, 1);
			}
			
		}
		
		return "";
		
    }

}
