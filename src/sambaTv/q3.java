package sambaTv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class q3 {

	public static void main(String[] args) {
		int[] A = {0,2,2,3};
		int[] B = {1,1,4,4};
		
		int[] C = {1,6,6,3,0,5};
		int[] D = {6,2,0,0,4,0};
		
		int[] E = {0,1,1,1,1};
		int[] F = {1,2,3,4,5};
		
		System.out.println(solution(A, B));
		System.out.println(solution(C, D));
		System.out.println(solution(E, F));
	}
	
	public static int solution(int[] A, int[] B) {
       
		List<Integer> list1 = new ArrayList<Integer>();
		for (int text : A) {
			list1.add(text);
		}
		System.out.println(list1);

		List<Integer> list2 = new ArrayList<Integer>();
		for (int text : B) {
			list2.add(text);
		}
		System.out.println(list2);

	
		int count = 0;
		for (int i = 0; i < B.length; i++) {
			if (list1.get(i) == 0) {
				
				 int temp = list2.get(i); 
				 list2.set(i, list1.get(i)); 
				 list1.set(i, temp);
				 
				count++;

			} else if (!list1.contains((list2.get(i)))) {

				
				 int temp = list2.get(i); 
				 list2.set(i, list1.get(i)); 
				 list1.set(i, temp);
				 
				count++;

			}

		}

		return count;
    }

}
