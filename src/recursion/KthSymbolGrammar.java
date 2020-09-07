package recursion;

/*
 * 
 * https://leetcode.com/problems/k-th-symbol-in-grammar/submissions/
 * 
 * On the first row, we write a 0. Now in every subsequent row, 
 * we look at the previous row and replace each occurrence of 0 with 01, 
 * and each occurrence of 1 with 10.

Given row N and index K, 
return the K-th indexed symbol in row N. 
(The values of K are 1-indexed.) (1 indexed).

Examples:
Input: N = 1, K = 1
Output: 0

Input: N = 2, K = 1
Output: 0

Input: N = 2, K = 2
Output: 1

Input: N = 4, K = 5
Output: 1

Explanation:
row 1: 0
row 2: 01
row 3: 0110
row 4: 01101001

 */

public class KthSymbolGrammar {

	public static void main(String[] args) {
		
		int n = 4, k = 5;
		System.out.println(kthGrammar(n, k));

	}
	
	public static int kthGrammar(int n, int k) {
		
		// Base condition
		if (n == 1 & k == 1) {
			return 0;
		}
		
		// variable prev used to store result of recursive call 
		// for smaller value of n and k
		int prev = 0;
		
		// find number of elements in Nth row = 2 ^ (n-1)
		// find mid index value for the Nth row.

		int elemCount = (int) Math.pow(2, n-1);
		int mid = elemCount / 2;
		
		// Observe in example that first half of Nth row is same as (N-1)th row.
		// Also, observe that second half of Nth row is complement of (N-1)th row.
		// For second half of Nth row:
		// 1st element of (N-1)th row corresponds to (k-mid)th element of Nth row.
		
		if (k <= mid) {
			prev = kthGrammar(n-1, k);
		} 
		else { 
			prev = kthGrammar(n-1, k-mid);
			if (prev == 0) {
				return 1;
			} 
			else {
				return 0;
			}
		}
		return prev;
	}
	
	/*public static int kthGrammar(int n, int k) {
        
		String seq = helper(n);
		System.out.println(seq);
		System.out.println(seq.charAt(k-1));
		
		return seq.charAt(k-1) - '0';
		
		
    }

	private static String helper(int n) {
		
		if (n == 0) {
			return "0";
		}
		
		String prev = helper(n-1);
		StringBuilder resultSt = new StringBuilder();
		
		for (int i = 0; i < prev.length(); i++) {
			if (prev.charAt(i) == '0') {
				resultSt.append("01");
			} else {
				resultSt.append("10");
			}
		}
		
		return resultSt.toString();
		
	}
	*/
	
	

}
