package BinarySearch;

/*
 * https://www.geeksforgeeks.org/smallest-alphabet-greater-than-a-given-character/
 * 
 * Given a list of sorted characters consisting of both Uppercase and Lowercase Alphabets 
 * and a particular target value, say K, 
 * the task is to find the smallest element in the list that is larger than K.
 * 
 * Input : Letters = ["D", "J", "K"]
        K = "B"
Output: 'D'
Explanation:
The Next greater character of "B" is 'D'
since it is the smallest element from the 
set of given letters, greater than "B".

Input:  Letters = ["h", "n", "s"]
        K = "t"
Output: 'h'
 * 
 */

public class nextAlphabetInArray {

	public static void main(String[] args) {
		
		char[] arr = {'b','e','g','i'};
		char target = 'j';
		
		char res = findNextAlphabet(arr, target);
		
		if (res == 0) {
			System.out.println("Not found");
		}
		
		System.out.println(res);

	}

	public static char findNextAlphabet(char[] arr, char target) {
		
		int start = 0;
		int end = arr.length - 1;
		int mid = 0;
		char res = 0;
		
		while (start < end) {
			
			mid = start + (end-start)/2;
			
			if (arr[mid] == target)  {
					if(mid != arr.length-1) {
							return arr[mid+1];
					} else {
							return 0;
					}
			}
			
			if (arr[mid] <= target) {
				
				start = mid + 1;
					
			} else {
				
				res = arr[mid];
				end = mid - 1;
			}
				
		}
		
		if (arr[start] > target) {
			return arr[start];
		} 
	//	else if (arr[end] < target){
	//		return 0;
	//	} 
		else {
			return res;
		}
		
	}
}

