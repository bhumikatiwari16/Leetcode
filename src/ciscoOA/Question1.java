package ciscoOA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Question1 {

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int numOfElem = 0;
		int[] arr = null;
		String[] stringsArr = null;
		
		try {
			numOfElem = Integer.parseInt(br.readLine());
			arr = new int[numOfElem];
			String line = br.readLine(); // to read multiple integers line
			stringsArr = line.trim().split("\\s+");
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		// take sum of each element of stringsArr after converting each element to integer
		int sum = 0;
		
		// add each element to hashmap wherein key = element, value = frequency
		Map<Integer, Integer> hm = new HashMap<>();
		
		for (int i = 0; i < numOfElem; i++) {
		    
			arr[i] = Integer.parseInt(stringsArr[i]);
		    sum += arr[i];
		   
		    if (hm.containsKey(arr[i])) {
		    	int curFreq = hm.get(arr[i]);
		    	hm.put(arr[i], curFreq+1);
		    } else {
		    	hm.put(arr[i], 1);
		    }
		    
		}

		
		int maxFreq = Integer.MIN_VALUE;
		int mode = 0;
		
		for (Map.Entry<Integer, Integer> entry: hm.entrySet()) {
			
			if (entry.getValue() > maxFreq) {
				mode = entry.getKey();
				maxFreq = entry.getValue();
			}
			
			if (entry.getValue() == maxFreq) {
				
				mode = Math.min(mode, entry.getKey());
				//maxFreq = entry.getValue();
			}
			
		}
		

		double mean = (double) sum / numOfElem;
		
		System.out.println(mean);
		
		DecimalFormat df = new DecimalFormat("#.####");
		
		//String.format("%.4g%n", mean);
		
		System.out.println(df.format(mean) + " " + mode);

		
		
		
		
	}

}
