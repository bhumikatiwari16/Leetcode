package leetcode.List;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

	
	public static void main(String args[]) {
		
		List<String> o = fizzBuzz(15);
		int count = 0;
		
		while (count < o.size()) {
			System.out.println(o.get(count));
			count++;
		}
		
	}
	
	public static List<String> fizzBuzz(int n) {
        
		List<String> l = new ArrayList<String>();
		int i = 1;
		
		while (i <= n) {
			if ((i % 3 == 0) && (i % 5 == 0)) {
				l.add("FizzBuzz");
			} else if (i % 5 == 0) {
				l.add("Buzz");
			} else if (i % 3 == 0) {
				l.add("Fizz");
			} else {
				l.add(Integer.toString(i));
			}
			i++;
		}
		
		return l;
			
    }
}
