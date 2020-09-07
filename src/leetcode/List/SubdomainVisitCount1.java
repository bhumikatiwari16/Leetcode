package leetcode.List;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;



public class SubdomainVisitCount1 {

	public static void main(String[] args) {
		
		String[] l = new String[1];
		l[0]= "9001 discuss.leetcode.com";
		
		List<String> op = new ArrayList<String>();
		
		op = subdomainVisits(l);
		
		int j = 0;
		
		while(j < op.size()) {
			
			System.out.println(op.get(j));
			j++;
			
		}
		
	}
	
	 public static List<String> subdomainVisits(String[] cpdomains) {
		 
		// List<String> work = new ArrayList<String> ();
		// Instead of List  use String builder
		 // Use string build insert method 
		 
		 Map<String,Integer> hm = new HashMap<String,Integer>();
		 
		 for (int i = 0; i < cpdomains.length; i ++) {
			 
			 String wSt = cpdomains[i];
			 
			 String[] l = new String[2];
			 
			 l = wSt.split(" ");
			 
			 String freq = l[0];
			 
			 String dSt = l[1];
			 
			 String[] domains = dSt.split("\\.");
			 
			 for (int k = domains.length-1 ; k >= 0; k--) {
				 
				 if (k == domains.length-1) {
				 work.add(domains[k]);
			 } else {
				 work.add(domains[k] + "." + domains[k + 1]);
			 }
				 
			 }
			 
			 for (int m = 0; m < work.size(); m++ ) {
				 if (hm.containsKey(work.get(m))) {
					 hm.put(work.get(m), hm.get(work.get(m))+Integer.parseInt(freq));
				 } else {
					 hm.put(work.get(m), Integer.parseInt(freq));
				 }
			 } 
			 
		 }
		 
		 List<String> fnl = new ArrayList<String>();
		 Iterator<Map.Entry<String, Integer>> it = hm.entrySet().iterator();
		 
		 while (it.hasNext()) {
			 Map.Entry<String, Integer> en = it.next();
			 fnl.add((en.getValue()).toString() + " " + en.getKey());
		 }
		 
		 return fnl;
	 }

}
