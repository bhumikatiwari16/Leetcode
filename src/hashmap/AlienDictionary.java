package hashmap;

import java.util.Arrays;
import java.util.Comparator;

public class AlienDictionary {

	public static void main(String[] args) {
		
		String[] words = {"apple","app"};
		String order = "abcdefghijklmnopqrstuvwxyz";
		
		System.out.println(isAlienSorted(words, order));
	}
	
	public static boolean isAlienSorted(String[] words, String order) {
		
		int len = words.length;
		Custom[] custom = new Custom[len];
		
		// populating custom objects array from given words array
		
		for (int i = 0; i < len; i++) {
			
			custom[i] = new Custom(words[i], order);
			
		}
		
		// sort custom objects array using comparator
		
		Arrays.sort(custom, new Comparator<Custom>() {

			@Override
			public int compare(Custom o1, Custom o2) {
				
				String w1 = o1.word;
				String w2 = o2.word;
				
				// check if o1 word is same as o2 word
				if (w1.equals(w2)) {
					return 0;
				}
				
				// if o1 word not same as o2 word:: check common min length
				int comMinLen = Math.min(w1.length(), w2.length());
				
				// loop till common min length and compare char by char
				int k = 0;
				while (k < comMinLen) {
					
					char c1 = w1.charAt(k);
					char c2 = w2.charAt(k);
					int pos1 = order.indexOf(c1);
					int pos2 = order.indexOf(c2);
					
					if (pos1 == pos2) {
						k++;
					} else if (pos1 > pos2) {
						return 1;
					} else {
						return -1;
					}
					
				}
				
				// check which object has more length than common min length and return results accordingly
				if (w1.length() > comMinLen) {
					return 1;
				} else if (w2.length() > comMinLen) {
					return -1;
				}
				
				return 0;
			}
			
		});
		
		// compare elements of input array with sorted custom array to match elem by elem
		// if all elem match in both arrays, return true
		// else return false
		for (int l = 0; l < len; l++ ) {
			
			if (!custom[l].word.equals(words[l])) {
				return false;
			}
		}
		
		return true;
		
	}
	
	public static class Custom {
		
		String word;
		String order;
		
		public Custom (String word, String order) {
			
			this.word = word;
			this.order = order;
			
		}
	}

}
