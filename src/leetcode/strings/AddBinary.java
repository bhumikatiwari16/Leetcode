package leetcode.strings;

public class AddBinary {

	public static void main(String[] args) {
		
		String a = "1", b = "111";
		System.out.println(addBinary1(a,b));
		System.out.println(addBinary2(a,b));

	 }

	 public static String addBinary1(String a, String b) {
	        
		int lenA = a.length();
		int lenB =  b.length();
		//int maxLen = Math.max(lenA,lenB);
		//int minLen = Math.min(lenA, lenB);
		StringBuilder res = new StringBuilder();
		
		int i = lenA-1; 
		int j = lenB-1;
		char carry = '0';
	
		
		while (i >= 0 && j >= 0) {
			if (a.charAt(i) == '0' && b.charAt(j) == '0' && carry == '0') {
				res = res.insert(0, '0');
				carry = '0';
			} 
			else if (a.charAt(i) == '1' && b.charAt(j) == '1' && carry == '1') {
				res = res.insert(0, '1');
				carry = '1';
			} 
			else if (a.charAt(i) == '0' && b.charAt(j) == '0' && carry == '1') {
				res = res.insert(0, '1');
				carry = '0';
			} 
			else if (a.charAt(i) == '1' && b.charAt(j) == '0' && carry == '0') {
				res = res.insert(0, '1');
				carry = '0';
			}
			else if (a.charAt(i) == '0' && b.charAt(j) == '1' && carry == '0') {
				res = res.insert(0, '1');
				carry = '0';
			}
			else {
				res = res.insert(0, '0');
				carry = '1';
			}
			i--;
			j--;
		}
		
		while (i >= 0) {
			if ((a.charAt(i) == '1' && carry == '0') ||
					(a.charAt(i) == '0' && carry == '1')) {
				res = res.insert(0, '1');
				carry = '0';
			}
			else if (a.charAt(i) == '0' && carry == '0') {
				res =  res.insert(0,'0');
				carry = '0';
		} else {
				res =  res.insert(0,'0');
				carry = '1';
		}
			i--;
		}
		
		while (j >= 0) {
			if ((b.charAt(j) == '1' && carry == '0') ||
					(b.charAt(j) == '0' && carry == '1')) {
				res = res.insert(0, '1');
				carry = '0';
			}
			else if (b.charAt(j) == '0' && carry == '0') {
				res =  res.insert(0,'0');
				carry = '0';
		} else {
				res =  res.insert(0,'0');
				carry = '1';
		}
			j--;
		}
	
		if (carry == '1') {
			res.insert(0, '1');
		}
		
		String ans = res.toString();
		return ans;
		 
	 }
	 
	 public static String addBinary2(String a, String b) {
		 
		 int la = a.length() - 1;
		 int lb = b.length() - 1;
		 StringBuilder res = new StringBuilder();
		 int carry = 0;
		 
		 while (la >= 0 && lb >= 0) {
			 
			 int na = Integer.parseInt(a.charAt(la) + "");
			 int nb = Integer.parseInt(b.charAt(lb) + "");
			 
			 int temp = na + nb + carry;
			 carry = temp / 2;
			 int sum = temp % 2;
		
			 res.insert(0, sum);
			 
			 la--;
			 lb--;
	
		 }
		 
		 while (la >= 0) {
			 
			 int na = Integer.parseInt(a.charAt(la) + ""); 
			 int temp = na + carry;
			 carry = temp / 2;
			 int sum = temp % 2;
		
			 res.insert(0, sum);
			 
			 la--;
			 
		 }
		 
		 while (lb >= 0) {
			 
			 int nb = Integer.parseInt(b.charAt(lb) + ""); 
			 int temp = nb + carry;
			 carry = temp / 2;
			 int sum = temp % 2;
		
			 res.insert(0, sum);
			 
			 lb--;
			 
		 }
		 
		 if (carry == 1) {
			 res.insert(0, "1");
		 }
		 
		 return res.toString();
		 
	 }
	 
	 
}
