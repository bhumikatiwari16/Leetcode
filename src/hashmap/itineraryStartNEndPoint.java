package hashmap;

import java.util.HashMap;
import java.util.Map;

public class itineraryStartNEndPoint {

	public static void main(String[] args) { 
		
        Map<String, String> dataSet = new HashMap<String, String>(); 
        dataSet.put("Chennai", "Banglore"); 
        dataSet.put("Bombay", "Delhi"); 
        dataSet.put("Goa", "Chennai"); 
        dataSet.put("Delhi", "Goa"); 
  
        printResult(dataSet); 
        
       
        
    } 
	
	static void printResult(Map<String, String> dataSet) {
		
		String source = null, dest = null;
		
		for(Map.Entry<String, String> entry: dataSet.entrySet()) {
			if (!dataSet.containsKey(entry.getValue())){
				dest = entry.getValue();
			}
			if (!dataSet.containsValue(entry.getKey())){
				source = entry.getKey();
			}
		}
		
		System.out.println("source: " + source);
		System.out.println("destination: " + dest);
		
		while( source != null && source!= dest) {
			System.out.println(source + " -> " + dataSet.get(source));
			source = dataSet.get(source);
		}
	}
	
	
	
	
	
	

}
