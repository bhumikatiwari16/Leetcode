package Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {

	public static void main(String[] args) {
	
		String[] i = new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
		
		List<String> o = new ArrayList<String>();
		o = subdomainVisits(i);
		
		System.out.println(Arrays.toString(o.toArray()));
		
		//printList(o);

	}
	
	public static List<String> subdomainVisits(String[] cpdomains) {
		
		List<String> o = new ArrayList<String>();
		
		Map<String, Integer> hm = new HashMap<String, Integer>();
      
		for (int i = 0; i < cpdomains.length; i++) {
			
			String s = cpdomains[i];
			
			int spacePos = s.indexOf(" ");
			
			String num = s.substring(0, spacePos);
			
			String remString = s.substring(spacePos+1);
			
			String[] splitString = remString.split("\\.");
		
			StringBuilder sb = new StringBuilder();
			
			for (int j = splitString.length-1; j >= 0; j--) {
				
				System.out.println(splitString[j]);
				
				if (j == splitString.length-1) {
					sb.append(splitString[j]);
				} else {
					
					sb.insert(0, splitString[j]+".");
				}
				
				String key = sb.toString();
				
				if (hm.containsKey(key)) {
					hm.put(key, hm.get(key) + Integer.parseInt(num));
				} else {
					hm.put(key, Integer.parseInt(num));
				}
				
			}
			
		}
			
			for(Map.Entry<String,Integer> entry: hm.entrySet())  {
				
				String temp = entry.getValue() + " " + entry.getKey();
				o.add(temp);
				
			}
			
		return o;
		
	
    }
	
	public static void printList(List<String> o) {
		
		for (int i = 0; i < o.size(); i++) {
			
			System.out.println(o.get(i));
			
		}
		
	}
	
	

}
