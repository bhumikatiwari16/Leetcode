package recursion;

/*
 * Permutation with space
 * 
 * https://www.geeksforgeeks.org/print-possible-strings-can-made-placing-spaces/
 * 
 * Given a string you need to print all possible strings 
 * that can be made by placing spaces (zero or one) in between them.
 * 

Input:  str[] = "ABC"
Output: ABC
        AB C
        A BC
        A B C
        
 */

import java.util.ArrayList;
import java.util.List;

public class SpacesPermutation {

	public static void main(String[] args) {
		
		String s = "ABC";
		List<String> res = new ArrayList<>();
		String cur = s.charAt(0) + "";
		int index = 1;
		permuteSpaces(s, cur, res, index);
		
		System.out.println(res);

	}

	private static void permuteSpaces(String s, String cur, List<String> res, int index) {
		
			if (index >= s.length()) {
				res.add(cur);
				return;
			} 
			
			String o1 = cur;
			String o2 = cur;
			
			o1 = o1 + s.charAt(index);
			o2 = o2 + " " + s.charAt(index);
			
			permuteSpaces(s, o1, res, index+1);
			permuteSpaces(s, o2, res, index+1);
		
	}

}
