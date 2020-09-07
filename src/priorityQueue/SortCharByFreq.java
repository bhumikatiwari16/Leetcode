package priorityQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharByFreq {

	public static void main(String[] args) {
		
		String s = "Aabb";
		
		String res = frequencySort(s);
		
		System.out.println(res);

	}

    public static String frequencySort(String s) {
        
        Map<Character, Integer> hm = new HashMap<Character, Integer>();
        
        for(int i = 0; i < s.length(); i++) {
            
            if (hm.containsKey(s.charAt(i))) {
                
                int freq = hm.get(s.charAt(i));
                hm.put(s.charAt(i), freq + 1);
            }
            
            else {
                hm.put(s.charAt(i), 1);
            }   
        }
        
        PriorityQueue<A> pq = new PriorityQueue<A>();
        
        for(Map.Entry<Character, Integer> entry: hm.entrySet()) {
        	
        	A a = new A(entry.getKey(), entry.getValue());
        	System.out.println(entry.getKey() +  "    " + entry.getValue());
        	pq.offer(a);
        	
        }
        
        StringBuilder sb = new StringBuilder();
        
        
        while (pq.size() > 0) {
        	
        	A curA = pq.poll();
        	char curElem = curA.element;
        	int curFreq = curA.frequency;
        	
        	int track = 0;
        	while (track < curFreq) {
        		sb.append(curElem);
        		track++;
        	}
        	
        }
        
        return sb.toString();
        
        
        
        
    }
    
    public static class A implements Comparable<A>{
        
        char element;
        int frequency;
        
        A(char e, int f) {
            element = e;
            frequency = f;
        } 

		@Override
		
		public int compareTo(A a) {
			
			 if (this.frequency > a.frequency) {
	                return -1;
	            } 
	            
	            else if (this.frequency < a.frequency) {
	                return 1;
	            }
	            
	            else {
	                return 0;
	            }
		}
     
    }
}
