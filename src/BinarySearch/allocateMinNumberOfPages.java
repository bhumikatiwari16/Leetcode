package BinarySearch;

/*
 * Given number of pages in n different books and m students. 
 * The books are arranged in ascending order of number of pages. 
 * Every student is assigned to read some consecutive books. 
 * The task is to assign books in such a way 
 * that the maximum number of pages assigned to a student is minimum.
 * 
 * Input :  pages[] = {12, 34, 67, 90}
        	m = 2
   Output: 113
   
   Explanation:
   There are 2 number of students. Books can be distributed 
	in following fashion : 
  1) [12] and [34, 67, 90]
      Max number of pages is allocated to student 
      2 with 34 + 67 + 90 = 191 pages
  2) [12, 34] and [67, 90]
      Max number of pages is allocated to student
      2 with 67 + 90 = 157 pages 
  3) [12, 34, 67] and [90]
      Max number of pages is allocated to student 
      1 with 12 + 34 + 67 = 113 pages

	Of the 3 cases, Option 3 has the minimum pages = 113. 
 */

public class allocateMinNumberOfPages {

	public static void main(String[] args) {
		
		//int pages[] = {12, 34, 67, 90};
        //int k = 2;
        
		//int pages[] = {1,2,3,1,1};
        //int k = 4;
		
		int pages[] = {1,2,3,4,5,6,7,8,9,10};
        int k = 5;
        
        System.out.println(minimizeMaxNumberOfPages(pages, k));
	}
	
	public static int minimizeMaxNumberOfPages(int[] pages, int k) {
		
		
		int length = pages.length;
		int start = 0;
		int end = 0;
		int result = -1;
		int max = -1;
		
		for (int i = 0; i < length; i++) {
			end += pages[i];
			max = Math.max(max,pages[i]);
		}
		
		int mid = 0;
		
		start = max;
		
		while (start <= end) {
			
			mid = start + (end-start)/2;
			
			if (isValid(pages, k, mid) == true) {
				result = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}	
			
		}
		
		return result;
		
	}
	
	public static boolean isValid (int[] pages, int k, int mid) {
		
		int sum=0, student=1;
		
		if (pages.length < k) {
			return false;
		}
		
		for (int i = 0; i < pages.length; i++) {
			
			sum += pages[i];
			if (sum > mid) {
				student ++;
				sum = pages[i];
			}
			
			if (student > k) {
				return false;
			}
			
		}
	
		return true;
		
	}

}
