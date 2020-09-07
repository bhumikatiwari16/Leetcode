package sambaTv;

public class q2 {

	public static void main(String[] args) {
		
		String i = "BAAABAB";
		String j = "BBABAA";
		String k = "AABBBB";
		//solution(i);
		//solution(j);
		//solution(k);
		//System.out.println(solution(i));
		//System.out.println(solution(j));
		System.out.println(solution(k));
		

	}

	 public static int solution(String S) {
	      
		 int j = 0;
		 int delCount = 0;
		 
		 while (S.charAt(j) != 'A') {
			 delCount++;
			 j++;
			 if (j >= S.length()) {
				 return delCount;
			 }
		 }
		 
		// System.out.println(delCount);
		// System.out.println(j);
		
		 while (S.charAt(j) == 'A') {
			 j++;
			 if (j >= S.length()) {
				 return delCount;
			 }
		 }
		 
		// System.out.println("*************");
		// System.out.println(delCount);
		// System.out.println(j);
		 
		 
		while (S.charAt(j) == 'B' ) {
				 j++;
				 if (j >= S.length()) {
					 return delCount;
				 }
		}
		
		 
		// System.out.println("*************");
		// System.out.println(delCount);
		// System.out.println(j);
		 
		 while (S.charAt(j) != 'B') {
			 delCount++;
			 j++;
			 if (j >= S.length()) {
				 return (delCount-1);
			 }
		 }
		 
		// System.out.println("*************");
		// System.out.println(delCount);
		// System.out.println(j);
		 
		 return (delCount);
		 
	}
	
}
