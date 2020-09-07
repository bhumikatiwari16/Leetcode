package hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MostCommonWord {

	public static void main(String[] args) {
		
		String paragraph = "a, a, a, a, b,b,b,c, c";
		String[] banned = {"a"};
		
		System.out.println(mostCommonWord(paragraph, banned));
	}
	
	public static String mostCommonWord (String paragraph, String[] banned) {
        
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		// Convert Banned array to Set
		List<String> banLst = Arrays.asList(banned);
		
		paragraph = paragraph.toLowerCase() + " ";
		//paragraph = (paragraph.replaceAll("[^a-z\\s]", "")) + " ";

		System.out.println(paragraph);
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < paragraph.length(); i++) {
			
			if (Character.isLetter(paragraph.charAt(i))) {
				sb.append(paragraph.charAt(i));
			} else if (sb.length() != 0){
				hm.put(sb.toString(), hm.getOrDefault(sb.toString(),0)+1);
				sb = new StringBuilder();
			}
		
		}

	   String maxString = "";
	   int maxFreq = Integer.MIN_VALUE;
	  
	   // do for loop over map and populate maxString and maxFreq
	   for (Map.Entry<String,Integer> xyz: hm.entrySet()) {
		   System.out.println(xyz.getKey() + "   "  + xyz.getValue());
		   
		   if (!banLst.contains(xyz.getKey()) && xyz.getValue() > maxFreq) {
			   maxString = xyz.getKey();
			   maxFreq = xyz.getValue();
		   }
	   }
	   
	   System.out.println(maxString);
	   System.out.println(maxFreq);
	   
	   
	   return maxString;
	   
	}
		
	        
} 
