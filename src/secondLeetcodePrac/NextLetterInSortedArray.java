package secondLeetcodePrac;

public class NextLetterInSortedArray {

	static char nextChar = '0';
	
	public static void main(String[] args) {
		
		char[] arr = {'b','e','g','i'};
		char target = 'a';
		
		int len = arr.length;
		findNextLetter(arr, target, 0, len-1);
		
		if (nextChar == '0') {
			nextChar = arr[0];
		}
		
		System.out.println(nextChar);

	}

	private static void findNextLetter(char[] arr, char target, int start, int end) {
		
		if (start > end) {
			return;
		}
		
		int mid = start + (end-start)/2;
		
		
		if (arr[mid] == target)  {
			
			if (mid == arr.length-1 ) {
					nextChar = arr[0];
					return;
			} 
			nextChar = arr[mid+1];
			return;
		}
		
		if (arr[mid] < target) {
			findNextLetter(arr, target, mid+1, end);
		}
		
		if (arr[mid] > target) {
			nextChar = arr[mid];
			findNextLetter(arr, target, start, mid-1);
		}
		
	}
	
	

}
